/**
 * 
 */
package common;

import java.sql.Date;

/**
 * @author Israel
 *
 */
public class Libreria {
	public static void escribirLog (DBConnection conex, Usuario user, String usuario, String operacion, String afectado) {
		String sql = "insert into log (id, fecha, operacion, afectado) values (?, ?, ?, ?)";
		conex.crearStatement(sql);
		conex.agregarParametroStatement(1, user.getMail());
		conex.agregarParametroStatement(2, new Date(System.currentTimeMillis()));
		conex.agregarParametroStatement(3, operacion);
		conex.agregarParametroStatement(4, afectado);
		conex.realizarConsulta();
	}
}
