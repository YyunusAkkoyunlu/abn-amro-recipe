package com.abnamro.recipes.dao.repository.recipe;

import com.abnamro.recipes.dao.entity.recipe.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    RecipeEntity findRecipeEntityByName(String name);

    List<RecipeEntity> findAllByVegetarianTrue();

    List<RecipeEntity> findAllByVegetarianFalse();

    List<RecipeEntity> findRecipeEntitiesByIngredientsName(String name); // works

    List<RecipeEntity> findRecipeEntitiesByIngredientsNameIn(List<String> names); // works

    List<RecipeEntity> findRecipeEntitiesByIngredientsNameNotIn(List<String> names); // works

    List<RecipeEntity> findDistinctByIngredientsNameIn(List<String> names); // works
    List<RecipeEntity> findDistinctByIngredientsNameNotIn(List<String> names);

    List<RecipeEntity> findAllByInstructionsContaining(String search);

    List<RecipeEntity> findAllByNumberOfPerson(Integer number);

    List<RecipeEntity> findDistinctByNumberOfPersonAndIngredientsNameIn(Integer number, List<String> ingredients);

    List<RecipeEntity> findDistinctByInstructionsContainingAndIngredientsNameNotIn(String instructions, List<String> ingredients);

    List<RecipeEntity> findDistinctByInstructionsContainingAndIngredientsNameIn(String instructions, List<String> ingredients);

/*//    @Query(value = "select distinct r from RecipeEntity r, IngredientEntity i where r.ingredients = i.id and r.instructions like ?1 and i not in (:ingredients)")
    @Query(value = "select distinct RecipeEntity from RecipeEntity inner join IngredientEntity where RecipeEntity.instructions like ?1 and IngredientEntity.name not in (?2)")
    List<RecipeEntity> deneme(String instructions, List<String> ingredients);*/

//    @Query("select * from RecipeEntity where concat(id, name, vegetarian, numberOfPerson, ingredients, instructions) like %?1")

//    @Query("SELECT p FROM RecipeEntity p WHERE CONCAT(p.id, ' ', p.name, ' ', p.user, ' ', p.vegetarian, ' ', p.numberOfPerson, ' ', p.ingredients, ' ', p.instructions) LIKE %?1%")
//    List<RecipeEntity> findAllByCustomParam(String keyword);
//    List<RecipeEntity> findAllByNameLikeOrNumberOfPersonLike(String keyword);

    List<RecipeEntity> findAllByIngredientsNotContainingAndInstructionsLike(String ingredients, String instructions);

}
