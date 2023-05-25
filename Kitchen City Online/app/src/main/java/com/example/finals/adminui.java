package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class adminui extends AppCompatActivity {
    TextView itemEdit1;
    TextView itemEdit2;
    TextView itemEdit3;
    TextView itemEdit4;
    TextView itemEdit5;
    TextView itemEdit6;
    String id;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
    TextView item1Name;
    TextView item2Name;
    TextView item3Name;
    TextView item4Name;
    TextView item5Name;
    TextView item6Name;

    TextView item1Price;
    TextView item2Price;
    TextView item3Price;
    TextView item4Price;
    TextView item5Price;
    TextView item6Price;

    TextView adminRefresh;

    String itemName1;
    String itemName2;
    String itemName3;
    String itemName4;
    String itemName5;
    String itemName6;

    String itemPrice1;
    String itemPrice2;
    String itemPrice3;
    String itemPrice4;
    String itemPrice5;
    String itemPrice6;



    BottomNavigationView nav4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.admin);

        itemEdit1 = (TextView) findViewById(R.id.itemEdit1);
        itemEdit2 = (TextView) findViewById(R.id.itemEdit2);
        itemEdit3 = (TextView) findViewById(R.id.itemEdit3);
        itemEdit4 = (TextView) findViewById(R.id.itemEdit4);
        itemEdit5 = (TextView) findViewById(R.id.itemEdit5);
        itemEdit6 = (TextView) findViewById(R.id.itemEdit6);

        item1Name = (TextView) findViewById(R.id.Item1Name);
        item2Name = (TextView) findViewById(R.id.Item2Name);
        item3Name = (TextView) findViewById(R.id.Item3Name);
        item4Name = (TextView) findViewById(R.id.Item4Name);
        item5Name = (TextView) findViewById(R.id.Item5Name);
        item6Name = (TextView) findViewById(R.id.Item6Name);

        item1Price = (TextView) findViewById(R.id.Item1price);
        item2Price = (TextView) findViewById(R.id.Item2Price);
        item3Price = (TextView) findViewById(R.id.Item3Price);
        item4Price = (TextView) findViewById(R.id.Item4Price);
        item5Price = (TextView) findViewById(R.id.Item5Price);
        item6Price = (TextView) findViewById(R.id.Item6Price);

        adminRefresh = findViewById(R.id.AdminRefresh);

        databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                itemName1 = snapshot.child("1").child("caption").getValue(String.class);
                itemName2 = snapshot.child("2").child("caption").getValue(String.class);
                itemName3 = snapshot.child("3").child("caption").getValue(String.class);
                itemName4 = snapshot.child("4").child("caption").getValue(String.class);
                itemName5 = snapshot.child("5").child("caption").getValue(String.class);
                itemName6 = snapshot.child("6").child("caption").getValue(String.class);

                itemPrice1 = snapshot.child("1").child("price").getValue(String.class);
                itemPrice2 = snapshot.child("2").child("price").getValue(String.class);
                itemPrice3 = snapshot.child("3").child("price").getValue(String.class);
                itemPrice4 = snapshot.child("4").child("price").getValue(String.class);
                itemPrice5 = snapshot.child("5").child("price").getValue(String.class);
                itemPrice6 = snapshot.child("6").child("price").getValue(String.class);


                item1Name.setText(itemName1);
                item2Name.setText(itemName2);
                item3Name.setText(itemName3);
                item4Name.setText(itemName4);
                item5Name.setText(itemName5);
                item6Name.setText(itemName6);

                item1Price.setText("₱"+itemPrice1);
                item2Price.setText("₱"+itemPrice2);
                item3Price.setText("₱"+itemPrice3);
                item4Price.setText("₱"+itemPrice4);
                item5Price.setText("₱"+itemPrice5);
                item6Price.setText("₱"+itemPrice6);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        adminRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item1Name.setText(itemName1);
                item2Name.setText(itemName2);
                item3Name.setText(itemName3);
                item4Name.setText(itemName4);
                item5Name.setText(itemName5);
                item6Name.setText(itemName6);

                item1Price.setText("₱"+itemPrice1);
                item2Price.setText("₱"+itemPrice2);
                item3Price.setText("₱"+itemPrice3);
                item4Price.setText("₱"+itemPrice4);
                item5Price.setText("₱"+itemPrice5);
                item6Price.setText("₱"+itemPrice6);
            }
        });

        itemEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        id = "1";
                Intent intent=new Intent(com.example.finals.adminui.this,MainActivity4.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        itemEdit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "2";
                Intent intent=new Intent(com.example.finals.adminui.this,MainActivity4.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        itemEdit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "3";
                Intent intent=new Intent(com.example.finals.adminui.this,MainActivity4.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        itemEdit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "4";
                Intent intent=new Intent(com.example.finals.adminui.this,MainActivity4.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        itemEdit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "5";
                Intent intent=new Intent(com.example.finals.adminui.this,MainActivity4.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        itemEdit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "6";
                Intent intent=new Intent(com.example.finals.adminui.this,MainActivity4.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        nav4 = findViewById(R.id.nav_bar4);

        nav4.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.shoppingCart:
                        Intent intent=new Intent(adminui.this,pendingOrders.class);
                        startActivity(intent);
                        break;

                    case R.id.logout:
                        Intent intent2=new Intent(adminui.this,MainActivity2.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });


    }
}