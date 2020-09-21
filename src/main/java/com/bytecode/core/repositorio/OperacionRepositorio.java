package com.bytecode.core.repositorio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.core.mapper.OperacionMapper;
import com.bytecode.core.modelo.Operacion;

@Repository
public class OperacionRepositorio implements IOperacion {

	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbc;
	
	@PostConstruct
	public void postConstruct() {
		this.jdbc = new JdbcTemplate(datasource);
	}
	
	@Override
	public boolean save(Operacion operacion) {
		
		try {
			
			String sql = String.format("insert into operacion(operacion_descripcion, operacion_valor) values ('%s', '%d')", operacion.getDescripcion(), operacion.getValor());
			jdbc.execute(sql);
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public List<Operacion> getAll(Pageable pageable) {
		
		return jdbc.query("select * from operacion", new OperacionMapper());
		
	}

	@Override
	public Operacion getById(int id) {
		
		return jdbc.queryForObject("select * from operacion where operacion_id = ?", new Object[]{id}, new OperacionMapper());
		
	}

	@Override
	public boolean update(Operacion operacion) {
		
		try {
			
			String sql = String.format("update operacion set Operacion_descripcion = '%s', operacion_valor = '%d' where operacion_id = '%d'", operacion.getDescripcion(), operacion.getValor(), operacion.getId());
			jdbc.execute(sql);
			return true;
			
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean delete(int id) {
		
		try {
			
			String sql = String.format("delete from operacion where operacion_id = '%d'", id);
			jdbc.execute(sql);
			return true;
			
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<Operacion> buscarOperaciones(String filtro){
		
		return jdbc.query("select * from operacion where operacion_descripcion like ?", new Object[]{filtro}, new OperacionMapper());
		
	}
	
	@Override
	public int getLastId() {
		return jdbc.queryForObject("select operacion_id from operacion order by operacion_id desc limit 1", Integer.class);
	}
}
