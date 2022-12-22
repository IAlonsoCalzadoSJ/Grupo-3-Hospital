package ftp;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.ConexionFtp;

public class VentanaSwingFTP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6190453287526537347L;
	private JPanel contentPane;
	private JLabel lblIpServer, lblUsuarioNombre, lblRutaDirectorio, lblRutaDirActual;
	private JList listArchivos;
	private ConexionFtp modelo = new ConexionFtp();
	private ArrayList<JButton> botones = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaSwingFTP frame = new VentanaSwingFTP();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaSwingFTP() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botones.add(new JButton(modelo.getTextoSubir()));
		botones.get(0).setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/subir.png")));
		botones.get(0).setForeground(new Color(0, 0, 0));
		botones.get(0).setBackground(new Color(240, 240, 240));
		botones.get(0).setHorizontalAlignment(SwingConstants.LEFT);
		botones.get(0).setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		botones.get(0).setBounds(46, 34, 229, 54);
		contentPane.add(botones.get(0));
		
		botones.add(new JButton(modelo.getTextoBajar()));
		botones.get(1).setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/bajar.png")));
		botones.get(1).setBackground(new Color(240, 240, 240));
		botones.get(1).setHorizontalAlignment(SwingConstants.LEFT);
		botones.get(1).setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		botones.get(1).setBounds(46, 98, 229, 54);
		contentPane.add(botones.get(1));
		
		botones.add(new JButton(modelo.getTextoBorrar()));
		botones.get(2).setIconTextGap(1);
		botones.get(2).setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/borrar.png")));
		botones.get(2).setBackground(new Color(240, 240, 240));
		botones.get(2).setHorizontalAlignment(SwingConstants.LEFT);
		botones.get(2).setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		botones.get(2).setBounds(46, 162, 229, 54);
		contentPane.add(botones.get(2));
		
		botones.add(new JButton(modelo.getTextoRenombrar()));
		botones.get(3).setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/renombrar.png")));
		botones.get(3).setBackground(new Color(240, 240, 240));
		botones.get(3).setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		botones.get(3).setHorizontalAlignment(SwingConstants.LEFT);
		botones.get(3).setBounds(46, 226, 229, 54);
		contentPane.add(botones.get(3));
		
		botones.add(new JButton(""));
		botones.get(4).setBackground(new Color(240, 240, 240));
		botones.get(4).setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/crearCarpeta.png")));
		botones.get(4).setBounds(46, 300, 91, 54);
		contentPane.add(botones.get(4));
		
		botones.add(new JButton(""));
		botones.get(5).setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/borrarCarpeta.png")));
		botones.get(5).setBackground(new Color(240, 240, 240));
		botones.get(5).setBounds(184, 300, 91, 54);
		contentPane.add(botones.get(5));
		
		JLabel lblServidor = new JLabel(modelo.getTextoServidor());
		lblServidor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblServidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblServidor.setBounds(51, 386, 86, 25);
		contentPane.add(lblServidor);
		
		lblIpServer = new JLabel("New label");
		lblIpServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpServer.setBounds(155, 386, 120, 25);
		contentPane.add(lblIpServer);
		
		JLabel lblUsuario = new JLabel(modelo.getTextoUsuario());
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblUsuario.setBounds(51, 428, 86, 25);
		contentPane.add(lblUsuario);
		
		lblUsuarioNombre = new JLabel("New label");
		lblUsuarioNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioNombre.setBounds(155, 428, 120, 25);
		contentPane.add(lblUsuarioNombre);
		
		JLabel lblDirectorio = new JLabel(modelo.getTextoArchivo());
		lblDirectorio.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblDirectorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirectorio.setBounds(323, 10, 158, 34);
		contentPane.add(lblDirectorio);
		
		lblRutaDirectorio = new JLabel("Ruta");
		lblRutaDirectorio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRutaDirectorio.setBounds(529, 10, 221, 34);
		contentPane.add(lblRutaDirectorio);
		
		listArchivos = new JList();
		listArchivos.setFont(new Font("Courier New", Font.PLAIN, 14));
		listArchivos.setForeground(new Color(0, 128, 255));
		listArchivos.setBounds(323, 98, 427, 355);
		listArchivos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(listArchivos);
		
		JLabel lblDirActual = new JLabel(modelo.getTextoDirActual());
		lblDirActual.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblDirActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirActual.setBounds(323, 54, 158, 34);
		contentPane.add(lblDirActual);
		
		lblRutaDirActual = new JLabel("Ruta");
		lblRutaDirActual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRutaDirActual.setBounds(529, 56, 221, 33);
		contentPane.add(lblRutaDirActual);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 374, 309, 98);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(323, 10, 474, 79);
		contentPane.add(panel_1);
		
		botones.add(new JButton(modelo.getTextoVolver()));
		botones.get(6).setBackground(new Color(240, 240, 240));
		botones.get(6).setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		botones.get(6).setBounds(485, 463, 85, 32);
		contentPane.add(botones.get(6));
	}
	
	public JLabel getLblIpServer() {
		return lblIpServer;
	}

	public void setLblIpServer(JLabel lblIpServer) {
		this.lblIpServer = lblIpServer;
	}

	public JLabel getLblUsuarioNombre() {
		return lblUsuarioNombre;
	}

	public void setLblUsuarioNombre(JLabel lblUsuarioNombre) {
		this.lblUsuarioNombre = lblUsuarioNombre;
	}

	public JLabel getLblRutaDirectorio() {
		return lblRutaDirectorio;
	}

	public void setLblRutaDirectorio(JLabel lblRutaDirectorio) {
		this.lblRutaDirectorio = lblRutaDirectorio;
	}

	public JLabel getLblRutaDirActual() {
		return lblRutaDirActual;
	}

	public void setLblRutaDirActual(JLabel lblRutaDirActual) {
		this.lblRutaDirActual = lblRutaDirActual;
	}

	public JList getListArchivos() {
		return listArchivos;
	}

	public void setListArchivos(JList listArchivos) {
		this.listArchivos = listArchivos;
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	} 
	
	
}
