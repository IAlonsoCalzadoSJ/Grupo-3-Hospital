/**
 * 
 */
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import common.DBConnection;
import common.Usuario;

/**
 * @author Israel
 *
 */
public class ListenerBtnSelector implements ActionListener {
	private DBConnection conn;
	private Usuario user;
	
	public ListenerBtnSelector(DBConnection conn, Usuario user) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.user = user;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (((JButton) e.getSource()).getText()) {
		case "FTP":
//			new ControladorMenuEventos(conn, user);
			break;
		case "eMail":
//			new ControladorEmail(conn, user);
			break;
		case "Manual":
			
			break;
		case "Volver":
			
			break;
		default:
			break;
		}
	}

}
