package ftp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VistaFTP extends JFrame{

	private static final long serialVersionUID = 1L;
	//Campos cabecera superior
	static JTextField cab = new JTextField();
	static JTextField cab2 = new JTextField();
	static JTextField cab3 = new JTextField();
	
	private static JTextField campo = new JTextField();
	private static JTextField campo2 = new JTextField();
	
	JButton botonSubir = new JButton("Subir fichero");
	JButton botonBajar = new JButton("Descargar fichero");
	JButton botonBorrar = new JButton("Borrar fichero");
	JButton botonRenombrar = new JButton("Renombrar fichero");
	JButton botonCrearDir = new JButton("Crear carpeta");
	JButton botonBorrarCarpeta = new JButton("Eliminar Carpeta");
	JButton botonSalir = new JButton("Salir");
	
	
	
	public static void main(String[] args) {
		
		

	}

}
