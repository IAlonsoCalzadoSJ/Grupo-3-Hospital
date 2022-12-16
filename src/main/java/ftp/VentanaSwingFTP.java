package ftp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaSwingFTP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSwingFTP frame = new VentanaSwingFTP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JButton btnSubir = new JButton("Subir Archivo");
		btnSubir.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/subir.png")));
		btnSubir.setForeground(new Color(0, 0, 0));
		btnSubir.setBackground(new Color(240, 240, 240));
		btnSubir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubir.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnSubir.setBounds(46, 34, 229, 54);
		contentPane.add(btnSubir);
		
		JButton btnBajar = new JButton("Bajar Archivo");
		btnBajar.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/bajar.png")));
		btnBajar.setBackground(new Color(240, 240, 240));
		btnBajar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajar.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnBajar.setBounds(46, 98, 229, 54);
		contentPane.add(btnBajar);
		
		JButton btnBorrarAr = new JButton("Borrar Archivo");
		btnBorrarAr.setIconTextGap(1);
		btnBorrarAr.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/borrar.png")));
		btnBorrarAr.setBackground(new Color(240, 240, 240));
		btnBorrarAr.setHorizontalAlignment(SwingConstants.LEFT);
		btnBorrarAr.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnBorrarAr.setBounds(46, 162, 229, 54);
		contentPane.add(btnBorrarAr);
		
		JButton btnRenombrar = new JButton("Renombrar ");
		btnRenombrar.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/renombrar.png")));
		btnRenombrar.setBackground(new Color(240, 240, 240));
		btnRenombrar.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnRenombrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRenombrar.setBounds(46, 226, 229, 54);
		contentPane.add(btnRenombrar);
		
		JButton btnCrearCarpeta = new JButton("");
		btnCrearCarpeta.setBackground(new Color(240, 240, 240));
		btnCrearCarpeta.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/crearCarpeta.png")));
		btnCrearCarpeta.setBounds(46, 300, 91, 54);
		contentPane.add(btnCrearCarpeta);
		
		JButton btnBorrarCarpeta = new JButton("");
		btnBorrarCarpeta.setIcon(new ImageIcon(VentanaSwingFTP.class.getResource("/images/borrarCarpeta.png")));
		btnBorrarCarpeta.setBackground(new Color(240, 240, 240));
		btnBorrarCarpeta.setBounds(184, 300, 91, 54);
		contentPane.add(btnBorrarCarpeta);
		
		JLabel lblServidor = new JLabel("Servidor:");
		lblServidor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblServidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblServidor.setBounds(51, 386, 86, 25);
		contentPane.add(lblServidor);
		
		JLabel lblIpServer = new JLabel("New label");
		lblIpServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpServer.setBounds(155, 386, 120, 25);
		contentPane.add(lblIpServer);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblUsuario.setBounds(51, 428, 86, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(155, 428, 120, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblDirectorio = new JLabel("Directorio:");
		lblDirectorio.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblDirectorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirectorio.setBounds(323, 10, 158, 34);
		contentPane.add(lblDirectorio);
		
		JLabel lblRutaDirectorio = new JLabel("Ruta");
		lblRutaDirectorio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRutaDirectorio.setBounds(529, 10, 221, 34);
		contentPane.add(lblRutaDirectorio);
		
		JList listArchivos = new JList();
		listArchivos.setBounds(323, 98, 427, 355);
		contentPane.add(listArchivos);
		
		JLabel lblDirActual = new JLabel("Directorio Actual:");
		lblDirActual.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblDirActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirActual.setBounds(323, 54, 158, 34);
		contentPane.add(lblDirActual);
		
		JLabel lblRutaDirActual = new JLabel("Ruta");
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
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton.setBounds(485, 463, 85, 32);
		contentPane.add(btnNewButton);
	}
}
