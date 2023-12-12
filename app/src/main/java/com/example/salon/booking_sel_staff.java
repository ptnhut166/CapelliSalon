package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class booking_sel_staff extends AppCompatActivity {
    RelativeLayout staff0, staff1, staff2, staff3;

    private void setStaffOnClickListener(final RelativeLayout staff) {
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện hành động khi nhấn vào schedule ở đây
                // Thêm logic kiểm tra sự lựa chọn nếu cần

                Intent intent = new Intent(booking_sel_staff.this, booking_confirm.class);
                startActivity(intent);
                finish(); // Đóng activity hiện tại nếu cần
            }
        });
    }
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_sel_staff);
        staff0 = findViewById(R.id.staff_0);
        staff1 = findViewById(R.id.staff_1);
        staff2 = findViewById(R.id.staff_2);
        staff3 = findViewById(R.id.staff_3);

        setStaffOnClickListener(staff0);
        setStaffOnClickListener(staff1);
        setStaffOnClickListener(staff2);
        setStaffOnClickListener(staff3);
        BottomNavigationView bottomNav = findViewById(R.id.bnv_staff); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(booking_sel_staff.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(booking_sel_staff.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(booking_sel_staff.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(booking_sel_staff.this);
                } else if (id == R.id.action_acc) {
                    // Xử lý khi click vào Settings
                }

                return true;
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.back_staff);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booking_sel_staff.this, Booking_sel_schedule.class);
                startActivity(intent);
            }
        });

    }
}
