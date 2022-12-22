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
	
	int numeroBotones = 7;
	
	String textoSubir = "Subir Archivo";
	String textoBajar = "Bajar Archivo";
	String textoBorrar = "Borrar Archivo";
	String textoRenombrar = "Renombrar";
	String textoVolver = "Volver";
	String textoServidor = "Servidor: ";
	String textoArchivo = "Archivo: ";
	String textoDirActual = "Directorio Actual: ";
	String textoUsuario = "Usuario: ";
	
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

	public int getNumeroBotones() {
		return numeroBotones;
	}

	public void setNumeroBotones(int numeroBotones) {
		this.numeroBotones = numeroBotones;
	}

	public String getTextoSubir() {
		return textoSubir;
	}

	public void setTextoSubir(String textoSubir) {
		this.textoSubir = textoSubir;
	}

	public String getTextoBajar() {
		return textoBajar;
	}

	public void setTextoBajar(String textoBajar) {
		this.textoBajar = textoBajar;
	}

	public String getTextoBorrar() {
		return textoBorrar;
	}

	public void setTextoBorrar(String textoBorrar) {
		this.textoBorrar = textoBorrar;
	}

	public String getTextoRenombrar() {
		return textoRenombrar;
	}

	public void setTextoRenombrar(String textoRenombrar) {
		this.textoRenombrar = textoRenombrar;
	}

	public String getTextoVolver() {
		return textoVolver;
	}

	public void setTextoVolver(String textoVolver) {
		this.textoVolver = textoVolver;
	}

	public String getTextoServidor() {
		return textoServidor;
	}

	public void setTextoServidor(String textoServidor) {
		this.textoServidor = textoServidor;
	}

	public String getTextoArchivo() {
		return textoArchivo;
	}

	public void setTextoArchivo(String textoArchivo) {
		this.textoArchivo = textoArchivo;
	}

	public String getTextoDirActual() {
		return textoDirActual;
	}

	public void setTextoDirActual(String textoDirActual) {
		this.textoDirActual = textoDirActual;
	}

	public String getTextoUsuario() {
		return textoUsuario;
	}

	public void setTextoUsuario(String textoUsuario) {
		this.textoUsuario = textoUsuario;
	}
	
	
}
