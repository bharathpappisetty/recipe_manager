package com.abn.recipe.service;

import java.util.List;

import com.abn.recipe.model.recipe.Recipe;
import com.abn.recipe.model.request.RecipeRequest;
import com.abn.recipe.service.excep.RecipeException;

public interface RecipeService {
	
	String addRecipe(RecipeRequest req) throws RecipeException;
	
	String updateRecipe(RecipeRequest req) throws RecipeException;
	
	List<Recipe> getAll() throws RecipeException;
	
	Recipe getRecipe(String code) throws RecipeException;
	
	String deleteRecipe(String code) throws RecipeException;
	
	String deleteAll() throws RecipeException;
	
	
}
