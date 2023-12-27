package com.example.salon.Booking;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Helper.NavigationManager;
import com.example.salon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class booking_sel_staff extends AppCompatActivity {
    RelativeLayout staff0, staff1, staff2, staff3;
    TextView namestaff0, namestaff1, namestaff2, namestaff3, phone0, phone1, phone2,phone3;
    user_class user_class;
    FirebaseUser user = user_class.mAuth.getCurrentUser();
    String userID = user.getUid();
    private void setStaffOnClickListener(final RelativeLayout staff, final  TextView namestaffTextview, final  TextView pnumberTextview) {
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                staff.setBackgroundColor(Color.parseColor("#B7B7B7"));
                String namestaff = namestaffTextview.getText().toString();
                String pnumber = pnumberTextview.getText().toString();
                user_class user_class = new user_class("", "","", "", namestaff, pnumber);

                Toast.makeText(getApplicationContext(), "Selected Name: " + namestaff + ", Phone number: " + pnumber, Toast.LENGTH_SHORT).show();

                FirebaseDatabase database = user_class.Database.getInstance();

                if (userID != null) {

                    DatabaseReference bookingRef = database.getReference().child("userID").child(userID).child("InfoBooking").child("Staff name");
                    bookingRef.setValue(namestaff);

                    bookingRef = database.getReference().child("userID").child(userID).child("InfoBooking").child("Phone number");
                    bookingRef.setValue(pnumber);
                }
                //intent
                Intent intent = new Intent(booking_sel_staff.this, booking_confirm.class);
                intent.putExtra("booking_info", user_class);
                startActivity(intent);
                finish();
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
        namestaff0 = findViewById(R.id.tv_staff_0);
        namestaff1 = findViewById(R.id.tv_staff_1);
        namestaff2 = findViewById(R.id.tv_staff_2);
        namestaff3 = findViewById(R.id.tv_staff_3);
        phone0 = findViewById(R.id.tv_pnumber_0);
        phone1 = findViewById(R.id.tv_pnumber_1);
        phone2 = findViewById(R.id.tv_pnumber_2);
        phone3 = findViewById(R.id.tv_pnumber_3);
        setStaffOnClickListener(staff0, namestaff0, phone0);
        setStaffOnClickListener(staff1, namestaff1, phone1);
        setStaffOnClickListener(staff2, namestaff2, phone2);
        setStaffOnClickListener(staff3, namestaff3, phone3);
        Intent intent = getIntent();
        user_class user_class = (user_class) intent.getSerializableExtra("booking_info");
// hoặc sử dụng getParcelableExtra nếu bạn đã sử dụng Parcelable
        if (user_class != null) {
            // Kiểm tra xem dữ liệu đã được chuyển qua hay chưa bằng cách in ra log
            Log.d("BookingInfo", "Name: " + user_class.getName());
            Log.d("BookingInfo", "Address: " + user_class.getAddress());
            Log.d("BookingInfo", "Time: " + user_class.getTime());
            // Kiểm tra các trường thông tin khác tương tự ở đây
        } else {
            Log.d("BookingInfo", "Null bookingInfo received");
        }
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
                } else if (id == R.id.action_acc) {
                    NavigationManager.navigateToProfile(booking_sel_staff.this);
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