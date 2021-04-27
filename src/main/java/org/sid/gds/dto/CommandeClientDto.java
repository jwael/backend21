package org.sid.gds.dto;

import java.time.Instant;
import java.util.List;

import org.sid.gds.model.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommandeClientDto {


	private Integer id;
	
	private String code;
	

	private Instant dateCommande;
	

	private ClientDto client;
	
	
	private List<LigneCommandeClientDto> ligneCommandeClients;
	
	
	public static CommandeClientDto fromEntity(CommandeClient commandeclient) {
		if(commandeclient==null) {
			return null;
		}
		return  CommandeClientDto.builder()
				.id(commandeclient.getId())
				.code(commandeclient.getCode())
				.dateCommande(commandeclient.getDateCommande())
				.client(ClientDto.fromEntity(commandeclient.getClient()))
				.build();
	}
	public static CommandeClient toEntity(CommandeClientDto commandeclientDto) {
		CommandeClient commandeclient = new CommandeClient();
		commandeclient.setId(commandeclientDto.getId());
		commandeclient.setCode(commandeclientDto.getCode());
		commandeclient.setDateCommande(commandeclientDto.getDateCommande());
		
		return commandeclient;
	}
	
	

}
