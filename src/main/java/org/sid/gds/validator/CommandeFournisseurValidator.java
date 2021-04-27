package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

public class CommandeFournisseurValidator {

	public static List<String> validate(CommandeFournisseurDto dto){
		List<String> errors = new ArrayList<>();
		
		if(dto==null) {
			errors.add("Veullez renseigner le code");
			errors.add("Veullez renseigner la date");
			errors.add("Veullez renseigner la ligne fournisseur");
			errors.add("Veuillez renseigner le fournisseur");
			return errors;
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veullez renseigner le code");
		}
		if(dto.getDateCommande()==null) {
			errors.add("Veullez renseigner la date");
		}
		if(dto.getLigneCommandeFournisseurs()==null) {
			errors.add("Veullez renseigner la ligne fournisseur");
		}
		if(dto.getFournisseur()==null) {
			errors.add("Veuillez renseigner le fournisseur");
		}
		return errors;
	}
}
