package com.example.salon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salon.Domain.Order;
import com.example.salon.R;
import com.example.salon.Helper.ManagmentCart;
import com.google.firebase.database.FirebaseDatabase;
import com.example.salon.Helper.TinyDB;

import com.example.salon.Adapter.CartAdapter;
import com.example.salon.Helper.ChangeNumberItemsListener;
import com.example.salon.Helper.ManagmentCart;



import com.google.firebase.database.DatabaseReference;


import java.util.List;
import java.util.UUID;

public class OrderActivity extends  BaseActivity{

    private DatabaseReference mDatabase;
    private ManagmentCart managmentCart;

    private CartAdapter cartAdapter;
    private TinyDB tinyDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        managmentCart = new ManagmentCart(this);

        TextView detailTxt= findViewById(R.id.detailTxt);
        TextView priceTxt= findViewById(R.id.priceTxt);
        TextView IDTxt = findViewById(R.id.IDTxt);

        EditText nameEdt= findViewById(R.id.edt_fullname);
        EditText emailEdt= findViewById(R.id.edt_email);
        EditText phoneEdt= findViewById(R.id.edt_phone);
        EditText addressEdt= findViewById(R.id.edt_address);

        Button btnOrder =findViewById(R.id.btn_order);
        Button btnCancel = findViewById(R.id.btn_cancel);

        Intent intent = getIntent();

        String intentDetail = intent.getStringExtra("detail");
        double price  = calculateCart();
        String finalresult = String.valueOf(price);

        detailTxt.setText(intentDetail);
        priceTxt.setText(finalresult);

        String uniqueID = UUID.randomUUID().toString();
        IDTxt.setText(uniqueID);




        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID = IDTxt.getText().toString();
                String name = nameEdt.getText().toString();
                String email = emailEdt.getText().toString();
                String phone = phoneEdt.getText().toString();
                String address = addressEdt.getText().toString();
                String detail = detailTxt.getText().toString();
                String price = priceTxt.getText().toString();


                // Check if fields are not empty before proceeding
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(address) ) {
                    mDatabase = FirebaseDatabase.getInstance().getReference();
                    writeNewOrder(ID, name, email,phone, address, detail, price );

                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), HomeActivity.class);

                    startActivity(intent);
                } else {
                    Toast.makeText(OrderActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(v.getContext(), CartActivity.class);

                startActivity(intent);
            }
        });


    }

    private double calculateCart() {
        double tax;
        double percentTax = 0.02; //percent 2% tax
        double delivery = 10; // 10 Dollar

        tax = Math.round(managmentCart.getTotalFee() * percentTax * 100.0) / 100;

        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;

        return total;
    }
    public void writeNewOrder(String ID , String name, String email, String phone, String address, String detail, String price) {
        // Check if userID is not null before proceeding
            Order order = new Order(ID, name, phone, email, address, price, detail);

            mDatabase.child("Orders").child(Order.getID()).setValue(order);
            Toast.makeText(OrderActivity.this, "Order added successfully", Toast.LENGTH_SHORT).show();

    }
}

