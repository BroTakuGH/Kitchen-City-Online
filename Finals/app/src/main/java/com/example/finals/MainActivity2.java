package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class MainActivity2 extends AppCompatActivity {
   DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        TextView signup = findViewById(R.id.signup);
        TextView login = findViewById(R.id.loginButton);
        EditText id_input = findViewById(R.id.userID);
        EditText password_input = findViewById(R.id.password_input);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = id_input.getText().toString();
                String pass = password_input.getText().toString();

                if(id.isEmpty()||pass.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please Enter Your ID/Password", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(id)){
                               final String getPassword = snapshot.child(id).child("Password").getValue(String.class);
                               if(getPassword.equals(pass)){
                                   Toast.makeText(MainActivity2.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                               }else{
                                   Toast.makeText(MainActivity2.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                               }

                            }else{
                                Toast.makeText(MainActivity2.this, "No Account Found", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}