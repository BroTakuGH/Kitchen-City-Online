package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        TextView signup = findViewById(R.id.login);
        Database database = new Database(MainActivity3.this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);

            }

        });
    }
}