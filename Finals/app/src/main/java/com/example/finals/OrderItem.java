package com.example.finals;

import android.content.Intent;

public class OrderItem extends order{
    float totalPrice;

    public void SetPrice(float getTotalPrice){
        this.totalPrice = getTotalPrice;
    }

    public float GetPrice(){
        return totalPrice;
    }



}
