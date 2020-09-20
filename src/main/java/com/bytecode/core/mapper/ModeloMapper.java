package com.bytecode.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bytecode.core.modelo.Modelo;

public class ModeloMapper implements RowMapper<Modelo>{

	@Override
	public Modelo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Modelo modelo = new Modelo();
		modelo.setId(rs.getInt("modelo_id"));
		modelo.setNombre(rs.getString("modelo_nombre"));
		modelo.setValor(rs.getInt("modelo_valor"));
		modelo.setProveedor(rs.getInt("modelo_proveedor"));
		
		return modelo;
	}
	
	

}

