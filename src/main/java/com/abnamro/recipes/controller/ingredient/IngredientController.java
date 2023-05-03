package com.abnamro.recipes.controller.ingredient;

import com.abnamro.recipes.dao.model.ingredient.IngredientModel;
import com.abnamro.recipes.service.ingredient.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;
    

    @PostMapping("/createOrUpdate")
    ResponseEntity<IngredientModel> createOrUpdateRecipe(@RequestBody IngredientModel input) {
        IngredientModel ingredientModel = ingredientService.createOrUpdate(input);

        return new ResponseEntity<>(ingredientModel, HttpStatus.OK);
    }

    @GetMapping("getAllIngredients")
    ResponseEntity<List<IngredientModel>> getAllIngredients() {
        List<IngredientModel> listIngredient = ingredientService.getAllIngredients();

        return new ResponseEntity<>(listIngredient, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<IngredientModel> getIngredient(@PathVariable Long id) {
        IngredientModel ingredientModel = ingredientService.findById(id);

        return new ResponseEntity<>(ingredientModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);

        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
    
}
