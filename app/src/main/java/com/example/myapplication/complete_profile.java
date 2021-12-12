package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class complete_profile extends AppCompatActivity {
    RadioButton rb_male, rb_female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);

        rb_female = findViewById(R.id.radioFemale);
        rb_male = findViewById(R.id.radioMale);

        rb_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    Toast.makeText(getBaseContext(), "Checked", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Un checked", Toast.LENGTH_LONG).show();
            }
        });
    }
}