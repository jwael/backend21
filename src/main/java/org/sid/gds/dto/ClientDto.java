package org.sid.gds.dto;

import java.util.List;

import org.sid.gds.model.Client;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {

	private Integer id;
	
	private String nom;
	
	
	private String prenom;
	
	
	private AdresseDto adresse;
	

	private String photo;
	

	private String email;
	
	
	private String numTel;
	
	@JsonIgnore
	private List<CommandeClientDto> commandeClients;
	
	public static ClientDto fromEntity(Client client) {
		if(client==null) {
			return null;
		}
		
		return ClientDto.builder()
				.id(client.getId())
				.prenom(client.getPrenom())
				.email(client.getEmail())
				.nom(client.getNom())
				.numTel(client.getNumTel())
				.build();
		
	}
	
		public static Client toEntity(ClientDto clientDto) {
			Client client = new Client();
			client.setId(clientDto.getId());
			client.setPrenom(clientDto.getPrenom());
			client.setEmail(clientDto.getEmail());
			client.setNom(clientDto.getNom());
			client.setNumTel(clientDto.getNumTel());
			return client;
			
		}
	
}
