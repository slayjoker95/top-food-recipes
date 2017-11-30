package com.topfood.recipes.recipe.service;

import com.topfood.recipes.common.enums.ErrorCodes;
import com.topfood.recipes.cuisine.repository.CuisineRepository;
import com.topfood.recipes.recipe.model.Recipe;

import com.topfood.recipes.recipe.repository.RecipeRepository;
import com.topfood.recipes.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.topfood.recipes.common.enums.ErrorCodes.OK;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe getByID(String recipe_id)
    {
        return recipeRepository.findOne(Long.valueOf(recipe_id));
    }

    public ErrorCodes add(Recipe recipe){
        recipeRepository.save(recipe);
        return (OK);
    }
    public void delete(String recipe_id){
        recipeRepository.delete(Long.valueOf(recipe_id));
    }

    public void update(Recipe newRecipe)
    {
        Recipe recipe = recipeRepository.findOne(newRecipe.getRecipe_id());
        recipe.setCuisine(newRecipe.getCuisine());
        recipe.setRecipe(newRecipe.getRecipe());
        recipe.setUser(newRecipe.getUser());
        recipeRepository.flush();
    }

}
