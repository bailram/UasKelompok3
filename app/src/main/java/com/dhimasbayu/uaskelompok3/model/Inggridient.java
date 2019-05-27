package com.dhimasbayu.uaskelompok3.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inggridient {
    @SerializedName("meals")
    @Expose
    private List<Inggridient_> meals = null;

    public List<Inggridient_> getMeals() {
        return meals;
    }

    public void setMeals(List<Inggridient_> meals) {
        this.meals = meals;
    }
}

