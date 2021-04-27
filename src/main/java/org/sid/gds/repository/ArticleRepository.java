package org.sid.gds.repository;

import java.util.Optional;

import org.sid.gds.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository <Article, Integer>{
	

	
	Optional<Article> findByCodeArticle(String  codeArticle);
}
