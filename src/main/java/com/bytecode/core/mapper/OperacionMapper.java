package com.bytecode.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bytecode.core.modelo.Operacion;

public class OperacionMapper implements RowMapper<Operacion>{

	@Override
	public Operacion mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Operacion operacion = new Operacion();
		operacion.setId(rs.getInt(1));
		operacion.setDescripcion(rs.getString(2));
		operacion.setValor(rs.getInt(3));
		
		return operacion;
	}

}
