package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class booking_sel_staff extends AppCompatActivity {
<<<<<<< Updated upstream
=======
    RelativeLayout staff0, staff1, staff2, staff3;
    TextView namestaff0, namestaff1, namestaff2, namestaff3, phone0, phone1, phone2,phone3;
    String userID;
    private void setStaffOnClickListener(final RelativeLayout staff, final  TextView namestaffTextview, final  TextView pnumberTextview) {
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namestaff = namestaffTextview.getText().toString();
                String pnumber = pnumberTextview.getText().toString();
                BookingInfo bookingInfo = new BookingInfo("", "", "", namestaff, pnumber);

                Toast.makeText(getApplicationContext(), "Selected Name: " + namestaff + ", Phone number: " + pnumber, Toast.LENGTH_SHORT).show();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                userID = "1"; // value kiểm thử, đợi a nhựt làm userID đã
                if (userID != null && userID != database.getReference().child("userID").child(userID).get().toString()) {

                    DatabaseReference bookingRef = database.getReference().child("userID").child(userID).child("InfoBooking").child("Staff name");
                    bookingRef.setValue(namestaff);

                    bookingRef = database.getReference().child("userID").child(userID).child("InfoBooking").child("Phone number");
                    bookingRef.setValue(pnumber);
                }
                //intent
                Intent intent = new Intent(booking_sel_staff.this, booking_confirm.class);
                intent.putExtra("booking_info", bookingInfo);
                startActivity(intent);
                finish();
            }
        });
    }
>>>>>>> Stashed changes
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_sel_staff);

        ImageButton imageButton = (ImageButton) findViewById(R.id.ibutton_staff_next);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booking_sel_staff.this, booking_confirm.class);
                startActivity(intent);
            }
        });

    }
}
