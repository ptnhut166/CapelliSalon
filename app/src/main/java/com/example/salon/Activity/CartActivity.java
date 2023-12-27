package com.example.salon.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salon.Adapter.CartAdapter;
import com.example.salon.Helper.ChangeNumberItemsListener;
import com.example.salon.Helper.ManagmentCart;
import com.example.salon.Helper.TinyDB;
import com.example.salon.R;
import com.example.salon.Domain.Products;
import java.util.List;

public class CartActivity extends BaseActivity {
    private RecyclerView.Adapter adapter;
    private ManagmentCart managmentCart;
    private double tax;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managmentCart = new ManagmentCart(this);

        setVariable();
        calculateCart();
        initList();
    }
    public String initDetail()
    {
        String detail = "";
        List<Products> list = managmentCart.getListCart();
        for (int i = 0; i < list.size(); i++) {
            detail = detail+ list.get(i).toString();
            detail = detail +"*" + list.get(i).getNumberInCart() +";";
        }
        return detail;
    }

    private void initList() {
        TextView emptyTxt = findViewById(R.id.emptyTxt);
        ScrollView scrollviewCart = findViewById(R.id.scrollviewCart);
        RecyclerView cardView = findViewById(R.id.cardView);




        if (managmentCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollviewCart.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollviewCart.setVisibility(View.VISIBLE);
        }



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cardView.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managmentCart.getListCart(), this, () -> calculateCart());
        cardView.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentTax = 0.02; //percent 2% tax
        double delivery = 10; // 10 Dollar

        tax = Math.round(managmentCart.getTotalFee() * percentTax * 100.0) / 100;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;


        TextView totalFeeTxt = findViewById(R.id.totalFeeTxt);
        TextView taxTxt = findViewById(R.id.taxTxt);
        TextView deliveryTxt = findViewById(R.id.deliveryTxt);
        TextView totalTxt = findViewById(R.id.totalTxt);

        AppCompatButton orderBtn = findViewById(R.id.orderBtn);

        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$" + tax);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);

        if(itemTotal>0)
        {
            orderBtn.setVisibility(View.VISIBLE);
        }
        else {
            orderBtn.setVisibility(View.GONE);
        }
    }

    private void setVariable() {
        ImageView backBtn = findViewById(R.id.backBtn);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(v.getContext(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        AppCompatButton orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(v.getContext(), OrderActivity.class);
                intent.putExtra("detail", initDetail().toString());

                startActivity(intent);
            }
        });
    }
}