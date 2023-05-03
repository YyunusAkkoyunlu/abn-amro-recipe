package com.abnamro.recipes.service.ingredient;

import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import com.abnamro.recipes.dao.implementation.ingredient.IngredientDAOImpl;
import com.abnamro.recipes.dao.model.ingredient.IngredientModel;
import com.abnamro.recipes.mapper.ingredient.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientDAOImpl ingredientDAOImpl;

    @Autowired
    private IngredientMapper ingredientMapper;

    public IngredientModel createOrUpdate(IngredientModel ingredientModel) {
        IngredientEntity ingredientEntity = ingredientMapper.toDto(ingredientModel);
        IngredientEntity returnEntity = ingredientDAOImpl.createOrUpdate(ingredientEntity);

        return ingredientMapper.toModel(returnEntity);
    }

    public List<IngredientModel> getAllIngredients() {
        List<IngredientEntity> listIngredientEntity = ingredientDAOImpl.getAllIngredients();

        List<IngredientModel> listIngredientModel = new ArrayList<>();
        listIngredientEntity.forEach(ingredient -> listIngredientModel.add(ingredientMapper.toModel(ingredient)));

        return listIngredientModel;
    }

    public IngredientModel findById(Long id) {
        IngredientEntity ingredientEntity = ingredientDAOImpl.findById(id);

        return ingredientMapper.toModel(ingredientEntity);
    }

    public void deleteById(Long id) {
        ingredientDAOImpl.deleteById(id);
    }

}
