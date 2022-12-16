package controladores;

import java.awt.Color;

import javax.swing.DefaultListModel;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import ftp.VentanaSwingFTP;
import ftp.VistaFTP;
import modelo.ConexionFtp;

public class ControladorLista {

	private VentanaSwingFTP vista;
	private ConexionFtp modelo;
	private FTPClient cliente;
	
	public ControladorLista(VentanaSwingFTP vista2, ConexionFtp modelo, FTPClient cliente) {
		this.cliente = cliente;
		this.modelo = modelo;
		this.vista = vista2;
		
		eventoListaArchivos();
	}

	private void eventoListaArchivos() {
		
		try {
			cliente.connect(modelo.getServidor(),modelo.getPuerto());
			
			int respuesta = cliente.getReplyCode();
			
			if (!FTPReply.isPositiveCompletion(respuesta)) {
				System.out.println("No se ha podido conectar al servidor, respuesta: "+respuesta);
			}
			boolean loginSatisfactorio = cliente.login(modelo.getUser(), modelo.getPasw());
			
			if(loginSatisfactorio) {
				System.out.println("Se ha iniciado sesión en el servidor FTP");
			}else {
				System.out.println("Las credenciales son inválidas");
				cliente.disconnect();
			}
			
			cliente.changeWorkingDirectory(modelo.getDirecInicial());
			FTPFile[] files = cliente.listFiles();
			
			llenarLista(files, modelo.getDirecInicial());
			
			vista.getLblIpServer().setText(modelo.getServidor());
			vista.getLblUsuarioNombre().setText(modelo.getUser());
			vista.getLblRutaDirectorio().setText(modelo.getDirecInicial());

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void llenarLista(FTPFile[] files, String direcInicial) {
		if(files == null) return;
		
		DefaultListModel modeloLista = new DefaultListModel();
		modeloLista = new DefaultListModel();
		
		vista.getListArchivos().removeAll();
		
		try {
			cliente.changeWorkingDirectory(direcInicial);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String direcSelec = modelo.getDirecSelec();
		direcSelec = direcInicial;
		modeloLista.addElement(direcInicial);
		
		for (int i = 0; i < files.length; i++) {
			if(!(files[i].getName()).equals(".")&&!(files[i].getName()).equals("..")) {
				String f = files[i].getName();
				if(files[i].isDirectory()) {
					f = "(DIR) "+f;
				}
				modeloLista.addElement(f);
			}
		}
		try {
			vista.getListArchivos().setModel(modeloLista);
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		
	}
}
