package com.example.myapplication;

import static com.example.myapplication.User.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    static HomePage instance;
    TextView Hi_name;
    EditText status;
    Button add_food, add_record, view_food,logout;
RecyclerView rv;
public static BMIRecordsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_home_page);
        rv = findViewById(R.id.rv_BMI);
        ArrayList<BMIRecord> records = new ArrayList<>();
        records.add(new BMIRecord("12/3/2020" ,2.15,    160, "Normal"));
        records.add(new BMIRecord("12/3/2020" ,2.15,    160, "Normal"));
        records.add(new BMIRecord("12/3/2020" ,2.15,    160, "Normal"));
        records.add(new BMIRecord("12/3/2020" ,2.15,    160, "Normal"));
        BMIRecordsAdapter adapter = new BMIRecordsAdapter(records);
        RecyclerView.LayoutManager lm;
        lm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        Hi_name = findViewById(R.id.txt_hi);
        status = findViewById(R.id.normal);
        add_food = findViewById(R.id.btn_addfood);
        add_record = findViewById(R.id.btn_addrecord);
        view_food = findViewById(R.id.btn_viewfood);
        logout = findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
        add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFood();
            }
        });
        add_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRecord();
            }
        });
        view_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFood();
            }
        });






    }
    public void addFood(){
    Intent x= new Intent (HomePage.this, AddFood.class);
    startActivity(x);
}
public void viewFood(){
        Intent x= new Intent (HomePage.this, Foodlist.class);
        startActivity(x);
        }
public void addRecord(){
        Intent x= new Intent (HomePage.this, new_record.class);
        startActivity(x);
        }
public void logout(){
    firebase.logout();
        Intent x= new Intent (HomePage.this, LogIn.class);
finish();
        startActivity(x);
}
public static void checkBMIChange(){
    if(instance==null)return;
    instance.adapter.notifyDataSetChanged();
    instance.status.setText(user.setHomeMessage());
    instance.Hi_name.setText("Hi," + user.getName());
        }
        @Override
protected void onResume(){
  super.onResume();
        checkBMIChange();
        }
}