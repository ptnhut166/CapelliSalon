package com.example.salon;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Payment_2 extends AppCompatActivity {
    CheckBox checkBox_cod, checkBox_momo;
    Button confirm_cash_button;
    ImageButton back_payment_2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_2_page);
        back_payment_2 = findViewById(R.id.back_payment_2);
        checkBox_cod = findViewById(R.id.checkBox_cod);
        checkBox_momo = findViewById(R.id.checkBox_momo);
        confirm_cash_button = findViewById(R.id.btn_confirm_cash);
        back_payment_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment_2.this, Payment_1.class);
                startActivity(intent);
            }
        });
        confirm_cash_button.setEnabled(false);
        checkBox_cod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox_momo.setChecked(false); // Tắt checkBox_momo nếu checkBox_cod được chọn
                    confirm_cash_button.setEnabled(true); // Kích hoạt button khi có ít nhất một checkbox được chọn
                } else {
                    confirm_cash_button.setEnabled(checkBox_momo.isChecked()); // Kích hoạt button nếu checkBox_momo được chọn
                }
            }
        });

        checkBox_momo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox_cod.setChecked(false); // Tắt checkBox_cod nếu checkBox_momo được chọn
                    confirm_cash_button.setEnabled(true); // Kích hoạt button khi có ít nhất một checkbox được chọn
                } else {
                    confirm_cash_button.setEnabled(checkBox_cod.isChecked()); // Kích hoạt button nếu checkBox_cod được chọn
                }
            }
        });
    }
}
