package com.dhimasbayu.uaskelompok3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.dhimasbayu.uaskelompok3.generator.ServiceGenerator;
import com.dhimasbayu.uaskelompok3.model.Meal;
import com.dhimasbayu.uaskelompok3.model.Meal_;
import com.dhimasbayu.uaskelompok3.services.MealService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private RecyclerView recyclerView,areaRecyclerView;
    private MealAdapter adapter;
    private AreaAdapter adapterArea;
    private MealService service;
    private List<Meal_> meals;
//  Button button, buttonIngridient;
    TextView button, buttonIngridient;
    private List<Meal_> area;
    String filterCategory, filterArea, filterIngridient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn_category);
        buttonIngridient = findViewById(R.id.btn_ingridient);

        Intent intent = getIntent();
        filterCategory = intent.getStringExtra("CATEGORY");
        filterArea = intent.getStringExtra("AREA");
        filterIngridient = intent.getStringExtra("INGRIDIENT");

        recyclerView = findViewById(R.id.recycler_view);
        areaRecyclerView = findViewById(R.id.recycler_area);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this,ListCategory.class);
                startActivity(intent);
            }
        });

        buttonIngridient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this,IndrigientList.class);
                startActivity(intent);
            }
        });

        service = ServiceGenerator.createService(MealService.class);
        setupArea();
        //Call<Meal> call = service.getPostMeal(52831);
        //if(!filterCategory.equalsIgnoreCase("")){
         if(filterCategory != null){
            Call<Meal> call = service.getMealByCategory(filterCategory);
            call.enqueue(new Callback<Meal>() {
                @Override
                public void onResponse(Call<Meal> call, Response<Meal> response) {
                    meals = response.body().getMeals();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new MealAdapter(meals,R.layout.list_item_meal,MainActivity.this);
                    //recyclerView.setAdapter(new MealAdapter(meals,R.layout.list_item_meal, getApplicationContext()));
                    recyclerView.setAdapter(adapter);
                    Log.d(TAG, "Data Berhasil dimuat");
                }

                @Override
                public void onFailure(Call<Meal> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        //}else if(!filterArea.equalsIgnoreCase("")){
         }else if(filterArea != null){
            Call<Meal> call = service.getMealByArea(filterArea);
            call.enqueue(new Callback<Meal>() {
                @Override
                public void onResponse(Call<Meal> call, Response<Meal> response) {
                    meals = response.body().getMeals();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new MealAdapter(meals,R.layout.list_item_meal,MainActivity.this);
                    //recyclerView.setAdapter(new MealAdapter(meals,R.layout.list_item_meal, getApplicationContext()));
                    recyclerView.setAdapter(adapter);
                    Log.d(TAG, "Data Berhasil dimuat");
                }

                @Override
                public void onFailure(Call<Meal> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        //}else if(!filterIngridient.equalsIgnoreCase("")) {
         }else if(filterIngridient != null) {
            Call<Meal> call = service.getMealByIngridient(filterIngridient);
            call.enqueue(new Callback<Meal>() {
                @Override
                public void onResponse(Call<Meal> call, Response<Meal> response) {
                    meals = response.body().getMeals();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new MealAdapter(meals,R.layout.list_item_meal,MainActivity.this);
                    //recyclerView.setAdapter(new MealAdapter(meals,R.layout.list_item_meal, getApplicationContext()));
                    recyclerView.setAdapter(adapter);
                    Log.d(TAG, "Data Berhasil dimuat");
                }

                @Override
                public void onFailure(Call<Meal> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }else{
            Call<Meal> call = service.getJapaneseMeal();
            call.enqueue(new Callback<Meal>() {
                @Override
                public void onResponse(Call<Meal> call, Response<Meal> response) {
                    meals = response.body().getMeals();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new MealAdapter(meals,R.layout.list_item_meal,MainActivity.this);
                    //recyclerView.setAdapter(new MealAdapter(meals,R.layout.list_item_meal, getApplicationContext()));
                    recyclerView.setAdapter(adapter);
                    Log.d(TAG, "Data Berhasil dimuat");
                }

                @Override
                public void onFailure(Call<Meal> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }
        //setupArea();
    }

    private void setupArea(){
        Call<Meal> call = service.getAreaList();
        call.enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {
                area = response.body().getMeals();
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                areaRecyclerView.setLayoutManager(layoutManager);
                adapterArea = new AreaAdapter(area, R.layout.list_item_area, MainActivity.this);
                areaRecyclerView.setAdapter(adapterArea);
                Log.d(TAG, "Data Berhasil dimuat");
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Call<Meal> call = service.getSearchMeal(query);
                call.enqueue(new Callback<Meal>() {
                    @Override
                    public void onResponse(Call<Meal> call, Response<Meal> response) {
                        meals = response.body().getMeals();
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        recyclerView.setLayoutManager(layoutManager);
                        adapter = new MealAdapter(meals,R.layout.list_item_meal,MainActivity.this);
                        //recyclerView.setAdapter(new MealAdapter(meals,R.layout.list_item_meal, getApplicationContext()));
                        recyclerView.setAdapter(adapter);
                        Log.d(TAG, "Data Berhasil dimuat");
                    }

                    @Override
                    public void onFailure(Call<Meal> call, Throwable t) {
                        Log.e(TAG, t.toString());
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
