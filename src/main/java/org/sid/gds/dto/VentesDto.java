package org.sid.gds.dto;

import java.time.Instant;
import java.util.List;

import org.sid.gds.model.Ventes;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class VentesDto {
	
	private Integer id;


	private String code;
	
	
	private Instant dateVente;
	
	
	private String commentaire;
	
	
	private List<LigneVenteDto> ligneVentes; 	
	
	public static VentesDto fromEntity(Ventes ventes) {
		if(ventes==null) {
			return null;
		}
		return VentesDto.builder()
				.id(ventes.getId())
				.code(ventes.getCode())
				.commentaire(ventes.getCommentaire())
				.build();
	}
	
	public static Ventes toEntity(VentesDto dto) {
		if(dto==null) {
			return null;
		}
		Ventes ventes = new Ventes();
		ventes.setId(dto.getId());
		ventes.setCode(dto.getCode());
		ventes.setCommentaire(dto.getCommentaire());


		return ventes;
	}
}
