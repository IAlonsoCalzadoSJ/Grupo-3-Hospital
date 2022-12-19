package controladores;

import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class EventoListaArchivos implements ListSelectionListener {

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
			String direcSelec = modelo.getDirecInicial();
			String fic = vista.getListArchivos().getSelectedValue().toString();

			if (vista.getListArchivos().getSelectedIndex() == 0) {
				if (!fic.equals(modelo.getDirecInicial())) {
					try {
						cliente.changeToParentDirectory();
						direcSelec = cliente.printWorkingDirectory();
						FTPFile[] lista = null;
						cliente.changeWorkingDirectory(direcSelec);
						lista = cliente.listFiles();
						controlLista.llenarLista(lista, direcSelec);
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
						if (direcSelec.equals("/")) {
							otroSelec = direcSelec + fic;
						} else {
							otroSelec = direcSelec + "/" + fic;
						}
						FTPFile[] lista = null;
						cliente.changeWorkingDirectory(otroSelec);
						lista = cliente.listFiles();
						vista.getLblRutaDirectorio().setText(fic + " - " + lista.length + " Ficheros.");
						direcSelec = otroSelec;
						vista.getLblRutaDirActual().setText("/" + direcSelec);
						controlLista.llenarLista(lista, direcSelec);
					} catch (IOException e2) {
						// TODO: handle exception
					}
				} else {
					// Fichero
					ficSelec = direcSelec;
					if (direcSelec.equals("/")) {
						ficSelec += fic;
					} else {
						ficSelec += "/" + fic;
					}
					ficSelec = fic;
					vista.getLblRutaDirectorio().setText(fic);
					vista.getLblRutaDirActual().setText(direcSelec + "/" + fic);
				}
				vista.getLblRutaDirActual().setText(direcSelec);
			}
		}
	}
}
