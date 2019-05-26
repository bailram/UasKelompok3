
package com.dhimasbayu.uaskelompok3.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal {

    @SerializedName("meals")
    @Expose
    private List<Meal_> meals = null;

    public List<Meal_> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal_> meals) {
        this.meals = meals;
    }

}
