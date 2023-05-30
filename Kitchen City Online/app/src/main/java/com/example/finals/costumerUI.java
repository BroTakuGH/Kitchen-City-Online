package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
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
    String imageURLDisplay2;
    String imageURLDisplay3;
    String imageURLDisplay4;
    String imageURLDisplay5;
    String imageURLDisplay6;
    String Price;
    String PriceDisplay1;
    String PriceDisplay2;
    String PriceDisplay3;
    String PriceDisplay4;
    String PriceDisplay5;
    String PriceDisplay6;
    BottomNavigationView nav;

    String CaptionDisplay1;
    String CaptionDisplay2;
    String CaptionDisplay3;
    String CaptionDisplay4;
    String CaptionDisplay5;
    String CaptionDisplay6;
    Button Refresh;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.costumerui);
        //Declaration

        setContentView(R.layout.costumerui);
        nav = findViewById(R.id.bottom_navigation);


        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){

                        case R.id.nav_cart:
                            Intent intent=new Intent(costumerUI.this,cart.class);
                            startActivity(intent);
                            break;

                        case R.id.nav_logout:
                            Intent intent2=new Intent(costumerUI.this,MainActivity2.class);
                            startActivity(intent2);
                            break;

                    }

                return false;
            }
        });


        ImageView firstMenu = findViewById(R.id.firstMenu);
        TextView firstPrice = findViewById(R.id.firstPrice);
        ImageView secondMenu = findViewById(R.id.secondMenu);
        TextView secondPrice = findViewById(R.id.secondPrice);
        ImageView thirdMenu = findViewById(R.id.thirdMenu);
        TextView thirdPrice = findViewById(R.id.thirdPrice);
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
        

        databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PriceDisplay1 = snapshot.child("1").child("price").getValue(String.class);
                imageURLDisplay1 = snapshot.child("1").child("imageURL").getValue(String.class);
                CaptionDisplay1 = snapshot.child("1").child("caption").getValue(String.class);

                PriceDisplay2 = snapshot.child("2").child("price").getValue(String.class);
                imageURLDisplay2 = snapshot.child("2").child("imageURL").getValue(String.class);
                CaptionDisplay2 = snapshot.child("2").child("caption").getValue(String.class);

                PriceDisplay3 = snapshot.child("3").child("price").getValue(String.class);
                imageURLDisplay3 = snapshot.child("3").child("imageURL").getValue(String.class);
                CaptionDisplay3 = snapshot.child("3").child("caption").getValue(String.class);

                PriceDisplay4 = snapshot.child("4").child("price").getValue(String.class);
                imageURLDisplay4 = snapshot.child("4").child("imageURL").getValue(String.class);
                CaptionDisplay4 = snapshot.child("4").child("caption").getValue(String.class);

                PriceDisplay5 = snapshot.child("5").child("price").getValue(String.class);
                imageURLDisplay5 = snapshot.child("5").child("imageURL").getValue(String.class);
                CaptionDisplay5 = snapshot.child("5").child("caption").getValue(String.class);

                PriceDisplay6 = snapshot.child("6").child("price").getValue(String.class);
                imageURLDisplay6 = snapshot.child("6").child("imageURL").getValue(String.class);
                CaptionDisplay6 = snapshot.child("6").child("caption").getValue(String.class);

                Glide.with(costumerUI.this).load(imageURLDisplay1).into(firstMenu);
                Glide.with(costumerUI.this).load(imageURLDisplay2).into(secondMenu);
                Glide.with(costumerUI.this).load(imageURLDisplay3).into(thirdMenu);
                Glide.with(costumerUI.this).load(imageURLDisplay4).into(fourthMenu);
                Glide.with(costumerUI.this).load(imageURLDisplay5).into(fifthMenu);
                Glide.with(costumerUI.this).load(imageURLDisplay6).into(sixthMenu);

                firstPrice.setText(PriceDisplay1);
                secondPrice.setText(PriceDisplay2);
                thirdPrice.setText(PriceDisplay3);
                forthPrice.setText(PriceDisplay4);
                fifthPrice.setText(PriceDisplay5);
                sixthPrice.setText(PriceDisplay6);

                caption1.setText(CaptionDisplay1);
                caption2.setText(CaptionDisplay2);
                caption3.setText(CaptionDisplay3);
                caption4.setText(CaptionDisplay4);
                caption5.setText(CaptionDisplay5);
                caption6.setText(CaptionDisplay6);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //Data Declaration


        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        PriceDisplay1 = snapshot.child("1").child("price").getValue(String.class);
                        imageURLDisplay1 = snapshot.child("1").child("imageURL").getValue(String.class);
                        CaptionDisplay1 = snapshot.child("1").child("caption").getValue(String.class);

                        PriceDisplay2 = snapshot.child("2").child("price").getValue(String.class);
                        imageURLDisplay2 = snapshot.child("2").child("imageURL").getValue(String.class);
                        CaptionDisplay2 = snapshot.child("2").child("caption").getValue(String.class);

                        PriceDisplay3 = snapshot.child("3").child("price").getValue(String.class);
                        imageURLDisplay3 = snapshot.child("3").child("imageURL").getValue(String.class);
                        CaptionDisplay3 = snapshot.child("3").child("caption").getValue(String.class);

                        PriceDisplay4 = snapshot.child("4").child("price").getValue(String.class);
                        imageURLDisplay4 = snapshot.child("4").child("imageURL").getValue(String.class);
                        CaptionDisplay4 = snapshot.child("4").child("caption").getValue(String.class);

                        PriceDisplay5 = snapshot.child("5").child("price").getValue(String.class);
                        imageURLDisplay5 = snapshot.child("5").child("imageURL").getValue(String.class);
                        CaptionDisplay5 = snapshot.child("5").child("caption").getValue(String.class);

                        PriceDisplay6 = snapshot.child("6").child("price").getValue(String.class);
                        imageURLDisplay6 = snapshot.child("6").child("imageURL").getValue(String.class);
                        CaptionDisplay6 = snapshot.child("6").child("caption").getValue(String.class);

                        Glide.with(costumerUI.this).load(imageURLDisplay1).into(firstMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay2).into(secondMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay3).into(thirdMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay4).into(fourthMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay5).into(fifthMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay6).into(sixthMenu);

                        firstPrice.setText(PriceDisplay1);
                        secondPrice.setText(PriceDisplay2);
                        thirdPrice.setText(PriceDisplay3);
                        forthPrice.setText(PriceDisplay4);
                        fifthPrice.setText(PriceDisplay5);
                        sixthPrice.setText(PriceDisplay6);

                        caption1.setText(CaptionDisplay1);
                        caption2.setText(CaptionDisplay2);
                        caption3.setText(CaptionDisplay3);
                        caption4.setText(CaptionDisplay4);
                        caption5.setText(CaptionDisplay5);
                        caption6.setText(CaptionDisplay6);

                        Glide.with(costumerUI.this).load(imageURLDisplay1).into(firstMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay2).into(secondMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay3).into(thirdMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay4).into(fourthMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay5).into(fifthMenu);
                        Glide.with(costumerUI.this).load(imageURLDisplay6).into(sixthMenu);

                        firstPrice.setText(PriceDisplay1);
                        secondPrice.setText(PriceDisplay2);
                        thirdPrice.setText(PriceDisplay3);
                        forthPrice.setText(PriceDisplay4);
                        fifthPrice.setText(PriceDisplay5);
                        sixthPrice.setText(PriceDisplay6);

                        caption1.setText(CaptionDisplay1);
                        caption2.setText(CaptionDisplay2);
                        caption3.setText(CaptionDisplay3);
                        caption4.setText(CaptionDisplay4);
                        caption5.setText(CaptionDisplay5);
                        caption6.setText(CaptionDisplay6);
                        swipeRefreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });

