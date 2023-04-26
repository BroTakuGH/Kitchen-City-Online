package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class adminui extends AppCompatActivity {

    BottomNavigationView nav4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.admin);

        nav4 = findViewById(R.id.nav_bar4);

        nav4.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.shoppingCart:
                        Intent intent=new Intent(adminui.this,pendingOrders.class);
                        startActivity(intent);
                        break;

                    case R.id.logout:
                        Intent intent2=new Intent(adminui.this,MainActivity2.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });


    }
}