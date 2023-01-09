package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import common.DBConnection;
import common.Libreria;
import common.Usuario;
import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class RenombrarArchivo implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;
	private DBConnection conex;
	private Usuario user;

	public RenombrarArchivo(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo,
			ControladorLista controlLista, DBConnection conex, Usuario user) {
		this.vista = vista;
		this.cliente = cliente;
		this.modelo = modelo;
		this.controlLista = controlLista;
		this.conex = conex;
		this.user = user;
	}

	public void actionPerformed(ActionEvent e) {
		String directorio = modelo.getDirecSelec();

		if ((!modelo.getDirecSelec().equals("/"))) {
			directorio = directorio;
		}
		if ((!modelo.getFicheroSelec().equals(""))) {
			renombrarArchivo(directorio + modelo.getFicheroSelec(), modelo.getFicheroSelec());
			Libreria.escribirLog(conex, user, user.getMail(), "renombrar archivo", ConexionFtp.getFicheroSelec());
		}

	}

	private void renombrarArchivo(String string, String ficheroSelec) {
		String nombreNuevo = JOptionPane.showInputDialog(null, "Escribe nombre nuevo del fichero " + ficheroSelec);
		if (!(nombreNuevo == null)) {
			if (!(nombreNuevo.isEmpty() || nombreNuevo.length()<2)) {
				try {
					nombreNuevo.trim();
					cliente.setFileType(FTP.BINARY_FILE_TYPE);
					String extension = ficheroSelec.substring(ficheroSelec.lastIndexOf('.'));
					if (cliente.rename(ficheroSelec,nombreNuevo.concat(extension))) {
						JOptionPane.showMessageDialog(vista, "Archivo Renombrado Correctamente");
						cliente.changeWorkingDirectory(modelo.getDirecSelec());
						FTPFile[] lista = null;
						lista = cliente.listFiles();
						controlLista.llenarLista(lista, modelo.getDirecSelec());
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido renombrar el archivo " + ficheroSelec);
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}else {
				JOptionPane.showMessageDialog(vista, "Debe tener un nombre válido. (Mín: 2 Caracteres).");
			}
		}
	}

}
