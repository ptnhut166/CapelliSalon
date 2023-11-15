package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        Button btn_login = findViewById(R.id.button);

        View.OnClickListener listenerSignUp = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                //Gán context và tên lớp Activity cần chạy
                intent.setClass(view.getContext(), HomeActivity.class);



                //Gửi Intent cho hệ thống Android để kích hoạt Activity
                startActivity(intent);
                //Muốn Activity thứ nhất kết thúc thì thêm finish();
            }
        };
        //Gán Listener cho editbutton
        btn_login.setOnClickListener(listenerSignUp);
    }
}
