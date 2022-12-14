/**
 * 
 */
package correo;








import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import org.jsoup.Jsoup;




/**
 * @author Israel
 *
 */
public class ClienteCorreo {
	public static void main(String[] args) {
		//Properties props = new Properties( );
		Properties prop = new Properties();

		// Deshabilitamos TLS
		prop.setProperty("mail.pop3.starttls.enable","false");

		// Hay que usar SSL
		prop.setProperty("mail.pop3.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.pop3.socketFactory.fallback","false");

		// Puerto 995 para conectarse.
		prop.setProperty("mail.pop3.port","995");
		prop.setProperty("mail.pop3.socketFactory.port","995");
	
		String host = "pop.gmail.com";
		String username = "miguelangelmeridamedina.sanjose@alumnado.fundacionloyola.net";
		String password = "12345678";
		String provider = "pop3";
		
		try {
			//			
			//
		Session session = Session.getDefaultInstance(prop, null);
		
		Store store = session.getStore(provider);
		store.connect(host, username, password);
		Folder inbox = store.getFolder("INBOX");
		if (inbox == null) {
		System.out.println("No INBOX");
		System.exit(1);
		}
		inbox.open(Folder.READ_ONLY);
		Message[] messages = inbox.getMessages( );
		/*for (int j =0; j < 1; j++) {
		System.out.println("---------------Message " + (j+1) + " ---------------");
		messages[j].writeTo(System.out);
		}*/
		//el que recibe
	//Address[] a=messages[messages.length-1].getAllRecipients();
		//el que se lo ha enviado pero hay que tocar lo que devuelve
		//Address[] a=messages[messages.length-1].getReplyTo();
		
		//Fecha y hora del correo
		//Date a=messages[messages.length-1].getSentDate();
		//Asunto del correo
		//String a=messages[messages.length-1].getSubject();
		Messages m= new Messages();
		String a=m.getTextFromMessage( messages[messages.length-1]);
	    System.out.print(a);
		inbox.close(false);
		
		store.close( );
		}
		catch (Exception er) {
		er.printStackTrace( );
		}
		
		
		}
		
	
	
	
	
	
	

}
