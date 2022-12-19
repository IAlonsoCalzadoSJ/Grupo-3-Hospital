package controladores;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.ftp.FTPClient;

import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class EventoListaArchivos implements ListSelectionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;

	public EventoListaArchivos(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo) {
		this.vista = vista;
		this.cliente = cliente;
		this.modelo = modelo;
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			String ficSelec = modelo.getFicheroSelec();
			ficSelec = "";

			String fic = vista.getListArchivos().getSelectedValue().toString();
			if(vista.getListArchivos().getSelectedIndex() == 0) {
				if(!fic.equals(modelo.getDirecInicial())) {
					try {
						cliente.changeToParentDirectory();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		}

	}

}
