package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Booking_sel_locale extends AppCompatActivity {
    RelativeLayout location;
    RelativeLayout location0;
    RelativeLayout location1;
    RelativeLayout location2;
    RelativeLayout location3;
    FirebaseDatabase dataBase;

    private void setLocationOnClickListener(final RelativeLayout location) {
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện hành động khi nhấn vào location ở đây
                Intent intent = new Intent(Booking_sel_locale.this, Booking_sel_schedule.class);
                startActivity(intent);
                finish(); // Đóng activity hiện tại nếu cần
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_sel_locate);
        BottomNavigationView bottomNav = findViewById(R.id.bnv_locate); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(Booking_sel_locale.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(Booking_sel_locale.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(Booking_sel_locale.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(Booking_sel_locale.this);
                } else if (id == R.id.action_acc) {
                    // Xử lý khi click vào Settings
                }

                return true;
            }
        });

        dataBase = FirebaseDatabase.getInstance();

        location0 = findViewById(R.id.location_0);
        location1 = findViewById(R.id.location_1);
        location2 = findViewById(R.id.location_2);
        location3 = findViewById(R.id.location_3);

        setLocationOnClickListener(location0);
        setLocationOnClickListener(location1);
        setLocationOnClickListener(location2);
        setLocationOnClickListener(location3);

        ImageButton imageButton = findViewById(R.id.ibutton_next);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Đưa logic xử lý khi nhấn vào imageButton ở đây (nếu có)
                location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(location.isSelected() == true) {
//                    // Lấy tham chiếu đến node 'user_choice'
//                    DatabaseReference ref = dataBase.getReference("user_choice");
//                    // Thêm mới hoặc cập nhật dữ liệu
//                    ref.child("booking_sel_employee").setValue("Employee Name");
//                    ref.child("booking_sel_loc").setValue("Location Name");
//                    ref.child("booking_sel_schedule").setValue("Schedule Time");

                            //setup intent
                            Intent intent = new Intent(Booking_sel_locale.this, Booking_sel_schedule.class);
                            startActivity(intent);


                        }
                    }
                });
            }
        });
    }
}
