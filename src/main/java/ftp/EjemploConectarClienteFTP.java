package ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class EjemploConectarClienteFTP {

	public static void main(String[] args) throws IOException {
//		// Crear cliente ftp
//		FTPClient cliente = new FTPClient();
//
//		// Decir a qué servidor ftp me voy a conectar
//		String servidorFTP = "ftp.rediris.es";
//
//		// conectarse a ese servidor
//		cliente.connect(servidorFTP);
//
//		// string de respuesta de que nos hemos conectado al servidor
//		System.out.print(cliente.getReplyString());
//
//		// saber si el servidor nos ha mandado a tomar por el culo
//		int respuesta = cliente.getReplyCode();
//		if (!FTPReply.isPositiveCompletion(respuesta)) {
//			System.out.println("Te ha mandado a tomar por culo");
//			cliente.disconnect();
//		}
//
//		// desconectarse del servidor ftp
//		cliente.disconnect();

		//----------------------------------------------------------------------//
		
		// Crear cliente ftp
		FTPClient cliente = new FTPClient(); 
		
		// Decir a qué servidor ftp me voy a conectar
		String servidorFTP = "127.0.0.1";

		// conectarse a ese servidor
		cliente.connect(servidorFTP);

		String usuario="usuario1";
		String contraseña="";
		
		// logearse en el servidor (iniciar sesión de toda la vida)
		boolean loginCorrecto = cliente.login(usuario, contraseña);
		if (loginCorrecto) {
			System.out.println("Te has conectado al servidor");
		} else {
			System.out.println("ERROR: usuario o contraseña incorrectas");
			cliente.disconnect();
		}

		// Mostrar directorio actual
		System.out.println("Directorio actual: " + cliente.printWorkingDirectory());

		// Ficheros en el directorio actual
		FTPFile[] files = cliente.listFiles();

		for (int j = 0; j < files.length; j++) {
			// Mostrar el nombre de un fichero
			files[j].getName();
			// Mostrar el tipo de un fichero
			files[j].getType();
		}

		// Cerrar sesión en el servidor
		cliente.logout();

		// Desconectarse del servidor
		cliente.disconnect();
		
		//---------------------------------------------------------------//
		
		
	}

}
