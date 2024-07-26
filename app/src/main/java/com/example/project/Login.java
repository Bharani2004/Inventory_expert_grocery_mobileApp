package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    Button b;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item1)
        {
            Intent intent = new Intent(this,help.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText e1,e2;
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b=findViewById(R.id.btn1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredName = e1.getText().toString().trim();
                String enteredPassword = e2.getText().toString().trim();

                db d = new db(Login.this);
                String storedPassword = d.getUserPassword(enteredName);
                if(storedPassword !=null && storedPassword.equals((enteredPassword)))
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", enteredName);
                    Intent intent = new Intent(Login.this, item.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}