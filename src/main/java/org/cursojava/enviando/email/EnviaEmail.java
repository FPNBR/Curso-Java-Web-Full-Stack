package org.cursojava.enviando.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviaEmail {

    private String userName = "email";
    private String senha = "senha";
    private String nomeRemetente = "";
    private String assuntoEmail = "";
    private String textoEmail = "";
    private String listaDestinatarios = "";

    public EnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
        this.listaDestinatarios = listaDestinatarios;
        this.nomeRemetente = nomeRemetente;
        this.assuntoEmail = assuntoEmail;
        this.textoEmail = textoEmail;
    }

    public void enviarEmail() throws Exception {
        Properties properties = new Properties();

        properties.put("mail.smtp.ssl.trust", "*");
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

        Address[] toUser = InternetAddress.parse(listaDestinatarios);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName, nomeRemetente)); // Remetente, o primeiro parâmetro é o email, e o segundo para mostrar o nome em vez do endereço de email
        message.setRecipients(Message.RecipientType.TO, toUser); // Destinatário
        message.setSubject(assuntoEmail); // Assunto do email
        message.setText(textoEmail); // Corpo do texto

        Transport.send(message);
    }
}