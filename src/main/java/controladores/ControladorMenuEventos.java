package controladores;

import org.apache.commons.net.ftp.FTPClient;

import ftp.VentanaSwingFTP;
import ftp.VistaFTP;
import modelo.ConexionFtp;

public class ControladorMenuEventos {

	private static VentanaSwingFTP vista;
	private static ConexionFtp modelo;
	static FTPClient cliente = new FTPClient();
	private static ControladorLista controlLista;
	
	public ControladorMenuEventos() {
		vista = new VentanaSwingFTP();
		modelo = new ConexionFtp();
		
		vista.setVisible(true);
		controlLista = new ControladorLista(vista,modelo,cliente);
		eventos();
	}

	private void eventos() {
		
		
		//Evento Listener de Lista De Archivos del JList FTP
		vista.getListArchivos().addListSelectionListener(new EventoListaArchivos(vista, cliente, modelo, controlLista));
		
		//Evento Boton Subir Archivo FTP
		vista.getBtnSubir().addActionListener(new SubirArchivo(vista,cliente,modelo,controlLista));
		
		//Evento Boton Bajar Archivo FTP
		vista.getBtnBajar().addActionListener(new BajarArchivo(vista,cliente,modelo,controlLista));
		
		//Evento del Botón Volver FTP
		vista.getBtnVolver().addActionListener(new EventoVolver(vista,cliente));
		
	}
}
