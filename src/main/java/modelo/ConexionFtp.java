package modelo;

public class ConexionFtp {

	String servidor = "127.0.0.1";
	String user = "usuario1";
	String pasw = "admin";
	int puerto = 21;
	boolean login;
	static String direcInicial = "/";
	
	static String direcSelec = direcInicial;
	static String ficheroSelec = "";
	
	public ConexionFtp() {
		
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasw() {
		return pasw;
	}

	public void setPasw(String pasw) {
		this.pasw = pasw;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public static String getDirecInicial() {
		return direcInicial;
	}

	public static void setDirecInicial(String direcInicial) {
		ConexionFtp.direcInicial = direcInicial;
	}

	public static String getDirecSelec() {
		return direcSelec;
	}

	public static void setDirecSelec(String direcSelec) {
		ConexionFtp.direcSelec = direcSelec;
	}

	public static String getFicheroSelec() {
		return ficheroSelec;
	}

	public static void setFicheroSelec(String ficheroSelec) {
		ConexionFtp.ficheroSelec = ficheroSelec;
	}
	
	
}
