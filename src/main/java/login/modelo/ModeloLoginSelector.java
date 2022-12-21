/**
 * 
 */
package login.modelo;

/**
 * @author Israel
 *
 */
public class ModeloLoginSelector {
	private static final String txtEmail = "e-Mail";
	private static final String txtPassword = "Contraseña";
	private static final String txtLogin = "Login";
	private static final String sqlConsultaUsuario = "select correo, permisos from usuarios where correo like ? and password = sha(?);";
	private static final String sqlCampoPermisos = "permisos";
	private static final String errLoginNoUsuarioTexto = "No se ha encontrado esa combinacion de usuario y contraseña";
	private static final String errloginNoUsuarioTitulo = "Error login";
	private static final String errLoginCorreoErroneoTexto = "Direccion de correo no valida";
	private static final String errLoginCorreoErroneoTitulo = "Error correo";
	private static final String errLoginBDTexto = "Error accediendo a los datos de usuarios";
	private static final String errLoginBDTitulo = "Error BBDD";
	private static final String errLoginNoTextTexto = "No se permiten campos vacios en usuario o contraseña";
	private static final String cfgFuenteVistaLogin = "Tahoma";
	private static final String cfgFuenteVistaSelector = "Sitka Text";
	private static final String txtFtp = "FTP";
	private static final String txtManual = "Manual";
	private static final String txtVolver = "Volver";
	
	public static String getTxtemail() {
		return txtEmail;
	}
	public static String getTxtpassword() {
		return txtPassword;
	}
	public static String getTxtlogin() {
		return txtLogin;
	}
	public static String getSqlconsultausuario() {
		return sqlConsultaUsuario;
	}
	public static String getSqlcampopermisos() {
		return sqlCampoPermisos;
	}
	public static String getErrloginnousuariotexto() {
		return errLoginNoUsuarioTexto;
	}
	public static String getErrloginnousuariotitulo() {
		return errloginNoUsuarioTitulo;
	}
	public static String getErrlogincorreoerroneotexto() {
		return errLoginCorreoErroneoTexto;
	}
	public static String getErrlogincorreoerroneotitulo() {
		return errLoginCorreoErroneoTitulo;
	}
	public static String getErrloginbdtexto() {
		return errLoginBDTexto;
	}
	public static String getErrloginbdtitulo() {
		return errLoginBDTitulo;
	}
	public static String getCfgfuentevistalogin() {
		return cfgFuenteVistaLogin;
	}
	public static String getCfgfuentevistaselector() {
		return cfgFuenteVistaSelector;
	}
	public static String getTxtftp() {
		return txtFtp;
	}
	public static String getTxtmanual() {
		return txtManual;
	}
	public static String getTxtvolver() {
		return txtVolver;
	}
	public static String getErrloginnotexttexto() {
		return errLoginNoTextTexto;
	}	
}
