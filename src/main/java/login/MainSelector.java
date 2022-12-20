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
	
	public MainSelector(DBConnection conn, Usuario user) {
		super();
		
		VistaSelector view = new VistaSelector();
		view.addListeners(new ListenerBtnSelector(conn, user));
		view.setVisible(true);
	}
}
