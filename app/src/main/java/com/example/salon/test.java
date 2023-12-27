package com.example.salon;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class test extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(/*context=*/ this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(DebugAppCheckProviderFactory.getInstance());
        setContentView(R.layout.test);
        FirebaseDatabase dataBase= FirebaseDatabase.getInstance();
        DatabaseReference ref = dataBase.getReference("user_choice");

        ref.child("booking_sel_employee").setValue("")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Dữ liệu đã được ghi thành công vào cơ sở dữ liệu
                            // Hiển thị thông báo thành công bằng Toast
                            Toast.makeText(getApplicationContext(), "Ghi dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            // Xảy ra lỗi khi ghi dữ liệu
                            // Hiển thị thông báo lỗi bằng Toast
                            Toast.makeText(getApplicationContext(), "Lỗi khi ghi dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//                    ref.child("booking_sel_loc").setValue("Location Name");
//                    ref.child("booking_sel_schedule").setValue("Schedule Time");
    }
}