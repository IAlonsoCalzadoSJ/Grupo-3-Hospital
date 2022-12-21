package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class RenombrarArchivo implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;
	
	public RenombrarArchivo(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo,
			ControladorLista controlLista) {
		this.vista = vista;
		this.cliente = cliente;
		this.modelo = modelo;
		this.controlLista = controlLista;
	}

	public void actionPerformed(ActionEvent e) {
		String directorio = modelo.getDirecSelec();
		
		if((!modelo.getDirecSelec().equals("/"))) {
			directorio = directorio;
		}
		if((!modelo.getFicheroSelec().equals(""))) {
			renombrarArchivo(directorio+modelo.getFicheroSelec(),modelo.getFicheroSelec());
			modelo.setFicheroSelec("");
		}
		
	}

	private void renombrarArchivo(String string, String ficheroSelec) {
		String nombreNuevo = JOptionPane.showInputDialog(null,"Escribe nombre nuevo de fichero");
		if(!(nombreNuevo.isEmpty())) {
			try {
				nombreNuevo.trim();
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				String extension = ficheroSelec.substring(ficheroSelec.lastIndexOf('.'));
				if(cliente.rename(ficheroSelec, nombreNuevo+extension)) {
					JOptionPane.showMessageDialog(vista, "Archivo Renombrado Correctamente");
					cliente.changeWorkingDirectory(modelo.getDirecSelec());
					FTPFile[] lista = null;
					lista = cliente.listFiles();
					controlLista.llenarLista(lista, modelo.getDirecSelec());
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podido renombrar el archivo "+ficheroSelec);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			JOptionPane.showMessageDialog(vista, "Debes introducir un nombre válido");
		}
		
	}

}
