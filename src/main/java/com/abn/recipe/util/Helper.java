package com.abn.recipe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abn.recipe.model.recipe.Ingredient;
import com.abn.recipe.model.recipe.Recipe;

public class Helper {
	private static Logger LOGGER = LoggerFactory.getLogger(Helper.class.getName());

	public List<Recipe> recpsByIngredients(String includedIngs, String excludedIngs,List<Recipe> recps) {
		
		if ( includedIngs == null || excludedIngs == null)
			LOGGER.warn("Filter criteria is received empty");
		
		List<Recipe> recpsFinal = new ArrayList<>();
		//included search
		if (!StringUtils.isEmpty(includedIngs)) {
			for (Recipe r : recps) {
				List<String> inDbIngStr =  new ArrayList<>();
				if ( r.getIngredients() != null && r.getIngredients().size() > 0) {
					for ( Ingredient i:  r.getIngredients()) {
						inDbIngStr.add(i.getName());
					}
				}
				boolean included = true;
				if (!StringUtils.isEmpty(includedIngs)) {
					List<String> includedIngrs = Arrays.asList(includedIngs.split(","));
					for (String s : includedIngrs) {
						if (  ! inDbIngStr.contains(s) ) included = false;
							
					}
					if (included) {
						recpsFinal.add(r);
					}
				}
			}
		}
		//excluded search
		if (!StringUtils.isEmpty(excludedIngs)) {
			for (Recipe r : recps) {
				List<String> inDbIngStr =  new ArrayList<>();
				if ( r.getIngredients() != null && r.getIngredients().size() > 0) {
					for ( Ingredient i:  r.getIngredients()) {
						inDbIngStr.add(i.getName());
					}
				}
				boolean excluded = false;
				if (!StringUtils.isEmpty(excludedIngs)) {
					List<String> exIngs = Arrays.asList(excludedIngs.split(","));
					for (String s : exIngs) {
						if (!inDbIngStr.contains(s))
							excluded = true;
						else
							excluded = false;
					}
					if (excluded) {
						recpsFinal.add(r);
					}
				}
			}
		}
		
		if (StringUtils.isEmpty(includedIngs) && StringUtils.isEmpty(excludedIngs))
			return recps;
		
		return recpsFinal;
	}

}
