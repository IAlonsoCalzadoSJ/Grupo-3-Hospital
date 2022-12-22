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
	private int group;
	private String doctor;
	private boolean leerAjena;
	private boolean modificarPropia;
	
	public Usuario(String mail, int group, String doctor, boolean leerAjena, boolean modificarPropia) {
		super();
		this.mail = mail;
		this.group = group;
		this.doctor = doctor;
		this.leerAjena = leerAjena;
		this.modificarPropia = modificarPropia;
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
