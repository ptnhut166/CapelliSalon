package com.example.salon;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_page);

        listnoti = findViewById(R.id.notificationListView);
        notificationList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notificationList);
        listnoti.setAdapter(adapter);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userID = user.getUid();
            DatabaseReference bookingRef = FirebaseDatabase.getInstance().getReference().child(userID).child("InfoBooking");

            bookingRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    notificationList.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String address = snapshot.child("Address").getValue(String.class);
                        String locationName = snapshot.child("Location name").getValue(String.class);
                        String phoneNumber = snapshot.child("Phone number").getValue(String.class);
                        String staffName = snapshot.child("Staff name").getValue(String.class);
                        String time = snapshot.child("Time").getValue(String.class);

                        address = address != null ? address : "Không có thông tin";
                        locationName = locationName != null ? locationName : "Không có thông tin";
                        phoneNumber = phoneNumber != null ? phoneNumber : "Không có thông tin";
                        staffName = staffName != null ? staffName : "Không có thông tin";
                        time = time != null ? time : "Không có thông tin";

                        String info = "Registration successful!\nAddress: " + address +
                                "\nLocation Name: " + locationName +
                                "\nPhone Number: " + phoneNumber +
                                "\nStaff Name: " + staffName +
                                "\nTime: " + time;
                        notificationList.add(info);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Xử lý khi có lỗi xảy ra trong việc đọc dữ liệu từ Firebase
                }
            });
            BottomNavigationView bottomNav = findViewById(R.id.bnv_noti);
            bottomNav.setOnNavigationItemSelectedListener(item -> {
                int id = item.getItemId();

                if (id == R.id.action_home) {
                    NavigationManager.navigateToHome(NotiActivity.this);
                } else if (id == R.id.action_cart) {
                    NavigationManager.navigateToCart(NotiActivity.this);
                } else if (id == R.id.action_his) {
                    NavigationManager.navigateToHistory(NotiActivity.this);
                } else if (id == R.id.action_acc) {
                    // Xử lý khi click vào Settings
                }
                return true;
            });
        }
    }
}