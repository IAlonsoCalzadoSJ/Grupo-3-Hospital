package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class EventoListaArchivos extends MouseAdapter implements ListSelectionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;
	

	public EventoListaArchivos(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo,
			ControladorLista controlLista) {
		this.vista = vista;
		this.cliente = cliente;
		this.modelo = modelo;
		this.controlLista = controlLista;
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			
			String ficSelec = "";
			String fic = vista.getListArchivos().getSelectedValue().toString();
			
			if (vista.getListArchivos().getSelectedIndex() == 0) {
				
				if (!fic.equals(modelo.getDirecInicial())) {
					try {
						cliente.changeToParentDirectory();
						modelo.setDirecSelec(cliente.printWorkingDirectory());
						FTPFile[] lista = null;
						cliente.changeWorkingDirectory(modelo.getDirecSelec());
						lista = cliente.listFiles();
						controlLista.llenarLista(lista, modelo.getDirecSelec());
					} catch (IOException e2) {
						// TODO: handle exception
					}
				}
			} else {
				// Directorio
				if (fic.substring(0, 6).equals("(DIR) ")) {
					try {
						fic = fic.substring(6);
						String otroSelec = "";
						if (modelo.getDirecSelec().equals("/")) {
							otroSelec = modelo.getDirecSelec() + fic;
							modelo.setDirecSelec(otroSelec);
						} else {
							otroSelec = modelo.getDirecSelec() + "/" + fic;
							modelo.setDirecSelec(otroSelec);
						}
						FTPFile[] lista = null;
						cliente.changeWorkingDirectory(otroSelec);
						lista = cliente.listFiles();
						vista.getLblRutaDirectorio().setText(fic + " - " + lista.length + " Ficheros.");
						modelo.setDirecSelec(otroSelec);
						vista.getLblRutaDirActual().setText("/" + modelo.getDirecSelec());
						controlLista.llenarLista(lista, modelo.getDirecSelec());
						
					} catch (IOException e2) {
						// TODO: handle exception
					}
				} else {
					// Fichero
					ficSelec = modelo.getDirecSelec();
					if (modelo.getDirecSelec().equals("/")) {
						ficSelec += fic;
					} else {
						ficSelec += "/" + fic;
					}
					ficSelec = fic;
					vista.getLblRutaDirectorio().setText(fic);
					vista.getLblRutaDirActual().setText(modelo.getDirecSelec());
					modelo.setFicheroSelec(ficSelec);
				}
				vista.getLblRutaDirActual().setText(modelo.getDirecSelec());
			}
		}
	}
	public void mouseClicked(MouseEvent evt) {
		if(evt.getClickCount() == 2) {
			
		}
	}
	
	
}
