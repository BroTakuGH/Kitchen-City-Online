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

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cart extends AppCompatActivity {

    BottomNavigationView nav2;



    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
        nav2 = findViewById(R.id.nav_bar2);
        String costumerOrder [] = {};
        String orders2 = OrderManager.GetInstance().listViewContent;
        nav2.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        Intent intent=new Intent(cart.this,costumerUI.class);
                        startActivity(intent);
                        break;

                    case R.id.logout:
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
                String ha[];
//                List<String> your_array_list = new ArrayList<String>();
                String array[] = {"burat","burat2"};

                 listView = (ListView) findViewById(R.id.resultsListView);

                List<String> your_array = new ArrayList<String>();
                for (OrderItem item : OrderManager.GetInstance().orders) {
                    your_array.add(item.mealName + " ₱" + OrderManager.GetInstance().itemPrice + "\n" +
                            OrderManager.GetInstance().extraRice + "\n" + OrderManager.GetInstance().drinks +
                            "\n" + "==========");
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                        (cart.this, R.layout.activity_list_view,R.id.listviewtext, your_array);
                listView.setAdapter(arrayAdapter);
//                HashMap<String, String> nameAddresses = new HashMap<>();
//                nameAddresses.put("lmFAO", "lmfao");



                for (OrderItem item : OrderManager.GetInstance().orders) {
                    orderss += item.mealName;

                }

                //databaseReference.child("Users").child(OrderManager.GetInstance().username).child("orders").setValue(orderss);

            }
        });


    }
}