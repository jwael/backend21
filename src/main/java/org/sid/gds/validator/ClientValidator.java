package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.ClientDto;
import org.springframework.util.StringUtils;

public class ClientValidator {

	public static List<String> validate (ClientDto dto){
		List<String> errors = new ArrayList<>();
		
		if(dto==null) {
			errors.add("Veullez renseigner le nom");
			errors.add("Veuillez renseigner le prenom");
			errors.add("Veuillez renseigner l'email");
			errors.add("Veuillez renseigner le num de tel");
			return errors;
		}
		
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Veullez renseigner le nom");
		}
		if(!StringUtils.hasLength(dto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom");
		}
		if(!StringUtils.hasLength(dto.getEmail())) {
			errors.add("Veuillez renseigner l'email");
		}
		if(!StringUtils.hasLength(dto.getNumTel())) {
			errors.add("Veuillez renseigner le num de tel");
		}
		
		return errors;
	}
}
