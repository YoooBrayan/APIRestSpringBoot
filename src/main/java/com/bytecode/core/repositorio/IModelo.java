package com.bytecode.core.repositorio;

import java.util.List;

import com.bytecode.core.modelo.Modelo;
import com.bytecode.core.modelo.Operacion;

public interface IModelo  extends BaseRepositorio<Modelo>{

	public List<Modelo> buscarModelos(String filtro);
	
	public List<Operacion> operaciones(int id);
}
