package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    TextView caption;
    TextView priceView;
    String price;
    private int extraRice;
    private int royal;
    private int coke;
    private int sprite;


    private int order1;


    public int totalPrice;

    private CheckBox checkBoxVisibilityExtraRice;
    private CheckBox checkBoxVisibilityRoyal;
    private CheckBox checkBoxVisibilityCoke;
    private CheckBox checkBoxVisibilitySprite;

    Button button;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Images");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OrderItem orderItem = new OrderItem();
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
                    totalPrice += 15;
                    System.out.println("Extra Rice:" + extraRice);
                }
                else {
                    extraRice = 0;
                    totalPrice -= 15;
                    System.out.println("Extra Rice:" + extraRice);
                }
                }
            });
        checkBoxVisibilityRoyal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    royal += 1;
                    totalPrice += 15;
                    System.out.println("Royal:" + royal);
                    checkBoxVisibilityCoke.setChecked(false);
                    checkBoxVisibilitySprite.setChecked(false);
                }
                else {
                    royal = 0;
                    totalPrice -= 15;
                    System.out.println("Royal" + royal);
                }
            }
        });
        checkBoxVisibilityCoke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    coke += 1;
                    totalPrice += 15;
                    System.out.println("Coke:" + coke);
                    checkBoxVisibilityRoyal.setChecked(false);
                    checkBoxVisibilitySprite.setChecked(false);
                }
                else {
                    coke = 0;
                    totalPrice -= 15;
                    System.out.println("coke:" + coke);
                }
            }
        });
        checkBoxVisibilitySprite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    sprite += 1;
                    totalPrice += 15;
                    System.out.println("sprite:" + sprite);
                    checkBoxVisibilityCoke.setChecked(false);
                    checkBoxVisibilityRoyal.setChecked(false);
                }
                else {
                    totalPrice -= 15;
                    sprite = 0;
                    System.out.println("sprite:" + sprite);
                }
            }
        });


   itemView =  findViewById(R.id.ItemView);
   priceView = findViewById(R.id.PriceView);
    price = (getIntent().getStringExtra("priceo"));

    button = findViewById(R.id.addToCartButton);
    caption = findViewById(R.id.caption);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            totalPrice += Float.parseFloat(price);

            orderItem.SetPrice(totalPrice);
            System.out.println(orderItem.GetPrice());
            caption.setText(String.valueOf(orderItem.GetPrice()));

        }

    });
    Glide.with(this).load(getIntent().getStringExtra("imageo")){
            .into(itemView);
    priceView.setText(price);


    }

}