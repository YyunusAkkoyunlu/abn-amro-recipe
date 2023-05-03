package com.abnamro.recipes.service.recipe;

import com.abnamro.recipes.dao.entity.recipe.RecipeEntity;
import com.abnamro.recipes.dao.implementation.recipe.RecipeDAOImpl;
import com.abnamro.recipes.dao.model.recipe.RecipeModel;
import com.abnamro.recipes.mapper.recipe.RecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeDAOImpl recipeDAOImpl;

    @Autowired
    private RecipeMapper recipeMapper;


    public RecipeModel createOrUpdate(RecipeModel recipeModel) {
        RecipeEntity recipeEntity = recipeMapper.toDto(recipeModel);
        RecipeEntity returnEntity = recipeDAOImpl.createOrUpdate(recipeEntity);

        return recipeMapper.toModel(returnEntity);
    }

    public List<RecipeModel> getAllRecipes() {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.getAllRecipes();

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public RecipeModel findById(Long id) {
        RecipeEntity recipeEntity = recipeDAOImpl.findById(id);

        return recipeMapper.toModel(recipeEntity);
    }

    public List<RecipeModel> getAllVegetarianRecipes() {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.getAllVegetarianRecipes();

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public List<RecipeModel> getAllNonVegetarianRecipes() {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.getAllNonVegetarianRecipes();

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public List<RecipeModel> instructionsSearch(String search) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.instructionsSearch(search);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }


    public List<RecipeModel> getAllByCustomCriteria(String keyword) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.getAllByCustomCriteria(keyword);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public List<RecipeModel> getAllByWithoutIngredientsContainsInstructions(String ingredient, String instruction) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.getAllByWithoutIngredientsContainsInstructions(ingredient, instruction);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public List<RecipeModel> numberOfPerson(int numberOfPerson) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.numberOfPerson(numberOfPerson);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public List<RecipeModel> findRecipesByNumberOfPersonAndIngredients(Integer numberOfPerson, List<String> ingredients) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.findRecipesByNumberOfPersonAndIngredients(numberOfPerson, ingredients);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public void deleteById(Long id) {
        recipeDAOImpl.deleteRecipe(id);
    }

    public List<RecipeModel> findRecipesIngredients(List<String> ingredients) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.findRecipesIngredients(ingredients);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public List<RecipeModel> findRecipesNotIngredients(List<String> ingredients) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.findRecipesNotIngredients(ingredients);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }

    public List<RecipeModel> findRecipesNotIngredientWithInstructions(String instructions, List<String> ingredients) {
        List<RecipeEntity> listRecipeEntity = recipeDAOImpl.findRecipesNotIngredientWithInstructions(instructions, ingredients);

        List<RecipeModel> listRecipeModel = new ArrayList<>();
        listRecipeEntity.forEach(recipe -> listRecipeModel.add(recipeMapper.toModel(recipe)));

        return listRecipeModel;
    }
}
