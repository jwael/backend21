package org.sid.gds.services;

import java.util.List;

import org.sid.gds.dto.FournisseurDto;

public interface FournisseurService {

	FournisseurDto save(FournisseurDto dto);
	
	FournisseurDto findById(Integer id);
	
	List<FournisseurDto> findall ();
	
	void delete (Integer id);
}
