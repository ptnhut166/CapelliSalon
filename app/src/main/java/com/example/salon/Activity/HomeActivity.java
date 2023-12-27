package com.example.salon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Booking.Booking_sel_locale;
import com.example.salon.Helper.NavigationManager;
import com.example.salon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity
{
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        bottomNavigationView  = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.action_home);

        Button btn_booking = findViewById(R.id.home_btn_booking);
        Button btn_shopping = findViewById(R.id.home_btn_shopping);
        Button btn_lookbook = findViewById(R.id.home_btn_lookbook);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(HomeActivity.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(HomeActivity.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(HomeActivity.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(HomeActivity.this);
                } else if (id == R.id.action_acc) {
                    NavigationManager.navigateToProfile(HomeActivity.this);
                    // Xử lý khi click vào Settings
                }

                return true;
            }
        });
        View.OnClickListener listenerBooking = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Booking_sel_locale.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenerShopping = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), ShoppingActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenerLookbook = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), LookBookActivity.class);
                startActivity(intent);
            }
        };



        //Gán Listener cho editbutton
        btn_booking.setOnClickListener(listenerBooking);
        btn_shopping.setOnClickListener(listenerShopping);
        btn_lookbook.setOnClickListener(listenerLookbook);




    }

}
