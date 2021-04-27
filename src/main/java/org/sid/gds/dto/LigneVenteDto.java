package org.sid.gds.dto;

import java.math.BigDecimal;

import org.sid.gds.model.LigneVente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {
	
	
	private Integer id;

	private VentesDto ventes;
	
	
	private BigDecimal quantite;
	
	
	private BigDecimal prixUnitaire;
	
	
	private ArticleDto article;

	public static LigneVenteDto fromEntity(LigneVente ligneVente) {
		if(ligneVente==null) {
			return null;
		}
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.quantite(ligneVente.getQuantite())
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.build();
	}
	
	public static LigneVente toEntity(LigneVenteDto dto) {
		if(dto==null) {
			return null;
		}
		LigneVente ligneVente = new LigneVente();
		ligneVente.setId(dto.getId());
		ligneVente.setQuantite(dto.getQuantite());
		ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
		
		return ligneVente;
				
	}
	
}
