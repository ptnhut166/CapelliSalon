package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LookbookActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookbook_page);

        Button btn_long = findViewById(R.id.lookbook_btn_long);

        View.OnClickListener listenerLogin = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), LookbookLong.class);
                startActivity(intent);
            }
        };

        //Gán Listener cho editbutton
        btn_long.setOnClickListener(listenerLogin);
    }
}
