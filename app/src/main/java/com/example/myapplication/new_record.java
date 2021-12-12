package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class new_record extends AppCompatActivity {
    Button btn_inc,btn_dec, button_increment, button_decremrement;
    EditText et_number, edit_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        btn_inc = findViewById(R.id.buttinc222);
        et_number = findViewById(R.id.editTextText22);
        btn_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(et_number.getText().toString());
                x += 1;
                et_number.setText(x+"");
            }
        });
        btn_dec = findViewById(R.id.butdec2);
        et_number = findViewById(R.id.editTextText22);
        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y = Integer.parseInt(et_number.getText().toString());
                y -= 1;
                et_number.setText(y+"");
            }
        });
        button_increment = findViewById(R.id.buttinc2newrecord);
        edit_number = findViewById(R.id.editTextText2newrecord);
        button_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int z = Integer.parseInt(edit_number.getText().toString());
                z += 1;
                edit_number.setText(z+"");
            }
        });
        button_decremrement = findViewById(R.id.buttondecrement22);
        edit_number = findViewById(R.id.editTextText2newrecord);
        button_decremrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int k = Integer.parseInt(edit_number.getText().toString());
                k -= 1;
                edit_number.setText(k+"");
            }
        });
    }
}