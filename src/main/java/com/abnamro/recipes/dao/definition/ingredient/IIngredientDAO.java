package com.abnamro.recipes.dao.definition.ingredient;

import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;

import java.util.List;

public interface IIngredientDAO {

    public IngredientEntity createOrUpdate(IngredientEntity ingredientEntity);

    public List<IngredientEntity> getAllIngredients();

    public IngredientEntity findById(Long id);

    public void deleteById(Long id);
}
