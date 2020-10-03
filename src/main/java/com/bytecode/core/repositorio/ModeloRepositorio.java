package com.bytecode.core.repositorio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bytecode.core.mapper.ModeloMapper;
import com.bytecode.core.mapper.OperacionMapper;
import com.bytecode.core.modelo.Modelo;
import com.bytecode.core.modelo.Operacion;

@Repository
public class ModeloRepositorio implements IModelo {

	@Autowired
	private DataSource datasorce;
	private JdbcTemplate jdbc;

	@PostConstruct
	public void postConstruct() {
		jdbc = new JdbcTemplate(datasorce);
	}

	@Override
	public boolean save(Modelo modelo) {

		try {

			String sql = String.format(
					"insert into modelo(modelo_nombre, modelo_valor, modelo_proveedor) values ('%s', '%d', '%d')",
					modelo.getNombre(), modelo.getValor(), modelo.getProveedor());
			jdbc.execute(sql);
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public List<Modelo> getAll(Pageable pageable) {

		return jdbc.query("select * from modelo order by modelo_nombre", new ModeloMapper());

	}
	
	@Override
	public List<Operacion> operaciones(int id){
		
		return jdbc.query("call operacionesModeloE(?)", new Object[] {id}, new OperacionMapper());
		
	}

	@Override
	public Modelo getById(int id) {

		try {
			Object[] params = new Object[] {id};
			return jdbc.queryForObject("select * from modelo where modelo_id = ?", params, new ModeloMapper());
		}catch (Exception e) {
			return null;
		}
	}

	@Override	
	public boolean update(Modelo modelo) {
		
		if(modelo.getId() > 0) {
			String sql = String.format("update modelo set modelo_nombre = '%s', modelo_valor = '%d', modelo_proveedor = '%d' where modelo_id = '%d'", modelo.getNombre(), modelo.getValor(), modelo.getProveedor(), modelo.getId());
			jdbc.execute(sql);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {

		try {

			String sql = String.format("delete from modelo_operacion where modelo_id = '%d'", id);
			jdbc.execute(sql);
			String sql2 = String.format("delete from modelo where modelo_id = '%d'", id);
			jdbc.execute(sql2);
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public List<Modelo> buscarModelos(String filtro) {
		
		
		try {
			
			return jdbc.query("SELECT * FROM modelo WHERE modelo_nombre LIKE ?", new Object[] {"%"+filtro+"%"}, new ModeloMapper());
			
		}catch (Exception e) {
			return null;
		}
		
	}

}
