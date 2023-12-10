package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;


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

        View.OnClickListener listenerBooking = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Booking_sel_locale.class);
                startActivity(intent);
            }
        };
        View.OnClickListener listenerLookbook = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), LookbookActivity.class);
                startActivity(intent);
            }
        };

        //Gán Listener cho editbutton
        btn_booking.setOnClickListener(listenerBooking);
        btn_lookbook.setOnClickListener(listenerLookbook);



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            Fragment fragment =null;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.action_home)
                {

                }
                return true;
            }
        });

    }
}
