package correo;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;

public class Enviar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //La dirección de correo de envío
	    String remitente = "miguelangelmeridamedina.sanjose@alumnado.fundacionloyola.net";
	    String destinatario = "miguelangelmeridamedina.sanjose@alumnado.fundacionloyola.net";
	    //La clave de aplicación obtenida según se explica en este artículo:
	    String claveemail = "12345678";

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
	        message.setSubject("Piston");
	        BodyPart texto = new MimeBodyPart();
	        texto.setText("Texto del mensaje");	
	        BodyPart adjunto = new MimeBodyPart();
	        adjunto.setDataHandler(new DataHandler(new FileDataSource("C:\\datos\\fx2.jpg")));
	        adjunto.setFileName("fx.jpg");
	        MimeMultipart multiParte = new MimeMultipart();

	        multiParte.addBodyPart(texto);
	        multiParte.addBodyPart(adjunto);
	        message.setContent(multiParte);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, claveemail);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}

}
