package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Foodlist extends AppCompatActivity {
    RecyclerView rvf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodlist);
        rvf=findViewById(R.id.rv_foodlist);
        ArrayList<Food> foods=new ArrayList<>();
        foods.add(new Food(R.drawable.salamon,"Salamon", "fish", "22 cal/g"));
        foods.add(new Food(R.drawable.salamon,"Salamon", "fish", "22 cal/g"));
        foods.add(new Food(R.drawable.salamon,"Salamon", "fish", "22 cal/g"));
        foods.add(new Food(R.drawable.salamon,"Salamon", "fish", "22 cal/g"));
        FoodAdapter adapter= new FoodAdapter(foods);
        RecyclerView.LayoutManager lm=new GridLayoutManager( this, 2);
        rvf.setHasFixedSize(true);
        rvf.setLayoutManager(lm);
        rvf.setAdapter(adapter);
    }

}




