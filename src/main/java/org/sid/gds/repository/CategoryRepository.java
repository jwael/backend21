package org.sid.gds.repository;

import java.util.Optional;


import org.sid.gds.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Integer> {

	Optional<Category> findCategoryByCode(String code);
  
}
