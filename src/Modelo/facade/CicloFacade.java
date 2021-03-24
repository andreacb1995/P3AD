package Modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Constante;
import Modelo.vo.CicloVO;


public class CicloFacade {
	
	public CicloFacade() {
		
	}

	public static void nuevoCiclo(CicloVO ciclo) throws SQLException, ClassNotFoundException {
			
		Connection con=Constante.getConexion();
		Statement sentencia=con.createStatement();
		sentencia.executeUpdate("INSERT INTO ciclo (id,nombre,nivel,curso) VALUES ("+ciclo.getId()+",'"+ciclo.getNombre()+"',"+ciclo.getNivel()+","+ciclo.getCursos()+")");
		sentencia.close();
		con.close();
	}
			
			
	public static List<CicloVO> listarCiclo() throws SQLException, ClassNotFoundException {
			
		List<CicloVO> ciclos=new ArrayList<CicloVO>();
		Connection conexion=Constante.getConexion();
		Statement sentencia=conexion.createStatement();
		ResultSet resultado=sentencia.executeQuery("SELECT id,nombre,nivel,cursos FROM ciclo ORDER BY nombre");
		while(resultado.next()) {
			CicloVO ciclo=new CicloVO();
			ciclo.setId(resultado.getInt("id"));
			ciclo.setNombre(resultado.getString("nombre"));
			ciclo.setNombre(resultado.getString("nivel"));
			ciclo.setNombre(resultado.getString("cursos"));
			ciclos.add(ciclo);
		}
		sentencia.close();
		conexion.close();
		
		return ciclos;			
	}
		
	public static void actualizarCiclo(CicloVO ciclo) throws ClassNotFoundException, SQLException {
			
		Connection conexion=Constante.getConexion();
		Statement sentencia=conexion.createStatement();
		sentencia.executeUpdate("UPDATE ciclo SET nombre="+ciclo.getNombre()+" WHERE id="+ciclo.getId());
		sentencia.close();
		conexion.close();
	}
		
	public static void eliminarCiclo(CicloVO ciclo) throws ClassNotFoundException, SQLException {
			
		Connection conexion=Constante.getConexion();
		Statement sentencia=conexion.createStatement();
		sentencia.executeUpdate("DELETE FROM WHERE id="+ciclo.getId());
		sentencia.close();
		conexion.close();
	}			
}