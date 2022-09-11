package com.abn.recipe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abn.recipe.model.recipe.Ingredient;
import com.abn.recipe.model.recipe.Recipe;
import com.abn.recipe.model.request.RecipeRequest;
import com.abn.recipe.repo.RecipeRepository;
import com.abn.recipe.service.RecipeService;
import com.abn.recipe.service.excep.RecipeException;
@Service
public class RecipeServiceImpl implements RecipeService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(RecipeServiceImpl.class.getName());
	
	@Autowired
	RecipeRepository repo;
	

	@Override
	public String addRecipe(RecipeRequest req) throws RecipeException {
		String ingredients = req.getIngredients();
		
		//Check if Recipe already added
		
		if (repo.existsById(req.getCode()))
			throw new RecipeException("Recipe "+req.getName()+" is already added.");
		
		// Add if not exist		
		List<String> ingStrings = Stream.of(ingredients.split(",", -1))
				  .collect(Collectors.toList());
		List<Ingredient> ings = new ArrayList<Ingredient>();
		for ( String ingStr: ingStrings) {
			Ingredient ing = new Ingredient();
			ing.setName(ingStr);
			ings.add(ing);
		}
		
		Recipe recipe = new Recipe();
		recipe.setId(req.getCode());
		recipe.setName(req.getName());
		recipe.setCategory(req.getCategory());
		recipe.setServefor(req.getServeFor());
		recipe.setIngredients(ings);
		recipe.setInstructions(req.getInstructions());
		
		repo.save(recipe);
		
		LOGGER.info("Recipe {} for {} people is added !", req.getName(),req.getServeFor());
		return "Recipe "+req.getName()+" for "+req.getServeFor()+" people is added !";
		
		
	}
	

	@Override
	public String updateRecipe(RecipeRequest req) throws RecipeException {
		String ingredients = req.getIngredients();
		
		//Check if Recipe already added
		if (! repo.existsById(req.getCode())) {
			throw new RecipeException("Recipe "+req.getName()+" is not exist, please add it.");
		}else{
			//delete if exist
			repo.deleteById(req.getCode());
		}
		
		List<String> ingStrings = Stream.of(ingredients.split(",", -1))
				  .collect(Collectors.toList());
		List<Ingredient> ings = new ArrayList<Ingredient>();
		for ( String ingStr: ingStrings) {
			Ingredient ing = new Ingredient();
			ing.setName(ingStr);
			ings.add(ing);
		}
		
		Recipe recipe = new Recipe();
		recipe.setId(req.getCode());
		recipe.setName(req.getName());
		recipe.setCategory(req.getCategory());
		recipe.setServefor(req.getServeFor());
		recipe.setIngredients(ings);
		recipe.setInstructions(req.getInstructions());
		
		repo.save(recipe);
		
		LOGGER.info("Recipe {} for {} people is updated !", req.getName(),req.getServeFor());
		return "Recipe "+req.getName()+" for "+req.getServeFor()+" people is updated !";
		
	}
	
	
	@Override
	public List<Recipe> getAll() throws RecipeException {
		return repo.findAll();
	}
	
	
	@Override
	public Recipe getRecipe(String code) throws RecipeException {
		return repo.findById(code).get();
	}
	
	@Override
	public String deleteRecipe(String code) throws RecipeException {
		 repo.deleteById(code);
		 return "Recipe "+code+" deleted !";
	}
	
	@Override
	public String deleteAll() throws RecipeException {
		 repo.deleteAll();
		 return "All recipies deleted !";
	}
	
	


}
