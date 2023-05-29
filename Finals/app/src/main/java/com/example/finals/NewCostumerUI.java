package com.example.finals;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewCostumerUI#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewCostumerUI extends Fragment {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
    String imageURL;
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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewCostumerUI() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewCostumerUI.
     */
    // TODO: Rename and change types and number of parameters
    public static NewCostumerUI newInstance(String param1, String param2) {
        NewCostumerUI fragment = new NewCostumerUI();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_costumer_u_i, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Declaration


        nav = getView().findViewById(R.id.nav_bar);


//        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//
//                    case R.id.shoppingCart:
//                        Intent intent=new Intent(NewCostumerUI.this ,cart.class);
//                        startActivity(intent);
//                        break;
//
//                    case R.id.logout:
//                        Intent intent2=new Intent(costumerUI.this,MainActivity2.class);
//                        startActivity(intent2);
//                        break;
//
//                }
//
//                return false;
//            }
//        });


        ImageView firstMenu = getView().findViewById(R.id.firstMenu);
        TextView firstPrice = getView().findViewById(R.id.firstPrice);
        ImageView secondMenu = getView().findViewById(R.id.secondMenu);
        TextView secondPrice = getView().findViewById(R.id.secondPrice);
        ImageView thirdMenu = getView().findViewById(R.id.thirdMenu);
        TextView thirdPrice = getView().findViewById(R.id.thirdPrice);
        ImageView fourthMenu = getView().findViewById(R.id.fourthMenu);
        TextView forthPrice = getView().findViewById(R.id.forthPrice);
        ImageView fifthMenu = getView().findViewById(R.id.fifthMenu);
        TextView fifthPrice = getView().findViewById(R.id.fifthPrice);
        ImageView sixthMenu = getView().findViewById(R.id.sixthMenu);
        TextView sixthPrice = getView().findViewById(R.id.sixthPrice);

        TextView caption1 = getView().findViewById(R.id.firstCaption);
        TextView caption2 = getView().findViewById(R.id.secondCaption);
        TextView caption3 = getView().findViewById(R.id.thirdCaption);
        TextView caption4 = getView().findViewById(R.id.forthCaption);
        TextView caption5 = getView().findViewById(R.id.fifthCaption);
        TextView caption6 = getView().findViewById(R.id.sixthCaption);




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

                Glide.with(NewCostumerUI.this).load(imageURLDisplay1).into(firstMenu);
                Glide.with(NewCostumerUI.this).load(imageURLDisplay2).into(secondMenu);
                Glide.with(NewCostumerUI.this).load(imageURLDisplay3).into(thirdMenu);
                Glide.with(NewCostumerUI.this).load(imageURLDisplay4).into(fourthMenu);
                Glide.with(NewCostumerUI.this).load(imageURLDisplay5).into(fifthMenu);
                Glide.with(NewCostumerUI.this).load(imageURLDisplay6).into(sixthMenu);

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


        swipeRefreshLayout = getView().findViewById(R.id.swipeRefresh);
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

                        Glide.with(NewCostumerUI.this).load(imageURLDisplay1).into(firstMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay2).into(secondMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay3).into(thirdMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay4).into(fourthMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay5).into(fifthMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay6).into(sixthMenu);

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

                        Glide.with(NewCostumerUI.this).load(imageURLDisplay1).into(firstMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay2).into(secondMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay3).into(thirdMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay4).into(fourthMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay5).into(fifthMenu);
                        Glide.with(NewCostumerUI.this).load(imageURLDisplay6).into(sixthMenu);

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
//
//                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        Price = snapshot.child("1").child("price").getValue(String.class);
//                        imageURL = snapshot.child("1").child("imageURL").getValue(String.class);
//                        System.out.println(imageURL);
//                        Intent intent= new Intent( NewCostumerUI.this,order.class);
//                        intent.putExtra("captiono",CaptionDisplay1);
//                        intent.putExtra("priceo",Price);
//                        intent.putExtra("imageo", imageURL);
//                        startActivity(intent);
//                    }

//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


            }

        });

//        //second
//        secondMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        Price = snapshot.child("2").child("price").getValue(String.class);
//                        imageURL = snapshot.child("2").child("imageURL").getValue(String.class);
//                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
//                        intent.putExtra("captiono",CaptionDisplay2);
//                        intent.putExtra("priceo",Price);
//                        intent.putExtra("imageo", imageURL);
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//            }
//
//        });
//        //third
//        thirdMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        Price = snapshot.child("3").child("price").getValue(String.class);
//                        imageURL = snapshot.child("3").child("imageURL").getValue(String.class);
//                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
//                        intent.putExtra("captiono",CaptionDisplay3);
//                        intent.putExtra("priceo",Price);
//                        intent.putExtra("imageo", imageURL);
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//            }
//
//        });
//        //fourth
//        fourthMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        Price = snapshot.child("4").child("price").getValue(String.class);
//                        imageURL = snapshot.child("4").child("imageURL").getValue(String.class);
//                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
//                        intent.putExtra("captiono",CaptionDisplay4);
//                        intent.putExtra("priceo", Price);
//                        intent.putExtra("imageo", imageURL);
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//            }
//
//        });
//
//        fifthMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        Price = snapshot.child("5").child("price").getValue(String.class);
//                        imageURL = snapshot.child("5").child("imageURL").getValue(String.class);
//                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
//                        intent.putExtra("captiono",CaptionDisplay5);
//                        intent.putExtra("priceo", Price);
//                        intent.putExtra("imageo", imageURL);
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//            }
//
//        });
//
//        sixthMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                databaseReference.child("Images").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        Price = snapshot.child("6").child("price").getValue(String.class);
//                        imageURL = snapshot.child("6").child("imageURL").getValue(String.class);
//                        Intent intent=new Intent(com.example.finals.costumerUI.this,order.class);
//                        intent.putExtra("captiono",CaptionDisplay6);
//                        intent.putExtra("priceo", Price);
//                        intent.putExtra("imageo", imageURL);
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//            }
//
//        });
//
//    };


    }




}