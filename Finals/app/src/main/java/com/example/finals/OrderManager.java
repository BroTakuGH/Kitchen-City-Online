package com.example.finals;

public class OrderManager extends OrderItem {

    float totalPrice;

    public void SetPrice(float getTotalPrice){
        this.totalPrice = getTotalPrice;
    }

    public float GetPrice(){
        return totalPrice;
    }
    
}
