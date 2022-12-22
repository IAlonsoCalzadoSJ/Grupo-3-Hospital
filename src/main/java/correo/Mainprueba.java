package correo;

import javax.mail.internet.InternetAddress;

import common.Usuario;

public class Mainprueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String correo = "miguelangelmeridamedina.sanjose@alumnado.fundacionloyola.net";

		Usuario u = new Usuario(correo, 0, null, false, false, "12345678");
		ControladorEmail controlador = new ControladorEmail(u);
	}

}
