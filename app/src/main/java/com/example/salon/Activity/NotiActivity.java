package com.example.salon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Domain.BookingInfo;
import com.example.salon.Helper.NavigationManager;
import com.example.salon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotiActivity extends AppCompatActivity {
    ListView listnoti;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> notificationList;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_page);
        listnoti = findViewById(R.id.notificationListView);
        Intent intent = getIntent();
        BookingInfo bookingInfo = (BookingInfo) intent.getSerializableExtra("booking_info");
        notificationList = new ArrayList<>();

        // Populate the ArrayList with booking information
       // if (bookingInfo != null) {
           // notificationList.add("Registration successful!"+"\n" +bookingInfo.getName() +"\n"+bookingInfo.getAddress() +"\n"+bookingInfo.getTime() + "\n" + bookingInfo.getNameStaff() + "\n" + bookingInfo.getPhoneNumber());
            // Add other booking details as needed
       // }

        // Initialize ArrayAdapter and set it to the ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notificationList);
        listnoti.setAdapter(adapter);
        DatabaseReference bookingRef = FirebaseDatabase.getInstance().getReference().child("bookings");
        bookingRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Xử lý khi dữ liệu thay đổi
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    BookingInfo bookingInfo = snapshot.getValue(BookingInfo.class);
                    // Sử dụng bookingInfo ở đây
                    if (bookingInfo != null) {
                        // Tạo chuỗi thông tin từ đối tượng BookingInfo và thêm vào danh sách thông báo
                        String info = "Registration successful!" + "\n" + bookingInfo.getName() + "\n" + bookingInfo.getAddress() + "\n" + bookingInfo.getTime() + "\n" + bookingInfo.getNameStaff() + "\n" + bookingInfo.getPhoneNumber();
                        notificationList.add(info);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Xử lý khi có lỗi xảy ra
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bnv_noti); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                 if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(NotiActivity.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(NotiActivity.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(NotiActivity.this);
                } else if (id == R.id.action_acc) {
                    // Xử lý khi click vào Settings
                     NavigationManager.navigateToProfile(NotiActivity.this);
                }

                return true;
            }
        });
    }
}