package com.abn.recipe.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.abn.recipe.model.recipe.Recipe;
import com.abn.recipe.model.request.RecipeRequest;
import com.abn.recipe.service.RecipeService;
import com.abn.recipe.service.excep.RecipeException;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RecipeControllerTests {

	
	  @InjectMocks
	  RecipeController recipeController;
	 
	  @Mock
	  RecipeService service;

	
	  @Test
	    public void testGetAllRecipes() throws Exception 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        when(service.getAll()).thenReturn(getRecps());
	         
	        // when
	        List<Recipe> result = recipeController.getAll();
	         
	        // then
	        assertThat(result.size()).isEqualTo(1);
	    }
	  
	  
	  @Test
	    public void testAddRecipe() throws RecipeException
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	         
	        when(service.addRecipe(any(RecipeRequest.class))).thenReturn("Recipe Added");
	         
	       String res = recipeController.addRecipe(getReq());
	         
	        assertThat(res).isEqualTo("Recipe Added");
	    }

	
	private List<Recipe> getRecps(){
		List<Recipe> list  = new ArrayList<Recipe>();
		Recipe r = new Recipe();
		r.setId("VEG_MARG3");
		r.setName("Margareta");
		list.add(r);
		return list;
	}
	
	private RecipeRequest getReq(){
		RecipeRequest r = new RecipeRequest();
		r.setCode("VEG_MARG2");
		r.setName("Margareta");
		return r;
	}
	
}
