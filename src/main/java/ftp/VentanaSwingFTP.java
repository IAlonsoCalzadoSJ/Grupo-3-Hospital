package ftp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class VentanaSwingFTP extends JFrame {

	private JPanel contentPane;
	private JButton btnSubir, btnBajar, btnBorrarAr, btnRenombrar, btnCrearCarpeta, btnBorrarCarpeta, btnVolver;
	private JLabel lblIpServer, lblUsuarioNombre, lblRutaDirectorio, lblRutaDirActual;
	private JList listArchivos;
	
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
		
		btnSubir = new JButton("Subir Archivo");
		btnSubir.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/subir.png")));
		btnSubir.setForeground(new Color(0, 0, 0));
		btnSubir.setBackground(new Color(240, 240, 240));
		btnSubir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubir.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnSubir.setBounds(46, 34, 229, 54);
		contentPane.add(btnSubir);
		
		btnBajar = new JButton("Bajar Archivo");
		btnBajar.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/bajar.png")));
		btnBajar.setBackground(new Color(240, 240, 240));
		btnBajar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajar.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnBajar.setBounds(46, 98, 229, 54);
		contentPane.add(btnBajar);
		
		btnBorrarAr = new JButton("Borrar Archivo");
		btnBorrarAr.setIconTextGap(1);
		btnBorrarAr.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/borrar.png")));
		btnBorrarAr.setBackground(new Color(240, 240, 240));
		btnBorrarAr.setHorizontalAlignment(SwingConstants.LEFT);
		btnBorrarAr.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnBorrarAr.setBounds(46, 162, 229, 54);
		contentPane.add(btnBorrarAr);
		
		btnRenombrar = new JButton("Renombrar ");
		btnRenombrar.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/renombrar.png")));
		btnRenombrar.setBackground(new Color(240, 240, 240));
		btnRenombrar.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnRenombrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRenombrar.setBounds(46, 226, 229, 54);
		contentPane.add(btnRenombrar);
		
		btnCrearCarpeta = new JButton("");
		btnCrearCarpeta.setBackground(new Color(240, 240, 240));
		btnCrearCarpeta.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/crearCarpeta.png")));
		btnCrearCarpeta.setBounds(46, 300, 91, 54);
		contentPane.add(btnCrearCarpeta);
		
		btnBorrarCarpeta = new JButton("");
		btnBorrarCarpeta.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/borrarCarpeta.png")));
		btnBorrarCarpeta.setBackground(new Color(240, 240, 240));
		btnBorrarCarpeta.setBounds(184, 300, 91, 54);
		contentPane.add(btnBorrarCarpeta);
		
		JLabel lblServidor = new JLabel("Servidor:");
		lblServidor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblServidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblServidor.setBounds(51, 386, 86, 25);
		contentPane.add(lblServidor);
		
		lblIpServer = new JLabel("New label");
		lblIpServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpServer.setBounds(155, 386, 120, 25);
		contentPane.add(lblIpServer);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblUsuario.setBounds(51, 428, 86, 25);
		contentPane.add(lblUsuario);
		
		lblUsuarioNombre = new JLabel("New label");
		lblUsuarioNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioNombre.setBounds(155, 428, 120, 25);
		contentPane.add(lblUsuarioNombre);
		
		JLabel lblDirectorio = new JLabel("Directorio:");
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
		
		JLabel lblDirActual = new JLabel("Directorio Actual:");
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
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(240, 240, 240));
		btnVolver.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnVolver.setBounds(485, 463, 85, 32);
		contentPane.add(btnVolver);
	}

	public JButton getBtnSubir() {
		return btnSubir;
	}

	public void setBtnSubir(JButton btnSubir) {
		this.btnSubir = btnSubir;
	}

	public JButton getBtnBajar() {
		return btnBajar;
	}

	public void setBtnBajar(JButton btnBajar) {
		this.btnBajar = btnBajar;
	}

	public JButton getBtnBorrarAr() {
		return btnBorrarAr;
	}

	public void setBtnBorrarAr(JButton btnBorrarAr) {
		this.btnBorrarAr = btnBorrarAr;
	}

	public JButton getBtnRenombrar() {
		return btnRenombrar;
	}

	public void setBtnRenombrar(JButton btnRenombrar) {
		this.btnRenombrar = btnRenombrar;
	}

	public JButton getBtnCrearCarpeta() {
		return btnCrearCarpeta;
	}

	public void setBtnCrearCarpeta(JButton btnCrearCarpeta) {
		this.btnCrearCarpeta = btnCrearCarpeta;
	}

	public JButton getBtnBorrarCarpeta() {
		return btnBorrarCarpeta;
	}

	public void setBtnBorrarCarpeta(JButton btnBorrarCarpeta) {
		this.btnBorrarCarpeta = btnBorrarCarpeta;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
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
	
	
}
