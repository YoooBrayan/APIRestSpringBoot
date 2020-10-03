package com.bytecode.core.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bytecode.core.modelo.Modelo_Operacion;
import com.bytecode.core.modelo.common.RepBase;
import com.bytecode.core.repositorio.Modelo_OperacionRepositorio;

@RestController
@RequestMapping("/api/v1/modeloOperacion")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class Modelo_OperacionRestController {
	
	@Autowired
	private Modelo_OperacionRepositorio modeloOperacionRepositorio;
	
	@PostMapping
	public ResponseEntity save(@RequestBody Modelo_Operacion modeloOperacion) {
		
		return ResponseEntity.ok(new RepBase(modeloOperacionRepositorio.save(modeloOperacion)));
	}
	
	@GetMapping
	public ResponseEntity<Integer> getLastId(){
		
		return ResponseEntity.ok(modeloOperacionRepositorio.getLastId());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		
		return ResponseEntity.ok(modeloOperacionRepositorio.delete(id));
	}
	


}
