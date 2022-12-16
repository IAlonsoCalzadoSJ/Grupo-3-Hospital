/**
 * 
 */
package common;

import javax.mail.internet.InternetAddress;

/**
 * @author Israel
 *
 */
public class Usuario {
	private InternetAddress[] mail;
	private int group;

	public InternetAddress[] getMail() {
		return mail;
	}

	public int getGroup() {
		return group;
	}

	public Usuario(InternetAddress[] validMail, int int1) {
		super();
		this.mail = validMail;
		this.group = int1;
	}
}
