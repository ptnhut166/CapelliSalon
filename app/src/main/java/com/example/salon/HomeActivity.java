package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button btn_booking = findViewById(R.id.home_btn_booking);
        Button btn_shopping = findViewById(R.id.home_btn_shopping);
        Button btn_lookbook = findViewById(R.id.home_btn_lookbook);
        View.OnClickListener listenerBooking = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), BookingActivity.class);
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

    }
}
