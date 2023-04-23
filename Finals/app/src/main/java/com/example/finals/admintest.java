package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.finals.databinding.ActivityMainBinding;

public class admintest extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admintest);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView();
    }
}