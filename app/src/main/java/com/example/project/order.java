package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class order extends AppCompatActivity {
ImageView i1;
TextView n,p,total,q,t4;
Button i,d,back,place,cart;
int quantity = 1;
int pricePerItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Bundle b1 = getIntent().getExtras();
        String username= b1.getString("name");

        i1 = findViewById(R.id.img);
        q=findViewById(R.id.t7);
        n = findViewById(R.id.n);
        p=findViewById(R.id.p);
        i=findViewById(R.id.i);
        d=findViewById(R.id.d);
        total=findViewById(R.id.t4);
        back=findViewById(R.id.back);
        cart=findViewById(R.id.cart);
        q.setText(String.valueOf(quantity));

        Bundle r = getIntent().getExtras();
        int image = r.getInt("imageid");
        String name = r.getString("bag");
        String price = r.getString("bagp");
        if (r != null) {
            int imageId = r.getInt("imageid");
            String nameId = r.getString("bag");
            String bagp= r.getString("bagp");
            // Set the image resource for the ImageView
            i1.setImageResource(image);
            n.setText(name);
            p.setText(price);

            pricePerItem=Integer.parseInt(price);
        }
        else
        {
            quantity=0;
            updateTotal();
        }



        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                updateTotal();
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity>1)
                {
                    quantity--;
                }
                updateTotal();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(order.this, item.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                String t=total.getText().toString();
                b.putString("total",t);
                b.putString("name",username);
                Intent intent1 = new Intent(order.this, payment.class);
                intent1.putExtras(b);
                startActivity(intent1);
            }
        });

    }
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

        return super.onOptionsItemSelected(item);

    }

    private void updateTotal() {
        int cal = quantity*pricePerItem;
        total.setText(String.valueOf(cal));
        q.setText(String.valueOf(quantity));

    }

}