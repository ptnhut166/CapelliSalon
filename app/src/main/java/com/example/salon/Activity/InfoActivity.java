package com.example.salon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.R;
import com.google.firebase.auth.FirebaseAuth;

public class InfoActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btn_logout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_page);
        btn_logout=findViewById(R.id.btn_logout);
        View.OnClickListener listenerLogout = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent();
                intent.setClass(view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        };
        btn_logout.setOnClickListener(listenerLogout);
    }

}
