package com.example.salon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {
    TextInputEditText edt_email;


    Button btn_forgot;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_page);

        Button btn_logout = findViewById(R.id.btn_logout);

        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= String.valueOf(edt_email.getText());
                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(ForgotActivity.this, "Password reset link has been sent to  your email!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(ForgotActivity.this, LoginActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(ForgotActivity.this, "Invalid email!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
