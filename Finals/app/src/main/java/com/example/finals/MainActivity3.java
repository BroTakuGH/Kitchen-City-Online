package com.example.finals;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
private EditText id_input;
private EditText email_input;
private EditText name_input;
private EditText password_input;

     DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);

        id_input = findViewById(R.id.school_id_input);
        email_input= findViewById(R.id.school_email_input);
        name_input = findViewById(R.id.name_input);
        password_input = findViewById(R.id.password_input);
        Methods methods = new Methods();


        TextView backToLogin = findViewById(R.id.signup);
        TextView signup = findViewById(R.id.loginButton);
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){
                methods.SetSchoolId(id_input.getText().toString());
                methods.SetSchoolGmail(email_input.getText().toString());
                methods.SetUserName(name_input.getText().toString());
                methods.SetPass(password_input.getText().toString());

                    if(methods.GetSchoolID().isEmpty()||methods.GetPassword().isEmpty()||methods.GetSchoolGmail().isEmpty()||methods.GetName().isEmpty()){
                        Toast.makeText(MainActivity3.this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();
                    } else {
                        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.hasChild(methods.GetSchoolID())) {
                                    Toast.makeText(MainActivity3.this, "This ID is already registered", Toast.LENGTH_SHORT).show();
                                } else {
                                    databaseReference.child("Users").child(methods.GetSchoolID()).child("SchoolGmail").setValue(methods.GetSchoolGmail());
                                    databaseReference.child("Users").child(methods.GetSchoolID()).child("UserName").setValue(methods.GetName());
                                    databaseReference.child("Users").child(methods.GetSchoolID()).child("Password").setValue(methods.GetPassword());

                                    Toast.makeText(MainActivity3.this, "User registered succesfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity3.this, costumerUI.class);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }
                };

        });
    }
}
