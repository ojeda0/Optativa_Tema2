package com.daw.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daw.persistence.entities.PizzaPedidoEntity;
import com.daw.persistence.repositories.PizzaPedidoRepository;
import com.daw.services.exceptions.PizzaPedidoException;
import com.daw.services.exceptions.PizzaPedidoNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaPedidoService {
	
	private final PizzaPedidoRepository pizzaPedidoRepository;
	
	//Obtener todos los pizza pedidos
	public List<PizzaPedidoEntity> findAll() {
		
		return this.pizzaPedidoRepository.findAll();
		
	}
	
	
	//Obtener pizza pedido por ID
	public PizzaPedidoEntity findById(long idPizzaPedido) {
		
		if(!this.pizzaPedidoRepository.existsById(idPizzaPedido)) {
			
			throw new PizzaPedidoNotFoundException("El ID introducido no existe.");
			
		}
		
		return this.pizzaPedidoRepository.findById(idPizzaPedido).get();
		
	}
	
	
	//Crear pizza pedido
	public PizzaPedidoEntity create(PizzaPedidoEntity pizzaPedido) {
		
		pizzaPedido.setId(0L);
		
		return this.pizzaPedidoRepository.save(pizzaPedido);
		
	}
	
	
	//Actualizar pizza pedido
	public PizzaPedidoEntity update(long idPizzaPedido, PizzaPedidoEntity pizzaPedido) {
		
		if(idPizzaPedido != pizzaPedido.getId()) {
			
			throw new PizzaPedidoException(String.format("El ID del path (%d) y del body (%d) no coinciden.", idPizzaPedido, pizzaPedido.getId()));
			
		}
		
		PizzaPedidoEntity pizzaPedidoBD = this.findById(idPizzaPedido);
		
		pizzaPedidoBD.setIdPedido(pizzaPedido.getIdPedido());
		pizzaPedidoBD.setIdPizza(pizzaPedido.getIdPizza());
		pizzaPedidoBD.setPrecio(pizzaPedido.getPrecio());
		pizzaPedidoBD.setCantidad(pizzaPedido.getCantidad());
		
		return this.pizzaPedidoRepository.save(pizzaPedidoBD);
		
	}
	
	
	//Borrar pizza pedido
	public void delete(long idPizzaPedido) {
		
		if(!this.pizzaPedidoRepository.existsById(idPizzaPedido)) {
			
			throw new PizzaPedidoNotFoundException("El ID introducido no existe.");
			
		}
		
		this.pizzaPedidoRepository.deleteById(idPizzaPedido);
		
	}

}
