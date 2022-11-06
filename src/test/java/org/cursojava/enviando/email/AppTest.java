package org.cursojava.enviando.email;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AppTest {

    private String userName = "email";
    private String senha = "senha";

    @Test
    public void testeEmail() {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true"); // Autorização
            properties.put("mail.smtp.starttls", "true"); // Autenticação
            properties.put("mail.smtp.host", "smtp.gmail.com"); // Servidor Gmail Google
            properties.put("mail.smtp.port", "465"); // Porta do servidor
            properties.put("mail.smtp.socketFactory.port", "465"); // Especifica a porta a ser conectada pelo socket
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Classe socket de conexão ao SMTP

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, senha);
                }
            });

            Address[] toUser = InternetAddress.parse("email");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName)); // Remetente
            message.setRecipients(Message.RecipientType.TO, toUser); // Destinatário
            message.setSubject("Chegou o e-mail enviado com java"); // Assunto do email
            message.setText("Olá! Email enviado com java para testes"); // Corpo do texto

            Transport.send(message);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}