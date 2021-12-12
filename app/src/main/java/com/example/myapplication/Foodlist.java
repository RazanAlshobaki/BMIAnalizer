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
        ArrayList<food> foods=new ArrayList<>();
        foods.add(new food(R.id.salamonimg));
        foods.add(new food(R.id.foodset));
        foods.add(new food(R.id.editbutton));



        RecyclerViewAdapterOfFood adapter= new RecyclerViewAdapterOfFood(foods);
        RecyclerView.LayoutManager lm=new GridLayoutManager(Context: this, spanCount:1);
        rvf.setHasFixedSize(true);
        rvf.setLayoutManager(lm);
        rvf.setAdapter(adapter);
    }

}




