/**
 * 
 */
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import common.DBConnection;
import common.Usuario;

/**
 * @author Israel
 *
 */
public class LogBtnListener implements ActionListener{
	private DBConnection conn;
	private JFormattedTextField userText;
	private JPasswordField passwordText;
	
	public LogBtnListener(DBConnection conn, JFormattedTextField userText, JPasswordField passwordText) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.userText = userText;
		this.passwordText = passwordText;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String mail = userText.getText();
		String pass = String.valueOf(passwordText.getPassword());
		if (!mail.isEmpty() && !pass.isEmpty()) {
			try {
				InternetAddress validMail[] =  InternetAddress.parse(mail);
				String sql = "select correo, permisos from usuarios where correo like ? and password = sha(?);";
				conn.crearStatement(sql);
				conn.agregarParametroStatement(1, mail);
				conn.agregarParametroStatement(2, pass);
				conn.realizarConsulta();
				if (conn.getResultado().next()) {
					Usuario user = new Usuario(validMail, conn.getResultado().getInt("permisos"));
					new MainSelector(conn, user);
				} else {
					JOptionPane.showInternalMessageDialog(null, "No se ha encontrado esa combinacion de usuario y contraseña", "Error login", JOptionPane.WARNING_MESSAGE);
				}
			} catch (AddressException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showInternalMessageDialog(null, "Direccion de correo no valida", "Error correo", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showInternalMessageDialog(null, "Error accediendo a los datos de usuarios", "Error BBDD", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	
}
