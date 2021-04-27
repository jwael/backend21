package org.sid.gds.services;

import java.util.List;


import org.sid.gds.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {

	CommandeFournisseurDto save(CommandeFournisseurDto dto);
	
	CommandeFournisseurDto findById(Integer Id);
	
	CommandeFournisseurDto findByCode(String code);
	
	List<CommandeFournisseurDto> findAll();
	
	void delete(Integer Id);
}
