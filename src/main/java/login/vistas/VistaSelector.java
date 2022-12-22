package login.vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

import login.modelo.ModeloLoginSelector;

public class VistaSelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4353913001176228076L;
	private JPanel panelMain;
	private ArrayList<JButton> botones = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public VistaSelector() {
		setBackground(new Color(0, 128, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 450);
		panelMain = new JPanel();
		panelMain.setPreferredSize(new Dimension(400, 550));
		panelMain.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelMain.setBackground(new Color(0, 128, 255));
		panelMain.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		setContentPane(panelMain);

		JPanel manualPanel = new JPanel();
		manualPanel.setBackground(new Color(0, 128, 255));

		JPanel mailPanel = new JPanel();
		mailPanel.setBackground(new Color(0, 128, 255));

		botones.add(new JButton(ModeloLoginSelector.getTxtemail()));
		botones.get(0).setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		botones.get(0).setPreferredSize(new Dimension(40, 20));
		botones.get(0).setMinimumSize(new Dimension(40, 20));
		botones.get(0).setMaximumSize(new Dimension(40, 20));
		botones.get(0).setMargin(new Insets(5, 5, 5, 5));
		botones.get(0).setBackground(Color.LIGHT_GRAY);
		botones.get(0).setFont(new Font(ModeloLoginSelector.getCfgfuentevistaselector(), Font.PLAIN, 40));
		GroupLayout gl_mailPanel = new GroupLayout(mailPanel);
		gl_mailPanel.setHorizontalGroup(gl_mailPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mailPanel.createSequentialGroup().addContainerGap()
						.addComponent(botones.get(0), GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(140, Short.MAX_VALUE)));
		gl_mailPanel.setVerticalGroup(gl_mailPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mailPanel.createSequentialGroup().addContainerGap()
						.addComponent(botones.get(0), GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(76, Short.MAX_VALUE)));
		mailPanel.setLayout(gl_mailPanel);

		JPanel ftpPanel = new JPanel();
		ftpPanel.setBackground(new Color(0, 128, 255));

		botones.add(new JButton(ModeloLoginSelector.getTxtmanual()));
		botones.get(1).setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		botones.get(1).setPreferredSize(new Dimension(40, 20));
		botones.get(1).setMinimumSize(new Dimension(40, 20));
		botones.get(1).setMaximumSize(new Dimension(40, 20));
		botones.get(1).setMargin(new Insets(5, 5, 5, 5));
		botones.get(1).setBackground(Color.LIGHT_GRAY);
		botones.get(1).setFont(new Font(ModeloLoginSelector.getCfgfuentevistaselector(), Font.PLAIN, 40));
		GroupLayout gl_ftpPanel = new GroupLayout(ftpPanel);
		gl_ftpPanel.setHorizontalGroup(gl_ftpPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ftpPanel.createSequentialGroup().addContainerGap()
						.addComponent(botones.get(1), GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
						.addContainerGap()));
		gl_ftpPanel.setVerticalGroup(gl_ftpPanel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_ftpPanel.createSequentialGroup().addContainerGap()
						.addComponent(botones.get(1), GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));
		ftpPanel.setLayout(gl_ftpPanel);

		JPanel volverPanel = new JPanel();
		volverPanel.setBackground(new Color(0, 128, 255));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));

		JPanel panelDescripcion = new JPanel();
		panelDescripcion.setPreferredSize(new Dimension(30, 20));
		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain.setHorizontalGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelMain
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain.createSequentialGroup().addGap(12)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelDescripcion, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
						.addGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(ftpPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(mailPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(manualPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 377,
										Short.MAX_VALUE)))
				.addGap(128))
				.addGroup(Alignment.LEADING,
						gl_panelMain.createSequentialGroup().addGap(145).addComponent(volverPanel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(252, Short.MAX_VALUE)));
		gl_panelMain.setVerticalGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMain.createSequentialGroup()
						.addGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelMain.createSequentialGroup().addContainerGap().addComponent(panel,
										GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
								.addComponent(panelDescripcion, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(manualPanel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(mailPanel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(ftpPanel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE).addGap(18)
						.addComponent(volverPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(222)));
		panelDescripcion.setLayout(new GridLayout(0, 1, 0, 0));

		JTextPane textoDescripcion = new JTextPane();
		textoDescripcion.setPreferredSize(new Dimension(30, 20));
		textoDescripcion.setEditable(false);
		textoDescripcion.setFont(new Font(ModeloLoginSelector.getCfgfuentevistaselector(), Font.PLAIN, 15));
		textoDescripcion.setText("Window used to lead the user to each process.\r\nPressing each button will do so.");
		textoDescripcion.setBackground(new Color(0, 128, 255));
		panelDescripcion.add(textoDescripcion);

		JLabel labelIcon = new JLabel("");
		labelIcon.setBackground(new Color(0, 128, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(labelIcon, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addContainerGap().addComponent(labelIcon, GroupLayout.DEFAULT_SIZE, 81,
						Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		botones.add(new JButton(ModeloLoginSelector.getTxtvolver()));
		botones.get(2).setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		botones.get(2).setBackground(Color.LIGHT_GRAY);
		botones.get(2).setFont(new Font(ModeloLoginSelector.getCfgfuentevistaselector(), Font.PLAIN, 20));
		GroupLayout gl_volverPanel = new GroupLayout(volverPanel);
		gl_volverPanel.setHorizontalGroup(gl_volverPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_volverPanel.createSequentialGroup().addContainerGap()
						.addComponent(botones.get(2), GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_volverPanel.setVerticalGroup(gl_volverPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_volverPanel.createSequentialGroup().addContainerGap().addComponent(botones.get(2))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		volverPanel.setLayout(gl_volverPanel);

		botones.add(new JButton(ModeloLoginSelector.getTxtftp()));
		botones.get(3).setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		botones.get(3).setPreferredSize(new Dimension(40, 20));
		botones.get(3).setMinimumSize(new Dimension(40, 20));
		botones.get(3).setMaximumSize(new Dimension(40, 20));
		botones.get(3).setMargin(new Insets(5, 5, 5, 5));
		botones.get(3).setBackground(Color.LIGHT_GRAY);
		botones.get(3).setFont(new Font(ModeloLoginSelector.getCfgfuentevistaselector(), Font.PLAIN, 40));
		GroupLayout gl_manualPanel = new GroupLayout(manualPanel);
		gl_manualPanel.setHorizontalGroup(gl_manualPanel.createParallelGroup(Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_manualPanel.createSequentialGroup().addContainerGap()
						.addComponent(botones.get(3), GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(138, Short.MAX_VALUE)));
		gl_manualPanel.setVerticalGroup(gl_manualPanel.createParallelGroup(Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_manualPanel.createSequentialGroup().addContainerGap()
						.addComponent(botones.get(3), GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(80, Short.MAX_VALUE)));
		manualPanel.setLayout(gl_manualPanel);
		panelMain.setLayout(gl_panelMain);
		this.pack();
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}

}
