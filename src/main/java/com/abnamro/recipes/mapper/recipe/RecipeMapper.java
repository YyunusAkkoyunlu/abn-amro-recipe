package com.abnamro.recipes.mapper.recipe;

import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import com.abnamro.recipes.dao.entity.recipe.RecipeEntity;
import com.abnamro.recipes.dao.model.ingredient.IngredientModel;
import com.abnamro.recipes.dao.model.recipe.RecipeModel;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class RecipeMapper {

    public RecipeModel toModel(final RecipeEntity recipeEntity) {
        if (recipeEntity == null) {
            return null;
        }

        return RecipeModel.builder()
                .id(recipeEntity.getId())
                .name(recipeEntity.getName())
                .numberOfPerson(recipeEntity.getNumberOfPerson())
                .vegetarian(recipeEntity.isVegetarian())
                .instructions(recipeEntity.getInstructions())
                .ingredients(recipeEntity.getIngredients().stream()
                        .map(IngredientModel::toModel)
                        .collect(Collectors.toSet())
                )
                .build();
    }

    public RecipeEntity toDto(final RecipeModel recipeModel) {
        return RecipeEntity.builder()
                .id(recipeModel.getId())
                .name(recipeModel.getName())
                .numberOfPerson(recipeModel.getNumberOfPerson())
                .vegetarian(recipeModel.isVegetarian())
                .instructions(recipeModel.getInstructions())
                .ingredients(recipeModel.getIngredients().stream()
                        .map(IngredientEntity::toModelEntity)
                        .collect(Collectors.toSet())
                )
                .build();
    }

}
