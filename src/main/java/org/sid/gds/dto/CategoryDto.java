package org.sid.gds.dto;

import java.util.List;

import org.sid.gds.model.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDto {
	
	private Integer id;
	
	
	private String code;
	

	private String designiation;
	
	@JsonIgnore
	private List<ArticleDto> articles;
	
	
	public static CategoryDto fromEntity(Category category) {
		if(category == null) {
			return null;
		}
		
		return CategoryDto.builder()
				.id(category.getId())
				.code(category.getCode())
				.designiation(category.getDesigniation())
				.build();
				
	}
	
	public static Category toEntity(CategoryDto categoryDto) {
		if(categoryDto==null) {
			return null;
		}
			
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCode(categoryDto.getCode());
		category.setDesigniation(categoryDto.getDesigniation());
		return category;
	
}

	
}

