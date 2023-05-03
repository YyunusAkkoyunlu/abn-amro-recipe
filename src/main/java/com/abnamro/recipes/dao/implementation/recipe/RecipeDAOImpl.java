package com.abnamro.recipes.dao.implementation.recipe;

import com.abnamro.recipes.dao.definition.recipe.IRecipeDAO;
import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import com.abnamro.recipes.dao.entity.recipe.RecipeEntity;
import com.abnamro.recipes.dao.repository.ingredient.IngredientRepository;
import com.abnamro.recipes.dao.repository.recipe.RecipeRepository;
import com.abnamro.recipes.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RecipeDAOImpl implements IRecipeDAO {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public RecipeEntity createOrUpdate(RecipeEntity recipeEntity) {
        Set<IngredientEntity> listIngredient = new HashSet<>();
        if (recipeEntity.getIngredients().size() > 0) {
            for (IngredientEntity ingredientEntity : recipeEntity.getIngredients()) {
                Optional ingredient = ingredientRepository.findById(ingredientEntity.getId());
                if (ingredient.isEmpty()) {
                    throw new ApiRequestException("Ingredient is not available");
                }

                listIngredient.add((IngredientEntity) ingredient.get());
            }
        }
        recipeEntity.setIngredients(listIngredient);

        return recipeRepository.save(recipeEntity);
    }

    @Override
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void deleteRecipe(Long id) {
        RecipeEntity recipeEntity = findById(id);
        recipeRepository.delete(recipeEntity);

    }

    @Override
    public RecipeEntity findById(Long id) {
        Optional entity = recipeRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ApiRequestException("Recipe not found..!");
        }
        return (RecipeEntity) entity.get();
    }

    @Override
    public List<RecipeEntity> getAllVegetarianRecipes() {
        return recipeRepository.findAllByVegetarianTrue();
    }

    @Override
    public List<RecipeEntity> getAllNonVegetarianRecipes() {
        return recipeRepository.findAllByVegetarianFalse();
    }

    @Override
    public List<RecipeEntity> instructionsSearch(String search) {
        return recipeRepository.findAllByInstructionsContaining(search);
    }

    @Override
    public List<RecipeEntity> getAllByCustomCriteria(String keyword) {
//        return recipeRepository.findAllByCustomParam(keyword);
        return null;
    }

    @Override
    public List<RecipeEntity> getAllByWithoutIngredientsContainsInstructions(String ingredient, String instruction) {
        return recipeRepository.findAllByIngredientsNotContainingAndInstructionsLike(ingredient, instruction);
    }

    @Override
    public List<RecipeEntity> numberOfPerson(int numberOfPerson) {
        return recipeRepository.findAllByNumberOfPerson(numberOfPerson);
    }

    @Override
    public List<RecipeEntity> findRecipesByNumberOfPersonAndIngredients(Integer numberOfPerson, List<String> ingredients) {
        return recipeRepository.findDistinctByNumberOfPersonAndIngredientsNameIn(numberOfPerson, ingredients);
    }

    @Override
    public List<RecipeEntity> findRecipesIngredients(List<String> ingredients) {
        return recipeRepository.findRecipeEntitiesByIngredientsNameIn(ingredients);
    }

    @Override
    public List<RecipeEntity> findRecipesNotIngredients(List<String> ingredients) {
        return recipeRepository.findRecipeEntitiesByIngredientsNameNotIn(ingredients);
    }

    @Override
    public List<RecipeEntity> findRecipesNotIngredientWithInstructions(String instructions, List<String> ingredients) {
        return recipeRepository.findDistinctByInstructionsContainingAndIngredientsNameNotIn(instructions, ingredients);
    }

}
