package com.abn.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abn.recipe.model.recipe.Recipe;
import com.abn.recipe.model.request.FilterRequest;
import com.abn.recipe.service.FilterService;
import com.abn.recipe.service.excep.FilterException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "filter")
@RequestMapping("/api/v1/recipes")
public class FilterController {
	
	@Autowired
	FilterService filterService;
	
	
	@PostMapping("/search")
	@ApiOperation(value = "Fetch Recipes by filter(s)",tags = "filter")
	public List<Recipe> getByFilter(
			@ApiParam("filter##") @RequestBody FilterRequest req) throws FilterException{
		
		return filterService.getByFilter(req);
		
	}
	
	


}
