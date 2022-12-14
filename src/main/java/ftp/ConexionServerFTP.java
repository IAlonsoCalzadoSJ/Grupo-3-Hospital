package ftp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class ConexionServerFTP {

	public static void main(String[] args) {
		
		final String SERVIDOR = "127.0.0.1";
		final int PUERTO = 21;
		final String USUARIO = "usuario1";
		final String PASSWORD = "admin";
		
		FTPClient cliente = new FTPClient();
		
		try {
			cliente.connect(SERVIDOR,PUERTO);
			
			int respuesta = cliente.getReplyCode();
			
			if (!FTPReply.isPositiveCompletion(respuesta)) {
				System.out.println("No se ha podido conectar al servidor, respuesta: "+respuesta);
			}
			
			boolean loginSatisfactorio = cliente.login(USUARIO, PASSWORD);
			
		if(loginSatisfactorio) {
			System.out.println("Se ha iniciado sesión en el servidor FTP");
		}else {
			System.out.println("Las credenciales son inválidas");
			cliente.disconnect();
		}
			
		String rutaFicheros = cliente.printWorkingDirectory();
		// Mostrar directorio actual
		System.out.println("Directorio actual: " + rutaFicheros);

		// Ficheros en el directorio actual
		FTPFile[] files = cliente.listFiles();
//
//		for (int j = 0; j < files.length; j++) {
//		// Mostrar el nombre de un fichero y tipo
//		System.out.println(files[j].getName()+", "+files[j].getType());
//		}	
		
		buscarFicheroRuta(files);
		
		
			
		
		// Cerrar sesión en el servidor
		cliente.logout();
		// Desconectarse del servidor
		cliente.disconnect();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	private static void buscarFicheroRuta(FTPFile[] files) {
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName()+"--"+files[i].getType());
			
			
			
		}
	}

}
