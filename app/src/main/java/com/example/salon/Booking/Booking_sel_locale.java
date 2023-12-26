package com.example.salon.Booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.Domain.BookingInfo;
import com.example.salon.Helper.NavigationManager;
import com.example.salon.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking_sel_locale extends AppCompatActivity {
    RelativeLayout location, location0, location1, location2, location3;
    TextView name0, name1, name2, name3, address0, address1, address2, address3;
    FirebaseDatabase dataBase;

    private void setLocationOnClickListener(final RelativeLayout location, final TextView nameTextView, final TextView addressTextView) {
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện hành động khi nhấn vào location ở đây
                String name = nameTextView.getText().toString();
                String address = addressTextView.getText().toString();
                BookingInfo bookingInfo = new BookingInfo(name, address, "", "", "");
                // Sử dụng thông tin name và address ở đây (ví dụ: hiển thị hoặc xử lý thông tin)
                // Ví dụ:
                Toast.makeText(getApplicationContext(), "Selected Name: " + name + ", Address: " + address, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Booking_sel_locale.this, Booking_sel_schedule.class);
                intent.putExtra("booking_info", bookingInfo);
                startActivity(intent);
                finish(); // Đóng activity hiện tại nếu cần
                DatabaseReference bookingRef = FirebaseDatabase.getInstance().getReference().child("bookings");
                bookingRef.push().setValue(bookingInfo);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_sel_locate);
        BottomNavigationView bottomNav = findViewById(R.id.bnv_locate); // Thay R.id.bottom_navigation bằng ID của BottomNavigationView trong layout của bạn
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.action_noti) {
                    // Xử lý khi click vào Notifications
                    NavigationManager.navigateToNotifications(Booking_sel_locale.this);
                    // Không gọi finish() ở đây nếu bạn không muốn kết thúc Activity hiện tại
                } else if (id == R.id.action_home) {
                    // Xử lý khi click vào Home
                    NavigationManager.navigateToHome(Booking_sel_locale.this);
                } else if (id == R.id.action_cart) {
                    // Xử lý khi click vào Cart
                    NavigationManager.navigateToCart(Booking_sel_locale.this);
                } else if (id == R.id.action_his) {
                    // Xử lý khi click vào History
                    NavigationManager.navigateToHistory(Booking_sel_locale.this);
                } else if (id == R.id.action_acc) {
                    // Xử lý khi click vào Settings
                    NavigationManager.navigateToProfile(Booking_sel_locale.this);
                }

                return true;
            }
        });

        dataBase = FirebaseDatabase.getInstance();
        name0 = findViewById(R.id.tv_locate_name_0);
        name1 = findViewById(R.id.tv_locate_name_1);
        name2 = findViewById(R.id.tv_locate_name_2);
        name3 = findViewById(R.id.tv_locate_name_3);
        address0 = findViewById(R.id.tv_locate_address_0);
        address1 = findViewById(R.id.tv_locate_address_1);
        address2 = findViewById(R.id.tv_locate_address_2);
        address3 = findViewById(R.id.tv_locate_address_3);
        location0 = findViewById(R.id.location_0);
        location1 = findViewById(R.id.location_1);
        location2 = findViewById(R.id.location_2);
        location3 = findViewById(R.id.location_3);

        setLocationOnClickListener(location0, name0, address0);
        setLocationOnClickListener(location1, name1, address1);
        setLocationOnClickListener(location2, name2, address2);
        setLocationOnClickListener(location3, name3, address3);

        ImageButton imageButton = findViewById(R.id.ibutton_next);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Đưa logic xử lý khi nhấn vào imageButton ở đây (nếu có)
                location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(location.isSelected() == true) {
//                    // Lấy tham chiếu đến node 'user_choice'
//                    DatabaseReference ref = dataBase.getReference("user_choice");
//                    // Thêm mới hoặc cập nhật dữ liệu
//                    ref.child("booking_sel_employee").setValue("Employee Name");
//                    ref.child("booking_sel_loc").setValue("Location Name");
//                    ref.child("booking_sel_schedule").setValue("Schedule Time");

                            //setup intent
                            Intent intent = new Intent(Booking_sel_locale.this, Booking_sel_schedule.class);
                            startActivity(intent);


                        }
                    }
                });
            }
        });
    }
}
