package com.example.salon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LookbookLong extends AppCompatActivity {
    ImageSwitcher imageSwitcherLong;
    int position =0;
    int[] imgLong = {R.drawable.lookbook_img1,R.drawable.lookbook_img2,R.drawable.lookbook_img3};
    Button prevLong, nextLong;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookbook_page_long);

        imageSwitcherLong = findViewById(R.id.lookbook_long_switcher);
        prevLong = findViewById(R.id.previous);
        nextLong = findViewById(R.id.next);

        imageSwitcherLong.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
        imageSwitcherLong.setImageResource(imgLong[position]);
        nextLong.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (position<imgLong.length-1)
                {
                    position++;
                    imageSwitcherLong.setImageResource(imgLong[position]);
                }
            }
        });
        prevLong.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (position>=0)
                {
                    position--;
                    imageSwitcherLong.setImageResource(imgLong[position]);
                }
            }
        });
    }
}
