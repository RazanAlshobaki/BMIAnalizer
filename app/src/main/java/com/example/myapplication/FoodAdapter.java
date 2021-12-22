package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private ArrayList<Food> foods=new ArrayList<Food>();

    public FoodAdapter(ArrayList<Food> foods) {
        this.foods = foods;
    }


    public FoodAdapter() {
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_customitem, null,false);
        FoodViewHolder viewHolder = new FoodViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food f= foods.get(position);
        holder.iv_image1.setImageResource(f.getImg());
        holder.tv1.setText(f.getName());
        holder.tv2.setText(f.getType());
        holder.tv3.setText(f.getCalory());



    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_image1;
        TextView tv1, tv2, tv3;
         Button edit;
        ImageView iv_image2;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image1 =itemView.findViewById(R.id.salamonimg);
            tv1=itemView.findViewById(R.id.text_salamon);
            tv2=itemView.findViewById(R.id.text_fish);
            tv3=itemView.findViewById(R.id.text_calrv);
            edit=itemView.findViewById(R.id.editbutton);
        }
    }
}
