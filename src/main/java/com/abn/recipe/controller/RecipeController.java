package com.abn.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abn.recipe.model.recipe.Recipe;
import com.abn.recipe.model.request.RecipeRequest;
import com.abn.recipe.service.RecipeService;
import com.abn.recipe.service.excep.RecipeException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "recipe")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	

	@GetMapping("/recipes")
	@ApiOperation(value = "Fetch all Recipes",tags = "recipe")
	public List<Recipe> getAll() throws RecipeException{
		return recipeService.getAll();
	}
	
	
	@DeleteMapping("/recipes")
	@ApiOperation(value = "Delete all Recipes",tags = "recipe")
	public String deleteAll() throws RecipeException{
		return recipeService.deleteAll();
	}
	

	@GetMapping("/recipes/{code}")
	@ApiOperation(value = "Fetch Recipe of given id.",tags = "recipe")
	public Recipe getRecipe(@PathVariable("code") String code) throws RecipeException{
		return recipeService.getRecipe(code);
	}
	
	@DeleteMapping("/recipes/{code}")
	@ApiOperation(value = "Delete Recipe",tags = "recipe")
	public String deleteRecipe(@PathVariable("code") String code) throws RecipeException{
		return recipeService.deleteRecipe(code);
	}
	
	
	
	@PostMapping("/recipe")
	@ApiOperation(value = "Create/Add new Recipe accoring to the inputs", notes="If Recipe exist, it lets you know already exist.",tags = "recipe")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully added."),
	        @ApiResponse(code = 500, message = "Internal server error during addition.")
	})
	public String addRecipe(@RequestBody RecipeRequest req) throws RecipeException{
		return recipeService.addRecipe(req);
	}
	
	
	@PutMapping("/recipe")
	@ApiOperation(value = "Updates Recipe accoring to the inputs",tags = "recipe")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Successfully updated."),
	        @ApiResponse(code = 500, message = "Internal server error during updation.")
	})
	public String updateRecipe(@RequestBody RecipeRequest req) throws RecipeException{
		return recipeService.updateRecipe(req);
	}
	
	


}
