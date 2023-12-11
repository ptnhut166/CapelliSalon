package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

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

    FirebaseDatabase dataBase;
    RelativeLayout location;
    RelativeLayout test;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(/*context=*/ this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(DebugAppCheckProviderFactory.getInstance());
        setContentView(R.layout.booking_sel_locate);

        //declare and initialize views
        ImageButton imageButton = (ImageButton) findViewById(R.id.ibutton_next);
        dataBase= FirebaseDatabase.getInstance();
        location = (RelativeLayout)findViewById(R.id.location_0);
//        location[1] = (RelativeLayout)findViewById(R.id.location_1);

        imageButton.setOnClickListener(new View.OnClickListener() {
            //setup intent
            @Override
            public void onClick(View view) {
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
