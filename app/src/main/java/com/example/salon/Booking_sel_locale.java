package com.example.salon;

import android.content.Intent;
import android.graphics.Color;
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
<<<<<<< Updated upstream
    RelativeLayout location;
    RelativeLayout test;

=======
    BookingInfo bookingInfo;
    String userID;

    private void setLocationOnClickListener(final RelativeLayout location, final TextView nameTextView, final TextView addressTextView) {
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện hành động khi nhấn vào location ở đây
                String name = nameTextView.getText().toString();
                String address = addressTextView.getText().toString();

                bookingInfo = new BookingInfo(name, address, "", "", "");
                // Sử dụng thông tin name và address ở đây (ví dụ: hiển thị hoặc xử lý thông tin)
                // Ví dụ:
                Toast.makeText(getApplicationContext(), "Selected Name: " + name + ", Address: " + address, Toast.LENGTH_SHORT).show();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                userID = "1";
                if (userID != null && userID != database.getReference().child("userID").child(userID).get().toString()) {

                    DatabaseReference bookingRef = database.getReference().child("userID").child(userID).child("InfoBooking").child("Location name");
                    bookingRef.setValue(name);

                    bookingRef = database.getReference().child("userID").child(userID).child("InfoBooking").child("Address");
                    bookingRef.setValue(address);
                }
                Intent intent = new Intent(Booking_sel_locale.this, Booking_sel_schedule.class);
                intent.putExtra("booking_info", bookingInfo);
                startActivity(intent);
                finish(); // Đóng activity hiện tại nếu cần
//                DatabaseReference ref = dataBase.getReference("user_choice");
//                ref.child("booking_sel_employee").setValue("Employee Name");
//                ref.child("booking_sel_loc").setValue("Location Name");
//                ref.child("booking_sel_schedule").setValue("Schedule Time");
            }
        });
    }

    @Override
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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

=======
                return true;
            }
        });

        dataBase = FirebaseDatabase.getInstance();
        name0 = findViewById(R.id.tv_locate_name_0);
        name1 = findViewById(R.id.tv_locate_name_1);
        name2 = findViewById(R.id.tv_locate_name_2);
        name3 = findViewById(R.id.tv_locate_name_3);
        address0 = findViewById(R.id.tv_locate_address_0);
        address1 = findViewById(R.id.tv_locate_address_1);
        address2 = findViewById(R.id.tv_locate_address_2);
        address3 = findViewById(R.id.tv_locate_address_3);
        location0 = findViewById(R.id.location_0);
        location1 = findViewById(R.id.location_1);
        location2 = findViewById(R.id.location_2);
        location3 = findViewById(R.id.location_3);

        setLocationOnClickListener(location0, name0, address0);
        setLocationOnClickListener(location1, name1, address1);
        setLocationOnClickListener(location2, name2, address2);
        setLocationOnClickListener(location3, name3, address3);

        ImageButton imageButton = findViewById(R.id.ibutton_next);


>>>>>>> Stashed changes
    }


}
