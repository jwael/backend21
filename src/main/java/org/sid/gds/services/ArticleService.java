package org.sid.gds.services;

import java.util.List;

import org.sid.gds.dto.ArticleDto;

public interface ArticleService {

	ArticleDto save(ArticleDto dto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	void delete(Integer id);
}
