package com.daw.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
