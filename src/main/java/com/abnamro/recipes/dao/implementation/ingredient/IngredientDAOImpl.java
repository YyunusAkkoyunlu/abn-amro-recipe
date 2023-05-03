package com.abnamro.recipes.dao.implementation.ingredient;

import com.abnamro.recipes.dao.definition.ingredient.IIngredientDAO;
import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import com.abnamro.recipes.dao.repository.ingredient.IngredientRepository;
import com.abnamro.recipes.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class IngredientDAOImpl implements IIngredientDAO {

    @Autowired
    private IngredientRepository ingredientRepository;


    @Override
    public IngredientEntity createOrUpdate(IngredientEntity ingredientEntity) {
        IngredientEntity entity = ingredientRepository.findByNameIgnoreCase(ingredientEntity.getName());
        if (entity != null) {
            throw new ApiRequestException("Ingredient already exists..!");
        }
        return ingredientRepository.save(ingredientEntity);
    }

    @Override
    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public IngredientEntity findById(Long id) {
        Optional entity = ingredientRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ApiRequestException("Ingredient not found..!");
        }

        return (IngredientEntity) entity.get();
    }

    @Override
    public void deleteById(Long id) {
        IngredientEntity ingredientEntity = findById(id);

        ingredientRepository.delete(ingredientEntity);
    }

}
