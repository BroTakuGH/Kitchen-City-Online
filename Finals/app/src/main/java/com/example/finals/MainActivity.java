package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String id = OrderManager.GetInstance().username;
        OrderItem o1 = new OrderItem(100, "Bulalo", id);
        OrderItem o2 = new OrderItem(150, "Sinigang", id);
        OrderItem o3 = new OrderItem(200, "Adobo", id);

        OrderManager.GetInstance().orders.add(o1);
        OrderManager.GetInstance().orders.add(o2);
        OrderManager.GetInstance().orders.add(o3);


        for (OrderItem item : OrderManager.GetInstance().orders) {
            System.out.println(item.GetMealName());
            System.out.println(item.GetPrice());
            System.out.println(item.GetUserName());
        }

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        TextView getstarted = findViewById(R.id.textView);
        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }

        });
    }
}