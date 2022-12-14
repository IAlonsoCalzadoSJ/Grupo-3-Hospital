/**
 * 
 */
package correo;

import java.util.Properties;

/**
 * @author Israel
 *
 */
public class ClienteCorreo {	

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.user", "alvaropalacioscabrera.sanjose@alumnado.fundacionloyola.net");
		properties.put("mail.password", "password");
		
		Session session = Session.getInstance(properties, null);;
	}
}
