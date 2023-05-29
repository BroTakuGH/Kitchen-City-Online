package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.finals.databinding.ActivityFragmentBinding;
import com.example.finals.databinding.ActivityNewMainUserBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class
newMainUser extends AppCompatActivity {


    ActivityNewMainUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewMainUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new NewCostumerUI());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.nav_home:
                    replaceFragment(new NewCostumerUI());
                    break;
                case R.id.nav_cart:
                    replaceFragment(new cartFragment());
                    break;
                case R.id.nav_logout:
                    replaceFragment(new CostumerFragment());
                    break;

            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}