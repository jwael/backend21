package org.sid.gds.services;

import java.util.List;

import org.sid.gds.dto.CommandeClientDto;
import org.sid.gds.dto.VentesDto;


public interface VentesService {

	VentesDto save(VentesDto dto);
	
	VentesDto findById(Integer id);
	
	VentesDto findByCode(String code);
	
	List<VentesDto> findAll();
	
	void delete(Integer id);
}
