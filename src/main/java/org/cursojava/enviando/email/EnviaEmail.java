package org.cursojava.enviando.email;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
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

    public void enviarEmail(boolean envioHtml) throws Exception {
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

        if (envioHtml) {
            message.setContent(textoEmail, "text/html; charset=utf-8");
        }
        else {
            message.setText(textoEmail); // Corpo do texto
        }

        Transport.send(message);
    }

    public void enviarEmailAnexo(boolean envioHtml) throws Exception {
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

        // Parte 1 do email que é o texto e a descrição do email
        MimeBodyPart corpoEmail = new MimeBodyPart();

        if (envioHtml) {
            corpoEmail.setContent(textoEmail, "text/html; charset=utf-8");
        }
        else {
            corpoEmail.setText(textoEmail); // Corpo do texto
        }

        List<FileInputStream> arquivos = new ArrayList<>();
        arquivos.add(simuladorDePDF()); // Poderia ser um certificado
        arquivos.add(simuladorDePDF()); // Poderia ser uma nota fiscal
        arquivos.add(simuladorDePDF()); // Poderia ser um texto
        arquivos.add(simuladorDePDF()); // Poderia ser uma imagem

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(corpoEmail);

        int index = 0;
        for (FileInputStream fileInputStream : arquivos) {
            // Parte 2 do email que são os anexos em pdf
            MimeBodyPart anexoEmail = new MimeBodyPart();

            // Onde é passado o simulador de pdf, pode passar o arquivo gravado no banco de dados ou de outro local também
            anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(fileInputStream, "application/pdf")));
            anexoEmail.setFileName("anexo" + index + ".pdf");

            multipart.addBodyPart(anexoEmail);

            index++;
        }

        message.setContent(multipart);

        Transport.send(message);
    }

    private FileInputStream simuladorDePDF() throws Exception {
        Document document = new Document();
        File file = new File("anexo.pdf");
        file.createNewFile();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        document.add(new Paragraph("Conteúdo do PDF anexo com Java Mail"));
        document.close();
        return new FileInputStream(file);
    }
}