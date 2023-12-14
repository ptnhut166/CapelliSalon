package com.example.salon;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {
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
    }
}
