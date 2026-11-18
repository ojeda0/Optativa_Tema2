package com.daw.services.mappers;

import org.springframework.stereotype.Component;

import com.daw.persistence.entities.ClienteEntity;
import com.daw.services.dtos.ClienteDTO;

@Component
public class ClienteMapper {

	public ClienteDTO toDto(ClienteEntity cliente) {
		
		if(cliente == null) {
			return null;
		}
		
		ClienteDTO dto = new ClienteDTO();
		dto.setId(cliente.getId());
		dto.setNombre(cliente.getNombre());
		dto.setEmail(cliente.getEmail());
		dto.setDireccion(cliente.getDireccion());
		dto.setTelefono(cliente.getTelefono());
		
		return dto;
		
	}
	
	public ClienteEntity toEntity(ClienteDTO dto) {
		
		if(dto == null) {
			return null;
		}
		
		ClienteEntity cliente = new ClienteEntity();
		cliente.setId(dto.getId());
		cliente.setNombre(dto.getNombre());
		cliente.setEmail(dto.getEmail());
		cliente.setDireccion(dto.getDireccion());
		cliente.setTelefono(dto.getTelefono());
		
	}
	
}
