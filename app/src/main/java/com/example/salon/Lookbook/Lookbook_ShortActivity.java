package com.example.salon.Lookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Activity.LookBookActivity;
import com.example.salon.R;

import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;

public class Lookbook_ShortActivity extends AppCompatActivity {

    PageCurlView pageCurlView;
    List<Integer> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookbook_short);
        //pagecurl
        pageCurlView =findViewById(R.id.pagecurlView);
        images=new ArrayList<>();

        images.add(R.drawable.lookbook_short_2);
        images.add(R.drawable.lookbook_short_3);
        images.add(R.drawable.lookbook_short_4);
        pageCurlView.setCurlView(images);
        pageCurlView.setCurlSpeed(600);

        ImageView backButton = findViewById(R.id.backBtn);

        View.OnClickListener listenerShortHair = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), LookBookActivity.class);
                startActivity(intent);
            }
        };

        backButton.setOnClickListener(listenerShortHair);





    }

}
