package org.sid.gds.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.gds.dto.ArticleDto;
import org.sid.gds.exception.EntityNotFoundException;
import org.sid.gds.exception.ErrorCodes;
import org.sid.gds.exception.InvalidEntityException;
import org.sid.gds.model.Article;
import org.sid.gds.repository.ArticleRepository;
import org.sid.gds.services.ArticleService;
import org.sid.gds.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository= articleRepository;
	}
	
	
	
	@Override
	public ArticleDto save(ArticleDto dto) {
		List<String> errors = ArticleValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Articlee n est pass valide {}", dto);
			throw new InvalidEntityException("l article nest pas valide",ErrorCodes.ARTICLE_NOT_VALID,errors);
		}
		return ArticleDto.fromEntity(articleRepository.save(
				ArticleDto.toEntity(dto)
				));
	}

	@Override
	public ArticleDto findById(Integer id) {
		if(id==null) {
			log.error("Article id is null");
			return null;
		}
	Optional <Article> article = articleRepository.findById(id);
	
	
	return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
		new EntityNotFoundException(
				"aucun article avec id="+ id + "n ete trouve dans la bdd",
				ErrorCodes.ARTICLE_NOT_FOUND)
				);
		
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if(!StringUtils.hasLength(codeArticle)) {
			log.error("codeArticle is null");
			return null;
		}
		Optional<Article> article= articleRepository.findByCodeArticle(codeArticle);
		
		return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
			new EntityNotFoundException(
					"aucun article avec id="+ codeArticle + "n ete trouve dans la bdd",
					ErrorCodes.ARTICLE_NOT_VALID)
	);
}
	@Override
	public List<ArticleDto> findAll() {
		return articleRepository.findAll().stream()
				.map(ArticleDto ::fromEntity)
				.collect(Collectors.toList());

	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("article id is null");
		return ;	
		}
	 articleRepository.deleteById(id);
	 
		
	}

}
