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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytecode.core.modelo.Operacion;
import com.bytecode.core.modelo.common.RepBase;
import com.bytecode.core.repositorio.OperacionRepositorio;

@RestController
@RequestMapping("/api/v1/operacion")
public class OperacionRestController {

	@Autowired
	private OperacionRepositorio operacionRepository;

	@GetMapping
	public ResponseEntity<List<Operacion>> getAll(SpringDataWebProperties.Pageable pageable) {

		return ResponseEntity.ok(operacionRepository.getAll(pageable));

	}

	@GetMapping("/{id}")
	public ResponseEntity<Operacion> getById(@PathVariable int id) {

		return ResponseEntity.ok(operacionRepository.getById(id));

	}
	
	@GetMapping("/lastId")
	public ResponseEntity<Integer> getLastId() {
		return ResponseEntity.ok(operacionRepository.getLastId());
	}

	@PostMapping
	public ResponseEntity save(@RequestBody Operacion operacion) {

		return ResponseEntity.ok(new RepBase(operacionRepository.save(operacion)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {

		if (operacionRepository.getById(id) != null) {

			return ResponseEntity.ok(new RepBase(operacionRepository.delete(id)));

		} else {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}

	}

}
