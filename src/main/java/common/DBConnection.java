/**
 * 
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Israel
 *
 */
public class DBConnection {
	Connection conexion;
	PreparedStatement consultor;
	ResultSet resultado;
	
	/**
	 * Registra el driver e instancia el objeto conexión.
	 */
	public void crearConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el driver de conexion a la base de datos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error conectando a la base de datos");
		}		
	}
	
	/**
	 * Genera un PreparedStatement con el parametro recibido.
	 * @param baseSentence - String - Sentencia SQL parametrizada.
	 * @return 
	 */
	public void crearStatement(String baseSentence) {
		try {
			consultor = conexion.prepareStatement(baseSentence);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al crear el Statement");
		}
	}
	
	/**
	 * Agrega un parámetro String al PreparedStatement en la posición indicada.
	 * @param posicion - int - Indica en que posición ha de agregarse el parámetro.
	 * @param parametro - String - Parámetro a agregar al PreparedStatement.
	 * @return 
	 */
	public void agregarParametroStatement(int posicion, String parametro) {
		try {
			consultor.setString(posicion, parametro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al agregar el parámetro seleccionado");
		}
	}
	
	/**
	 * Agrega un parámetro int al PreparedStatement en la posición indicada.
	 * @param posicion - int - Indica en que posición ha de agregarse el parámetro.
	 * @param parametro - int - Parámetro a agregar al PreparedStatement.
	 * @return 
	 */
	public void agregarParametroStatement(int posicion, int parametro) {
		try {
			consultor.setInt(posicion, parametro);
		} catch (SQLException e) {
			System.out.println("Error al agregar el parámetro seleccionado");
		}
	}
	
	/**
	 * Agrega un parámetro float al PreparedStatement en la posición indicada.
	 * @param posicion - int - Indica en que posición ha de agregarse el parámetro.
	 * @param parametro - float - Parámetro a agregar al PreparedStatement.
	 * @return 
	 */
	public void agregarParametroStatement(int posicion, float parametro) {
		try {
			consultor.setFloat(posicion, parametro);
		} catch (SQLException e) {
			System.out.println("Error al agregar el parámetro seleccionado");
		}
	}
	
	/**
	 * Crea un Resultset ejecutando el PreparedStatement recibido.
	 * @param sql - PreparedStatement - Contiene la consulta SQL a realizar.
	 */
	public void realizarConsulta() {
		try {
			resultado = consultor.executeQuery();
		} catch (SQLException e) {
			System.out.println("No se han encontrado resultados");
		}
	}
	
	/**
	 * Realiza la consulta de escritura en la base de datos, devoviendo el total de filas afectadas.
	 * @param sql - PreparedStatement - Contiene la sentencia SQL para realizar la operación de escritura.
	 * @return - int - Devuelve el numero de filas modificadas por la consulta.
	 */
	public int realizarModificacion() {
		try {
			return consultor.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la consulta");
		}
		return -1;
	}
	
	/**
	 * Cierra la conexión a la base de datos.
	 */
	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión");
		}
	}
	
	/**
	 * Cierra el Statement.
	 */
	public void cerrarStatement() {
		try {
			consultor.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar el Statement");
		}
	}
	
	/**
	 * Cierra el ResultSet.
	 */
	public void cerrarResultSet() {
		try {
			resultado.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar el resultset");
		}
	}

	/**
	 * @return
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * @param conexion the conexion to set
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	/**
	 * @return the consultor
	 */
	public PreparedStatement getConsultor() {
		return consultor;
	}

	/**
	 * @param consultor the consultor to set
	 */
	public void setConsultor(PreparedStatement consultor) {
		this.consultor = consultor;
	}

	/**
	 * @return the resultado
	 */
	public ResultSet getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(ResultSet resultado) {
		this.resultado = resultado;
	}
}
