package com.example.satur.controllers;


import com.example.satur.entities.Recipe;
import com.example.satur.repos.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private RecipeRepo recipeRepo;

    @GetMapping
    public String main(Map<String, Object> model) {

        Iterable<Recipe> recipes = recipeRepo.findAll();

        model.put("some", recipes);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String nameRecipe,
                      @RequestParam String form,
                      @RequestParam String howToCook,
                      Map<String, Object> model){

        Recipe recipe = new Recipe(nameRecipe, form, howToCook);

        recipeRepo.save(recipe);

        Iterable<Recipe> recipes = recipeRepo.findAll();

        model.put("recipes", recipes);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {

        List<Recipe> recipes = recipeRepo.findByFormIgnoreCaseContaining(filter);

        model.put("recipes", recipes);
        return "main";
    }

//    @PostMapping("delete")
//    public String delete(@RequestParam("del") Long id, Map<String, Object> model){
//        recipeRepo.delete
//        return "redirect:/";
//    }

}