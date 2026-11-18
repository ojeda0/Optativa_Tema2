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

import com.daw.persistence.entities.PizzaPedidoEntity;
import com.daw.services.PizzaPedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pizzas_pedidos")
@RequiredArgsConstructor
public class PizzaPedidoController {

	private final PizzaPedidoService pizzaPedidoService;
	
	//Obtener todas las pizzas pedidos
	@GetMapping
	public ResponseEntity<List<PizzaPedidoEntity>> findAll() {
		
		return ResponseEntity.ok(this.pizzaPedidoService.findAll());
		
	}
	
	
	//Obtener pizza pedido por ID
	@GetMapping("/{idPizzaPedido}")
	public ResponseEntity<?> findById(@PathVariable long idPizzaPedido) {
		
		return ResponseEntity.ok(this.pizzaPedidoService.findById(idPizzaPedido));
		
	}
	
	
	//Crear pizza pedido
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PizzaPedidoEntity pizzaPedido) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.pizzaPedidoService.create(pizzaPedido));
		
	}
	
	
	//Actualizar pizza pedido
	@PutMapping("/{idPizzaPedido}")
	public ResponseEntity<?> update(@PathVariable long idPizzaPedido, @RequestBody PizzaPedidoEntity pizzaPedido) {
		
		return ResponseEntity.ok(this.pizzaPedidoService.update(idPizzaPedido, pizzaPedido));
		
	}
	
	
	//Borrar pizza pedido
	@DeleteMapping("/{idPizzaPedido}")
	public ResponseEntity<?> delete(@PathVariable long idPizzaPedido) {
		
		this.pizzaPedidoService.delete(idPizzaPedido);
		
		return ResponseEntity.ok().build();
		
	}
	
}
