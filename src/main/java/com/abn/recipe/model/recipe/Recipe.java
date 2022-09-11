package com.abn.recipe.model.recipe;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "recipe")
@Data
public class Recipe {
	@Id
	@Column(name = "code")
	private String id;
	private String name;
	private String category;
	private int servefor;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ingredient> ingredients;
	private String instructions;
	

}
