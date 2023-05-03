package com.abnamro.recipes.dao.repository.recipe;

import com.abnamro.recipes.dao.entity.recipe.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    List<RecipeEntity> findAllByVegetarianTrue();

    List<RecipeEntity> findAllByVegetarianFalse();

    List<RecipeEntity> findRecipeEntitiesByIngredientsNameIn(List<String> names);

    List<RecipeEntity> findRecipeEntitiesByIngredientsNameNotIn(List<String> names);

    List<RecipeEntity> findAllByInstructionsContaining(String search);

    List<RecipeEntity> findAllByNumberOfPerson(Integer number);

    List<RecipeEntity> findDistinctByNumberOfPersonAndIngredientsNameIn(Integer number, List<String> ingredients);

    List<RecipeEntity> findDistinctByInstructionsContainingAndIngredientsNameNotIn(String instructions, List<String> ingredients);

    List<RecipeEntity> findAllByIngredientsNotContainingAndInstructionsLike(String ingredients, String instructions);

}
