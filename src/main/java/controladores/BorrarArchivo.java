package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class BorrarArchivo implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;

	public BorrarArchivo(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo, ControladorLista controlLista) {
		this.cliente = cliente;
		this.vista = vista;
		this.modelo = modelo;
		this.controlLista = controlLista;
	}

	public void actionPerformed(ActionEvent e) {
		String directorio = modelo.getDirecSelec();
		if (!modelo.getDirecSelec().equals("/")) {
			directorio = directorio;
		}
		if (!modelo.getFicheroSelec().equals("")) {
			BorrarFichero(directorio + modelo.getFicheroSelec(), modelo.getFicheroSelec());
		}
	}

	private void BorrarFichero(String fichero, String nombreFichero) {
		int eleccion = JOptionPane.showConfirmDialog(vista, "¿Seguro que quiere eliminar el fichero "+nombreFichero+"?");
		if (eleccion == JOptionPane.OK_OPTION) {
			try {
				if (cliente.deleteFile(nombreFichero)) {
					JOptionPane.showMessageDialog(vista, "Archivo " + nombreFichero + " Borrado Correctamente.");
					cliente.changeWorkingDirectory(modelo.getDirecSelec());
					FTPFile[] lista = null;
					lista = cliente.listFiles();
					controlLista.llenarLista(lista, modelo.getDirecSelec());
					modelo.setFicheroSelec("");
				} else {
					JOptionPane.showMessageDialog(vista, "No se ha podido borrar el archivo " + nombreFichero + ".");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
