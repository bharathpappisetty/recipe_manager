package com.abn.recipe.model.request;

import lombok.Data;

@Data
public class RecipeRequest {

	private String code;
	private String name;
	private String category;
	private int serveFor;
	private String ingredients;
	private String instructions;

}
