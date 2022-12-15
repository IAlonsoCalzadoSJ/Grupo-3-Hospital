package login;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class VistaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5791554074174637886L;
	private JPanel contentPane;
	private JFormattedTextField textEmail;
	private JPasswordField textPassw;
	private JButton loginBoton;

	/**
	 * Create the frame.
	 */
	public VistaLogin() {
		setBackground(new Color(128, 128, 128));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 180, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(SystemColor.activeCaption);
		
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textEmail = new JFormattedTextField(mascara);
		textEmail.setText("");
		textEmail.setColumns(50);
		
		JLabel loginEmail = new JLabel("Email:");
		loginEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		loginBoton = new JButton("Log-in");
		loginBoton.setBackground(Color.WHITE);
		loginBoton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textPassw = new JPasswordField();
		textPassw.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(185)
					.addComponent(loginEmail, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(88)
					.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(91)
					.addComponent(textPassw, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(183))
				.addGroup(Alignment.TRAILING, gl_panelLogin.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addComponent(loginBoton)
					.addGap(193))
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addGap(95)
					.addComponent(loginEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textPassw, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(loginBoton)
					.addGap(124))
		);
		panelLogin.setLayout(gl_panelLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\alexs\\Descargas\\hospital logo doctor medical - Hecho con PosterMyWall (1).png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(161)
							.addComponent(lblNewLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public JFormattedTextField getUserText() {
		return textEmail;
	}
	
	public JPasswordField getPasswordText() {
		return textPassw;
	}
	
	public void setBtnSendEvent(LogBtnListener list) {
		loginBoton.addActionListener(list);
	}
}
