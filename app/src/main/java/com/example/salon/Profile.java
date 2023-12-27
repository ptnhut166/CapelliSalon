package com.example.salon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {
    public static TextView id_profile;
    public static TextView tv_profile;
    public static TextView address;
    public static TextView phone;
    public static TextView birthday;
    public static TextView usermail;
    String userid;
    String newName, newAddress, newPhone, newMail, newBirthday;
    SwipeRefreshLayout swipe;
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // Thực hiện tải lại thông tin hoặc cập nhật giao diện ở đây
//        user_class.Database.getReference().child("userID").child(userid).child("Personal Information")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        // Kiểm tra xem dữ liệu có tồn tại không
//                        if (dataSnapshot.exists()) {
//                            // Vòng lặp qua tất cả các trường dữ liệu
//                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                                // Bạn có thể lấy key (tên trường) và value (giá trị) như sau:
//                                String key = snapshot.getKey();
//                                Object value = snapshot.getValue();
//
//                                // Thực hiện các hành động tương ứng dựa trên key và value
//                                switch (key) {
//                                    case "Name":
//                                        tv_profile.setText(String.valueOf(value));
//                                        break;
//                                    case "Phone":
//                                        phone.setText(String.valueOf(value));
//                                    case "Email":
//                                        usermail.setText(String.valueOf(value));
//                                        break;
//                                    case "Birthday":
//                                        birthday.setText(String.valueOf(value));
//                                        break;
//                                    case "Address":
//                                        address.setText(String.valueOf(value));
//                                        break;
//                                    // Thêm các case khác nếu cần
//                                }
//                            }
//                        } else {
//                            Log.d("FirebaseData", "Personal Information is not available.");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Xử lý khi có lỗi xảy ra
//                        Log.w("FirebaseError", "Failed to read value.", error.toException());
//                    }
//                });
//
//    }

    protected void onCreate(Bundle savedInstanceState) {
        userid = user_class.mAuth.getUid();
        super.onCreate(savedInstanceState);

        swipe = findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                user_class.Database.getReference().child("userID").child(userid).child("Personal Information")
                            .addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    // Kiểm tra xem dữ liệu có tồn tại không
                                    if (dataSnapshot.exists()) {
                                        // Vòng lặp qua tất cả các trường dữ liệu
                                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                            // Bạn có thể lấy key (tên trường) và value (giá trị) như sau:
                                            String key = snapshot.getKey();
                                            Object value = snapshot.getValue();

                                            // Thực hiện các hành động tương ứng dựa trên key và value
                                            switch (key) {
                                                case "Name":
                                                    tv_profile.setText(String.valueOf(value));
                                                    break;
                                                case "Phone":
                                                    phone.setText(String.valueOf(value));
                                                case "Email":
                                                    usermail.setText(String.valueOf(value));
                                                    break;
                                                case "Birthday":
                                                    birthday.setText(String.valueOf(value));
                                                    break;
                                                case "Address":
                                                    address.setText(String.valueOf(value));
                                                    break;
                                                // Thêm các case khác nếu cần
                                            }
                                        }
                                    } else {
                                        Log.d("FirebaseData", "Personal Information is not available.");
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError error) {
                                    // Xử lý khi có lỗi xảy ra
                                    Log.w("FirebaseError", "Failed to read value.", error.toException());
                                }
                            });
                swipe.setRefreshing(false);
            }
        });
        ActivityResultLauncher<Intent> profileEditLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        // Xử lý kết quả ở đây
                        Intent data = result.getData();
                        if (data != null) {
//                            String newId = data.getStringExtra("newId");
                             newName = data.getStringExtra("newName");
                             newAddress = data.getStringExtra("newAddress");
                             newPhone =  data.getStringExtra("newPhone");
                             newMail = data.getStringExtra("newMail");
                             newBirthday = data.getStringExtra("newBirthday");
                            // Cập nhật thông tin tại đây
//                            id_profile.setText(newId);
                            tv_profile.setText(newName);
                            address.setText(newAddress);
                            phone.setText(newPhone);
                            usermail.setText(newMail);
                            birthday.setText(newBirthday);

                            //cập nhật lên cơ sở dữ liệu, không cho sửa ID vì ID liên kết đến userID gốc của user
//
                            user_class.Database.getReference().child("userID").child(userid).child("Personal Infomation").child("Name").setValue(newName);
                            user_class.Database.getReference().child("userID").child(userid).child("Personal Infomation").child("Phone").setValue(newPhone);
                            user_class.Database.getReference().child("userID").child(userid).child("Personal Infomation").child("Email").setValue(newMail);
                            user_class.Database.getReference().child("userID").child(userid).child("Personal Infomation").child("Address").setValue(newAddress);
                            user_class.Database.getReference().child("userID").child(userid).child("Personal Infomation").child("Birthday").setValue(newBirthday);

                        }
                    }
                }
        );

        setContentView(R.layout.profile);
        BottomNavigationView bottomNav = findViewById(R.id.bnv_profile); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(Profile.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(Profile.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(Profile.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(Profile.this);
                }

                return true;
            }
        });


        Button buttonLogout = findViewById(R.id.btn_logOut2);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_class.mAuth.signOut();
                Intent intent = new Intent(Profile.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        ImageButton imgbutton = findViewById(R.id.imgbtn_profile_infoEdit);
        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Profile_edit.class);
                profileEditLauncher.launch(intent);
            }
        });

        userid = user_class.mAuth.getUid();
        id_profile = findViewById(R.id.id_profile);
        tv_profile = findViewById(R.id.tv_profile_name);
        address = findViewById(R.id.tv_profile_address);
        phone = findViewById(R.id.tv_profile_mobile);
        birthday = findViewById(R.id.tv_profile_dob);
        usermail = findViewById(R.id.tv_profile_email);

        //setID
        id_profile.setText(userid);

        //setName

//        user_class.Database.getReference().child("userID").child(userid).child("Personal Information")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        // Kiểm tra xem dữ liệu có tồn tại không
//                        if (dataSnapshot.exists()) {
//                            // Vòng lặp qua tất cả các trường dữ liệu
//                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                                // Bạn có thể lấy key (tên trường) và value (giá trị) như sau:
//                                String key = snapshot.getKey();
//                                Object value = snapshot.getValue();
//
//                                // Thực hiện các hành động tương ứng dựa trên key và value
//                                switch (key) {
//                                    case "Name":
//                                        tv_profile.setText(String.valueOf(value));
//                                        break;
//                                    case "Phone":
//                                        phone.setText(String.valueOf(value));
//                                    case "Email":
//                                        usermail.setText(String.valueOf(value));
//                                        break;
//                                    case "Birthday":
//                                        birthday.setText(String.valueOf(value));
//                                        break;
//                                    case "Address":
//                                        address.setText(String.valueOf(value));
//                                        break;
//                                    // Thêm các case khác nếu cần
//                                }
//                            }
//                        } else {
//                            Log.d("FirebaseData", "Personal Information is not available.");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Xử lý khi có lỗi xảy ra
//                        Log.w("FirebaseError", "Failed to read value.", error.toException());
//                    }
//                });



        //setAddress
        //setPhone
        //setD.O.B

        //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100 && resultCode == RESULT_OK) {
//            if (data != null) {
//                String newId = data.getStringExtra("newId");
//                // Cập nhật giá trị id bằng newId ở đây
//                id_profile.setText("test");
//            }
//        }
//    }
//        Button buttonTest = findViewById(R.id.btn_getUserid);
//        buttonTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Profile.this, userid, Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
