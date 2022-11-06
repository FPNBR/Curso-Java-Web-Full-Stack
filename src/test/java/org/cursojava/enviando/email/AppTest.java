package org.cursojava.enviando.email;

import org.junit.Test;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
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

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
