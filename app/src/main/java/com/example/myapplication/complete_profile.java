package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class complete_profile extends AppCompatActivity {
    RadioButton rb_male, rb_female;
    Button btn_inc1,btn_dec1, button_increment1, button_decremrement1, save_data;
    EditText et_number1, edit_number1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);
        save_data= findViewById(R.id.btn_save);
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new  Intent(complete_profile.this, HomePage.class);
                startActivity(intent);

            }
        });
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

        btn_inc1 = findViewById(R.id.increment33);
        et_number1 = findViewById(R.id.editTextText1weight);
        btn_inc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(et_number1.getText().toString());
                x += 1;
                et_number1.setText(x+"");
            }
        });
        btn_dec1 = findViewById(R.id.button11dec);
        et_number1 = findViewById(R.id.editTextText1weight);
        btn_dec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y = Integer.parseInt(et_number1.getText().toString());
                y -= 1;
                et_number1.setText(y+"");
            }
        });
        button_increment1 = findViewById(R.id.incLength);
        edit_number1 = findViewById(R.id.edit_txtcomplete);
        button_increment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int z = Integer.parseInt(edit_number1.getText().toString());
                z += 1;
                edit_number1.setText(z+"");
            }
        });
        button_decremrement1 = findViewById(R.id.butdecrementlength);
        edit_number1 = findViewById(R.id.edit_txtcomplete);
        button_decremrement1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int k = Integer.parseInt(edit_number1.getText().toString());
                k -= 1;
                edit_number1.setText(k+"");
            }
        });
    }
}