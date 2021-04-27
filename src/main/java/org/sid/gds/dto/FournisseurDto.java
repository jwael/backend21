package org.sid.gds.dto;

import java.util.List;

import org.sid.gds.model.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FournisseurDto {
	
	private Integer id;

	
	private String nom;
	
	
	private String prenom;
	
	
	private AdresseDto adresse;
	
	
	private String photo;
	
	
	private String email;
	
	
	private String numTel;
	
	
	private List<CommandeFournisseurDto> commandeFournisseurs;
	
	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		if(fournisseur==null) {
			return null;
		}
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.email(fournisseur.getEmail())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.numTel(fournisseur.getNumTel())
				.photo(fournisseur.getPhoto())
				.build();
				
	}
	
	public static Fournisseur toEntity(FournisseurDto fournisseurdto) {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurdto.getId());
		fournisseur.setNom(fournisseurdto.getNom());
		fournisseur.setPrenom(fournisseur.getPrenom());
		fournisseur.setEmail(fournisseur.getEmail());
		fournisseur.setNumTel(fournisseur.getNumTel());
		
		return fournisseur;
	}

}
