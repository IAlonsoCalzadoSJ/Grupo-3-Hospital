package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import common.DBConnection;
import common.Libreria;
import common.Usuario;
import ftp.VentanaSwingFTP;
import modelo.ConexionFtp;

public class CrearCarpeta implements ActionListener {

	private VentanaSwingFTP vista;
	private FTPClient cliente;
	private ConexionFtp modelo;
	private ControladorLista controlLista;
	private DBConnection conex;
	private Usuario user;

	public CrearCarpeta(VentanaSwingFTP vista, FTPClient cliente, ConexionFtp modelo, ControladorLista controlLista, DBConnection conex, Usuario user) {
		this.cliente = cliente;
		this.vista = vista;
		this.modelo = modelo;
		this.controlLista = controlLista;
		this.conex = conex;
		this.user = user;
	}

	public void actionPerformed(ActionEvent e) {
		String nombreCarpeta = JOptionPane.showInputDialog(vista, "Introduce nombre de carpeta");
		if (!(nombreCarpeta == null)) {
			String directorio = modelo.getDirecSelec();
			if (!modelo.getDirecSelec().equals("/"))
				directorio = directorio + "/";
			directorio += nombreCarpeta.trim();
			if (!(nombreCarpeta.isEmpty())) {
				boolean especial = false;
				String[] caractEspeciales = { "/", "\"", ":", "@", "*", "?", "<", ">", "|" };
				for (String s : caractEspeciales) {
					if (nombreCarpeta.contains(s)) {
						especial = true;
					}
				}
				if (!especial) {
					try {
						if (cliente.makeDirectory(directorio)) {
							JOptionPane.showMessageDialog(vista, "Carpeta Creada Correctamente");
							Libreria.escribirLog(conex, user, user.getMail(), "crear carpeta", directorio);
							cliente.changeWorkingDirectory(modelo.getDirecSelec());
							FTPFile[] lista = null;
							lista = cliente.listFiles();
							controlLista.llenarLista(lista, modelo.getDirecSelec());
						} else {
							JOptionPane.showMessageDialog(vista, "No se ha podido crear la carpeta");
						}
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(vista, "No se admiten carácteres especiales.");
				}
			}else {
				JOptionPane.showMessageDialog(vista, "Debe introducir un nombre válido.");
			}
		}
	}
}
