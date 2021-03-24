package Modelo.facade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Constante;
import Modelo.vo.AlumnoVO;
import Modelo.vo.AlumnosVO;


public class AlumnoFacade {
	private static ArrayList<AlumnoVO> listaAlumnos;
	
	public AlumnoFacade() {

	}
	public static void agregarAlumno(AlumnoVO alumno) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = Constante.getConexion();
		Statement sentencia = con.createStatement();
		sentencia.executeUpdate("INSERT INTO alumno (dni,nombre,apellido1,apellido2,telefono,fechaNacimiento) VALUES ('" + alumno.getDni() + "','" + alumno.getNombre() + "' ,'"
				+ alumno.getApellido1() + "','" + alumno.getApellido2() + "'," + alumno.getTelefono() + ",'"
				+ new Date(alumno.getFechaNacimiento().getTime()) + "')");
		sentencia.close();
		con.close();
//		
		
	}
	
	public static void editarAlumno(AlumnoVO alumno) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = Constante.getConexion();
		Statement sentencia = con.createStatement();
		sentencia.executeUpdate("UPDATE alumno SET nombre='" + alumno.getNombre() + "', apellido1='"
				+ alumno.getApellido1() + "', apellido2='" + alumno.getApellido2() + "', telefono=" + alumno.getTelefono()
				+ ", fechanacimiento='" + new Date(alumno.getFechaNacimiento().getTime()) + "' WHERE dni='" + alumno.getDni()+"'");
		sentencia.close();
		con.close();
	}
	
	public static void eliminarAlumno(String dni) throws ClassNotFoundException, SQLException {

		Connection con = Constante.getConexion();
		Statement sentencia = con.createStatement();
		sentencia.executeUpdate("DELETE FROM alumno WHERE dni='" + dni+"'");
		sentencia.close();
		con.close();
	}
	



	public static List<AlumnoVO> transformarListaVO() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		List<AlumnoVO> alumnos = new ArrayList<AlumnoVO>();
		Connection con = Constante.getConexion();
		Statement sentencia = con.createStatement();
		ResultSet result = sentencia.executeQuery(
				"SELECT dni,nombre,apellido1,apellido2,telefono,fechanacimiento FROM alumno ORDER BY nombre");
		while (result.next()) {
			AlumnoVO alumno = new AlumnoVO();

			alumno.setDni(result.getString("dni"));
			alumno.setNombre(result.getString("nombre"));
			alumno.setApellido1(result.getString("apellido1"));
			alumno.setApellido2(result.getString("apellido2"));
			alumno.setTelefono(result.getInt("telefono"));
			alumno.setFechaNacimiento(result.getDate("fechanacimiento"));
			alumnos.add(alumno);
		}
		sentencia.close();
		con.close();

		return alumnos;
	}
}


