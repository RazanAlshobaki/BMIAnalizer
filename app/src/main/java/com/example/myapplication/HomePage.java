package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_HomePage);
rv=findViewById(R.id.rv_BMI);
ArrayList<BMI> BMIS=new ArrayList<>();
BMIS.add(new BMI(R.id.oldstatus_date));
BMIS.add(new BMI(R.id.oldstatus_weight));
BMIS.add(new BMI(R.id.oldstatus_status));
BMIS.add(new BMI(R.id.oldstatus_length));

RecyclerViewAdapterOfBMIRecord adapter= new RecyclerViewAdapterOfBMIRecord(BMIS);
RecyclerView.LayoutManager lm=new GridLayoutManager(Context: this, spanCount:2);
rv.setHasFixedSize(true);
rv.setLayoutManager(lm);
rv.setAdapter(adapter);

    }
}