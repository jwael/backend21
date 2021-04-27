package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

public class CommandeClientValidator {

	public static List<String> validate(CommandeClientDto dto) {
		List<String> errors = new ArrayList<>();
		if(dto==null) {
			errors.add("Veuillez renseigner le code");
			errors.add("Veullez renseigner le client");
			errors.add("Veullez renseigner la date de commande");
			errors.add("Veullez renseigner la ligne commande client");
			return errors;
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veuillez renseigner le code");
		}
		if(dto.getClient()==null) {
			errors.add("Veullez renseigner le client");
		}
		if(dto.getDateCommande()==null) {
			errors.add("Veullez renseigner la date de commande");
		}
		if(dto.getLigneCommandeClients()==null) {
			errors.add("Veullez renseigner la ligne commande client");
		}
		return errors;
	}
}
