package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class cart extends AppCompatActivity {

    BottomNavigationView nav2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        nav2 = findViewById(R.id.nav_bar2);

        nav2.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        Intent intent=new Intent(cart.this,costumerUI.class);
                        startActivity(intent);
                        break;

                    case R.id.logout:
                        Intent intent2=new Intent(cart.this,MainActivity2.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });



    }
}