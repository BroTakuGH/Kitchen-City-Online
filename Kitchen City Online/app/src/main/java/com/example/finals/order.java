package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
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

public class order extends AppCompatActivity {
    private ImageView itemView;
    TextView caption;
    TextView priceView;
    String price;
    private int extraRice;
    private int royal;
    private int coke;
    private int sprite;

    private String drinks;
    private String extraRice1 = "No Extra Rice";


    private int order1;
    String Caption;

    public float totalPrice;

    private CheckBox checkBoxVisibilityExtraRice;
    private CheckBox checkBoxVisibilityRoyal;
    private CheckBox checkBoxVisibilityCoke;
    private CheckBox checkBoxVisibilitySprite;
    private ArrayList<SubItem> selectedSubItems = new ArrayList<SubItem>();
    AppCompatButton button;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Images");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Caption =(getIntent().getStringExtra("captiono"));

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
                if (compoundButton.isChecked()) {
                    extraRice += 1;
                    totalPrice += 15;
                    System.out.println("Extra Rice:" + extraRice);
                    extraRice1 = "Extra Rice +1";

                } else {
                    extraRice = 0;
                    totalPrice -= 15;
                    System.out.println("Extra Rice:" + extraRice);
                    extraRice1 = "No Extra Rice";
                }


            }
        });
        checkBoxVisibilityRoyal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    royal += 1;
                    totalPrice += 15;
                    System.out.println("Royal:" + royal);
                    checkBoxVisibilityCoke.setChecked(false);
                    checkBoxVisibilitySprite.setChecked(false);
                    drinks = "Royal +1";
                } else {
                    royal = 0;
                    totalPrice -= 15;
                    System.out.println("Royal" + royal);
                    drinks = "No Drinks";
                }
            }
        });
        checkBoxVisibilityCoke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    coke += 1;
                    totalPrice += 15;
                    System.out.println("Coke:" + coke);
                    checkBoxVisibilityRoyal.setChecked(false);
                    checkBoxVisibilitySprite.setChecked(false);
                    drinks = "Coke +1";
                } else {
                    coke = 0;
                    totalPrice -= 15;
                    System.out.println("coke:" + coke);
                    drinks = "No Drinks";
                }
            }
        });
        checkBoxVisibilitySprite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    sprite += 1;
                    totalPrice += 15;
                    System.out.println("sprite:" + sprite);
                    checkBoxVisibilityCoke.setChecked(false);
                    checkBoxVisibilityRoyal.setChecked(false);
                    drinks = "Sprite +1";
                } else {
                    totalPrice -= 15;
                    sprite = 0;
                    System.out.println("sprite:" + sprite);
                    drinks = "No Drinks";
                }
            }
        });

        itemView = findViewById(R.id.ItemView);
        priceView = findViewById(R.id.PriceView);
        price = (getIntent().getStringExtra("priceo"));

        button = findViewById(R.id.addToCartButton);
        caption = findViewById(R.id.caption);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check combo boxes
                if (checkBoxVisibilityCoke.isChecked()) {
                    SubItem sub = new SubItem("Coke", extraRice1);
                    selectedSubItems.add(sub);
                }
                if (checkBoxVisibilityRoyal.isChecked()) {
                    SubItem sub = new SubItem("Royal", extraRice1);
                    selectedSubItems.add(sub);
                }
                if (checkBoxVisibilitySprite.isChecked()) {
                    SubItem sub = new SubItem("Sprite", extraRice1);
                    selectedSubItems.add(sub);
                }


//            String captionText = caption.getText().toString();
//            OrderItem captions = new OrderItem(captionText);
//            OrderManager.GetInstance().orders.add(caption);
//            orderItem.SetPrice(totalPrice);
//            System.out.println(orderItem.GetPrice());
//            caption.setText(String.valueOf(orderItem.GetPrice()));
                totalPrice += Float.valueOf(price);
                String captionText = caption.getText().toString();
                String itemPrice = priceView.getText().toString();
                float itemPrice2 = Float.parseFloat(itemPrice);

                OrderItem order = new OrderItem(captionText, itemPrice2);
                order.subitems = selectedSubItems;

                OrderManager.GetInstance().orders.add(order);
                OrderManager.GetInstance().extraRice += extraRice;
                OrderManager.GetInstance().extraRiceDisplay = extraRice1;
                OrderManager.GetInstance().totalPrice += totalPrice;
//                OrderManager.GetInstance().orders.add(captions);
//                OrderManager.GetInstance().listViewContent += captionText;
//                OrderManager.GetInstance().itemPrice.add(itemPrice3);
//                OrderManager.GetInstance().drinks = drinks;
//                OrderManager.GetInstance().extraRice = extraRice1;
//            OrderManager.GetInstance().listViewContent = "lol";
                System.out.println(OrderManager.GetInstance().totalPrice + "totalprice");
                System.out.println(OrderManager.GetInstance().username);
                for (OrderItem item : OrderManager.GetInstance().orders) {
                    System.out.println(item.mealName);
                }
//            String test = OrderManager.GetInstance().listViewContent;
                System.out.println(OrderManager.GetInstance().listViewContent);
                Intent intent = new Intent(order.this, costumerUI.class);
                startActivity(intent);
                System.out.println(totalPrice + "totalprice2");
            }


        });

        Glide.with(this).load(getIntent().getStringExtra("imageo"))
                .into(itemView);
        priceView.setText(price);
        caption.setText(Caption);


    }

}

