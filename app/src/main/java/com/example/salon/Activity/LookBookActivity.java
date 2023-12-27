package com.example.salon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Lookbook.Lookbook_ColorActivity;
import com.example.salon.Lookbook.Lookbook_LongActivity;
import com.example.salon.Lookbook.Lookbook_ShortActivity;
import com.example.salon.R;

public class LookBookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookbook);


        Button long_hair = findViewById(R.id.long_hair);
        Button short_hair = findViewById(R.id.short_hair);
        Button color = findViewById(R.id.hair_color);
        ImageView backButton = findViewById(R.id.backBtn);


        View.OnClickListener listenerLongHair = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Lookbook_LongActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener listenerShortHair = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Lookbook_ShortActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener listenerColor = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), Lookbook_ColorActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener listenerBack = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        };

        long_hair.setOnClickListener(listenerLongHair);
        short_hair.setOnClickListener(listenerShortHair);
        color.setOnClickListener(listenerColor);
        backButton.setOnClickListener(listenerBack);



    }
}
