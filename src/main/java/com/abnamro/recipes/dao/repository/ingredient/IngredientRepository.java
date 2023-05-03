package com.abnamro.recipes.dao.repository.ingredient;

import com.abnamro.recipes.dao.entity.ingredient.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    IngredientEntity findByNameIgnoreCase(String name);

}
