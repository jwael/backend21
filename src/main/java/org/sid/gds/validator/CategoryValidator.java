package org.sid.gds.validator;

import java.util.ArrayList;
import java.util.List;

import org.sid.gds.dto.CategoryDto;
import org.springframework.util.StringUtils;

public class CategoryValidator {
	
	
	public static List<String> validate(CategoryDto categoryDto){
		List<String> errors = new ArrayList<>();
		if(categoryDto==null ||!StringUtils.hasLength(categoryDto.getCode())) {
			errors.add("Veuillez renseigner le code de renseignement");
		}
		return errors;
	}

}
