package org.sid.gds.services;

import java.util.List;

import org.sid.gds.dto.EntrepriseDto;

public interface EntrepriseService {

	EntrepriseDto save(EntrepriseDto dto);
	
	EntrepriseDto findById(Integer id);
	
	List<EntrepriseDto> findall ();
	
	void delete (Integer id);
}
