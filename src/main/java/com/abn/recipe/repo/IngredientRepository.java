package com.abn.recipe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abn.recipe.model.recipe.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
	
}
