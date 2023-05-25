package com.example.finals;

import android.content.Intent;

import java.util.ArrayList;

public class OrderItem {
    float totalPrice;
    String mealName;
    String username;
    public float itemPrice;
    ArrayList<SubItem> subitems = new ArrayList<>();

    public OrderItem(String mealName) {
        this.mealName = mealName;
    }

    public OrderItem(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public OrderItem(String mealName, float itemPrice) {
        this.itemPrice = itemPrice;
        this.mealName = mealName;
    }
}

