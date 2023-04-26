package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class order extends AppCompatActivity {
    private ImageView itemView;

    private int extraRice;
    private int royal;
    private int coke;
    private int sprite;
    private int priceExtraRice;
    private int priceRoyal;
    private int priceCoke;
    private int priceSprite;

    private int order1;
    private int order2;
    private int order3;
    private int order4;
    private int order5;
    private int order6;

    public int totalPrice;

    private CheckBox checkBoxVisibilityExtraRice;
    private CheckBox checkBoxVisibilityRoyal;
    private CheckBox checkBoxVisibilityCoke;
    private CheckBox checkBoxVisibilitySprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        checkBoxVisibilityExtraRice = findViewById(R.id.extraRiceCheckbox);
        checkBoxVisibilityRoyal = findViewById(R.id.royalCheckBox);
        checkBoxVisibilityCoke = findViewById(R.id.cokeCheckBox);
        checkBoxVisibilitySprite = findViewById(R.id.spriteCheckBox);

//        boolean extraRiceIsChecked = checkBoxVisibilityExtraRice.isChecked();
//        boolean royalIsChecked = checkBoxVisibilityRoyal.isChecked();
//        boolean cokeIsChecked = checkBoxVisibilityCoke.isChecked();
//        boolean spriteIsCheck = checkBoxVisibilitySprite.isChecked();

            checkBoxVisibilityExtraRice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    extraRice += 1;
                    System.out.println("Extra Rice:" + extraRice);
                }
                else {
                    extraRice = 0;
                    System.out.println("Extra Rice:" + extraRice);
                }
                }
            });
        checkBoxVisibilityRoyal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    royal += 1;
                    System.out.println("Royal:" + royal);
                    checkBoxVisibilityCoke.setChecked(false);
                    checkBoxVisibilitySprite.setChecked(false);
                }
                else {
                    royal = 0;
                    System.out.println("Royal" + royal);
                }
            }
        });
        checkBoxVisibilityCoke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    coke += 1;
                    System.out.println("Coke:" + coke);
                    checkBoxVisibilityRoyal.setChecked(false);
                    checkBoxVisibilitySprite.setChecked(false);
                }
                else {
                    coke = 0;
                    System.out.println("coke:" + coke);
                }
            }
        });
        checkBoxVisibilitySprite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    sprite += 1;
                    System.out.println("sprite:" + sprite);
                    checkBoxVisibilityCoke.setChecked(false);
                    checkBoxVisibilityRoyal.setChecked(false);
                }
                else {
                    sprite = 0;
                    System.out.println("sprite:" + sprite);
                }
            }
        });


   itemView =  findViewById(R.id.ItemView);
   priceView = findViewById(R.id.PriceView);
    price = (getIntent().getStringExtra("priceo"));

    Glide.with(this).load(getIntent().getStringExtra("imageo"))
            .into(itemView);
    priceView.setText(price);


    }

}