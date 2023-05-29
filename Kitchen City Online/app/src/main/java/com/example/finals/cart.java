package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class cart extends AppCompatActivity {

    BottomNavigationView nav2;

    TextView totalAmount;

    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
        nav2 = findViewById(R.id.bottom_navigation);
        String costumerOrder [] = {};
        String orders2 = OrderManager.GetInstance().listViewContent;

        nav2.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_home:
                        Intent intent=new Intent(cart.this,RealMainCostumer.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_logout:
                        Intent intent2=new Intent(cart.this,MainActivity2.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });

        Button button = findViewById(R.id.payOrder);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String orderss = "";
//                String drinks = "";
//                String ha[];
//                List<String> your_array_list = new ArrayList<String>();
                String array[] = {"burat","burat2"};


//                HashMap<String, String> nameAddresses = new HashMap<>();
//                nameAddresses.put("lmFAO", "lmfao");


                String drinks = "";
                for (OrderItem item : OrderManager.GetInstance().orders) {

                    for (SubItem sub_item : item.subitems) {
                        drinks += sub_item.subitemName + "+1" + " ";
                    }
                    orderss += item.mealName + " ";


                }
                Random random = new Random();
                int randomNumber = random.nextInt(1000);
                OrderManager.GetInstance().randomNumber = Integer.toString(randomNumber);
                databaseReference.child("Orders").child(OrderManager.GetInstance().randomNumber).child("user").setValue(OrderManager.GetInstance().username);
                databaseReference.child("Orders").child(OrderManager.GetInstance().randomNumber).child("orders").setValue(orderss);
                databaseReference.child("Orders").child(OrderManager.GetInstance().randomNumber).child("drinks").setValue(drinks);
                databaseReference.child("Orders").child(OrderManager.GetInstance().randomNumber).child("extraRice").setValue(OrderManager.GetInstance().extraRice);
                databaseReference.child("Orders").child(OrderManager.GetInstance().randomNumber).child("orderNumber").setValue(OrderManager.GetInstance().randomNumber);

                Intent intent=new Intent(cart.this,orderNumber.class);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.resultsListView);

        List<String> your_array = new ArrayList<String>();
        for (OrderItem item : OrderManager.GetInstance().orders) {
            String subitemsStr = "";
            for (SubItem sub_item : item.subitems) {
                subitemsStr += sub_item.subitemName + "+1";
            }
            your_array.add(item.mealName + " ₱" + item.itemPrice + "\n" + subitemsStr + "\n" +  OrderManager.GetInstance().extraRiceDisplay);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (cart.this, R.layout.activity_list_view,R.id.listviewtext, your_array);
        listView.setAdapter(arrayAdapter);
        totalAmount = findViewById(R.id.totalPrice);


        totalAmount.setText(String.valueOf(OrderManager.GetInstance().totalPrice));
    }
}