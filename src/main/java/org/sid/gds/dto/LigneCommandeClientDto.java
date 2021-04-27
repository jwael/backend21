package org.sid.gds.dto;

import java.math.BigDecimal;

import org.sid.gds.model.Article;
import org.sid.gds.model.CommandeClient;
import org.sid.gds.model.LigneCommandeClient;
import org.sid.gds.model.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeClientDto {
	
	private Integer id;


	private ArticleDto article;
	

	private CommandeClientDto commandeClient;
	

	private BigDecimal quantite;
	
	
	private BigDecimal prixUnitaire;
	

	public static LigneCommandeClientDto fromEntity(LigneCommandeClient  ligneCommandeClient) {
		if(ligneCommandeClient==null) {
			return null;
		}
		return LigneCommandeClientDto.builder()
				.id(ligneCommandeClient.getId())
				.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
				.quantite(ligneCommandeClient.getQuantite())
				.article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
				.commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
				.build();
									
	}
	
	public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
		if(ligneCommandeClientDto==null) {
			return null;
		}
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
	
		ligneCommandeClient.setId(ligneCommandeClientDto.getId());
		ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
		ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
		
		return ligneCommandeClient;
}

	
}
