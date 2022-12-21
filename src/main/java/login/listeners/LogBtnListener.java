/**
 * 
 */
package login.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

import common.DBConnection;
import common.Usuario;
import login.controladores.MainSelector;
import login.vistas.VistaLogin;

/**
 * @author Israel
 *
 */
public class LogBtnListener implements ActionListener {
	private DBConnection conn;
	private VistaLogin view;

	public LogBtnListener(DBConnection conn, VistaLogin view) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String mail = view.getUserText().getText();
		String pass = String.valueOf(view.getPasswordText().getPassword());
		if (!mail.isEmpty() && !pass.isEmpty()) {
			try {
				InternetAddress validMail[] = InternetAddress.parse(mail);
				String sql = "select u.correo, u.permisos, u.doctor, p.leer_ajena, p.modificar_propia from usuarios as u inner join permisos as p on u.permisos = p.id where correo like ? and password = sha(?);";
				conn.crearStatement(sql);
				conn.agregarParametroStatement(1, mail);
				conn.agregarParametroStatement(2, pass);
				conn.realizarConsulta();
				if (conn.getResultado().next()) {
					Usuario user = new Usuario(mail, conn.getResultado().getInt("permisos"),
							conn.getResultado().getString("doctor"), conn.getResultado().getBoolean("leer_ajena"),
							conn.getResultado().getBoolean("modificar_propia"), pass);
					view.setVisible(false);
					new MainSelector(conn, user, view);
				} else {
					JOptionPane.showInternalMessageDialog(null,
							"No se ha encontrado esa combinacion de usuario y contraseña", "Error login",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (AddressException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showInternalMessageDialog(null, "Direccion de correo no valida", "Error correo",
						JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showInternalMessageDialog(null, "Error accediendo a los datos de usuarios", "Error BBDD",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showInternalMessageDialog(null,
					"No se permiten campos vacios en usuario o contraseña", "Error login",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}