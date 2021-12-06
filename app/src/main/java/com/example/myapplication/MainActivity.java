package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
Button next ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next=(Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create your Intent Here
                Intent i = new Intent(MainActivity.this,LogIn.class);
                startActivity(i);
            }
        });
    }
}