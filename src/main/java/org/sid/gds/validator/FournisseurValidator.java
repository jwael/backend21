package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.FournisseurDto;
import org.springframework.util.StringUtils;

public class FournisseurValidator {

	public static List<String> validate(FournisseurDto dto){
		List<String> errors = new ArrayList<>();
		if(dto==null) {
			errors.add("Veuilelz renseigner le nom de fournisseur");
			errors.add("Veuillez renseigner  le prenom de fournisseur");
			errors.add("Veuillez renseigner l'email de fournisseur");
			errors.add("Veuillez renseigner le num de tel de fournisseur");
		}
		
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Veuilelz renseigner le nom de fournisseur");
		}
		if(!StringUtils.hasLength(dto.getPrenom())) {
			errors.add("Veuillez renseigner  le prenom de fournisseur");
		}
		if(!StringUtils.hasLength(dto.getEmail())) {
			errors.add("Veuillez renseigner l'email de fournisseur");	
		}
		if(!StringUtils.hasLength(dto.getNumTel())) {
			errors.add("Veuillez renseigner le num de tel de fournisseur");
		}
		return errors;
	}
}
