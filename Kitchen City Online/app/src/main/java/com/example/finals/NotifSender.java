package com.example.finals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.messaging.FirebaseMessaging;

public class NotifSender extends AppCompatActivity {

    BottomNavigationView nav5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_notif_sender);

        FirebaseMessaging.getInstance().subscribeToTopic("all");

        EditText title = findViewById(R.id.titleID);
        EditText message = findViewById(R.id.messageID);

        nav5 = findViewById(R.id.bottom_navigation);


        nav5.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_cart:
                        Intent intent=new Intent(NotifSender.this,pendingOrders.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_logout:
                        Intent intent2=new Intent(NotifSender.this,MainActivity2.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_home:
                        Intent intent3=new Intent(NotifSender.this,adminui.class);
                        startActivity(intent3);
                        break;

                }

                return false;
            }
        });


//        FirebaseMessagingService firebaseMessagingService = new FirebaseMessagingService();
//        System.out.println(firebaseMessagingService.resourceImage + "test111");
        findViewById(R.id.alldeviceId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!title.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){
                FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/all",title.getText().toString(),
                        message.getText().toString(), getApplicationContext(), NotifSender.this);
                        notificationsSender.SendNotifications();
                }
                else {
                    Toast.makeText(NotifSender.this, "Text cannot be blank!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}