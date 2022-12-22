package login.vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import login.modelo.ModeloLoginSelector;

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
		setName("login");
		setBackground(new Color(0, 128, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
//		contentPane.setMaximumSize(new Dimension(0, 0));
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		setContentPane(contentPane);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(0, 128, 255));

		textEmail = new JFormattedTextField();
		textEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textEmail.setText("");
		textEmail.setColumns(50);

		JLabel loginEmail = new JLabel(ModeloLoginSelector.getTxtemail());
		loginEmail.setFont(new Font(ModeloLoginSelector.getCfgfuentevistalogin(), Font.PLAIN, 20));
		loginEmail.setHorizontalAlignment(SwingConstants.CENTER);

		loginBoton = new JButton(ModeloLoginSelector.getTxtlogin());
		loginBoton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		loginBoton.setBackground(Color.WHITE);
		loginBoton.setFont(new Font(ModeloLoginSelector.getCfgfuentevistalogin(), Font.PLAIN, 20));

		textPassw = new JPasswordField();
		textPassw.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPassw.setColumns(10);

		JLabel lblPassword = new JLabel(ModeloLoginSelector.getTxtpassword());
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font(ModeloLoginSelector.getCfgfuentevistalogin(), Font.PLAIN, 20));

		JLabel lblNewLabel_1 = new JLabel(ModeloLoginSelector.getTxtsufijocorreocorporativo());
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING).addGroup(gl_panelLogin
				.createSequentialGroup()
				.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLogin.createSequentialGroup().addGap(10)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1))
						.addGroup(gl_panelLogin.createSequentialGroup().addGap(114).addComponent(loginEmail,
								GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelLogin.createSequentialGroup().addContainerGap().addComponent(textPassw, 334,
								334, 334))
						.addGroup(gl_panelLogin.createSequentialGroup().addGap(116).addComponent(lblPassword,
								GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelLogin.createSequentialGroup()
						.addContainerGap(152, Short.MAX_VALUE).addComponent(loginBoton).addGap(141)));
		gl_panelLogin.setVerticalGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup().addContainerGap()
						.addComponent(loginEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(11)
						.addGroup(gl_panelLogin.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1))
						.addGap(35)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textPassw, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addComponent(loginBoton).addGap(26)));
		panelLogin.setLayout(gl_panelLogin);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("D:\\alexs\\Descargas\\hospital logo doctor medical - Hecho con PosterMyWall (1).png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(lblNewLabel)
						.addContainerGap(364, Short.MAX_VALUE))
				.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE).addComponent(lblNewLabel)
						.addGap(1)));
		contentPane.setLayout(gl_contentPane);
		this.pack();
	}

	public JFormattedTextField getUserText() {
		return textEmail;
	}

	public JPasswordField getPasswordText() {
		return textPassw;
	}

	public JButton getLoginBoton() {
		return loginBoton;
	}
}
