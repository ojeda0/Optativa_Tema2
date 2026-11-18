package com.daw.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daw.persistence.entities.ClienteEntity;
import com.daw.persistence.repositories.ClienteRepository;
import com.daw.services.exceptions.ClienteException;
import com.daw.services.exceptions.ClienteNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	//Obtener todos los clientes
	public List<ClienteEntity> findAll() {
		
		return this.clienteRepository.findAll();
		
	}
	
	
	//Obtener cliente por ID
	public ClienteEntity findById(long idCliente) {
		
		if(!this.clienteRepository.existsById(idCliente)) {
			
			throw new ClienteNotFoundException("El ID introducido no existe.");
			
		}
		
		return this.clienteRepository.findById(idCliente).get();
		
	}
	
	
	//Crear cliente
	public ClienteEntity create(ClienteEntity cliente) {
		
		cliente.setId(0L);
		
		return this.clienteRepository.save(cliente);
		
	}
	
	
	//Actualizar cliente
	public ClienteEntity update(long idCliente, ClienteEntity cliente) {
		
		if(idCliente != cliente.getId()) {
			
			throw new ClienteException(String.format("El ID del path (%d) y del body (%d) no coinciden.", idCliente, cliente.getId()));
			
		}
		
		ClienteEntity clienteBD = this.findById(idCliente);
		
		clienteBD.setNombre(cliente.getNombre());
		clienteBD.setDireccion(cliente.getDireccion());
		clienteBD.setEmail(cliente.getEmail());
		clienteBD.setTelefono(cliente.getTelefono());
		
		return this.clienteRepository.save(clienteBD);
		
	}
	
	
	//Borrar cliente
	public void delete(long idCliente) {
		
		if(!this.clienteRepository.existsById(idCliente)) {
			
			throw new ClienteNotFoundException("El ID introducido no existe.");
			
		}
		
		this.clienteRepository.deleteById(idCliente);
		
	}

}
