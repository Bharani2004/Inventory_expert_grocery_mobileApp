package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class item extends AppCompatActivity {

    Button b2, b3, b4, b5, b6, b7,b13;
    TextView t1,t8,t3,t9;
    int quantity=0;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart, menu);

        MenuItem menuItem = menu.findItem(R.id.cart);
        View actionView = menuItem.getActionView();
        TextView cartBadge = actionView.findViewById(R.id.cartbadge);
        if (quantity > 0) {
            cartBadge.setText(String.valueOf(quantity));
        } else {
            cartBadge.setText("0");
        }

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.i1) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b13=findViewById(R.id.b13);
        t1=findViewById(R.id.t1);
        t8=findViewById(R.id.t8);
        t3=findViewById(R.id.t3);
        t9=findViewById(R.id.t9);

        Bundle b1 = getIntent().getExtras();
        String username= b1.getString("name");




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                String bagname=t1.getText().toString();
                String bagp= t8.getText().toString();
                b.putInt("imageid", R.drawable.bag);
                b.putString("bag",bagname);
                b.putString("bagp",bagp);
                b.putString("name",username);
                Intent intent1 = new Intent(item.this, order.class);
                intent1.putExtras(b);
                startActivity(intent1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                String bagname=t3.getText().toString();
                String bagp= t9.getText().toString();
                b.putInt("imageid", R.drawable.phone);
                b.putString("bag",bagname);
                b.putString("bagp",bagp);
                b.putString("name",username);
                Intent intent1 = new Intent(item.this, order.class);
                intent1.putExtras(b);
                startActivity(intent1);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(item.this, review.class);
                startActivity(intent1);
            }
        });


        }
    }
