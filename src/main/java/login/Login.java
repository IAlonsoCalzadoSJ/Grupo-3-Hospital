/**
 * 
 */
package login;

import common.DBConnection;

/**
 * @author Israel
 *
 */
public class Login {
	DBConnection conn = new DBConnection();
	VistaLogin view;
	
	public Login() {
		conn.crearConexion();
		view = new VistaLogin();
		LogBtnListener list = new LogBtnListener(conn, view.getUserText(), view.getPasswordText());
		view.setBtnSendEvent(list);
		view.setVisible(true);
	}
}
