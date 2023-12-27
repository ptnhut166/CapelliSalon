package com.example.salon.Helper;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.R;
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

                    ref.child("booking_sel_employee").setValue(null)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // Dữ liệu đã được ghi thành công vào cơ sở dữ liệu
                    Log.d("Firebase", "Ghi dữ liệu thành công");
                } else {
                    // Xảy ra lỗi khi ghi dữ liệu
                    Log.e("Firebase", "Lỗi khi ghi dữ liệu", task.getException());
                }
            }
        });
//                    ref.child("booking_sel_loc").setValue("Location Name");
//                    ref.child("booking_sel_schedule").setValue("Schedule Time");
    }
}
