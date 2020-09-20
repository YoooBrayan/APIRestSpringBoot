package com.bytecode.core.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytecode.core.modelo.Modelo;
import com.bytecode.core.modelo.common.RepBase;
import com.bytecode.core.repositorio.ModeloRepositorio;

@RestController
@RequestMapping("/api/v1/modelo")
public class ModeloRestController {
	
	@Autowired
	private ModeloRepositorio modeloRepositorio;
	
	@GetMapping
	public ResponseEntity<List<Modelo>> getAll(SpringDataWebProperties.Pageable pageable){
		
		return ResponseEntity.ok(modeloRepositorio.getAll(pageable));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Modelo> getById(@PathVariable int id){
		return ResponseEntity.ok(modeloRepositorio.getById(id));
	}
	
	@GetMapping("/filter/{filtro}")
	public ResponseEntity<List<Modelo>> getByFilter(@PathVariable String filtro){
		return ResponseEntity.ok(modeloRepositorio.buscarModelos(filtro));
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody Modelo modelo){
		
		return ResponseEntity.ok(new RepBase(modeloRepositorio.save(modelo)));
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody Modelo modelo){
		return ResponseEntity.ok(new RepBase(modeloRepositorio.update(modelo)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		
		if(modeloRepositorio.getById(id) != null) {
			System.out.println("Entro");
			return ResponseEntity.ok(new RepBase(modeloRepositorio.delete(id)));
		}else {
			System.out.println("No Entro");
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		
		
	}
	 

}
