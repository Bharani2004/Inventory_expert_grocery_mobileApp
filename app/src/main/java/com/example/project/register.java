package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class register extends AppCompatActivity {

    Button b1;
    SharedPreferences sp;
    String n,p;
    EditText name,password;

    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_PASSWORD="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=findViewById(R.id.btn1);
        name=findViewById(R.id.e1);
        password=findViewById(R.id.e2);


        sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=name.getText().toString().trim();
                p=password.getText().toString().trim();

                SharedPreferences.Editor editor =sp.edit();
                editor.putString(KEY_NAME, n);
                editor.putString(KEY_PASSWORD, p);
                editor.commit();


                db d = new db(register.this);
                String res = d.addUser(name.getText().toString().trim(), password.getText().toString().trim());
                Toast.makeText(register.this,res, Toast.LENGTH_LONG).show();

                name.setText("");
                password.setText("");

                Intent intent = new Intent(register.this, Login.class);
                startActivity(intent);

                //d.addRecord("AK"); since we are fetching from user
                String data = d.addUser(name.getText().toString(),password.getText().toString());


            }
        });


    }
}