package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

public class EntrepriseValidator {

	public static List<String> validate(EntrepriseDto dto) {
		List<String> errors = new ArrayList<>();
		
		if(dto==null) {
			errors.add("Veuillez renseigner le nom ");
			errors.add("Veuillez renseigner l'email ");
			errors.add("Veuillez renseigner le num de tel ");
			errors.add("Veuillez renseigner le code fisacl ");
			errors.add("Veuillez renseigner le description");
			errors.add("Veuillez renseigner le site web ");
		}
		
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Veuillez renseigner le nom ");
		}
		if(!StringUtils.hasLength(dto.getEmail())) {
			errors.add("Veuillez renseigner l'email ");
		}
		if(!StringUtils.hasLength(dto.getNumTel())) {
			errors.add("Veuillez renseigner le num de tel ");
		}
		if(!StringUtils.hasLength(dto.getCodeFiscal())) {
			errors.add("Veuillez renseigner le code fisacl ");
		}
		if(!StringUtils.hasLength(dto.getDescription())) {
			errors.add("Veuillez renseigner le description");
		}
		if(!StringUtils.hasLength(dto.getSiteWeb())) {
			errors.add("Veuillez renseigner le site web ");
		}
		
		return errors;
	}
}
