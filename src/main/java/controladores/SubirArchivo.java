package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class SubirArchivo implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;
	
	public SubirArchivo(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo, ControladorLista controlLista) {
		this.cliente = cliente;
		this.vista = vista;
		this.modelo = modelo;
		this.controlLista = controlLista;
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		File file;
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("Busca el fichero a subir al servidor FTP");
		int valor = chooser.showDialog(chooser, "Escoger");
		if(valor == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			String fichero = file.getAbsolutePath();
			String nombreFichero = file.getName();
			try {
				subirFichero(fichero,nombreFichero);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	private boolean subirFichero(String fichero, String nombreFichero) throws IOException {
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(fichero));
		boolean correcto = false;
		cliente.changeWorkingDirectory(modelo.getDirecSelec());
		if(cliente.storeFile(nombreFichero, in)) {
			JOptionPane.showMessageDialog(vista, nombreFichero+" Subido correctamente");
			FTPFile[] lista = null;
			lista = cliente.listFiles();
			controlLista.llenarLista(lista, modelo.getDirecSelec());
			correcto = true;
		}else {
			JOptionPane.showMessageDialog(vista, "No se ha podido subir el archivo");
		}
		return correcto;
	}

}
