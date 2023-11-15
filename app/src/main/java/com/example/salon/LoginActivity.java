package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        Button btn_login = findViewById(R.id.button);

        View.OnClickListener listenerLogin = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        };
        //Gán Listener cho editbutton
        btn_login.setOnClickListener(listenerLogin);
    }
}
