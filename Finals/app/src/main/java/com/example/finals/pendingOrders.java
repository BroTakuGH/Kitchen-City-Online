package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class pendingOrders extends AppCompatActivity {
    String UserName;

    String UserName1;
    String Orders ;
    String Orders1;
    int Extra_Rice;
    int Extra_Rice1;
    String Drinks;
    String Drinks1;
    ListView listView;
    BottomNavigationView nav3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
        listView = (ListView) findViewById(R.id.AdminList1);
        nav3 = findViewById(R.id.nav_bar3);

        databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserName = snapshot.child("2021sha01116").child("UserName").getValue(String.class);
                Orders = snapshot.child("2021sha01116").child("orders").getValue(String.class);
                Extra_Rice = snapshot.child("2021sha01116").child("extraRice").getValue(int.class);
                Drinks = snapshot.child("2021sha01116").child("drinks").getValue(String.class);

                UserName1 = snapshot.child("2021sha01129").child("UserName").getValue(String.class);
                Orders1 = snapshot.child("2021sha01129").child("orders").getValue(String.class);
                Extra_Rice1 = snapshot.child("2021sha01129").child("extraRice").getValue(int.class);
                Drinks1 = snapshot.child("2021sha01129").child("drinks").getValue(String.class);

                //String NewRice = Extra_Rice.toString;
                List<String> your_array = new ArrayList<String>();
                your_array.add(UserName+"\n"+Orders+"\n"+"Extra Rice:"+Extra_Rice+"\n"+Drinks);

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                        (pendingOrders.this, R.layout.adminlistviewdisplay,R.id.Adminlistdisplay, your_array);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


















        nav3.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        Intent intent=new Intent(pendingOrders.this,adminui.class);
                        startActivity(intent);
                        break;

                    case R.id.logout:
                        Intent intent2=new Intent(pendingOrders.this,MainActivity2.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });

    }
}