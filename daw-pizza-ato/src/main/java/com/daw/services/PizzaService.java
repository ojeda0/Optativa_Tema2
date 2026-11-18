package com.daw.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daw.persistence.entities.PizzaEntity;
import com.daw.persistence.repositories.PizzaRepository;
import com.daw.services.exceptions.PizzaException;
import com.daw.services.exceptions.PizzaNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaService {
	
	private final PizzaRepository pizzaRepository;
	
	//Obtener todas las pizzas
	public List<PizzaEntity> findAll() {
		
		return this.pizzaRepository.findAll();
		
	}
	
	
	//Obtener pizza por ID
	public PizzaEntity findById(long idPizza) {
		
		if(!this.pizzaRepository.existsById(idPizza)) {
			
			throw new PizzaNotFoundException("El ID introducido no existe.");
			
		}
		
		return this.pizzaRepository.findById(idPizza).get();
		
	}
	
	
	//Crear pizza
	public PizzaEntity create(PizzaEntity pizza) {	
		
		if(pizza.getDisponible() == null) {
			
			pizza.setDisponible(true);
			
		}
		
		pizza.setId(0L);
		
		return this.pizzaRepository.save(pizza);
		
	}
	
	
	//Actualizar pizza
	public PizzaEntity update(long idPizza, PizzaEntity pizza) {
		
		if(idPizza != pizza.getId()) {
			
			throw new PizzaException(String.format("El ID del path (%d) y del body (%d) no coinciden.", idPizza, pizza.getId()));
			
		}
		
		PizzaEntity pizzaBD = this.findById(idPizza);
		
		pizzaBD.setDescripcion(pizza.getDescripcion());
		pizzaBD.setDisponible(pizza.getDisponible());
		pizzaBD.setNombre(pizza.getNombre());
		pizzaBD.setPrecio(pizza.getPrecio());
		pizzaBD.setVegana(pizza.isVegana());
		pizzaBD.setVegetariana(pizza.isVegetariana());
		
		return this.pizzaRepository.save(pizzaBD);
		
	}
	
	
	//Borrar pizza
	public void delete(long idPizza) {
		
		if(!this.pizzaRepository.existsById(idPizza)) {
			
			throw new PizzaNotFoundException("El ID introducido no existe.");
			
		}
		
		this.pizzaRepository.deleteById(idPizza);
		
	}

}
