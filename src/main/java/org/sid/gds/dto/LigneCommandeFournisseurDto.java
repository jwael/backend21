package org.sid.gds.dto;

import java.math.BigDecimal;


import org.sid.gds.model.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	
	private Integer id;

	private ArticleDto article;
	

	private CommandeFournisseurDto commandeFournisseur;
	

	private BigDecimal quantite;
	

	private BigDecimal prixUnitaire;

	

	public static LigneCommandeFournisseurDto  fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
		if(ligneCommandeFournisseur==null) {
			return null;
		}
		return  LigneCommandeFournisseurDto .builder()
				.id(ligneCommandeFournisseur.getId())
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				.commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.build();
	}
	public static LigneCommandeFournisseur toEntity (LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		LigneCommandeFournisseur lignecommandefournisseur = new LigneCommandeFournisseur();
		lignecommandefournisseur.setId(ligneCommandeFournisseurDto.getId());
		lignecommandefournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		lignecommandefournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getQuantite());
		
		
		return lignecommandefournisseur;
		
		
		
		
		
	}
}
