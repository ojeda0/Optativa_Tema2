package com.daw.web.controllers;

import java.util.List;

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

import com.daw.persistence.entities.ClienteEntity;
import com.daw.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteService clienteService;
	
	//Obtener todos los clientes
	@GetMapping
	public ResponseEntity<List<ClienteEntity>> findAll() {
		
		return ResponseEntity.ok(this.clienteService.findAll());
		
	}
	
	
	//Obtener cliente por ID
	@GetMapping("/{idCliente}")
	public ResponseEntity<?> findById(@PathVariable long idCliente) {
		
		return ResponseEntity.ok(this.clienteService.findById(idCliente));
		
	}
	
	//Crear cliente
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ClienteEntity cliente) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.create(cliente));
		
	}
	
	
	//Actualizar cliente
	@PutMapping("/{idCliente}")
	public ResponseEntity<?> update(@PathVariable long idCliente, @RequestBody ClienteEntity cliente) {
		
		return ResponseEntity.ok(this.clienteService.update(idCliente, cliente));
		
	}
	
	
	//Borrar cliente
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> delete(@PathVariable long idCliente) {
		
		this.clienteService.delete(idCliente);
		
		return ResponseEntity.ok().build();
		
	}
	
}
