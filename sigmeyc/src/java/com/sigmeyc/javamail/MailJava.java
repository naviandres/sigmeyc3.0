/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigmeyc.javamail;

//Email email = new Email(parametros);
//email.enviar.....
import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author SENA
 */
public class MailJava {

    public final static String HOST_EMAIL_GMAIL = "smtp.gmail.com";

    private String emailRemitente;
    private String passRemitente;
    private String emailDestinatario;

    private Session session;
    private MimeMessage mimeMessage;

    public MailJava() {
    }

    public MailJava(String emailRemitente, String passRemitente, String emailDestinatario) {
        this.emailRemitente = emailRemitente;
        this.passRemitente = passRemitente;
        this.emailDestinatario = emailDestinatario;
    }

    private void init() {
        try {
            Properties propiedades = new Properties();

            propiedades.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
            propiedades.setProperty("mail.smtp.starttls.enable", "true");
            propiedades.setProperty("mail.smtp.port", "25");//587-25
            propiedades.setProperty("mail.smtp.user", this.emailRemitente);
            propiedades.setProperty("mail.smtp.auth", "true");

            session = Session.getDefaultInstance(propiedades);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(emailRemitente));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));

        } catch (Exception ex) {
            Logger.getLogger(MailJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean enviarBasic(String asunto, String contenido) {
        try {
            init();
            mimeMessage.setSubject(asunto);
            //mimeMessge.setText(contenido);
            mimeMessage.setContent(contenido, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(emailRemitente, passRemitente);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException mex) {
            Logger.getLogger(MailJava.class.getName()).log(Level.SEVERE, null, mex);
            return false;
        }
    }

    private void init2() {
        try {
            Properties propiedades = new Properties();

            propiedades.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
            propiedades.setProperty("mail.smtp.starttls.enable", "true");
            propiedades.setProperty("mail.smtp.port", "25");//587-25
            propiedades.setProperty("mail.smtp.user", this.emailRemitente);
            propiedades.setProperty("mail.smtp.auth", "true");

            session = Session.getDefaultInstance(propiedades);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(emailRemitente));
            mimeMessage.setRecipients(Message.RecipientType.TO, emailDestinatario);

        } catch (Exception ex) {
            Logger.getLogger(MailJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean enviarMasivo(String asunto, String contenido) {
        try {
            init2();
            mimeMessage.setSubject(asunto);
            //mimeMessge.setText(contenido);
            mimeMessage.setContent(contenido, "text/html");
            Transport transport = session.getTransport("smtp");
            transport.connect(emailRemitente, passRemitente);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException mex) {
            Logger.getLogger(MailJava.class.getName()).log(Level.SEVERE, null, mex);
            return false;
        }
    }

    public boolean enviar(String asunto, String contenido) {
        try {
            init();

            Multipart contenidoMensaje = new MimeMultipart();

            BodyPart adjunto = new MimeBodyPart();
            File file = new File("/media/ivan/Nuevo vol/SENA-ADSI/Fase4b/proyecto/sigmeyc/sigmeyc/web/resources/img/headerr.jpg");
            adjunto.setDataHandler(new DataHandler(new FileDataSource(file)));
            adjunto.setFileName(file.getName());

            contenidoMensaje.addBodyPart(adjunto);
            BodyPart texto = new MimeBodyPart();
            texto.setContent(contenido + "<hl>Attached image</hl>"
                    + "<img src=\"cid:image_id\"/>", "text/html");
            mimeMessage.setSubject(asunto);
            mimeMessage.setContent(contenidoMensaje);
            //mimeMessge.setText(contenido);

            Transport transport = session.getTransport("smtp");
            transport.connect(emailRemitente, passRemitente);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException mex) {
            Logger.getLogger(MailJava.class.getName()).log(Level.SEVERE, null, mex);
            return false;
        }
    }

}
