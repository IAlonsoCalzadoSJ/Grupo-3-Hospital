package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;

public class Leer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leer frame = new Leer();
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
	public Leer() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelIcon = new JPanel();
		panelIcon.setLayout(null);
		
		JLabel labelIcon = new JLabel("");
		labelIcon.setBounds(0, 0, 106, 96);
		panelIcon.add(labelIcon);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(SystemColor.activeCaption);
		
		JButton botonVolver = new JButton("Go back");
		botonVolver.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		botonVolver.setBackground(SystemColor.inactiveCaptionBorder);
		
		JButton botonDescargarArchivo = new JButton("Download file");
		botonDescargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonDescargarArchivo.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		botonDescargarArchivo.setBackground(SystemColor.inactiveCaptionBorder);
		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		gl_panelBotones.setHorizontalGroup(
			gl_panelBotones.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(botonDescargarArchivo, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelBotones.setVerticalGroup(
			gl_panelBotones.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 82, Short.MAX_VALUE)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonDescargarArchivo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelBotones.setLayout(gl_panelBotones);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.activeCaption);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel labelCabecera = new JLabel("Header:");
		labelCabecera.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JTextPane paneCuerpo = new JTextPane();
		
		JScrollBar scrollBar = new JScrollBar();
		
		table = new JTable();
		GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
		gl_panelInfo.setHorizontalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panelInfo.createSequentialGroup()
									.addComponent(lblFrom, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 1153, GroupLayout.PREFERRED_SIZE)
									.addGap(9))
								.addGroup(gl_panelInfo.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_panelInfo.createSequentialGroup()
										.addComponent(labelCabecera, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 1153, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_panelInfo.createSequentialGroup()
										.addComponent(paneCuerpo, GroupLayout.PREFERRED_SIZE, 1289, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(154)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelInfo.setVerticalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFrom)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelCabecera, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(paneCuerpo, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelInfo.setLayout(gl_panelInfo);
		
		JTextPane txtpnWindowUsedTo_1 = new JTextPane();
		txtpnWindowUsedTo_1.setText("Window used to read emails and download it's attached files.\r\nPressing the \"Go back\" button will lead you to the previous window.\r\nPressing the \"Download file\" will do so, asking where should the files be downloaded.");
		txtpnWindowUsedTo_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnWindowUsedTo_1.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelIcon, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtpnWindowUsedTo_1, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 1356, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelIcon, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnWindowUsedTo_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
