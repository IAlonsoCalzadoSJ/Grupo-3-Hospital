package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class VistaSelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3804543259665476927L;
	private ArrayList<JButton> botones = new ArrayList<>();
	
	/**
	 * Create the frame.
	 */
	public VistaSelector() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 832);
		JPanel panelMain = new JPanel();
		panelMain.setBackground(SystemColor.activeCaption);
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelMain);
		
		JPanel manualPanel = new JPanel();
		manualPanel.setBackground(SystemColor.activeCaption);
		
		JPanel mailPanel = new JPanel();
		mailPanel.setBackground(SystemColor.activeCaption);
		
		botones.add(new JButton("eMail"));
		botones.get(0).setBackground(Color.ORANGE);
		botones.get(0).setFont(new Font("Sitka Text", Font.PLAIN, 40));
		GroupLayout gl_mailPanel = new GroupLayout(mailPanel);
		gl_mailPanel.setHorizontalGroup(
			gl_mailPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mailPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(botones.get(0), GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_mailPanel.setVerticalGroup(
			gl_mailPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mailPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(botones.get(0), GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		mailPanel.setLayout(gl_mailPanel);
		
		JPanel ftpPanel = new JPanel();
		ftpPanel.setBackground(SystemColor.activeCaption);
		
		botones.add(new JButton("Manual"));
		botones.get(1).setBackground(Color.ORANGE);
		botones.get(1).setFont(new Font("Sitka Text", Font.PLAIN, 40));
		GroupLayout gl_ftpPanel = new GroupLayout(ftpPanel);
		gl_ftpPanel.setHorizontalGroup(
			gl_ftpPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ftpPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(botones.get(1), GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_ftpPanel.setVerticalGroup(
			gl_ftpPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_ftpPanel.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addComponent(botones.get(1), GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		ftpPanel.setLayout(gl_ftpPanel);
		
		JLabel labelLogo = new JLabel("New label");
		labelLogo.setIcon(new ImageIcon("D:\\alexs\\Descargas\\hospital logo doctor medical - Hecho con PosterMyWall (1).png"));
		
		JPanel volverPanel = new JPanel();
		volverPanel.setBackground(SystemColor.activeCaption);
		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain.setHorizontalGroup(
			gl_panelMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain.createSequentialGroup()
							.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
									.addComponent(ftpPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
									.addComponent(mailPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE))
								.addComponent(manualPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panelMain.createSequentialGroup()
							.addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(67))
						.addGroup(Alignment.TRAILING, gl_panelMain.createSequentialGroup()
							.addComponent(volverPanel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panelMain.setVerticalGroup(
			gl_panelMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addComponent(volverPanel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(labelLogo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(manualPanel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mailPanel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ftpPanel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
		);
		
		botones.add(new JButton("Volver"));
		botones.get(2).setBackground(Color.ORANGE);
		botones.get(2).setFont(new Font("Sitka Text", Font.PLAIN, 20));
		GroupLayout gl_volverPanel = new GroupLayout(volverPanel);
		gl_volverPanel.setHorizontalGroup(
			gl_volverPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_volverPanel.createSequentialGroup()
					.addComponent(botones.get(2), GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
					.addGap(20))
		);
		gl_volverPanel.setVerticalGroup(
			gl_volverPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_volverPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(botones.get(2), GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addContainerGap())
		);
		volverPanel.setLayout(gl_volverPanel);
		
		botones.add(new JButton("FTP"));
		botones.get(3).setBackground(Color.ORANGE);
		botones.get(3).setFont(new Font("Sitka Text", Font.PLAIN, 40));
		GroupLayout gl_manualPanel = new GroupLayout(manualPanel);
		gl_manualPanel.setHorizontalGroup(
			gl_manualPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_manualPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(botones.get(3), GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_manualPanel.setVerticalGroup(
			gl_manualPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_manualPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(botones.get(3), GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		manualPanel.setLayout(gl_manualPanel);
		panelMain.setLayout(gl_panelMain);
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}
}
