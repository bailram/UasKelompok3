package com.dhimasbayu.uaskelompok3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhimasbayu.uaskelompok3.generator.ServiceGenerator;
import com.dhimasbayu.uaskelompok3.model.Meal;
import com.dhimasbayu.uaskelompok3.model.Meal_;
import com.dhimasbayu.uaskelompok3.services.MealService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMeal extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private MealService service;
    private List<Meal_> meals;
    TextView judul, bahan1, bahan2, bahan3, bahan4, bahan5, bahan6, bahan7, bahan8, bahan9,
            bahan10, bahan11, bahan12, bahan13, bahan14, bahan15, measure1, measure2, measure3,
            measure4, measure5, measure6, measure7, measure8, measure9, measure10, measure11,
            measure12, measure13, measure14, measure15, instruction, area, category;
    ImageView imageMeal,image1, image2, image3, image4, image5, image6, image7, image8, image9,
            image10, image11, image12, image13, image14,  image15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_meal);
        connectComponent();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Intent intent = getIntent();
        String id_meal = intent.getStringExtra("ID_MEAL");

        service = ServiceGenerator.createService(MealService.class);
        Call<Meal> call = service.getPostMeal(id_meal);
        call.enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {
                meals = response.body().getMeals();
                setComponent();
                Log.d(TAG,"Data Berhasil dimuat");
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }

    private void connectComponent(){
        judul = findViewById(R.id.judul);
        area = findViewById(R.id.area);
        category = findViewById(R.id.category);
        bahan1 = findViewById(R.id.bahan1);
        bahan2 = findViewById(R.id.bahan2);
        bahan3 = findViewById(R.id.bahan3);
        bahan4 = findViewById(R.id.bahan4);
        bahan5 = findViewById(R.id.bahan5);
        bahan6 = findViewById(R.id.bahan6);
        bahan7 = findViewById(R.id.bahan7);
        bahan8 = findViewById(R.id.bahan8);
        bahan9 = findViewById(R.id.bahan9);
        bahan10 = findViewById(R.id.bahan10);
        bahan11 = findViewById(R.id.bahan11);
        bahan12 = findViewById(R.id.bahan12);
        bahan13 = findViewById(R.id.bahan13);
        bahan14 = findViewById(R.id.bahan14);
        bahan15 = findViewById(R.id.bahan15);
        measure1 = findViewById(R.id.measure1);
        measure2 = findViewById(R.id.measure2);
        measure3 = findViewById(R.id.measure3);
        measure4 = findViewById(R.id.measure4);
        measure5 = findViewById(R.id.measure5);
        measure6 = findViewById(R.id.measure6);
        measure7 = findViewById(R.id.measure7);
        measure8 = findViewById(R.id.measure8);
        measure9 = findViewById(R.id.measure9);
        measure10 = findViewById(R.id.measure10);
        measure11 = findViewById(R.id.measure11);
        measure12 = findViewById(R.id.measure12);
        measure13 = findViewById(R.id.measure13);
        measure14 = findViewById(R.id.measure14);
        measure15 = findViewById(R.id.measure15);
        imageMeal = findViewById(R.id.imageMeal);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);
        instruction = findViewById(R.id.instruction);
    }

    private void setComponent(){
        Meal_ meal = meals.get(0);
        judul.setText(meal.getStrMeal());
        area.setText(meal.getStrArea());
        category.setText(meal.getStrCategory());
        bahan1.setText((meal.getStrIngredient1() != null) ? meal.getStrIngredient1() : "");
        bahan2.setText((meal.getStrIngredient2() != null) ? meal.getStrIngredient2() : "");
        bahan3.setText((meal.getStrIngredient3() != null) ? meal.getStrIngredient3() : "");
        bahan4.setText((meal.getStrIngredient4() != null) ? meal.getStrIngredient4() : "");
        bahan5.setText((meal.getStrIngredient5() != null) ? meal.getStrIngredient5() : "");
        bahan6.setText((meal.getStrIngredient6() != null) ? meal.getStrIngredient6() : "");
        bahan7.setText((meal.getStrIngredient7() != null) ? meal.getStrIngredient7() : "");
        bahan8.setText((meal.getStrIngredient8() != null) ? meal.getStrIngredient8() : "");
        bahan9.setText((meal.getStrIngredient9() != null) ? meal.getStrIngredient9() : "");
        bahan10.setText((meal.getStrIngredient10() != null) ? meal.getStrIngredient10() : "");
        bahan11.setText((meal.getStrIngredient11() != null) ? meal.getStrIngredient11() : "");
        bahan12.setText((meal.getStrIngredient12() != null) ? meal.getStrIngredient12() : "");
        bahan13.setText((meal.getStrIngredient13() != null) ? meal.getStrIngredient13() : "");
        bahan14.setText((meal.getStrIngredient14() != null) ? meal.getStrIngredient14() : "");
        bahan15.setText((meal.getStrIngredient15() != null) ? meal.getStrIngredient15() : "");
        measure1.setText((meal.getStrMeasure1() != null) ? meal.getStrMeasure1() : "");
        measure2.setText((meal.getStrMeasure2() != null) ? meal.getStrMeasure2() : "");
        measure3.setText((meal.getStrMeasure3() != null) ? meal.getStrMeasure3() : "");
        measure4.setText((meal.getStrMeasure4() != null) ? meal.getStrMeasure4() : "");
        measure5.setText((meal.getStrMeasure5() != null) ? meal.getStrMeasure5() : "");
        measure6.setText((meal.getStrMeasure6() != null) ? meal.getStrMeasure6() : "");
        measure7.setText((meal.getStrMeasure7() != null) ? meal.getStrMeasure7() : "");
        measure8.setText((meal.getStrMeasure8() != null) ? meal.getStrMeasure8() : "");
        measure9.setText((meal.getStrMeasure9() != null) ? meal.getStrMeasure9() : "");
        measure10.setText((meal.getStrMeasure10() != null) ? meal.getStrMeasure10() : "");
        measure11.setText((meal.getStrMeasure11() != null) ? meal.getStrMeasure11() : "");
        measure12.setText((meal.getStrMeasure12() != null) ? meal.getStrMeasure12() : "");
        measure13.setText((meal.getStrMeasure13() != null) ? meal.getStrMeasure13() : "");
        measure14.setText((meal.getStrMeasure14() != null) ? meal.getStrMeasure14() : "");
        measure15.setText((meal.getStrMeasure15() != null) ? meal.getStrMeasure15() : "");
        instruction.setText(meal.getStrInstructions());
        Picasso.get()
                .load(meal.getStrMealThumb())
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(imageMeal);
        imageMeal.setScaleType(ImageView.ScaleType.FIT_XY);

        if(meal.getStrIngredient1() != null || meal.getStrIngredient1() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient1() + "-Small.png")
                    .into(image1);
        }

        if(meal.getStrIngredient2() != null || meal.getStrIngredient2() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient2() + "-Small.png")
                    .into(image2);
        }

        if(meal.getStrIngredient3() != null || meal.getStrIngredient3() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient3() + "-Small.png")
                    .into(image3);
        }

        if(meal.getStrIngredient4() != null || meal.getStrIngredient4() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient4() + "-Small.png")
                    .into(image4);
        }

        if(meal.getStrIngredient5() != null || meal.getStrIngredient5() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient5() + "-Small.png")
                    .into(image5);
        }

        if(meal.getStrIngredient6() != null || meal.getStrIngredient6() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient6() + "-Small.png")
                    .into(image6);
        }

        if(meal.getStrIngredient7() != null || meal.getStrIngredient7() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient7() + "-Small.png")
                    .into(image7);
        }

        if(meal.getStrIngredient7() != null || meal.getStrIngredient7() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient7() + "-Small.png")
                    .into(image7);
        }

        if(meal.getStrIngredient8() != null || meal.getStrIngredient8() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient8() + "-Small.png")
                    .into(image8);
        }

        if(meal.getStrIngredient9() != null || meal.getStrIngredient9() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient9() + "-Small.png")
                    .into(image9);
        }

        if(meal.getStrIngredient10() != null || meal.getStrIngredient10() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient10() + "-Small.png")
                    .into(image10);
        }

        if(meal.getStrIngredient11() != null || meal.getStrIngredient11() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient11() + "-Small.png")
                    .into(image11);
        }

        if(meal.getStrIngredient12() != null || meal.getStrIngredient12() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient12() + "-Small.png")
                    .into(image12);
        }

        if(meal.getStrIngredient13() != null || meal.getStrIngredient13() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient13() + "-Small.png")
                    .into(image13);
        }

        if(meal.getStrIngredient14() != null || meal.getStrIngredient14() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient14() + "-Small.png")
                    .into(image14);
        }

        if(meal.getStrIngredient15() != null || meal.getStrIngredient15() != "") {
            Picasso.get()
                    .load("https://www.themealdb.com/images/ingredients/" + meal.getStrIngredient15() + "-Small.png")
                    .into(image15);
        }
    }
}
