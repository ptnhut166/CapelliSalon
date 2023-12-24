package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {
    private String uid;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        BottomNavigationView bottomNav = findViewById(R.id.bnv_profile); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(Profile.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(Profile.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(Profile.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(Profile.this);
                }

                return true;
            }
        });
        String userid = user_class.mAuth.getUid();

        Button buttonLogout = findViewById(R.id.btn_logOut2);
//        Button buttonTest = findViewById(R.id.btn_getUserid);
//        buttonTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Profile.this, userid, Toast.LENGTH_SHORT).show();
//            }
//        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_class.mAuth.signOut();
                Intent intent = new Intent(Profile.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        ImageButton imgbutton = findViewById(R.id.imgbtn_profile_infoEdit);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Profile_edit.class);
                startActivity(intent);
            }
        });

        uid = user_class.mAuth.getUid();
        FirebaseDatabase database = user_class.Database.getInstance();
        TextView id_profile = findViewById(R.id.id_profile);
        TextView tv_profile = findViewById(R.id.tv_profile_name);
        TextView name = findViewById(R.id.tv_profile_name);
        TextView address = findViewById(R.id.tv_profile_address);
        TextView phone = findViewById(R.id.tv_profile_mobile);
        TextView birthday = findViewById(R.id.tv_profile_dob);

        //setID
        id_profile.setText(uid);

        //setName
//        database.getReference().child("userID").child(uid).child("InfoBooking").
        //setAddress
        //setPhone
        //setD.O.B
    }
}
