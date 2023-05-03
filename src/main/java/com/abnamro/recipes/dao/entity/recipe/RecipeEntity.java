package com.abnamro.recipes.dao.entity.recipe;

import com.abnamro.recipes.dao.entity.user.UserEntity;
import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import jakarta.persistence.*;
import lombok.*;

//import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
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

/*    @NotEmpty(message = "Ingredients can not be empty.")
//    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) // mappedBy = "recipe", fetch = FetchType.LAZY
    @OneToMany(cascade = CascadeType.ALL) // mappedBy = "recipe", fetch = FetchType.LAZY
    @JoinColumn(name = "fk_recipe_id", referencedColumnName = "id")
    private List<IngredientEntity> ingredients;*/

    @NotEmpty(message = "Ingredients can not be empty.")
//    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) // mappedBy = "recipe", fetch = FetchType.LAZY
    @ManyToMany(fetch = FetchType.EAGER) // mappedBy = "recipe", fetch = FetchType.LAZY
    @JoinTable(name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipeId"),
            inverseJoinColumns = @JoinColumn(name = "ingredientId"))
    private Set<IngredientEntity> ingredients;

    private String instructions;

}
