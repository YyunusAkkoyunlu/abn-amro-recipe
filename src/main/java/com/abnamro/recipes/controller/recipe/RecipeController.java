package com.abnamro.recipes.controller.recipe;

import com.abnamro.recipes.dao.model.recipe.RecipeModel;
import com.abnamro.recipes.service.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @PostMapping("/createOrUpdate")
    ResponseEntity<RecipeModel> createOrUpdateRecipe(@RequestBody RecipeModel input) {
        RecipeModel recipeModel = recipeService.createOrUpdate(input);

        return new ResponseEntity<>(recipeModel, HttpStatus.OK);
    }

    @GetMapping("getAllRecipes")
    ResponseEntity<List<RecipeModel>> getAllRecipes() {
        List<RecipeModel> listRecipe = recipeService.getAllRecipes();

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<RecipeModel> getRecipe(@PathVariable Long id) {
        RecipeModel recipeModel = recipeService.findById(id);

        return new ResponseEntity<>(recipeModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);

        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @GetMapping("getAllVegetarianRecipes")
    ResponseEntity<List<RecipeModel>> getAllVegetarianRecipes() {
        List<RecipeModel> listRecipe = recipeService.getAllVegetarianRecipes();

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("getAllNonVegetarianRecipes")
    ResponseEntity<List<RecipeModel>> getAllNonVegetarianRecipes() {
        List<RecipeModel> listRecipe = recipeService.getAllNonVegetarianRecipes();

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("/instructions")
    ResponseEntity<Object> instructionsSearch(@RequestParam(value = "search") String search) {
        List<RecipeModel> listRecipe = recipeService.instructionsSearch(search);

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("/numberOfPerson")
    ResponseEntity<Object> numberOfPerson(@RequestBody int numberOfPerson) {
        List<RecipeModel> listRecipe = recipeService.numberOfPerson(numberOfPerson);

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("/findRecipesByNumberOfPersonAndIngredients")
    ResponseEntity<Object> findRecipesByNumberOfPersonAndIngredients(@RequestBody int numberOfPerson, List<String> ingredients) {
        List<RecipeModel> listRecipe = recipeService.findRecipesByNumberOfPersonAndIngredients(numberOfPerson, ingredients);

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("/findRecipesIngredients")
    ResponseEntity<Object> findRecipesIngredients(@RequestBody List<String> ingredients) {
        List<RecipeModel> listRecipe = recipeService.findRecipesIngredients(ingredients);

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("/findRecipesNotIngredients")
    ResponseEntity<Object> findRecipesNotIngredients(@RequestBody List<String> ingredients) {
        List<RecipeModel> listRecipe = recipeService.findRecipesNotIngredients(ingredients);

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

    @GetMapping("/getAllByWithoutIngredientsContainsInstructions")
    ResponseEntity<Object> findRecipesNotIngredientWithInstructions(@RequestBody String instructions, List<String> ingredients) {
        List<RecipeModel> listRecipe = recipeService.findRecipesNotIngredientWithInstructions(instructions, ingredients);

        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }

}
