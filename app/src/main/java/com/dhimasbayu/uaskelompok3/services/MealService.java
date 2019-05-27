package com.dhimasbayu.uaskelompok3.services;

import com.dhimasbayu.uaskelompok3.model.CategoryList;
import com.dhimasbayu.uaskelompok3.model.Meal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    @GET("v1/1/random.php")
    Call<Meal> getRandomMeal();

    @GET("v1/1/filter.php?a=Japanese")
    Call<Meal> getJapaneseMeal();

    @GET("v1/1/lookup.php")
    Call<Meal> getPostMeal(@Query("i") String id);

    @GET("v1/1/search.php")
    Call<Meal> getSearchMeal(@Query("s") String keyword);

    @GET("v1/1/categories.php")
    Call<CategoryList> getCategory();
}
