package com.moblab.zsolt.moblab.model;

import com.orm.dsl.Table;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

@Table
public class Coffee {

    private Long id = null;
    private String name;
    private List<String> ingredients;
    private String preparation;

    public Coffee() {
    }

    public Coffee(Long id, List<String> ingredients, String name, String preparation) {
        this.id = id;
        this.ingredients = ingredients;
        this.name = name;
        this.preparation = preparation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
}
