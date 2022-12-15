/**
 * 
 */
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFormattedTextField;
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
			String sql = "select correo, permisos from usuarios where correo like ? and password = sha(?);";
			conn.crearStatement(sql);
			conn.agregarParametroStatement(1, mail);
			conn.agregarParametroStatement(2, pass);
			conn.realizarConsulta();
			try {
				if (conn.getResultado().next()) {
					Usuario user = new Usuario(conn.getResultado().getString("correo"), conn.getResultado().getInt("permisos"));
					new MainSelector(conn, user);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
}
