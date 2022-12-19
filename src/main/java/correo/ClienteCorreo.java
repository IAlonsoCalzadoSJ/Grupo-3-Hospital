/**
 * 
 */
package correo;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ClienteCorreo {

	private static String remitente = "alvaropalacioscabrera.sanjose@alumnado.fundacionloyola.net";
	private static String claveemail = "rlfcwbbjbeaygsoe";
	
	public static void main(String[] args) {
	
<<<<<<< Updated upstream
	String remitente = "alvaropalacioscabrera.sanjose@alumnado.fundacionloyola.net";
	String claveemail = "rlfcwbbjbeaygsoe";
=======
		Properties properties = System.getProperties();	
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.user",remitente);
		properties.put("mail.smtp.clave",claveemail);
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(properties);
	    MimeMessage message = new MimeMessage(session);
>>>>>>> Stashed changes
	
	    
    try {
        message.setFrom(new InternetAddress(remitente));
<<<<<<< Updated upstream
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("miguelangelmeridamedina.sanjose@alumnado.fundacionloyola.net"));   //Se podrían añadir varios de la misma manera
        message.setSubject("Probando jtable3");
=======
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("alvaropalacioscabrera.sanjose@alumnado.fundacionloyola.net"));   //Se podrían añadir varios de la misma manera
        message.setSubject("Probando mandar mensajes con imagenes parte 28");
>>>>>>> Stashed changes
        message.setText("Esto es una prueba de mensaje adjuntando");
        MimeMultipart mimeMultipart = new MimeMultipart();
        MimeBodyPart mimeBodyPartTexto = new MimeBodyPart();
        mimeBodyPartTexto.setText("Probando jtable2");
        MimeBodyPart mimeBodyPartAdjunto = new MimeBodyPart();
        mimeBodyPartAdjunto.attachFile("C:\\Users\\alvar\\Desktop\\imagen\\libroCompleto.pdf");
        mimeMultipart.addBodyPart(mimeBodyPartAdjunto);
        mimeMultipart.addBodyPart(mimeBodyPartTexto);
        message.setContent(mimeMultipart);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", remitente, claveemail);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException | IOException me) {
        me.printStackTrace();   //Si se produce un error
    }
	}

}