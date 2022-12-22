/**
 * 
 */
package common;

/**
 * @author Israel
 *
 */
public class Usuario {
	private String mail;
	private String user;
	private int group;
	private String doctor;
	private boolean leerAjena;
	private boolean modificarPropia;
	private String password;
	
	public Usuario(String mail, String user, int group, String doctor, boolean leerAjena, boolean modificarPropia, String password) {
		super();
		this.mail = mail;
		this.user = user;
		this.group = group;
		this.doctor = doctor;
		this.leerAjena = leerAjena;
		this.modificarPropia = modificarPropia;
		this.password =  password;
	}

	public String getMail() {
		return mail;
	}

	public String getUser() {
		return user;
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

	public String getPassword() {
		return password;
	}
}
