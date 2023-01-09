package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import common.DBConnection;
import common.Libreria;
import common.Usuario;
import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class BajarArchivo implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ControladorLista controlLista;
	private DBConnection conex;
	private Usuario user;

	public BajarArchivo(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo, ControladorLista controlLista, DBConnection conex, Usuario user) {
		this.cliente = cliente;
		this.controlLista = controlLista;
		this.cliente = cliente;
		this.conex = conex;
		this.user = user;
	}

	public void actionPerformed(ActionEvent e) {
		String directorio = ConexionFtp.getDirecSelec();
		if (!ConexionFtp.getDirecSelec().equals("/")) {
			directorio = directorio + "/";
		}
		;

		if (!ConexionFtp.getFicheroSelec().equals("")) {
			bajarArchivo(directorio + ConexionFtp.getFicheroSelec(), ConexionFtp.getFicheroSelec());
			Libreria.escribirLog(conex, user, user.getMail(), "bajar archivo", ConexionFtp.getFicheroSelec());
			
		}
		;

	}

	private void bajarArchivo(String fichero, String nombreFichero) {
		File file;
		String destino = "";
		String carpetaDestino = "";
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setDialogTitle("Selecciona la carpeta donde descargar el archivo "+nombreFichero);

		int val = chooser.showDialog(chooser, "Descargar");
		if (val == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			carpetaDestino = file.getAbsolutePath().toString();
			destino = carpetaDestino + File.separator + nombreFichero;
			try {
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destino));
				if (cliente.retrieveFile(nombreFichero, out)) {
					JOptionPane.showMessageDialog(null, nombreFichero + " Se ha descargado.");
					ConexionFtp.setFicheroSelec("");
				} else {
					JOptionPane.showMessageDialog(null, nombreFichero + " No se ha podido descargar.");
				}
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
