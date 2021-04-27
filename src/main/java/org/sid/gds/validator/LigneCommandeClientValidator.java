package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.LigneCommandeClientDto;


public class LigneCommandeClientValidator {

	public List<String> validate(LigneCommandeClientDto dto) {
		List<String> errors = new ArrayList<>();
		if(dto==null) {
			errors.add("Veuillez renseigenr l'article");
			errors.add("Veuillez Renseigner lacommande client");
			errors.add("Veuillez renseigner le prix ");	
			errors.add("Veuillez renseigner la quantite");
			return errors;
		}
		
		if(dto.getArticle()==null){
			errors.add("Veuillez renseigenr l'article");
		}
		if(dto.getCommandeClient()==null) {
			errors.add("Veuillez Renseigner lacommande client");
		}
		if(dto.getPrixUnitaire()==null) {
			errors.add("Veuillez renseigner le prix ");	
		}
		if(dto.getQuantite()==null) {
			errors.add("Veuillez renseigner la quantite");
		}
		return errors;
	}
}