//        Refresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Glide.with(costumerUI.this).load(imageURLDisplay1).into(firstMenu);
//                Glide.with(costumerUI.this).load(imageURLDisplay2).into(secondMenu);
//                Glide.with(costumerUI.this).load(imageURLDisplay3).into(thirdMenu);
//                Glide.with(costumerUI.this).load(imageURLDisplay4).into(fourthMenu);
//                Glide.with(costumerUI.this).load(imageURLDisplay5).into(fifthMenu);
//                Glide.with(costumerUI.this).load(imageURLDisplay6).into(sixthMenu);
//
//                firstPrice.setText(PriceDisplay1);
//                secondPrice.setText(PriceDisplay2);
//                thirdPrice.setText(PriceDisplay3);
//                forthPrice.setText(PriceDisplay4);
//                fifthPrice.setText(PriceDisplay5);
//                sixthPrice.setText(PriceDisplay6);
//
//                caption1.setText(CaptionDisplay1);
//                caption2.setText(CaptionDisplay2);
//                caption3.setText(CaptionDisplay3);
//                caption4.setText(CaptionDisplay4);
//                caption5.setText(CaptionDisplay5);
//                caption6.setText(CaptionDisplay6);
//
//            }
//        });



        //End of Costumer Display

        //first
        firstMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

//                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
//                        costumerUI.this, R.style.BottomSheetDialogTheme
//                );
//                View bottomSheetView = LayoutInflater.from(getApplicationContext())
//                        .inflate(
//                                R.layout.activity_layout_bottom_sheet,
//                                (RelativeLayout)findViewById(R.id.bottomSheetContainer)
//                        );
//                bottomSheetDialog.setContentView(bottomSheetView);
//                bottomSheetDialog.show();


                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Price = snapshot.child("1").child("price").getValue(String.class);
                            imageURL = snapshot.child("1").child("imageURL").getValue(String.class);
                            System.out.println(imageURL);
                            Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
//                            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
//                                    costumerUI.this, R.style.BottomSheetDialogTheme
//                            );
//                            View bottomSheetView = LayoutInflater.from(getApplicationContext())
//                                    .inflate(
//                                            R.layout.activity_layout_bottom_sheet,
//                                            (RelativeLayout)findViewById(R.id.bottomSheetContainer)
//                                    );
                            intent.putExtra("captiono",CaptionDisplay1);
                            intent.putExtra("priceo",Price);
                            intent.putExtra("imageo", imageURL);
//                            bottomSheetDialog.setContentView(bottomSheetView);
//                            bottomSheetDialog.show();
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
                        intent.putExtra("captiono",CaptionDisplay2);
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
                    intent.putExtra("captiono",CaptionDisplay3);
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
                        imageURL = snapshot.child("4").child("imageURL").getValue(String.class);
                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                        intent.putExtra("captiono",CaptionDisplay4);
                        intent.putExtra("priceo", Price);
                        intent.putExtra("imageo", imageURL);
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
                        imageURL = snapshot.child("5").child("imageURL").getValue(String.class);
                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                        intent.putExtra("captiono",CaptionDisplay5);
                        intent.putExtra("priceo", Price);
                        intent.putExtra("imageo", imageURL);
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
                    imageURL = snapshot.child("6").child("imageURL").getValue(String.class);
                    Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
                    intent.putExtra("captiono",CaptionDisplay6);
                    intent.putExtra("priceo", Price);
                    intent.putExtra("imageo", imageURL);
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

