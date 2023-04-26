package com.example.finals;

import android.content.Intent;

public class OrderItem extends order{
    float totalPrice;
    String mealName;
    String username;

    public OrderItem() {

    }

    public OrderItem(float totalPrice, String mealName, String username) {
        this.mealName = mealName;
        this.totalPrice = totalPrice;
        this.username = username;
    }

    public void SetPrice(float getTotalPrice){
        this.totalPrice = getTotalPrice;
    }

    public float GetPrice(){
        return totalPrice;
    }

    public void SetName(String mealName){
        this.mealName = mealName;
    }

    public String GetMealName(){
        return mealName;
    }

    public String GetUserName(){
        return username;
    }
}
