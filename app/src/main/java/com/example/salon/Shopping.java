package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

public class Shopping extends AppCompatActivity {
    ImageButton back_shopping, cart_shopping;
    private View.OnClickListener backProductClickListener;
    private void setProductOnClickListener(final LinearLayout product) {
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shopping.this, Product.class);
                startActivity(intent);
                // Không cần gọi finish() nếu bạn muốn Shopping Activity tiếp tục hoạt động sau khi chuyển sang Product Activity
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_page);
        cart_shopping = findViewById(R.id.img_button_cart);
        back_shopping = findViewById(R.id.back_shopping);
        LinearLayout[] products = new LinearLayout[8];
        products[0] = findViewById(R.id.product_0);
        products[1] = findViewById(R.id.product_1);
        products[2] = findViewById(R.id.product_2);
        products[3] = findViewById(R.id.product_3);
        products[4] = findViewById(R.id.product_4);
        products[5] = findViewById(R.id.product_5);
        products[6] = findViewById(R.id.product_6);
        products[7] = findViewById(R.id.product_7);

        for (LinearLayout product : products) {
            setProductOnClickListener(product);
        }
        back_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện hành động khi nhấn vào imageButton ở đây
                Intent intent = new Intent(Shopping.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Đóng activity hiện tại nếu cần
            }
        });
        backProductClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện hành động khi nhấn vào imageButton ở đây
                Intent intent = new Intent(Shopping.this, Cart.class);
                startActivity(intent);
                // Không gọi finish() để giữ lại activity hiện tại
            }
        };
        cart_shopping.setOnClickListener(backProductClickListener);

    }

}
