package com.abnamro.recipes.dao.entity.recipe;

import com.abnamro.recipes.dao.entity.user.UserEntity;
import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Set;

@Table(name = "Recipe")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Recipe name can not be blank.")
    @Size(max = 200, message = "Recipe name is too long.")
    private String name;

    @ManyToOne
    private UserEntity user;

    @NotNull(message = "Vegetarian/Non-vegetarian flag must be provided.")
    private boolean vegetarian;

    @NotNull(message = "Number of servings must be provided.")
    @Min(value = 1, message = "Number of servings must be at least 1")
    private int numberOfPerson;

    @NotEmpty(message = "Ingredients can not be empty.")
    @ManyToMany(fetch = FetchType.EAGER) // mappedBy = "recipe", fetch = FetchType.LAZY
    @JoinTable(name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipeId"),
            inverseJoinColumns = @JoinColumn(name = "ingredientId"))
    private Set<IngredientEntity> ingredients;

    private String instructions;

}
