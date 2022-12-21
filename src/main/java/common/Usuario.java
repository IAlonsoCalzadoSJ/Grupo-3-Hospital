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
	private String mail;
	private int group;
	private String doctor;
	private boolean leerAjena;
	private boolean modificarPropia;
	private String password;
	
	public Usuario(String mail, int group, String doctor, boolean leerAjena, boolean modificarPropia,String password) {
		super();
		this.mail = mail;
		this.group = group;
		this.doctor = doctor;
		this.leerAjena = leerAjena;
		this.modificarPropia = modificarPropia;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}



	public String getMail() {
		return mail;
	}

	public int getGroup() {
		return group;
	}

	public String getDoctor() {
		return doctor;
	}

	public boolean isLeerAjena() {
		return leerAjena;
	}

	public boolean isModificarPropia() {
		return modificarPropia;
	}
}
