package controladores;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import common.Usuario;
import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class ControladorLista {

	private VentanaSwingFTP vista;
	private ConexionFtp modelo;
	private FTPClient cliente;
	private Usuario usuario;

	public ControladorLista(VentanaSwingFTP vista2, ConexionFtp modelo, FTPClient cliente, Usuario usuario) {
		this.cliente = cliente;
		this.modelo = modelo;
		this.vista = vista2;
		this.usuario = usuario;

		eventoListaArchivos();
	}

	private void eventoListaArchivos() {
		cliente.setAutodetectUTF8(true);
		try {
			// Conectarse con el servidor FTP
			cliente.connect(modelo.getServidor(), modelo.getPuerto());

			int respuesta = cliente.getReplyCode();

			if (!FTPReply.isPositiveCompletion(respuesta)) {
				System.out.println("No se ha podido conectar al servidor, respuesta: " + respuesta);
			}
			boolean loginSatisfactorio = cliente.login(modelo.getUser(), modelo.getPasw());

			if (loginSatisfactorio) {
				System.out.println("Se ha iniciado sesión en el servidor FTP");
			} else {
				System.out.println("Las credenciales son inválidas");
				cliente.disconnect();
			}
			// Establece el directorio actual
			System.out.println(modelo.getDirecInicial());
			modelo.setDirecInicial("/");
			switch (usuario.getGroup()) {
			case 0:
				if (usuario.isLeerAjena()) {
					System.out.println(usuario.isLeerAjena() + " " + usuario.isModificarPropia());
					modelo.setDirecInicial(modelo.getDirecInicial() + usuario.getDoctor() + "/pacientes");
				} else {
					System.out.println(usuario.isLeerAjena() + " " + usuario.isModificarPropia());
					modelo.setDirecInicial(modelo.getDirecInicial() + usuario.getDoctor() + "/pacientes/" + usuario.getUser());
				}
				break;

			case 1:
				if (usuario.isLeerAjena()) {
					System.out.println(usuario.isLeerAjena() + " " + usuario.isModificarPropia());
					modelo.setDirecInicial(modelo.getDirecSelec());
				} else {
					modelo.setDirecInicial(modelo.getDirecSelec() + usuario.getUser());
				}
				break;
			}
			System.out.println(modelo.getDirecInicial());
			cliente.changeWorkingDirectory(modelo.getDirecInicial());
			System.out.println(modelo.getDirecInicial());
			modelo.setTextoDirActual(modelo.getDirecInicial());
			FTPFile[] files = cliente.listFiles();

			// Saca listado de todos los archivos y carpetas del directorio actual
			llenarLista(files, modelo.getDirecInicial());

			vista.getLblIpServer().setText(modelo.getServidor());
			vista.getLblUsuarioNombre().setText(modelo.getUser());
			vista.getLblRutaDirectorio().setText(modelo.getDirecInicial());

			if (!usuario.isModificarPropia()) {
				for (JButton boton : vista.getBotones()) {
					if (!boton.getText().equals("Subir Archivo") && !boton.getText().equals("Volver")) {
						boton.setEnabled(false);
						boton.setVisible(false);
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void llenarLista(FTPFile[] files, String direcInicial) {
		if (files == null)
			return;

		DefaultListModel modeloLista = new DefaultListModel();
//		modeloLista = new DefaultListModel();

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
			if (!(files[i].getName()).equals(".") && !(files[i].getName()).equals("..")) {
				String f = files[i].getName();      
				if (files[i].isDirectory()) {
					f = "(DIR) " + f;
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
