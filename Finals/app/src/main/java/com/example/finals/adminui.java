package com.example.finals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class adminui extends AppCompatActivity {
    TextView itemEdit1;
    TextView itemEdit2;
    TextView itemEdit3;
    TextView itemEdit4;
    TextView itemEdit5;
    TextView itemEdit6;
    String id;
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
    }
}