package com.abnamro.recipes.dao.model.recipe;

import com.abnamro.recipes.dao.model.user.UserModel;
import com.abnamro.recipes.dao.model.ingredient.IngredientModel;
import lombok.*;

import java.util.Set;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeModel {

    private Long id;

    private String name;

    private UserModel user;

    private boolean vegetarian;

    private int numberOfPerson;

    private Set<IngredientModel> ingredients;

    private String instructions;

}
