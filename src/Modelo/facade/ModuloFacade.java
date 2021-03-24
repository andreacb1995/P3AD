package Modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Constante;
import Modelo.vo.ModuloVO;
import Modelo.vo.ModulosVO;

public class ModuloFacade {
	 private ModuloFacade() {
	    }


	
	 public static void agregarModulo(ModuloVO modulo) throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
		 Connection conexion = Constante.getConexion();
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO modulo (nombre,curso,horas,idciclo) VALUES ('" + modulo.getNombre()
					+ "'," + modulo.getCurso() + "," + modulo.getHoras() + "," + modulo.getIdCiclo() + ")");
			sentencia.close();
			conexion.close();
		}
	public static void eliminarModulo(Integer id) throws ClassNotFoundException, SQLException {
		Connection conexion = Constante.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("DELETE FROM modulo WHERE id=" + id);
		sentencia.close();
		conexion.close();
	    }
		



	public static void editarModulo(ModuloVO modulo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conexion = Constante.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("UPDATE modulo SET nombre= '" + modulo.getNombre() + "', curso="
				+ modulo.getCurso() + ", horas=" + modulo.getHoras() + ", idciclo=" + modulo.getIdCiclo()
				+ " WHERE id=" + modulo.getId());
		sentencia.close();
		conexion.close();
	}


	public static List<ModuloVO> transformarListaVO() throws SQLException, ClassNotFoundException {
		List<ModuloVO> modulos = new ArrayList<ModuloVO>();
		Connection conexion = Constante.getConexion();
		Statement sentencia = conexion.createStatement();
		ResultSet result = sentencia
				.executeQuery("SELECT id,nombre,curso,horas,idciclo FROM modulo ORDER BY nombre");
		while (result.next()) {
			int id = result.getInt("id");
			String nombre = result.getString("nombre");
			int curso = result.getInt("curso");
			int horas = result.getInt("horas");
			int idCiclo = result.getInt("idciclo");
			modulos.add(new ModuloVO(id, nombre, curso, horas, idCiclo));

		}
		sentencia.close();
		conexion.close();

		return modulos;
	}


	

	

}