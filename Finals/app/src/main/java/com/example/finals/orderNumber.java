package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class orderNumber extends AppCompatActivity {

    TextView textView;
    TextView orderNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_number);
        orderNumber = findViewById(R.id.textView3);
        textView = findViewById(R.id.xButton);
        orderNumber.setText(OrderManager.GetInstance().randomNumber);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(orderNumber.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}