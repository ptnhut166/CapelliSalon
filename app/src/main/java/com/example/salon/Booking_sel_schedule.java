package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking_sel_schedule extends AppCompatActivity {


    ImageButton back;
    RelativeLayout schedule0, schedule1, schedule2, schedule3;
    TextView time0, time1, time2, time3;
    String userID;
    private void setScheduleOnClickListener(final RelativeLayout schedule, final TextView timeTextview) {
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện hành động khi nhấn vào schedule ở đây
                // Thêm logic kiểm tra sự lựa chọn nếu cần
                String time = timeTextview.getText().toString();
                BookingInfo bookingInfo = new BookingInfo("", "", time, "", "");
                // Sử dụng thông tin name và address ở đây (ví dụ: hiển thị hoặc xử lý thông tin)
                // Ví dụ:
                Toast.makeText(getApplicationContext(), "Selected Time: " + time, Toast.LENGTH_SHORT).show();


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                userID = "1";
                if (userID != null && userID != database.getReference().child("userID").child(userID).get().toString()) {

                    DatabaseReference bookingRef = database.getReference().child("userID").child(userID).child("InfoBooking").child("Time");
                    bookingRef.setValue(time);
                }
                Intent intent = new Intent(Booking_sel_schedule.this, booking_sel_staff.class);
                intent.putExtra("booking_info", bookingInfo);
                startActivity(intent);
                finish(); // Đóng activity hiện tại nếu cần

            }
        });
    }


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_sel_schedule);


        ImageButton imageButton = (ImageButton) findViewById(R.id.ibutton_schedule_next);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Booking_sel_schedule.this, booking_sel_staff.class);
                startActivity(intent);
            }
        });

    }
}
