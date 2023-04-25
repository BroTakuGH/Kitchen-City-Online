package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class order extends AppCompatActivity {
private ImageView itemView;
private TextView priceView;
String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.order);

   itemView =  findViewById(R.id.ItemView);
   priceView = findViewById(R.id.PriceView);
    price = (getIntent().getStringExtra("priceo"));

    Glide.with(this).load(getIntent().getStringExtra("imageo"))
            .into(itemView);
    priceView.setText(price);


    }
}