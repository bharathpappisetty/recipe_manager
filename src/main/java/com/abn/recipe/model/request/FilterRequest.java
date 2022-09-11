package com.abn.recipe.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Model that holds filter values during search.")
public class FilterRequest {
	
	@ApiModelProperty(example ="veg/non-veg")
	private String category;
	
	@ApiModelProperty(example ="1/2/4")
	private int serveFor = 0;
	
	@ApiModelProperty(example ="pan/oven/no-pan")
	private String instructions;
	
	
	@ApiModelProperty(example ="tomato/tomato,potato")
	private String includeIngredient;
	
	
	@ApiModelProperty(example ="tomato/tomato,potato")
	private String excludeIngredient;
	
	

}
