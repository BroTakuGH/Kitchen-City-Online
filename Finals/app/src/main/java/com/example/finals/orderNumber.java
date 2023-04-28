package com.example.finals;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class orderNumber extends AppCompatActivity {

    TextView orderNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_number);
        orderNumber = findViewById(R.id.textView3);
        orderNumber.setText(OrderManager.GetInstance().randomNumber);
    }
}