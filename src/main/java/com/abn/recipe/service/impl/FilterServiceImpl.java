package com.abn.recipe.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.abn.recipe.model.recipe.Recipe;
import com.abn.recipe.model.request.FilterRequest;
import com.abn.recipe.repo.RecipeRepository;
import com.abn.recipe.service.FilterService;
import com.abn.recipe.service.excep.FilterException;
import com.abn.recipe.util.Helper;

@Service
public class FilterServiceImpl implements FilterService {

	private static Logger LOGGER = LoggerFactory.getLogger(FilterServiceImpl.class.getName());

	@Autowired
	RecipeRepository repo;

	@Override
	public List<Recipe> getByFilter(FilterRequest fReq) throws FilterException {

		List<Recipe> recps = null;
		try {
			recps = repo.findAll(getSpec(fReq));

			// fliterByIngredients
			recps = new Helper().recpsByIngredients(fReq.getIncludeIngredient(),fReq.getExcludeIngredient(), recps);

			return recps;
			
		} catch (Exception e) {
			LOGGER.error("Error in searching with filters \n" + e.getMessage());
			throw new FilterException("Error in searching with filters" + e.getMessage());
		}

	}


	private Specification<Recipe> getSpec(FilterRequest fReq) {
		List<Predicate> predicates = new ArrayList<>();

		return (root, cq, cb) -> {

			// byCategory
			if (!StringUtils.isEmpty(fReq.getCategory())) {
				predicates.add(cb.equal(root.get("category"), fReq.getCategory()));
			}

			// bySize
			if (fReq.getServeFor() > 0) {
				predicates.add(cb.equal(root.get("servefor"), fReq.getServeFor()));
			}

			// byInstructions
			if (!StringUtils.isEmpty(fReq.getInstructions())) {
				predicates.add(cb.like(root.get("instructions"), "%" + fReq.getInstructions() + "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

}
