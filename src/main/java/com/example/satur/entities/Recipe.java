package com.example.satur.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nameRecipe;
    private String form;

    public Recipe(String nameRecipe, String form, String howToCook) {
        this.nameRecipe = nameRecipe;
        this.form = form;
        this.howToCook = howToCook;
    }

    public Recipe() {
    }

    private String howToCook;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getHowToCook() {
        return howToCook;
    }

    public void setHowToCook(String howToCook) {
        this.howToCook = howToCook;
    }
}
