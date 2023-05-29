package com.example.finals;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finals.databinding.ActivityLoginPageBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login_page extends AppCompatActivity {

    TextView textView;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kitchencityonline-1fbdb-default-rtdb.asia-southeast1.firebasedatabase.app");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = findViewById(R.id.signup);
        String text = "<font color=#808080>First Color</font> <font color=#000000>Second Color</font>";
        textView.setText(Html.fromHtml(text));
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login_page);

        TextView signup = findViewById(R.id.signup);
        Button login = findViewById(R.id.loginButton);
        EditText id_input = findViewById(R.id.userID);
        EditText password_input = findViewById(R.id.password_input);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(login_page.this,signup_page.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = id_input.getText().toString();
                String pass = password_input.getText().toString();

                String adminid = "Admin.admin";
                String adminpass = "Admin.pass";
                if(id.isEmpty()||pass.isEmpty()){
                    Toast.makeText(login_page.this, "Please Enter Your ID/Password", Toast.LENGTH_SHORT).show();
                }else{

                    databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(id.equals(adminid)){
                                if(pass.equals(adminpass)){
                                    Toast.makeText(login_page.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(login_page.this,adminui.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(login_page.this, "Invalid SchoolID and/or Password", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                if (snapshot.hasChild(id)) {
                                    final String getPassword = snapshot.child(id).child("Password").getValue(String.class);

                                    if (getPassword.equals(pass)) {
                                        Toast.makeText(login_page.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(login_page.this, NotifSender.class);
                                        startActivity(intent);

                                        OrderManager.GetInstance().username = id;

                                    } else {
                                        Toast.makeText(login_page.this, "Invalid SchoolID and/or Password", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(login_page.this, "Invalid SchoolID and/or Password", Toast.LENGTH_SHORT).show();
                                }
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