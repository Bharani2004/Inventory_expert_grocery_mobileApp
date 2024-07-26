package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    TextView t6,t4;
    RadioGroup rg;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Bundle b1 = getIntent().getExtras();
        String username1= b1.getString("name");
        t6 = findViewById(R.id.t6);
        t4=findViewById(R.id.t4);
        rg = findViewById(R.id.rg);
        b= findViewById(R.id.b);
        t4.setText(username1);
        Bundle r = getIntent().getExtras();

        if (r != null) {
            String username = r.getString("username");
            if (username != null) {
                t4.setText(username);
            } else {
                // Handle case where username is not found in extras (optional)
                Log.d("payment", "Username not found in intent extras");
            }
            String t = r.getString("total");
            t6.setText(t);
        }

        // Select a default RadioButton
        rg.check(R.id.rb);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb) {
                    Log.d("RadioButton", "Paytm Transaction Completed");
                    Toast.makeText(getApplicationContext(), "Paytm Transaction Completed", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.rbs) {
                    Log.d("RadioButton", "Received Amount");
                    Toast.makeText(getApplicationContext(), "Received Amount", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.rbr) {
                    Log.d("RadioButton", "Transaction Successful");
                    Toast.makeText(getApplicationContext(), "Transaction Successful", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.rbc) {
                    Log.d("RadioButton", "Pay when it's in your palms, not before");
                    Toast.makeText(getApplicationContext(), "Pay when it's in your palms, not before", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = t4.getText().toString();
                String price = t6.getText().toString();
                String pass = ""; // You need to get the password from somewhere

                // Store the user details along with the price in the database
                db d = new db(payment.this);
                String res = d.addUser(name, pass);
                Toast.makeText(payment.this, res, Toast.LENGTH_LONG).show();

                // Proceed to the next activity
                Intent intent = new Intent(payment.this, report.class);
                startActivity(intent);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = t4.getText().toString();
                String price = t6.getText().toString();
                String pass = ""; // You need to get the password from somewhere

                // Store the price value in the database
                db d = new db(payment.this);
                boolean isPriceStored = d.storePrice(price);
                if (isPriceStored) {
                    Toast.makeText(payment.this, "Price stored successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(payment.this, "Failed to store price in the database", Toast.LENGTH_SHORT).show();
                }

                // Proceed to the next activity
                Intent intent = new Intent(payment.this, report.class);
                startActivity(intent);
            }
        });



    }

}