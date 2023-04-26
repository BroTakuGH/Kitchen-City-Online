package com.example.finals;

public class OrderItem extends order{
    float totalPrice;

    public void SetPrice(float getTotalPrice){
        this.totalPrice = getTotalPrice;
    }

    public float GetPrice(){
        return totalPrice;
    }
}
