package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class report extends AppCompatActivity {
    TextView t1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        t1 = findViewById(R.id.t1);
        b1=findViewById(R.id.b);

        t1.setSelected(true);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(report.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}