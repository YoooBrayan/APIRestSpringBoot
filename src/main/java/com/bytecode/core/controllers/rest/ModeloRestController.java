package com.bytecode.core.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytecode.core.modelo.Modelo;
import com.bytecode.core.modelo.Operacion;
import com.bytecode.core.modelo.common.RepBase;
import com.bytecode.core.repositorio.ModeloRepositorio;

@RestController
@RequestMapping("/api/v1/modelo")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ModeloRestController {
	
	@Autowired
	private ModeloRepositorio modeloRepositorio;
	
	@GetMapping
	public ResponseEntity<List<Modelo>> getAll(SpringDataWebProperties.Pageable pageable){
		
		return new ResponseEntity(modeloRepositorio.getAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/operaciones")
	public ResponseEntity<List<Operacion>> operaciones(@PathVariable int id){
		return ResponseEntity.ok(modeloRepositorio.operaciones(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable int id){
		return new ResponseEntity<>(modeloRepositorio.getById(id), (modeloRepositorio.getById(id).equals(null)?HttpStatus.NOT_FOUND:HttpStatus.OK));	
	}
	
	@GetMapping("/filter/{filtro}")
	public ResponseEntity<List<Modelo>> getByFilter(@PathVariable String filtro){
		return ResponseEntity.ok(modeloRepositorio.buscarModelos(filtro));
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody Modelo modelo){
			
		boolean status = modeloRepositorio.save(modelo);
		if(status) {
			return new ResponseEntity(HttpStatus.CREATED);			
		}
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody Modelo modelo){
		return ResponseEntity.ok(new RepBase(modeloRepositorio.update(modelo)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		
		if(modeloRepositorio.getById(id) != null) {
			return ResponseEntity.ok(new RepBase(modeloRepositorio.delete(id)));
		}else {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/params")
	public ResponseEntity<Modelo> getParams(@RequestParam(name = "id") int idModelo, @RequestParam String modelo){
		return ResponseEntity.ok(modeloRepositorio.getByIdAndName(idModelo, modelo));
	}
	 

}
