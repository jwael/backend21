package org.sid.gds.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.gds.dto.CategoryDto;
import org.sid.gds.exception.EntityNotFoundException;
import org.sid.gds.exception.ErrorCodes;
import org.sid.gds.exception.InvalidEntityException;
import org.sid.gds.repository.CategoryRepository;
import org.sid.gds.services.CategoryService;
import org.sid.gds.validator.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}

	@Override
	public CategoryDto save(CategoryDto dto) {
		List<String> errors = CategoryValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("article is not valid{}"+dto);
			throw new InvalidEntityException("la category n est pas valide",ErrorCodes.CATEGORY_NOT_VALID,errors);
		}
		return CategoryDto.fromEntity(
			categoryRepository.save(CategoryDto.toEntity(dto)));
	}

	@Override
	public CategoryDto findById(Integer id) {
		if(id==null) {
			log.error("category id is null");
			return null;
		}
		return categoryRepository.findById(id)
				.map(CategoryDto :: fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"aucune category avec id " + id + "n a ete trouve",ErrorCodes.CATEGORY_NOT_FOUND)
						);
				
	}

	@Override
	public CategoryDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("Category  code is null");
			return null;
		}
		return categoryRepository.findCategoryByCode(code)
			.map(CategoryDto::fromEntity)
			.orElseThrow(() -> new EntityNotFoundException(
					"aucune category avec le code" +code+ "n a pas ete trouve",ErrorCodes.CATEGORY_NOT_FOUND)
					);
	}

	@Override
	public List<CategoryDto> findall() {
		
		return categoryRepository.findAll().stream()
				.map(CategoryDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("Category id is null");
			return;
		}
		
		categoryRepository.deleteById(id);
	}

}
