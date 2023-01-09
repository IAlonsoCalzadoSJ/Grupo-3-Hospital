package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import common.DBConnection;
import common.Libreria;
import common.Usuario;
import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class BorrarArchivo implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;
	private DBConnection conex;
	private Usuario user;

	public BorrarArchivo(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo, ControladorLista controlLista, DBConnection conex, Usuario user) {
		this.cliente = cliente;
		this.vista = vista;
		this.modelo = modelo;
		this.controlLista = controlLista;
		this.conex = conex;
		this.user = user;
	}

	public void actionPerformed(ActionEvent e) {
		String directorio = modelo.getDirecSelec();
		if (!modelo.getDirecSelec().equals("/")) {
			directorio = directorio;
		}
		if (!modelo.getFicheroSelec().equals("")) {
			BorrarFichero(directorio + modelo.getFicheroSelec(), modelo.getFicheroSelec());
			Libreria.escribirLog(conex, user, user.getMail(), "borrar archivo", ConexionFtp.getFicheroSelec());
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
