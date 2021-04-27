package org.sid.gds.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.sid.gds.model.Entreprise;
import org.sid.gds.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDto {
	
	
	private Integer id;
	
	private String nom;
	
	
	private String prenom;
	
	
	private AdresseDto adresse;
	
	
	private String photo;
	
	
	private String email;
	
	
	private String motDePasse;
	
	
	private Instant dateDeNaissance;
	
	
	private Entreprise entreprise;
	
	
	private List<RolesDto> roles;
	
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
		if(utilisateur ==null) {
			return null;
		}
		return UtilisateurDto.builder()
				.id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.email(utilisateur.getEmail())
				.motDePasse(utilisateur.getMotDePasse())
				.dateDeNaissance(utilisateur.getDateDeNaissance())
				.adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
				.photo(utilisateur.getPhoto())
				.entreprise(utilisateur.getEntreprise())
				.roles(
						utilisateur.getRoles() !=null ?
								utilisateur.getRoles().stream()
								.map(RolesDto::fromEntity)
								.collect(Collectors.toList()):null
				)
												
						.build();
	}

}
