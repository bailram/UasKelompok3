package com.dhimasbayu.uaskelompok3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dhimasbayu.uaskelompok3.model.Meal_;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
    private List<Meal_> meals;
    private int rowLayout;
    private Context context;

    public MealAdapter(List<Meal_> meals, int rowLayout, Context context){
        this.meals = meals;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //return null;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder mealViewHolder, int i) {
        String image_url = meals.get(i).getStrMealThumb();
        Picasso.get()
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(mealViewHolder.mealImage);
        mealViewHolder.mealImage.setScaleType(ImageView.ScaleType.FIT_XY);
        mealViewHolder.title.setText(meals.get(i).getStrMeal());
//        mealViewHolder.category.setText(meals.get(i).getStrCategory());
//        mealViewHolder.intruction.setText(meals.get(i).getStrInstructions());
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mealLayout;
        TextView title;
//        TextView category;
//        TextView intruction;
        ImageView mealImage;
        public MealViewHolder(@NonNull final View itemView) {
            super(itemView);
            mealLayout = itemView.findViewById(R.id.meal_layout);
            mealImage = itemView.findViewById(R.id.meal_image);
            title = itemView.findViewById(R.id.title);
//            category = itemView.findViewById(R.id.category);
//            intruction = itemView.findViewById(R.id.instruction);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(),DetailMeal.class);
                    intent.putExtra("ID_MEAL", meals.get(getAdapterPosition()).getIdMeal());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
