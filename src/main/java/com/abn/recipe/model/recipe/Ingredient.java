package com.abn.recipe.model.recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ingredient")
@Data
public class Ingredient {
	@Id
	private String name;
	@ManyToOne
	@JoinColumn(name = "recipe_code")
	private Recipe recipe;

}
