package com.bytecode.core.repositorio;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

public interface BaseRepositorio<T> {

	public boolean save(T object);
	
	public List<T> getAll(Pageable pageable);
	
	public T getById(int id);
	
	public boolean update(T object);
	
	public boolean delete(int id);
	
}
