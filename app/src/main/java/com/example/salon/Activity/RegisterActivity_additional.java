package com.example.salon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Booking.user_class;
import com.example.salon.R;
import com.google.android.material.textfield.TextInputEditText;


public class RegisterActivity_additional extends AppCompatActivity {

    Button btn_signup_addit;
    TextInputEditText edt_name, edt_birth, edt_phone, edt_address, edt_email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity_additional);

        btn_signup_addit=findViewById(R.id.btn_register_addit);
        edt_name = findViewById(R.id.edt_name_addit);
        edt_birth= findViewById(R.id.edt_birth_addit);
        edt_phone = findViewById(R.id.ed_phone_addit);
        edt_address=findViewById(R.id.edt_address_addit);
        edt_email = findViewById(R.id.edt_email_addit);

        btn_signup_addit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edt_name.getText()) ){
                    Toast.makeText(RegisterActivity_additional.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(edt_birth.getText())){
                    Toast.makeText(RegisterActivity_additional.this, "Please enter Birthday", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(edt_phone.getText())){
                    Toast.makeText(RegisterActivity_additional.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(edt_address.getText())) {
                    Toast.makeText(RegisterActivity_additional.this, "Please enter address", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(edt_name.getText())) {
                    Toast.makeText(RegisterActivity_additional.this, "Please enter name", Toast.LENGTH_SHORT).show();
                } else {
                    user_class.Database.getReference().child("userID").child(user_class.mAuth.getUid()).child("Personal Information").child("Name").setValue(edt_name.getText().toString());
                    user_class.Database.getReference().child("userID").child(user_class.mAuth.getUid()).child("Personal Information").child("Birthday").setValue(edt_birth.getText().toString());
                    user_class.Database.getReference().child("userID").child(user_class.mAuth.getUid()).child("Personal Information").child("Phonenumber").setValue(edt_phone.getText().toString());
                    user_class.Database.getReference().child("userID").child(user_class.mAuth.getUid()).child("Personal Information").child("Email").setValue(edt_email.getText().toString());
                    user_class.Database.getReference().child("userID").child(user_class.mAuth.getUid()).child("Personal Information").child("Address").setValue(edt_address.getText().toString());
                    Toast.makeText(RegisterActivity_additional.this, "Info added to FirebaseDatabase", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity_additional.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
