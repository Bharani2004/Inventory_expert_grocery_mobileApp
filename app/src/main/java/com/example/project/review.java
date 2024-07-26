package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class review extends AppCompatActivity {
    ListView simpleList;
    String item[] = {"Laptop Bag : Sleek", "Phone : Techy", "Watch : Timeless", "Lamp : Radiant", "Waterbottle : Hydrate", "Junction box : Connect", "Chair :Comfort "};
    int img[] = {R.drawable.bag, R.drawable.phone, R.drawable.watch, R.drawable.lamp, R.drawable.bottle, R.drawable.box, R.drawable.chair};
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewlist);
        simpleList = this.<ListView>findViewById(R.id.l1);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), item, img);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        b1=findViewById(R.id.b);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(review.this,item.class);
                startActivity(intent);
            }
        });
    }
}

