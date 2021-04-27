package org.sid.gds.services;

import java.util.List;

import org.sid.gds.dto.CategoryDto;

public interface CategoryService {

	CategoryDto save(CategoryDto dto);
	
	CategoryDto findById(Integer id);
	
	CategoryDto findByCode(String code);
	
	List<CategoryDto> findall();
	
	void delete(Integer id);
	
	
}
