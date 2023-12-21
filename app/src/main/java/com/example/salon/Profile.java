package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    private String uid;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_after_change);
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
        uid = user_class.mAuth.getUid();
        TextView id_profile = findViewById(R.id.id_profile);
        id_profile.setText("");

        //setName
        //setAddress
        //setPhone
        //setD.O.B
    }
}
