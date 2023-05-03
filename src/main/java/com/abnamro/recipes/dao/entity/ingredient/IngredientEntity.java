package com.abnamro.recipes.dao.entity.ingredient;

import com.abnamro.recipes.dao.entity.recipe.RecipeEntity;
import com.abnamro.recipes.dao.model.ingredient.IngredientModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
//import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Ingredient")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ingredient name can not be blank.")
    @Size(max = 200, message = "Ingredient name can not be more than 200 characters long.")
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_recipe_id")
//    @Fetch(FetchMode.JOIN)
//    @JsonIgnore
//    private RecipeEntity recipe;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "ingredients")
    @JsonIgnore
    private Set<RecipeEntity> recipes;

    public static IngredientEntity toModelEntity(IngredientModel ingredientModel) {
        return IngredientEntity.builder()
                .id(ingredientModel.getId())
                .name(ingredientModel.getName())
                .build();
    }

}
