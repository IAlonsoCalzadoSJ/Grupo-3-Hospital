package correo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.util.ArrayList;

public class VistaEnviar extends JFrame {

	private JPanel panelPrincipal;
	private JTextField fieldPara;
	private ArrayList<JButton> botones = new ArrayList();
	JTextPane paneCuerpo;
	private JTextField fieldCabecera;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VistaEnviar() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1400, 800);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.activeCaption);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);

		JPanel panelIcon = new JPanel();

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.activeCaption);

		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(SystemColor.activeCaption);

		JPanel panelDescripcion = new JPanel();
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(gl_panelPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPrincipal.createSequentialGroup().addContainerGap().addGroup(gl_panelPrincipal
						.createParallelGroup(Alignment.LEADING)
						.addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
						.addGroup(gl_panelPrincipal.createSequentialGroup()
								.addComponent(panelIcon, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panelDescripcion, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)
								.addGap(8)))
						.addContainerGap()));
		gl_panelPrincipal.setVerticalGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
						.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(panelDescripcion, GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(panelIcon, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelPrincipal.createSequentialGroup().addContainerGap().addComponent(
										panelBotones, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)));

		JTextPane txtpnWindowUsedTo = new JTextPane();
		txtpnWindowUsedTo.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnWindowUsedTo.setText(
				"Window used to send mails.\r\nPressing the \"Go back\" button will lead you to the previous window.\r\nPressing the \"Attach file\" button will allow you to attach files to the mail you want to send.\r\nPressing the \"Send\" button will send the mail once the required info has been written.");
		txtpnWindowUsedTo.setBackground(SystemColor.activeCaption);
		GroupLayout gl_panelDescripcion = new GroupLayout(panelDescripcion);
		gl_panelDescripcion.setHorizontalGroup(gl_panelDescripcion.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnWindowUsedTo, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE));
		gl_panelDescripcion.setVerticalGroup(gl_panelDescripcion.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnWindowUsedTo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE));
		panelDescripcion.setLayout(gl_panelDescripcion);

		JButton botonVolver = new JButton("Go back");
		botonVolver.setBackground(SystemColor.inactiveCaptionBorder);
		botonVolver.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		botones.add(botonVolver);

		JButton botonAdjuntarArchivo = new JButton("Attach file");
		botonAdjuntarArchivo.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		botonAdjuntarArchivo.setBackground(SystemColor.inactiveCaptionBorder);
		botones.add(botonAdjuntarArchivo);

		JButton botonEnviar = new JButton("Send");
		botonEnviar.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		botonEnviar.setBackground(SystemColor.inactiveCaptionBorder);
		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		botones.add(botonEnviar);

		gl_panelBotones.setHorizontalGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panelBotones.createSequentialGroup().addContainerGap(28, Short.MAX_VALUE)
						.addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(botonAdjuntarArchivo, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(botonEnviar, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panelBotones.setVerticalGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panelBotones.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panelBotones.createParallelGroup(Alignment.BASELINE)
								.addComponent(botonEnviar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonAdjuntarArchivo, GroupLayout.PREFERRED_SIZE, 64,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panelBotones.setLayout(gl_panelBotones);

		JLabel labelPara = new JLabel("For:");
		labelPara.setFont(new Font("Sitka Text", Font.PLAIN, 25));

		fieldPara = new JTextField();
		fieldPara.setColumns(10);

		JLabel labelCabecera = new JLabel("Header:");
		labelCabecera.setFont(new Font("Sitka Text", Font.PLAIN, 25));

		fieldCabecera = new JTextField();
		fieldCabecera.setColumns(10);

		paneCuerpo = new JTextPane();
		GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
		gl_panelInfo.setHorizontalGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelInfo
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelInfo.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelInfo.createSequentialGroup()
								.addComponent(labelPara, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE).addGap(10)
								.addComponent(fieldPara, GroupLayout.PREFERRED_SIZE, 1153, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING,
								gl_panelInfo.createSequentialGroup()
										.addComponent(labelCabecera, GroupLayout.PREFERRED_SIZE, 171,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(fieldCabecera,
												GroupLayout.PREFERRED_SIZE, 1153, GroupLayout.PREFERRED_SIZE))
						.addComponent(paneCuerpo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1328,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_panelInfo.setVerticalGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelInfo
				.createSequentialGroup().addGap(27)
				.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE).addComponent(labelPara)
						.addComponent(fieldPara, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGap(27)
				.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelCabecera, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldCabecera, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addGap(34).addComponent(paneCuerpo, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
				.addContainerGap()));
		panelInfo.setLayout(gl_panelInfo);
		panelIcon.setLayout(null);

		JLabel labelIcon = new JLabel("");
		labelIcon.setBounds(0, 0, 106, 96);
		panelIcon.add(labelIcon);
		labelIcon.setIcon(new ImageIcon("C:\\Users\\Alejandro\\Desktop\\descarga.jpg"));
		panelPrincipal.setLayout(gl_panelPrincipal);
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}

	public JTextPane getPaneCuerpo() {
		return paneCuerpo;
	}

	public void setPaneCuerpo(JTextPane paneCuerpo) {
		this.paneCuerpo = paneCuerpo;
	}

	public JTextField getFieldPara() {
		return fieldPara;
	}

	public void setFieldPara(JTextField fieldPara) {
		this.fieldPara = fieldPara;
	}

	public JTextField getFieldCabecera() {
		return fieldCabecera;
	}

	public void setFieldCabecera(JTextField fieldCabecera) {
		this.fieldCabecera = fieldCabecera;
	}

}
