package com.example.salon.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

import com.bumptech.glide.Glide;
import com.example.salon.Domain.Products;
import com.example.salon.Helper.ManagmentCart;
import com.example.salon.R;

public class DetailActivity extends BaseActivity {
    private Products object;
    private int num = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart = new ManagmentCart(this);

        ImageView backBtn = findViewById(R.id.backBtn);
        ImageView picImageView = findViewById(R.id.pic);
        TextView priceTxt = findViewById(R.id.priceTxt);
        TextView descriptionTxt= findViewById(R.id.descriptionTxt);
        TextView rateTxt= findViewById(R.id.rateTxt);
        TextView totalTxt = findViewById(R.id.totalTxt);
        TextView titleTxt = findViewById(R.id.titleTxt);
        RatingBar ratingBar =findViewById(R.id.ratingBar);
        TextView plusBtn =findViewById(R.id.plusBtn);
        TextView minusBtn =findViewById(R.id.minusBtn);
        TextView numTxt= findViewById(R.id.numTxt);
        AppCompatButton addBtn= findViewById(R.id.addBtn);

        backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(picImageView);




        priceTxt.setText("$" + object.getPrice());
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        rateTxt.setText(object.getStar() + " Rating");
        ratingBar.setRating((float) object.getStar());
        totalTxt.setText((num * object.getPrice() + "$"));

        plusBtn.setOnClickListener(v -> {
            num = num + 1;
            numTxt.setText(num + " ");
            totalTxt.setText("$" + (num * object.getPrice()));
        });

        minusBtn.setOnClickListener(v -> {
            if (num > 1) {
                num = num - 1;
                numTxt.setText(num + "");
                totalTxt.setText("$" + (num * object.getPrice()));
            }
        });

        addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertProduct(object);
        });
    }

    private void getIntentExtra() {
        object = (Products) getIntent().getSerializableExtra("object");
    }
}