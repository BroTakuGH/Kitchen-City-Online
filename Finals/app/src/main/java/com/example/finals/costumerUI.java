package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class costumerUI extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.costumerui);

        ImageView firstMenu = findViewById(R.id.firstMenu);
        ImageView secondMenu = findViewById(R.id.secondMenu);
        ImageView thirdMenu = findViewById(R.id.thirdMenu);
        ImageView fourthMenu = findViewById(R.id.fourthMenu);
        ImageView fifthMenu = findViewById(R.id.fifthMenu);
        ImageView sixthMenu = findViewById(R.id.sixthMenu);

        //first
        firstMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //String imageURL = databaseReference.child("Images").child("1").child("imageURL").toString();

                //System.out.println(imageURL);
                //Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                //intent.putExtra("image@#",imageURL);
                //startActivity(intent);
            }

        });
        //second
        secondMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(com.example.finals.costumerUI.this,costumerUI.class);
                startActivity(intent);

            }

        });
        //third
        thirdMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(com.example.finals.costumerUI.this,MainActivity2.class);
                startActivity(intent);

            }

        });
        //fourth
        fourthMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(com.example.finals.costumerUI.this,MainActivity2.class);
                startActivity(intent);

            }

        });

        fifthMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(com.example.finals.costumerUI.this,MainActivity2.class);
                startActivity(intent);

            }

        });

        sixthMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(com.example.finals.costumerUI.this,MainActivity2.class);
                startActivity(intent);

            }

        });

        };
    }

