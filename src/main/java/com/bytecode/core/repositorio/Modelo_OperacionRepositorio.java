package com.bytecode.core.repositorio;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.bytecode.core.modelo.Modelo_Operacion;

public class Modelo_OperacionRepositorio implements IModelo_Operacion{

	@Override
	public boolean save(Modelo_Operacion modeloOperacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Modelo_Operacion> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Modelo_Operacion getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Modelo_Operacion modeloOperacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
