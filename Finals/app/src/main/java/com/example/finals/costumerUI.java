package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class costumerUI extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
    String imageURL ;
    String imageURLDisplay1;
    String[] imageURLDisplay2 = {""};
    String[] imageURLDisplay3 = {""};
    String[] imageURLDisplay4 = {""};
    String[] imageURLDisplay5 = {""};
    String[] imageURLDisplay6 = {""};
    String Price;
    String PriceDisplay1;
    String PriceDisplay2;
    String PriceDisplay3;
    String PriceDisplay4;
    String PriceDisplay5;
    String PriceDisplay6;

    String CaptionDisplay1;
    String CaptionDisplay2;
    String CaptionDisplay3;
    String CaptionDisplay4;
    String CaptionDisplay5;
    String CaptionDisplay6;
    Button Refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.costumerui);
        //Declaration
        ImageView firstMenu = findViewById(R.id.firstMenu);
        TextView firstPrice = findViewById(R.id.firstPrice);
        ImageView secondMenu = findViewById(R.id.secondMenu);
        TextView secondPrice = findViewById(R.id.firstPrice);
        ImageView thirdMenu = findViewById(R.id.thirdMenu);
        TextView thirdPrice = findViewById(R.id.firstPrice);
        ImageView fourthMenu = findViewById(R.id.fourthMenu);
        TextView forthPrice = findViewById(R.id.forthPrice);
        ImageView fifthMenu = findViewById(R.id.fifthMenu);
        TextView fifthPrice = findViewById(R.id.fifthPrice);
        ImageView sixthMenu = findViewById(R.id.sixthMenu);
        TextView sixthPrice = findViewById(R.id.sixthPrice);

        TextView caption1 =  findViewById(R.id.firstCaption);
        TextView caption2 =  findViewById(R.id.secondCaption);
        TextView caption3 =  findViewById(R.id.thirdCaption);
        TextView caption4 =  findViewById(R.id.forthCaption);
        TextView caption5 =  findViewById(R.id.fifthCaption);
        TextView caption6 =  findViewById(R.id.sixthCaption);
        Refresh = findViewById(R.id.RefreshTest);

        databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PriceDisplay1 = snapshot.child("1").child("price").getValue(String.class);
                imageURLDisplay1 = snapshot.child("1").child("imageURL").getValue(String.class);
                CaptionDisplay1 = snapshot.child("1").child("caption").getValue(String.class);

//                PriceDisplay2 = snapshot.child("2").child("price").getValue(String.class);
//                imageURLDisplay2[0] = snapshot.child("2").child("imageURL").getValue(String.class);
//                CaptionDisplay2 = snapshot.child("2").child("caption").getValue(String.class);
//
//                PriceDisplay3 = snapshot.child("3").child("price").getValue(String.class);
//                imageURLDisplay3[0] = snapshot.child("3").child("imageURL").getValue(String.class);
//                CaptionDisplay3 = snapshot.child("3").child("caption").getValue(String.class);
//
//                PriceDisplay4 = snapshot.child("4").child("price").getValue(String.class);
//                imageURLDisplay4[0] = snapshot.child("4").child("imageURL").getValue(String.class);
//                CaptionDisplay4 = snapshot.child("4").child("caption").getValue(String.class);
//
//                PriceDisplay5 = snapshot.child("5").child("price").getValue(String.class);
//                imageURLDisplay5[0] = snapshot.child("5").child("imageURL").getValue(String.class);
//                CaptionDisplay5 = snapshot.child("5").child("caption").getValue(String.class);
//
//                PriceDisplay6 = snapshot.child("6").child("price").getValue(String.class);
//                imageURLDisplay6[0] = snapshot.child("6").child("imageURL").getValue(String.class);
//                CaptionDisplay6 = snapshot.child("6").child("caption").getValue(String.class);
                System.out.println(imageURLDisplay1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //Data Declaration


        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(imageURLDisplay1 + "TESTTTT");
                Glide.with(costumerUI.this).load(imageURLDisplay1).into(firstMenu);
            }
        });
        //Costumer Display
        
//        Glide.with(this).load(imageURLDisplay2).into(secondMenu);
//        Glide.with(this).load(imageURLDisplay3).into(thirdMenu);
//        Glide.with(this).load(imageURLDisplay4).into(fourthMenu);
//        Glide.with(this).load(imageURLDisplay5).into(fifthMenu);
//        Glide.with(this).load(imageURLDisplay6).into(sixthMenu);

        firstPrice.setText(PriceDisplay1);
        secondPrice.setText(PriceDisplay2);
        thirdPrice.setText(PriceDisplay3);
        forthPrice.setText(PriceDisplay4);
        fifthPrice.setText(PriceDisplay5);
        sixthPrice.setText(PriceDisplay6);
        //End of Costumer Display

        //first
        firstMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Price = snapshot.child("1").child("price").getValue(String.class);
                            imageURL = snapshot.child("1").child("imageURL").getValue(String.class);
                            System.out.println(imageURL);
                            Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                            intent.putExtra("priceo",Price);
                            intent.putExtra("imageo", imageURL);
                            startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }

        });
        //second
        secondMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Price = snapshot.child("2").child("price").getValue(String.class);
                        imageURL = snapshot.child("2").child("imageURL").getValue(String.class);
                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                        intent.putExtra("priceo",Price);
                        intent.putExtra("imageo", imageURL);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }

        });
        //third
        thirdMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Price = snapshot.child("3").child("price").getValue(String.class);
                    imageURL = snapshot.child("3").child("imageURL").getValue(String.class);
                    Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                    intent.putExtra("priceo",Price);
                    intent.putExtra("imageo", imageURL);
                    startActivity(intent);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            }

        });
        //fourth
        fourthMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Price = snapshot.child("4").child("price").getValue(String.class);
                        //imageURL[0] = snapshot.child("4").child("imageURL").getValue(String.class);
                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                        intent.putExtra("priceo", Price);
                        //intent.putExtra("imageo", imageURL[0]);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }

        });

        fifthMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Price = snapshot.child("5").child("price").getValue(String.class);
                        //imageURL[0] = snapshot.child("5").child("imageURL").getValue(String.class);
                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                        intent.putExtra("priceo", Price);
                        //intent.putExtra("imageo", imageURL[0]);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }

        });

        sixthMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Price = snapshot.child("6").child("price").getValue(String.class);
                    //imageURL[0] = snapshot.child("6").child("imageURL").getValue(String.class);
                    Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                    intent.putExtra("priceo", Price);
                    //intent.putExtra("imageo", imageURL[0]);
                    startActivity(intent);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            }

        });

        };
    }

