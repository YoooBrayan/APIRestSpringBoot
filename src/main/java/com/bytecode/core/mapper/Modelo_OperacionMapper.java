package com.bytecode.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bytecode.core.modelo.Modelo_Operacion;

public class Modelo_OperacionMapper implements RowMapper<Modelo_Operacion>{

	@Override
	public Modelo_Operacion mapRow(ResultSet rs, int rowNum) throws SQLException {

		Modelo_Operacion modeloOperacion = new Modelo_Operacion();
		modeloOperacion.setId(rs.getInt("modelo_operacion_id"));
		modeloOperacion.setModelo(rs.getInt("modelo_id"));
		modeloOperacion.setOperacion(rs.getInt("operacion_id"));
		
		return modeloOperacion;
	}

}
