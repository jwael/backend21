package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.ArticleDto;
import org.springframework.util.StringUtils;

public class ArticleValidator {

	public static  List<String> validate (ArticleDto dto) {
		List<String> errors = new ArrayList<>();
		
		if(dto==null) {
			errors.add("Veuillez Renseigner le code article");
			errors.add("Veuillez renseigner la designiation");
			errors.add("Veuillez renseigner le code");
			errors.add("Veuillez renseigner le prix Ht");
			errors.add("Veuillez renseigner le taux tva");
			errors.add("Veuillez renseigner le taux tva");
			return errors;
		}
		
		
		if(!StringUtils.hasLength(dto.getCodeArticle())) {
			errors.add("Veuillez Renseigner le code article");
		}
		if(StringUtils.hasLength(dto.getDesigniation())) {
			errors.add("Veuillez renseigner la designiation");
		}
		if(dto.getCategory()==null) {
			errors.add("Veuillez renseigner le code");
		}
		if(dto.getPrixUnitaireHT()==null) {
			errors.add("Veuillez renseigner le prix Ht");
		if(dto.getPrixUnitaireTtc()==null) {
			errors.add("Veuillez renseigner le prix ttc");
		}
		if(dto.getTauxTva()==null) {
			errors.add("Veuillez renseigner le taux tva");
		}
		}
		return errors;
	}
}
