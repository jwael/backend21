package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

public class UtilisateurValidator {

	
	public static List<String> validate(UtilisateurDto utilisateurDto){
		
		List<String> errors = new ArrayList<>();
		
		if(utilisateurDto==null) {
			errors.add("Veuiilez Renseigner le Nom d'utilisateur");
			errors.add("Veuiilez Renseigner le Prenom d'utilisateur");
			errors.add("Veuiilez Renseigner l'email d'utilisateur");
			errors.add("Veuiilez Renseigner le mdp d'utilisateur");
			errors.add("Veuiilez Renseigner l'adresse d'utilisateur");
			errors.add("Veuiilez Renseigner l'adresse d'utilisateur");
			return errors;
		}
		
		if(!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuiilez Renseigner le Nom d'utilisateur");
		}
		if(!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veuiilez Renseigner le Prenom d'utilisateur");
		}
		if(!StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("Veuiilez Renseigner l'email d'utilisateur");
		}	
		if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("Veuiilez Renseigner le mdp d'utilisateur");
		}
		if(utilisateurDto.getAdresse()==null) {
			errors.add("Veuiilez Renseigner l'adresse d'utilisateur");
		 } else {
		if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
			errors.add("le champs adress 1 est obligatoire");
		}
		if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
			errors.add("le champs code postale est obligatoire");
		}
		if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
			errors.add("le champs pays est obligatoire");
		}
			
		}
		
		return errors;
		
	}
}
