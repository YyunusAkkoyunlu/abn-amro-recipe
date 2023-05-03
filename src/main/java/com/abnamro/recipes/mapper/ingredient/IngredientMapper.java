package com.abnamro.recipes.mapper.ingredient;

import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import com.abnamro.recipes.dao.model.ingredient.IngredientModel;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public IngredientEntity toDto(final IngredientModel ingredientModel) {
        return IngredientEntity.builder()
                .id(ingredientModel.getId())
                .name(ingredientModel.getName())
                .build();
    }

    public IngredientModel toModel(IngredientEntity ingredientEntity) {
        if (ingredientEntity == null) {
            return null;
        }
        return IngredientModel.builder()
                .id(ingredientEntity.getId())
                .name(ingredientEntity.getName())
                .build();
    }

}
