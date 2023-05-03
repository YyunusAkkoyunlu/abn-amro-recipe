package com.abnamro.recipes.dao.model.ingredient;

import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import lombok.*;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientModel {

    private Long id;

    private String name;

    public static IngredientModel toModel(IngredientEntity ingredientEntity) {
        return IngredientModel.builder()
                .id(ingredientEntity.getId())
                .name(ingredientEntity.getName())
                .build();
    }

}
