package org.sid.gds.services;

import java.util.List;

import org.sid.gds.dto.ClientDto;

public interface ClientService {
	
	ClientDto save(ClientDto  dto);
	
	ClientDto findById(Integer id);
	
	List<ClientDto> findall();
	
	void delete(Integer id);

}
