package com.abnamro.recipes.dao.definition.recipe;

import com.abnamro.recipes.dao.entity.recipe.RecipeEntity;

import java.util.List;

public interface IRecipeDAO {

    public RecipeEntity createOrUpdate(RecipeEntity recipeEntity);

    public List<RecipeEntity> getAllRecipes();

    public void deleteRecipe(Long id);

    public RecipeEntity findById(Long id);

    public List<RecipeEntity> getAllVegetarianRecipes();

    public List<RecipeEntity> getAllNonVegetarianRecipes();

    public List<RecipeEntity> instructionsSearch(String search);

    public List<RecipeEntity> getAllByCustomCriteria(String keyword);

    public List<RecipeEntity> getAllByWithoutIngredientsContainsInstructions(String ingredient, String instruction);

    public List<RecipeEntity> numberOfPerson(int numberOfPerson);

    public List<RecipeEntity> findRecipesByNumberOfPersonAndIngredients(Integer numberOfPerson, List<String> ingredients);

    public List<RecipeEntity> findRecipesIngredients(List<String> ingredients);

    public List<RecipeEntity> findRecipesNotIngredients(List<String> ingredients);

    public List<RecipeEntity> findRecipesNotIngredientWithInstructions(String instructions, List<String> ingredients);
}
