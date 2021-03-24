package Controlador.controllers;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import Modelo.facade.AlumnoFacade;
import Modelo.facade.CursaFacade;
import Modelo.vo.AlumnoVO;
import Modelo.vo.CursaVO;
import Vista.views.AlumnosUI;


public class AlumnosController extends AlumnosUI{
	

	public AlumnosController(int idModulo) {
		super(idModulo);
		
	}

	@Override
	protected void agregarAlumno(String dni, String nombre, String apellido1, String apellido2, int telefono, Date fechaNacimiento) {

		AlumnoVO alumno = new AlumnoVO(dni, nombre, apellido1, apellido2, telefono,fechaNacimiento);
		try {
			AlumnoFacade.agregarAlumno(alumno);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void editarAlumno(String dni, String nombre, String apellido1, String apellido2, int telefono, Date fechaNacimiento) {

		AlumnoVO alumno = new AlumnoVO(dni, nombre, apellido1, apellido2, telefono, fechaNacimiento);

		try {
			AlumnoFacade.editarAlumno(alumno);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void eliminarAlumno(String dni) {

		
		try {
			AlumnoFacade.eliminarAlumno(dni);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	protected List<AlumnoVO> transformarListaVO() {

		List<AlumnoVO> listaAlumnos = null;
		
		try {
			listaAlumnos = AlumnoFacade.transformarListaVO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaAlumnos;
	}
	

	@Override
	protected void agregarCursa(String anho, float nota, String dni, int idModulo) {

		CursaVO cursa = new CursaVO(anho, nota, dni, idModulo);

		try {
			CursaFacade.agregarCursa(cursa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void editarCursa(String anho, float nota, String dni, int idModulo) {

		CursaVO cursa = new CursaVO(anho, nota, dni, idModulo);

		try {
			CursaFacade.editarCursa(cursa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void eliminarCursa(int idModulo, String dni) {

		try {
			CursaFacade.eliminarCursa(idModulo, dni);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected List<CursaVO> listarCursa() {

		List<CursaVO> listaCursa = null;
		
		try {
			listaCursa = CursaFacade.listarCursa();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCursa;
	}
}