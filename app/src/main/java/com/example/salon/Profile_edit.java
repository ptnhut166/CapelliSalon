package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class Profile_edit extends AppCompatActivity {
    private String UID;
//    String id;
//    String name;
//    String address;
//    String phone;
//    String birthday;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);
        BottomNavigationView bottomNav = findViewById(R.id.bnv_profile); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(Profile_edit.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(Profile_edit.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(Profile_edit.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(Profile_edit.this);
                }
                return true;
            }
        });

        Button btn_cancel = findViewById(R.id.btn_profile_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_edit.this, Profile.class);
                startActivity(intent);
            }
        });
//        TextView ed_id_profile = findViewById(R.id.ed_id_profile);
        TextView tv_name = findViewById(R.id.ed_profile_name);

        TextView ed_address = findViewById(R.id.ed_profile_address);
        TextView ed_phone = findViewById(R.id.ed_profile_mobile);
        TextView ed_birthday = findViewById(R.id.ed_profile_dob);
        TextView ed_mail = findViewById(R.id.ed_profile_email);
        FirebaseDatabase database = user_class.Database;
        Button btn_save = findViewById(R.id.btn_profile_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_name.getText().toString().isEmpty()) {
                    Toast.makeText(Profile_edit.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (ed_address.getText().toString().isEmpty()) {
                    Toast.makeText(Profile_edit.this, "address cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (ed_phone.getText().toString().isEmpty()) {
                    Toast.makeText(Profile_edit.this, " Phone cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (ed_birthday.getText().toString().isEmpty()) {
                    Toast.makeText(Profile_edit.this, "birthday cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (ed_mail.getText().toString().isEmpty()) {
                    Toast.makeText(Profile_edit.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    if(user_class.mAuth.getCurrentUser() != null){

//                    //Thực hiện update thông tin profile
//                        String id = ed_id_profile.getText().toString();
                        String name = tv_name.getText().toString();
                        String address = ed_address.getText().toString();
                        String phone = ed_phone.getText().toString();
                        String birthday = ed_birthday.getText().toString();
                        String mail = ed_mail.getText().toString();
//                    Profile.id_profile.setText(id);
                    Toast.makeText(Profile_edit.this, "Profile info updated!", Toast.LENGTH_SHORT).show();
                    Intent Result_intent = new Intent();
//                    Result_intent.putExtra("newId", id);
                    Result_intent.putExtra("newName", name);
                    Result_intent.putExtra("newAddress", address);
                    Result_intent.putExtra("newPhone", phone);
                    Result_intent.putExtra("newBirthday", birthday);
                    Result_intent.putExtra("newMail",mail);
                    setResult(RESULT_OK, Result_intent);
                    finish();
                    } else Toast.makeText(Profile_edit.this, "Attempt to invoke virtual method .getUid() on a null object reference", Toast.LENGTH_SHORT).show();
            }
        }});


    }
}
