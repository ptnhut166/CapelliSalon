package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class booking_confirm extends AppCompatActivity {
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_confirm);
        back = findViewById(R.id.back_confirm);
        Intent intent = getIntent();
        BookingInfo bookingInfo = (BookingInfo) intent.getSerializableExtra("booking_info");
        final CheckBox checkBox = findViewById(R.id.checkBox);
        final Button btn_book_now = findViewById(R.id.btn_book_now);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện hành động khi nhấn vào imageButton ở đây
                Intent intentback = new Intent(booking_confirm.this, booking_sel_staff.class);
                startActivity(intentback);
                finish(); // Đóng activity hiện tại nếu cần
            }
        });
        btn_book_now.setEnabled(false);

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

            btn_book_now.setEnabled(isChecked);
        });

        btn_book_now.setOnClickListener(v -> {
            Intent newintent = new Intent(booking_confirm.this, NotiActivity.class);
            newintent.putExtra("booking_info", bookingInfo);
            startActivity(newintent);
            Toast.makeText(booking_confirm.this, "Successful registration", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
