package ftp;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class VistaFTP extends JFrame{

	private static final long serialVersionUID = 1L;
	
	//Variables Ventana FTP
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
	
	static JList listaDir = new JList();
	
	private final Container c = getContentPane();
	
	//Datos servidor
	static FTPClient cliente = new FTPClient();
	String servidor = "127.0.0.1";
	String user = "usuario1";
	String pasw = "admin";
	int puerto = 21;
	boolean login;
	static String direcInicial = "/";
	
	static String direcSelec = direcInicial;
	static String ficheroSelec = "";
	
	
	
	public VistaFTP() {
		super("CLIENTE BASICO FTP PRUEBAS");
		
		try {
			cliente.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
			
			cliente.connect(servidor,puerto);
			int respuesta = cliente.getReplyCode();
			
			if (!FTPReply.isPositiveCompletion(respuesta)) {
				System.out.println("No se ha podido conectar al servidor, respuesta: "+respuesta);
			}
			boolean loginSatisfactorio = cliente.login(user, pasw);
			
			if(loginSatisfactorio) {
				System.out.println("Se ha iniciado sesión en el servidor FTP");
			}else {
				System.out.println("Las credenciales son inválidas");
				cliente.disconnect();
			}
			
			cliente.changeWorkingDirectory(direcInicial);
			FTPFile[] files = cliente.listFiles();
			
			llenarLista(files, direcInicial);
			
			//Construir ventana
			campo.setText("<<ARBOL DE DIRECTORIOS>>");
			cab.setText("SERVIDOR FTP: "+servidor);
			cab2.setText("Usuario: "+user);
			cab3.setText("Directorio raiz: "+direcInicial);
			
			//Preparar lista
			listaDir.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane barraDesplazamiento = new JScrollPane(listaDir);
			
			barraDesplazamiento.setPreferredSize(new Dimension(335,420));
			barraDesplazamiento.setBounds(new Rectangle(5,65,335,420));
			
			c.add(barraDesplazamiento);
			c.setLayout(null);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(510, 600);
			setVisible(true);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}



	private void llenarLista(FTPFile[] files, String direcInicial2) {
		if(files == null) return;
		
		DefaultListModel modeloLista = new DefaultListModel();
		modeloLista = new DefaultListModel();
		
		listaDir.setForeground(Color.blue);
		Font fuente = new Font("Courier",Font.PLAIN, 12);
		listaDir.setFont(fuente);
		
		listaDir.removeAll();
		
		try {
			cliente.changeWorkingDirectory(direcInicial2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		direcSelec = direcInicial2;
		
		modeloLista.addElement(direcInicial2);
		
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
			listaDir.setModel(modeloLista);
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}

}
