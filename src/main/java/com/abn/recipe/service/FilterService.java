package com.abn.recipe.service;

import java.util.List;

import com.abn.recipe.model.recipe.Recipe;
import com.abn.recipe.model.request.FilterRequest;
import com.abn.recipe.service.excep.FilterException;

public interface FilterService {

	 List<Recipe> getByFilter(FilterRequest req) throws FilterException;
}
