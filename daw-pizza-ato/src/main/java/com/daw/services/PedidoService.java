package com.daw.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.daw.persistence.entities.PedidoEntity;
import com.daw.persistence.repositories.PedidoRepository;
import com.daw.services.exceptions.PedidoException;
import com.daw.services.exceptions.PedidoNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;
	
	//Buscar todos los pedidos
	public List<PedidoEntity> findAll(){
		
		return this.pedidoRepository.findAll();
		
	}
	
	
	//Buscar pedido por ID
	public PedidoEntity findById(long idPedido) {
			
		if(!this.pedidoRepository.existsById(idPedido)) {
				
			throw new PedidoNotFoundException("El ID introducido no existe.");
				
		}
			
		return this.pedidoRepository.findById(idPedido).get();
			
	}
	
	
	//Crear pedido
	public PedidoEntity create(PedidoEntity pedido) {		
		
		//Añadir restricciones para que no se pueda modificar la fecha del pedido ni el total.
		
		if(pedido.getFecha() != null) {
			
			throw new PedidoException("ERROR. La fecha de captura no puede ser modificada.");
			
		}
		
		if(pedido.getTotal() != 0.0) {
			
			throw new PedidoException("ERROR. El total inicial al crear un pedido debe ser 0.0.");
			
		}
		
		//
		
		pedido.setId(0L);
		pedido.setFecha(LocalDateTime.now());
		pedido.setTotal(0.0);

		
		return this.pedidoRepository.save(pedido);
		
	}
	
	
	//Actualizar pedido
	public PedidoEntity update(long idPedido, PedidoEntity pedido) {
		
		if(idPedido != pedido.getId()) {
			
			throw new PedidoException(String.format("El ID del path (%d) y del body (%d) no coinciden.", idPedido, pedido.getId()));
			
		}
		
		PedidoEntity pedidoBD = this.findById(idPedido);
		
		pedidoBD.setIdCliente(pedido.getIdCliente());
		pedidoBD.setMetodo(pedido.getMetodo());
		pedidoBD.setNotas(pedido.getNotas());

		return this.pedidoRepository.save(pedidoBD);
		
	}
	
	
	//Borrar pedido
	public void delete(long idPedido) {
		
		if(!this.pedidoRepository.existsById(idPedido)) {
			
			throw new PedidoNotFoundException("El ID introducido no existe.");
			
		}
		
		this.pedidoRepository.deleteById(idPedido);
		
	}
	
}
