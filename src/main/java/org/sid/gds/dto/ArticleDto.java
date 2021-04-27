package org.sid.gds.dto;

import java.math.BigDecimal;

import org.sid.gds.model.Article;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {

	private Integer id;
	
	private String codeArticle;
	
	
	private String designiation;
	

	private BigDecimal prixUnitaireHT;
	
	
	private BigDecimal tauxTva;
	

	private BigDecimal prixUnitaireTtc;
	
	
	private String photo;
	
	private CategoryDto category;
	
	public static ArticleDto fromEntity(Article article) {
		if (article==null) {
			return null;
		}
		return ArticleDto.builder()
				.id(article.getId())
				.codeArticle(article.getCodeArticle())
				.designiation(article.getDesigniation())
				.photo(article.getPhoto())
				.prixUnitaireHT(article.getPrixUnitaireHT())
				.prixUnitaireTtc(article.getPrixUnitaireTtc())
				.build();			
	}
	public static Article toEntity(ArticleDto articleDto) {
		if(articleDto==null) {
			return null;
		}
		Article article = new Article();
		article.setId(articleDto.getId());
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesigniation(articleDto.getDesigniation());
		article.setPhoto(articleDto.getPhoto());
		article.setPrixUnitaireHT(articleDto.getPrixUnitaireHT());
		article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
		
		return article;
		
	}

}
