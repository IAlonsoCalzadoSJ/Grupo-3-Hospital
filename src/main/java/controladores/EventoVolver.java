package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.net.ftp.FTPClient;

import ftp.VentanaSwingFTP;

public class EventoVolver implements ActionListener {

	private FTPClient cliente;
	private VentanaSwingFTP vista;
	
	
	public EventoVolver(VentanaSwingFTP vista, FTPClient cliente) {
		this.cliente = cliente;
		this.vista = vista;
	}


	public void actionPerformed(ActionEvent e) {
		try {
			cliente.disconnect();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		System.exit(0);
	}

}
