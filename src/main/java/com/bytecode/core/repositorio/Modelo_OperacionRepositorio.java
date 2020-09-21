package com.bytecode.core.repositorio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.core.modelo.Modelo_Operacion;

@Repository
public class Modelo_OperacionRepositorio implements IModelo_Operacion{

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbc;
	
	@PostConstruct
	public void postConstruct() {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Modelo_Operacion modeloOperacion) {
		
		try {
			
			String sql = String.format("insert into modelo_operacion(modelo_id, operacion_id) values ('%d', '%d')", modeloOperacion.getModelo(), modeloOperacion.getOperacion());
			jdbc.execute(sql);
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
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
		
		try {
			
			String sql = String.format("delete from modelo_operacion where modelo_operacion_id = '%d'", id);
			jdbc.execute(sql);
			
			return true;
		}catch (Exception e) {
			return false;
		}
	
	}
	
	@Override
	public int getLastId() {
		
		return jdbc.queryForObject("select modelo_operacion_id from modelo_operacion order by modelo_operacion_id desc limit 1", Integer.class);
	}

}
