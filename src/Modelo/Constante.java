package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.xdevapi.Statement;

public class Constante {

	
	
	
	
	private static Connection conexion=null;
		
		public static Connection getConexion() throws ClassNotFoundException, SQLException {
			Properties configuracion = new Properties();
			final String cadena="jdbc:mysql://localhost:3306/colegio";
			final String usuario="root";
			final String contrasenha="root";
			
				try {

				// cargamos el fichero de propiedades
				configuracion.load(new FileInputStream("src\\connect.props"));
//				configuracion.getProperty("cadena")configuracion.getProperty("usuario"), configuracion.getProperty("contrasenha")
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

			if(conexion==null||conexion.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion=DriverManager.getConnection(cadena,usuario,contrasenha );
			}
			return conexion;
		}
	

}
