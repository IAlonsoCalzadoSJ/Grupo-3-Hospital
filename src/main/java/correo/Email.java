package correo;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextPane;

public class Email extends JFrame {

	private JPanel panelPrincipal;
	private JTable table;
	private ArrayList<JButton> botones= new ArrayList();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Email() {
		setResizable(false);
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
		DefaultTableModel model = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		}; 
		model.addColumn("Remitente");
		model.addColumn("Asunto");
		model.addColumn("Fecha/hora");
		table = new JTable();
	table.setDefaultEditor(Object.class, null);
	       
		table.setModel(model);
		table.setFillsViewportHeight(true);
		
		
		JScrollPane scrollBar = new JScrollPane(table);
		scrollBar.setBackground(SystemColor.activeCaption);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		
		JPanel panelDescripcion = new JPanel();
		
		panelDescripcion.setBackground(SystemColor.activeCaption);
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					//.addComponent(table, GroupLayout.DEFAULT_SIZE, 1518, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 1518, Short.MAX_VALUE))
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelDescripcion, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelPrincipal.setVerticalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(panelDescripcion, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(panelLogo, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelPrincipal.createSequentialGroup()
							.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
							.addContainerGap())))
					//	.addComponent(table, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)))
		);
	panel.repaint();
		panelDescripcion.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane txtpnMainWindowOf = new JTextPane();
		txtpnMainWindowOf.setEditable(false);
		txtpnMainWindowOf.setBackground(SystemColor.activeCaption);
		txtpnMainWindowOf.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnMainWindowOf.setText("Main window of the mail process.\r\nPressing the \"Refresh page\"  will reload all the emails.\r\nPressing the \"Write an email\" button will open a new window to do so.\r\nPressing the \"Go back\" button will lead you to the previous window.");
		panelDescripcion.add(txtpnMainWindowOf);
		
		JButton refrescarBoton = new JButton("Refresh page");
		
		refrescarBoton.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		refrescarBoton.setBackground(SystemColor.inactiveCaptionBorder);
		botones.add(refrescarBoton);
		JButton enviarBoton = new JButton("Write an email");
		enviarBoton.setBackground(SystemColor.inactiveCaptionBorder);
		enviarBoton.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		botones.add(enviarBoton);
		JButton volverBoton = new JButton("Go back");
		volverBoton.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		volverBoton.setBackground(SystemColor.inactiveCaptionBorder);
		botones.add(volverBoton);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(refrescarBoton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(enviarBoton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(volverBoton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(750))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(refrescarBoton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(enviarBoton, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
						.addComponent(volverBoton, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panelPrincipal.setLayout(gl_panelPrincipal);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}
}