package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.LigneCommandeFournisseurDto;


public class LigneCommandeFournnisseurValidator {

	public static List<String> validate(LigneCommandeFournisseurDto dto){
		List<String> errors = new ArrayList<>();
		
		if(dto==null) {
			errors.add("Veuillez renseigner l article");
			errors.add("Veuillez renseigner la commande fournisseur");
			errors.add("Veuillez renseigner le prix");
			errors.add("Veuillez renseigner la quantite");
		}
		
		if(dto.getArticle()==null) {
			errors.add("Veuillez renseigner l article");
		}
		if(dto.getCommandeFournisseur()==null) {
			errors.add("Veuillez renseigner la commande fournisseur");
		}
		if(dto.getPrixUnitaire()==null) {
			errors.add("Veuillez renseigner le prix");
		}
		if(dto.getQuantite()==null) {
			errors.add("Veuillez renseigner la quantite");
		}
		return errors;
	}
}
