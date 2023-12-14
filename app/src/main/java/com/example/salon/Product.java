package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class Product extends AppCompatActivity {
    private ImageButton backProductButton;
    private Button buyButton;
    private View.OnClickListener buyButtonClickListener;
    private View.OnClickListener backProductClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_description_page);

        buyButton = findViewById(R.id.btn_buy);
        backProductButton = findViewById(R.id.back_product);

        // Click Listener for Buy Button
        buyButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnew = new Intent(Product.this, Payment_1.class);
                startActivity(intentnew);
                // Không gọi finish() để giữ lại activity hiện tại
            }
        };
        buyButton.setOnClickListener(buyButtonClickListener);

        // Click Listener for Back Button
        backProductClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện hành động khi nhấn vào imageButton ở đây
                Intent intent = new Intent(Product.this, Shopping.class);
                startActivity(intent);
                // Không gọi finish() để giữ lại activity hiện tại
            }
        };
        backProductButton.setOnClickListener(backProductClickListener);
    }

    @Override
    protected void onDestroy() {
        // Gỡ bỏ các OnClickListener khi không cần thiết để tránh memory leak
        if (buyButton != null && buyButtonClickListener != null) {
            buyButton.setOnClickListener(null);
            buyButtonClickListener = null;
        }
        if (backProductButton != null && backProductClickListener != null) {
            backProductButton.setOnClickListener(null);
            backProductClickListener = null;
        }
        super.onDestroy();
    }
}
