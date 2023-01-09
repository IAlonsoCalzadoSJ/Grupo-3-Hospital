package correo;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import common.Usuario;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;

public class Enviar {
	MimeMessage message;
	String remitente;
	String destinatario;
	VistaEnviar e;
	Session session;
	String claveemail;
	Properties props;
	Usuario u;
	File f = null;

	public Enviar(Usuario u) {
		this.u = u;
		e = new VistaEnviar();
		e.setVisible(true);

		for (int i = 0; i < 3; i++) {
			e.getBotones().get(i).addActionListener(new EventoBotonesEnviar(e, this));
		}

		// Viene de clase Usuario

		remitente = u.getMail();

		// alvaropalacioscabrera.sanjose@alumnado.fundacionloyola.net
		// Viene de clase Usuario
		claveemail = u.getPassword();

		props = System.getProperties();

		props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", claveemail); // La clave de la cuenta
		props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
		props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google

		// session = Session.getDefaultInstance(props);
		session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remitente, claveemail);
			}
		});

		// session.setDebug(true);
		message = new MimeMessage(session);
		// enviar();
	}

	public void enviar() throws IOException {
		// TODO Auto-generated method stub
		// La dirección de correo de envío
		/*
		 * try { InternetAddress inte=new InternetAddress(e.getFieldPara().getText()); }
		 * catch(Exception r){
		 * System.out.println("La direccion:"+e.getFieldPara().getText()); }
		 */
		try {

			message.setFrom(new InternetAddress(remitente));

			// message.addRecipient(Message.RecipientType.TO, new
			// InternetAddress(e.getFieldPara().getText())); //Se podrían añadir varios de
			// la misma manera
			
			message.setSubject(e.getFieldCabecera().getText());
			message.addRecipients(Message.RecipientType.TO, e.getFieldPara().getText());
			MimeBodyPart texto = new MimeBodyPart();
			texto.setText(e.getPaneCuerpo().getText());
			MimeMultipart multiParte = new MimeMultipart();
			if (f!=null) {
				MimeBodyPart adjunto = new MimeBodyPart();
				adjunto.attachFile(f);

				multiParte.addBodyPart(adjunto);
			}

//System.out.print("detino:"+ e.getFieldPara().getText()+"cuerpo"+e.getPaneCuerpo().getText()+"subject"+e.getFieldCabecera().getText());
			multiParte.addBodyPart(texto);

			message.setContent(multiParte);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, claveemail);
			if(message.getContent().toString()==""||message.getAllRecipients()==null) {
			System.out.print("vacio");
			}
			else {
				e.dispose();
				transport.sendMessage(message, message.getAllRecipients());
			}
			transport.close();
		} catch (MessagingException me) {
			me.printStackTrace(); // Si se produce un error
		}
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}

}
