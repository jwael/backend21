package org.sid.gds.services;

import java.util.List;

	
import org.sid.gds.dto.UtilisateurDto;

public interface UtilisateurService {

	UtilisateurDto save(UtilisateurDto dto);
	
	UtilisateurDto findById(Integer id);
	
	List<UtilisateurDto> findall ();
	
	void delete (Integer id);
}
