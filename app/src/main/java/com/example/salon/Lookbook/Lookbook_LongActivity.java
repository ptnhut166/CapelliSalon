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

public class Lookbook_LongActivity extends AppCompatActivity {

    PageCurlView pageCurlView;
    List<Integer> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookbook_long);
        //pagecurl
        pageCurlView =findViewById(R.id.pagecurlView);
        images=new ArrayList<>();
        images.add(R.drawable.lookbook_long_1);
        images.add(R.drawable.lookbook_long_2);
        images.add(R.drawable.lookbook_long_3);
        images.add(R.drawable.lookbook_long_4);
        pageCurlView.setCurlView(images);
        pageCurlView.setCurlSpeed(600);

        ImageView backButton = findViewById(R.id.backBtn);

        View.OnClickListener listenerLongHair = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(), LookBookActivity.class);
                startActivity(intent);
            }
        };

        backButton.setOnClickListener(listenerLongHair);





    }

}
