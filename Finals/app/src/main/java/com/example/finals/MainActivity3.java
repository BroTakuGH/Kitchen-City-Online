package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
private EditText id_input;
private EditText email_input;
private EditText name_input;
private EditText password_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        id_input = findViewById(R.id.school_id_input);
        email_input= findViewById(R.id.school_email_input);
        name_input = findViewById(R.id.name_input);
        password_input = findViewById(R.id.password_input);
        Methods methods = new Methods();

        TextView signup = findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                methods.SetSchoolId(id_input.getText().toString());
                methods.SetSchoolGmail(email_input.getText().toString());
                methods.SetUserName(name_input.getText().toString());
                methods.SetUserName(password_input.getText().toString());

                if(methods.GetSchoolID().isEmpty()|| methods.GetPassword().isEmpty()){
                    Toast.makeText(MainActivity3.this,"Please Enter ID or Password", Toast.LENGTH_SHORT).show();
                }else{


                }



                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);

            }

        });
    }
}