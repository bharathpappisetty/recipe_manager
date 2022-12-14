package com.abn.recipe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.abn.recipe.model.recipe.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, String>, JpaSpecificationExecutor<Recipe>{
	
}
