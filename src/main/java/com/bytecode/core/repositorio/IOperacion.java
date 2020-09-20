package com.bytecode.core.repositorio;

import java.util.List;

import com.bytecode.core.modelo.Operacion;

public interface IOperacion extends BaseRepositorio<Operacion> {

	public List<Operacion> buscarOperaciones(String filtro);
}
