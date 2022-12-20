/**
 * 
 */
package login;

import common.DBConnection;
import common.Usuario;

/**
 * @author Israel
 *
 */
public class MainSelector {
	
	public MainSelector(DBConnection conn, Usuario user, VistaLogin preview) {
		super();
		
		VistaSelector view = new VistaSelector();
		ListenerBtnSelector list = new ListenerBtnSelector(conn, user, view, preview);
		for (int i = 0; i < view.getBotones().size(); i++) {
			view.getBotones().get(i).addActionListener(list);
		}
		view.setVisible(true);
	}
}
