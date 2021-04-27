package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.VentesDto;
import org.springframework.util.StringUtils;

public class VentesValidator {

	public static List <String> validate(VentesDto dto){
		List<String> errors= new ArrayList<>();
		
		if(dto==null) {
			errors.add("Veuillez renseigner le code");
			errors.add("Veuillez laisser un commentaire");
			errors.add("Veuillez ajouter date de commande");
			return errors;
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veuillez renseigner le code");
		}
		if(!StringUtils.hasLength(dto.getCommentaire())) {
			errors.add("Veuillez laisser un commentaire");
		}
		if(dto.getDateVente()==null){
			errors.add("Veuillez ajouter date de commande");
		}
		
		return errors;
	}
}
