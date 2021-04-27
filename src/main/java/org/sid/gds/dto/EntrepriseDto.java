package org.sid.gds.dto;

import java.util.List;

import javax.persistence.Embedded;

import org.sid.gds.model.Adresse;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EntrepriseDto {
	
	
	private Integer id;

	private String nom;
	
	private String description;
	
	
	private AdresseDto adresse;
	

	private String photo;
	

	private String codeFiscal;
	

	private String numTel;
	
	
	private String email;
	
	
	private String siteWeb;
	
	
	private List<UtilisateurDto> utilisateurs;
	

}
