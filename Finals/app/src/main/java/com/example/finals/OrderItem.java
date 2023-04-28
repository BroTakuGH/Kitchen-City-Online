package com.example.finals;

import android.content.Intent;

public class OrderItem {
    float totalPrice;
    String mealName;
    String username;
    float itemPrice;

//    public OrderItem() {
//
//    }
//
    public OrderItem(String mealName) {
        this.mealName = mealName;
    }
    public OrderItem(float itemPrice) {
        this.itemPrice = itemPrice;
    }


//
//    public void SetName(String mealName){
//        this.mealName = mealName;
//    }
//
//    public String GetMealName(){
//        return mealName;
//    }
//
//    public String GetUserName(){
//        return username;
//    }
}
