package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
public class Payment_1 extends AppCompatActivity {
    Button order_button;
    ImageButton back_payment_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_1_page);
        back_payment_1 = findViewById(R.id.back_payment_1);
        // Thêm dòng này để khởi tạo order_button
        order_button = findViewById(R.id.btn_order);
        back_payment_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment_1.this, Product.class);
                startActivity(intent);
            }
        });
        order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment_1.this, Payment_2.class);
                startActivity(intent);
                finish(); // Đóng activity hiện tại nếu cần
            }
        });
    }
}
