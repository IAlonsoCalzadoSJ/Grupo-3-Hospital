/**
 * 
 */
package correo;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import org.jsoup.Jsoup;

import common.Usuario;

/**
 * @author Israel
 *
 */
public class ClienteCorreo {
	Usuario u;
	private Store st;

	public Store getSt() {
		return st;
	}

	public void setSt(Store st) {
		this.st = st;
	}

	public ClienteCorreo(Usuario u) {
		this.u = u;
		// Properties props = new Properties( );
		Properties prop = new Properties();

		// Deshabilitamos TLS
		prop.setProperty("mail.pop3.starttls.enable", "false");

		// Hay que usar SSL
		prop.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.pop3.socketFactory.fallback", "false");

		// Puerto 995 para conectarse.
		prop.setProperty("mail.pop3.port", "995");
		prop.setProperty("mail.pop3.socketFactory.port", "995");

		String host = "pop.gmail.com";
		String username = u.getMail();
		String password = u.getPassword();
		String provider = "pop3";

		try {

			Session session = Session.getDefaultInstance(prop, null);

			st = session.getStore(provider);
			st.connect(host, username, password);

			// t.todocorreo(store);

			//
			//
			// todocorreo(store);

			// String eleccion="";
			// Scanner sc= new Scanner(System.in);
			// System.out.println("Nuevos correos?");

			// eleccion=sc.nextLine();

			// inbox=null;
			// inbox.close();

			// store.close( );

		} catch (Exception er) {
			er.printStackTrace();
		}

	}

}
