package com.daw.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daw.persistence.entities.PizzaEntity;
import com.daw.persistence.repositories.PizzaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaService {
	
	private final PizzaRepository pizzaRepository;
	
	//Obtener todas las pizzas
	public List<PizzaEntity> findAll() {
		
		return this.pizzaRepository.findAll();
		
	}

}
