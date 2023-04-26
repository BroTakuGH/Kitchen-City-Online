package com.example.finals;

import java.sql.Array;
import java.util.ArrayList;

public class OrderManager extends OrderItem {
    private static volatile OrderManager _Instance;
    public static OrderManager GetInstance() {
        if (_Instance == null) {
            synchronized (OrderManager.class) {
                if (_Instance == null) {
                    _Instance = new OrderManager();
                }
            }
        }

        return _Instance;
    }

    public String username;

    public ArrayList<OrderItem> orders = new ArrayList<OrderItem>();

    public void SetPrice(float getTotalPrice){
        this.totalPrice = getTotalPrice;
    }

    public float GetPrice(){
        return totalPrice;
    }


}
