package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class pendingOrders extends AppCompatActivity {

    BottomNavigationView nav3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);


        nav3 = findViewById(R.id.nav_bar3);

        nav3.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        Intent intent=new Intent(pendingOrders.this,adminui.class);
                        startActivity(intent);
                        break;

                    case R.id.logout:
                        Intent intent2=new Intent(pendingOrders.this,MainActivity2.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });

    }
}