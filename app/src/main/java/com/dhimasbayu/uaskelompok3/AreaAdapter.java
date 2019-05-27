package com.dhimasbayu.uaskelompok3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dhimasbayu.uaskelompok3.model.Meal_;

import java.util.List;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.AreaViewHolder> {
    private List<Meal_> area;
    private int rowLayout;
    private Context context;

    public AreaAdapter(List<Meal_> area, int rowLayout, Context context){
        this.area = area;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public AreaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //return null;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new AreaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaViewHolder areaViewHolder, int i) {
        areaViewHolder.nama.setText(area.get(i).getStrArea());
    }

    @Override
    public int getItemCount() {
        return area.size();
    }

    public class AreaViewHolder extends RecyclerView.ViewHolder {
        LinearLayout areaLayout;
        TextView nama;
        public AreaViewHolder(@NonNull View itemView) {
            super(itemView);
            areaLayout = itemView.findViewById(R.id.area_layout);
            nama = itemView.findViewById(R.id.nama_area);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    intent.putExtra("AREA", area.get(getAdapterPosition()).getStrArea());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
