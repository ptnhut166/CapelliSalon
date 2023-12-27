package com.example.salon.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Helper.NavigationManager;
import com.example.salon.R;
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
            DatabaseReference userBookingRef = FirebaseDatabase.getInstance().getReference().child("userID").child(userID).child("InfoBooking");
//            userBookingRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.exists()) {
//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            String address = snapshot.child("Address").getValue(String.class);
//                            String locationName = snapshot.child("Location name").getValue(String.class);
//                            String phoneNumber = snapshot.child("Phone number").getValue(String.class);
//                            String staffName = snapshot.child("Staff name").getValue(String.class);
//                            String time = snapshot.child("Time").getValue(String.class);
//
//                            address = address != null ? address : "No information";
//                            locationName = locationName != null ? locationName : "No information";
//                            phoneNumber = phoneNumber != null ? phoneNumber : "No information";
//                            staffName = staffName != null ? staffName : "No information";
//                            time = time != null ? time : "No information";
//
//                            String combinedData = "Registration successful!\nAddress: " + address +
//                                    "\nLocation Name: " + locationName +
//                                    "\nPhone Number: " + phoneNumber +
//                                    "\nStaff Name: " + staffName +
//                                    "\nTime: " + time;
//
//                            notificationList.add(combinedData);
//                        }
//                        adapter.notifyDataSetChanged();
//                    } else {
//                        Log.d("Firebase", "No data found at this path");
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//                    Log.d("Firebase", "Error: " + databaseError.getMessage());
//                }
//            });

            userBookingRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Log.d("Firebase", "DataSnapshot exists: " + dataSnapshot.getValue());
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Object data = snapshot.getValue();
                            if (data != null) {
                                String convertedData = data.toString();
                                notificationList.add(convertedData);
                            }


                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.d("Firebase", "No data found at this path");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.e("Firebase", "onCancelled called: " + databaseError.getMessage());
                }
            });

            BottomNavigationView bottomNav = findViewById(R.id.bnv_noti);
            bottomNav.setOnNavigationItemSelectedListener(item -> {
                int id = item.getItemId();

                if (id == R.id.action_home) {
                    NavigationManager.navigateToHome(NotiActivity.this);
                } else if (id == R.id.action_cart) {
                    NavigationManager.navigateToCart(NotiActivity.this);
                }
                return true;
            });
        }
    }
}