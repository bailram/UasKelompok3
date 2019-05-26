package com.dhimasbayu.uaskelompok3.services;

import com.dhimasbayu.uaskelompok3.model.Meal;
import com.dhimasbayu.uaskelompok3.model.Meal_;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    @GET("v1/1/random.php")
    Call<Meal> getRandomMeal();

    @GET("v1/1/filter.php?a=Japanese")
    Call<Meal> getJapaneseMeal();

    @GET("v1/1/lookup.php")
    Call<Meal> getPostMeal(@Query("i") int id);
}
