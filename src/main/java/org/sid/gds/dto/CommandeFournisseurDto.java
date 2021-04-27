package org.sid.gds.dto;

import java.time.Instant;
import java.util.List;

import org.sid.gds.model.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommandeFournisseurDto {
	
	
	private Integer id;
	
	private String code;
	

	private Instant dateCommande;
	
	
	private FournisseurDto fournisseur;
	

	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;


	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandefournisseur) {
		if(commandefournisseur==null) {
			return null;
		}
		return CommandeFournisseurDto.builder()
				.id(commandefournisseur.getId())
				.code(commandefournisseur.getCode())
				.dateCommande(commandefournisseur.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(commandefournisseur.getFournisseur()))
				.build();
		
	}


	public static CommandeFournisseurDto toEntity(CommandeFournisseurDto commandefournisseurdto) {
		CommandeFournisseur commandefournisseur = new CommandeFournisseur();
		commandefournisseur.setId(commandefournisseurdto.getId());
		commandefournisseur.setCode(commandefournisseurdto.getCode());
		commandefournisseur.setDateCommande(commandefournisseurdto.getDateCommande());
		commandefournisseur.setCreationDate(commandefournisseur.getCreationDate());
		
		return commandefournisseurdto;
	}





}
