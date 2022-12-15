package ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class PruebaSubidaBajada {

	public static void main(String[] args) {

		final String SERVIDOR = "127.0.0.1";
		final int PUERTO = 21;
		final String USUARIO = "usuario1";
		final String PASSWORD = "admin";

		FTPClient cliente = new FTPClient();

		try {
			cliente.connect(SERVIDOR, PUERTO);

			int respuesta = cliente.getReplyCode();

			if (!FTPReply.isPositiveCompletion(respuesta)) {
				System.out.println("No se ha podido conectar al servidor, respuesta: " + respuesta);
			}

			boolean loginSatisfactorio = cliente.login(USUARIO, PASSWORD);

			if (loginSatisfactorio) {
				System.out.println("Se ha iniciado sesión en el servidor FTP");
			} else {
				System.out.println("Las credenciales son inválidas");
				cliente.disconnect();
			}

//		String rutaFicheros = cliente.printWorkingDirectory();
			// Mostrar directorio actual
//		System.out.println("Directorio actual: " + rutaFicheros);

			// Ficheros en el directorio actual
//		FTPFile[] files = cliente.listFiles();

			// ---------Subir archivos----------//

//		cliente.setFileType(FTP.BINARY_FILE_TYPE);
//		
//		String ruta = "C:/Datos/Companies.txt";
//		BufferedInputStream buffEntrada = new BufferedInputStream(new FileInputStream(ruta));
//
//		cliente.storeFile("Companies.txt", buffEntrada);
//		System.out.println("Archivo Companies.txt subido");
//		buffEntrada.close();

			// --------Bajar Archivos----------//

			// Forma 1
//		cliente.setFileType(FTP.BINARY_FILE_TYPE);
//		String ficheroDescargar = "Companies.txt";
//		String rutaDescargar = "C:/Datos/Companies.txt";
//		
//		BufferedOutputStream buffSalida = new BufferedOutputStream(new FileOutputStream(rutaDescargar));
//		
//		cliente.retrieveFile(ficheroDescargar, buffSalida);
//		buffSalida.close();

			// ------------Renombrar-----------//

//		cliente.setFileType(FTP.BINARY_FILE_TYPE);
//		String antiguo = "gato.jpeg";
//		String nuevo = "GatoFeo.jpeg";
//		
//		boolean success = cliente.rename(antiguo, nuevo);
//		
//		if(success) {
//			System.out.println(antiguo+" Modificado correctamente");
//		}else {
//			System.out.println("No se ha podido modificar");
//		}

			// -----------Borrar Archivo-------//

//		String archivoBorrar = "Companies.txt";
//		
//		boolean deleted = cliente.deleteFile(archivoBorrar);
//		
//		if(deleted) {
//			System.out.println("Archivo Borrado");
//		}else {
//			System.out.println("No se puede Borrar");
//		}

			
			//-------------Moverse directorio---------//
			
			loginSatisfactorio = cliente.changeWorkingDirectory("/Carpeta2");
			
			verDirectorio(cliente);
			if(loginSatisfactorio) {
				System.out.println("Se ha cambiado correctamente de directorio");
			}else {
				System.out.println("No se ha podido cambiar");
			}
			
			System.out.println("Estoy en el directorio: "+cliente.printWorkingDirectory());
//			
//			//Subir fichero en esta carpeta
//			cliente.setFileType(FTP.BINARY_FILE_TYPE);
//			
//			String ruta = "C:/Datos/Companies.txt";
//			BufferedInputStream buffEntrada = new BufferedInputStream(new FileInputStream(ruta));
//	
//			cliente.storeFile("Companies.txt", buffEntrada);
//			System.out.println("Archivo Companies.txt subido");
//			buffEntrada.close();
			
			
			//---------------Crear Carpeta y eliminar------------//
			
//			String nombreCarpeta = "CarpetaCreada";
//			loginSatisfactorio = cliente.makeDirectory(nombreCarpeta);
//			if(loginSatisfactorio) {
//				System.out.println("La carpeta "+nombreCarpeta+" se ha creado correctamente en "+cliente.printWorkingDirectory());
//			}else {
//				System.out.println("no se ha podido crear el directorio");
//			}
			
			String nombreCarpetaBorrar = "CarpetaCreada";
			loginSatisfactorio = cliente.removeDirectory(nombreCarpetaBorrar);
			if(loginSatisfactorio) {
				System.out.println("Borrado correctamente");
			}else {
				System.out.println("No se ha podido borrar");
			}
			
			// ------------SubirCarpeta con ficheros-----------------//

//			cliente.enterLocalActiveMode();
//			
//			String rutaRemota = "/Carpeta1";
//			String rutaLocal = "C:/Datos/muchosDatos";
//
//			subirDirectorio(cliente, rutaRemota, rutaLocal, "");
//
			// Cerrar sesión en el servidor
			cliente.logout();
			// Desconectarse del servidor
			cliente.disconnect();

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}

	}
	
	private static void verDirectorio(FTPClient client) {
		String[] replies = client.getReplyStrings();
		if(replies != null && replies.length > 0) {
			for(String reply : replies) {
				System.out.println("Server: "+reply);
			}
		}
	}

}
