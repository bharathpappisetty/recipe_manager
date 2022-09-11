package com.abn.recipe.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipeControllerIntegrationTests {
	
	   
	   
	   TestRestTemplate restTemplate = new TestRestTemplate();
	   HttpHeaders headers = new HttpHeaders();
	   
	   @Test
	    public void testGetRecipeWithCode() throws Exception {
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	        createURLWithPort("/api/v1/recipes/VEG_MARG2"), HttpMethod.GET, entity, String.class);

	        System.out.println(response.getBody());
	        
	        
	        String expected = "{\r\n" + 
	        		"  \"id\": \"VEG_MARG2\",\r\n" + 
	        		"  \"name\": \"Margareta\",\r\n" + 
	        		"  \"category\": \"veg\",\r\n" + 
	        		"  \"servefor\": 2,\r\n" + 
	        		"  \"ingredients\": [\r\n" + 
	        		"{\r\n" + 
	        		"      \"name\": \"tomato\",\r\n" + 
	        		"      \"recipe\": null\r\n" + 
	        		"},\r\n" + 
	        		"    {\r\n" + 
	        		"      \"name\": \"corn\",\r\n" + 
	        		"      \"recipe\": null\r\n" + 
	        		"}\r\n" + 
	        		"  ],\r\n" + 
	        		"  \"instructions\": \"prepare in oven\"\r\n" + 
	        		"}\r\n" + 
	        		"";

	        JSONAssert.assertEquals(expected, response.getBody(), false);
	    }

	    private String createURLWithPort(String uri) {
	        return "http://localhost:8080" + uri;
	    }

}
