package Controlador.controllers;

import java.sql.SQLException;
import java.util.List;

import Vista.views.ModulosUI;
import Modelo.facade.ModuloFacade;
import Modelo.vo.ModuloVO;

public class ModulosController extends ModulosUI{

	@Override
	protected void agregarModulo(String nombre, int curso, int horas, int idCiclo) {

		ModuloVO modulo = new ModuloVO(null, nombre, curso, horas, idCiclo);

	
		try {
			ModuloFacade.agregarModulo(modulo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}


	@Override
	protected void editarModulo(Integer idModulo, String nombre, int curso, int horas, int idCiclo) {

		ModuloVO modulo = new ModuloVO(idModulo, nombre, curso, horas, idCiclo);

		try {
			ModuloFacade.editarModulo(modulo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void eliminarModulo(Integer idModulo) {

		try {
			ModuloFacade.eliminarModulo(idModulo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected List<ModuloVO> transformarListaVO() {

		List<ModuloVO> listaModulos = null;
		try {
			listaModulos = ModuloFacade.transformarListaVO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listaModulos;
	}
	

	

}
