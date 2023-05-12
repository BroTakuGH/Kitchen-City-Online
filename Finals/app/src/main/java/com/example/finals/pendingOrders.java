package com.example.finals;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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


    String OrderID;
    String OrderID2;
    ListView listView;
    BottomNavigationView nav3;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
        listView = (ListView) findViewById(R.id.AdminList1);
        nav3 = findViewById(R.id.nav_bar3);

        List<String> your_array = new ArrayList<String>();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {

                String selectedItem = (String) adapterView.getItemAtPosition(index);
                your_array.remove(index);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                        (pendingOrders.this, R.layout.adminlistviewdisplay,R.id.Adminlistdisplay, your_array);
                listView.setAdapter(arrayAdapter);
            }
        });

//listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        yourarray.remove(i)
//    }
//});

        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        OrderID = snapshot.child("2021sha01116").child("ID NUMBER").getValue(String.class);
                        UserName = snapshot.child("2021sha01116").child("UserName").getValue(String.class);
                        Orders = snapshot.child("2021sha01116").child("orders").getValue(String.class);
                        Extra_Rice = snapshot.child("2021sha01116").child("extraRice").getValue(int.class);
                        Drinks = snapshot.child("2021sha01116").child("drinks").getValue(String.class);

                        OrderID2 = snapshot.child("2021sha01129").child("ID NUMBER").getValue(String.class);
                        UserName1 = snapshot.child("2021sha01129").child("UserName").getValue(String.class);
                        Orders1 = snapshot.child("2021sha01129").child("orders").getValue(String.class);
                        Extra_Rice1 = snapshot.child("2021sha01129").child("extraRice").getValue(int.class);
                        Drinks1 = snapshot.child("2021sha01129").child("drinks").getValue(String.class);
                        your_array.add("Order Number: "+OrderID2+"\n"+UserName1+"\n"+Orders1+"\n"+"Extra Rice: "+Extra_Rice1+"\n"+Drinks1);
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                                (pendingOrders.this, R.layout.adminlistviewdisplay,R.id.Adminlistdisplay, your_array);
                        listView.setAdapter(arrayAdapter);
                        swipeRefreshLayout.setRefreshing(false);
                        //String NewRice = Extra_Rice.toString;




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                your_array.add("Order Number: "+OrderID+"\n"+UserName+"\n"+Orders+"\n"+"Extra Rice: "+Extra_Rice+"\n"+Drinks);

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