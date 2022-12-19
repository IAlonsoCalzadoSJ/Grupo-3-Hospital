package correo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Email extends JFrame {

	private JPanel panelPrincipal;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email frame = new Email();
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
	public Email() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1567, 824);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.activeCaption);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(SystemColor.activeCaption);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("D:\\alexs\\Descargas\\hospital logo doctor medical - Hecho con PosterMyWall (1).png"));
		GroupLayout gl_panelLogo = new GroupLayout(panelLogo);
		gl_panelLogo.setHorizontalGroup(
			gl_panelLogo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogo.createSequentialGroup()
					.addContainerGap()
					.addComponent(logoLabel)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_panelLogo.setVerticalGroup(
			gl_panelLogo.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelLogo.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(logoLabel))
		);
		panelLogo.setLayout(gl_panelLogo);
		
		JButton enviarBoton = new JButton("Write an email");
		enviarBoton.setBackground(Color.ORANGE);
		enviarBoton.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		
		JButton refrescarBoton = new JButton("Refresh page");
		refrescarBoton.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		refrescarBoton.setBackground(Color.ORANGE);
		
		JButton volverBoton = new JButton("Go back");
		volverBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		volverBoton.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		volverBoton.setBackground(Color.ORANGE);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(SystemColor.activeCaption);
		
		table = new JTable();
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPrincipal.createSequentialGroup()
							.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(111)
							.addComponent(enviarBoton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGap(219)
							.addComponent(refrescarBoton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
							.addComponent(volverBoton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGap(166))
						.addGroup(gl_panelPrincipal.createSequentialGroup()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 1506, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelPrincipal.setVerticalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelPrincipal.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(enviarBoton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(refrescarBoton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(volverBoton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelPrincipal.setLayout(gl_panelPrincipal);
	}
}
