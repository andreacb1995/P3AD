package Modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Constante;
import Modelo.vo.CursaVO;

public class CursaFacade {
private static ArrayList<CursaVO> listaCursa;
	
	
	public CursaFacade() {
		
	}
	
	public static void agregarCursa(CursaVO cursa) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conexion = Constante.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("INSERT INTO cursa (anho,nota,idModulo, dni) VALUES ('" + cursa.getAnho() + "',"
				+ cursa.getNota() + "," + cursa.getIdModulo() + ",'" + cursa.getDni() + "')");
		sentencia.close();
		conexion.close();
	}
	
	
	public static void eliminarCursa(int id, String dni) throws SQLException, ClassNotFoundException {
		Connection conexion = Constante.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("DELETE FROM cursa WHERE idModulo=" + id + " AND dni='" + dni + "'");
		sentencia.close();
		conexion.close();
	}

	public static void editarCursa(CursaVO cursa) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conexion = Constante.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("UPDATE cursa SET anho='" + cursa.getAnho() + "',nota=" + cursa.getNota()
				+ " WHERE idModulo=" + cursa.getIdModulo() + " AND dni='" + cursa.getDni() + "'");
		sentencia.close();
		conexion.close();
	}

	

	public static List<CursaVO> listarCursa() throws ClassNotFoundException, SQLException {
		List<CursaVO> cursan = new ArrayList<CursaVO>();
		Connection conexion = Constante.getConexion();
		Statement sentencia = conexion.createStatement();
		ResultSet result = sentencia.executeQuery("SELECT anho,nota,dni,idModulo FROM cursa ORDER BY anho");
		while (result.next()) {
			CursaVO cursa = new CursaVO();
			cursa.setAnho(result.getString("anho"));
			cursa.setNota(result.getFloat("nota"));
			cursa.setDni(result.getString("dni"));
			cursa.setIdModulo(result.getInt("idModulo"));
			cursan.add(cursa);
		}
		sentencia.close();
		conexion.close();

		return cursan;
	}
}

