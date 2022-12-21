package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class BorrarCarpeta implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;
	
	public BorrarCarpeta(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo, ControladorLista controlLista) {
		this.cliente = cliente;
		this.vista = vista;
		this.modelo = modelo;
		this.controlLista = controlLista;
	}

	public void actionPerformed(ActionEvent e) {
		String nombreCarpeta = JOptionPane.showInputDialog(vista,"Introduce nombre de carpeta a borrar");
		if(!(nombreCarpeta == null)) {
			String directorio = modelo.getDirecSelec();
						if(!modelo.getDirecSelec().equals("/")) 
				directorio = directorio+"/";
				
			directorio += nombreCarpeta.trim();
			try {
				cliente.changeToParentDirectory();
				if(cliente.removeDirectory(modelo.getDirecSelec())) {
					JOptionPane.showMessageDialog(vista, "Carpeta Borrada Correctamente");
					cliente.changeWorkingDirectory(modelo.getDirecSelec());
					FTPFile[] lista = null;
					lista = cliente.listFiles();
					controlLista.llenarLista(lista, modelo.getDirecSelec());
				}else {
					JOptionPane.showMessageDialog(vista, "No se ha podido borrar la carpeta");
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(vista, "Debe introducir un Nombre válido");
	}

}
