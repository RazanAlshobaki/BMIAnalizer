package com.example.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
public class signup extends AppCompatActivity {
    Button Log_In;
    EditText name,email,password,rePassword;
    Button CREATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Log_In = (Button)findViewById(R.id.btn_log);
        name=(EditText )findViewById(R.id.txt_name);
        email=(EditText )findViewById(R.id.txt_email);
        password=(EditText )findViewById(R.id.txt_password);
        rePassword=(EditText )findViewById(R.id.txt_repass);
        CREATE=(Button )findViewById(R.id.btn_create);

        Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create your Intent Here
                Intent i = new Intent(signup.this,LogIn.class);
                startActivity(i);
                Intent ii = new Intent(signup.this,complete_profile.class);
                startActivity(ii);
            }
        });




    }
}