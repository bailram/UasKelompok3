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

import com.dhimasbayu.uaskelompok3.model.Inggridient;
import com.dhimasbayu.uaskelompok3.model.Inggridient_;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IndrigientAdapter extends RecyclerView.Adapter<IndrigientAdapter.IndrigientViewHolder> {
    private List<Inggridient_> inggridients;
    private Context context;

    public IndrigientAdapter(List<Inggridient_> Meals, Context context) {
        this.inggridients = Meals;
        this.context = context;
    }

    @NonNull
    @Override
    public IndrigientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_indrigient, viewGroup, false);
        return new IndrigientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndrigientViewHolder indrigientViewHolder, int i) {
        indrigientViewHolder.title.setText(inggridients.get(i).getStrIngredient());
        Picasso.get()
                .load("https://www.themealdb.com/images/ingredients/"+inggridients.get(i).getStrIngredient()+"-Small.png")
                .into(indrigientViewHolder.mealImage);
    }

    @Override
    public int getItemCount() {
        return inggridients.size();
    }

    public class IndrigientViewHolder extends RecyclerView.ViewHolder{
        ImageView mealImage;
        TextView title;

            public IndrigientViewHolder(@NonNull View itemView) {
                super(itemView);
                mealImage = itemView.findViewById(R.id.meal_image);
                title = itemView.findViewById(R.id.title);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(),MainActivity.class);
                        intent.putExtra("INGRIDIENT", inggridients.get(getAdapterPosition()).getStrIngredient());
                        v.getContext().startActivity(intent);
                    }
                });

        }
    }
}
