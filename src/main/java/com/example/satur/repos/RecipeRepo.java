package com.example.satur.repos;

import com.example.satur.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {

    List<Recipe> findByFormIgnoreCaseContaining(String form);
}
