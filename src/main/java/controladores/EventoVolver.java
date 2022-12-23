package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.net.ftp.FTPClient;

import ftp.VentanaSwingFTP;
import login.vistas.VistaSelector;

public class EventoVolver implements ActionListener {

	private FTPClient cliente;
	private VentanaSwingFTP vista;
	private VistaSelector selector;
	
	
	public EventoVolver(VentanaSwingFTP vista, FTPClient cliente, VistaSelector selector) {
		this.cliente = cliente;
		this.vista = vista;
		this.selector = selector;
	}


	public void actionPerformed(ActionEvent e) {
		try {
			cliente.disconnect();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		vista.dispose();
		selector.setVisible(true);
	}

}
