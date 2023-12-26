package com.example.salon.Booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Domain.BookingInfo;
import com.example.salon.Helper.NavigationManager;
import com.example.salon.Activity.NotiActivity;
import com.example.salon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class booking_confirm extends AppCompatActivity {
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirm);
        back = findViewById(R.id.back_confirm);
        Intent intent = getIntent();
        BookingInfo bookingInfo = (BookingInfo) intent.getSerializableExtra("booking_info");
        final CheckBox checkBox = findViewById(R.id.checkBox);
        final Button btn_book_now = findViewById(R.id.btn_book_now);
        BottomNavigationView bottomNav = findViewById(R.id.bnv_confirm); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(booking_confirm.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(booking_confirm.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(booking_confirm.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(booking_confirm.this);
                } else if (id == R.id.action_acc) {
                    // Xử lý khi click vào Settings
                    NavigationManager.navigateToProfile(booking_confirm.this);
                }

                return true;
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện hành động khi nhấn vào imageButton ở đây
                Intent intentback = new Intent(booking_confirm.this, booking_sel_staff.class);
                startActivity(intentback);
                finish(); // Đóng activity hiện tại nếu cần
            }
        });
        btn_book_now.setEnabled(false);

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

            btn_book_now.setEnabled(isChecked);
        });

        btn_book_now.setOnClickListener(v -> {
            Intent newintent = new Intent(booking_confirm.this, NotiActivity.class);
            newintent.putExtra("booking_info", bookingInfo);
            startActivity(newintent);
            Toast.makeText(booking_confirm.this, "Successful registration", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
