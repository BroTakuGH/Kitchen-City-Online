package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class costumerUI extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    BottomNavigationView nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.costumerui);

        setContentView(R.layout.costumerui);
        nav = findViewById(R.id.nav_bar);

        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){

                        case R.id.shoppingCart:
                            Intent intent=new Intent(costumerUI.this,cart.class);
                            startActivity(intent);
                            break;

                        case R.id.logout:
                            Intent intent2=new Intent(costumerUI.this,MainActivity2.class);
                            startActivity(intent2);
                            break;

                    }

                return false;
            }
        });


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

                Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                startActivity(intent);

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

