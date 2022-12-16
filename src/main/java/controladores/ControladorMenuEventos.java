package controladores;

import org.apache.commons.net.ftp.FTPClient;

import ftp.VentanaSwingFTP;
import ftp.VistaFTP;
import modelo.ConexionFtp;

public class ControladorMenuEventos {

	private static VentanaSwingFTP vista;
	private static ConexionFtp modelo;
	static FTPClient cliente = new FTPClient();
	
	
	
	public ControladorMenuEventos() {
		vista = new VentanaSwingFTP();
		modelo = new ConexionFtp();
		
		vista.setVisible(true);
		controladorLista();
		eventos();
	}

	

	private void controladorLista() {
		ControladorLista controlLista = new ControladorLista(vista,modelo,cliente);
	}



	private void eventos() {
		
		//Evento Boton Subir Archivo
		
		
	}
}
