package com.example.salon.Activity;

import static java.lang.String.valueOf;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salon.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword, editTextConfirm;
    Button btnSignUp, btnLogin;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    protected void onCreate(Bundle savedInstanceState)
    {
        FirebaseApp.initializeApp(/*context=*/ this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(
                DebugAppCheckProviderFactory.getInstance());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        mAuth=FirebaseAuth.getInstance();

        btnLogin = findViewById(R.id.change_login);

        editTextEmail= findViewById(R.id.edt_email);
        editTextPassword =findViewById(R.id.edt_password);
        editTextConfirm = findViewById(R.id.edt_confirm);

        btnSignUp=findViewById(R.id.btn_register);
        progressBar=findViewById(R.id.progressbar);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password,confirm;
                email= String.valueOf(editTextEmail.getText());
                password=String.valueOf(editTextPassword.getText());
                confirm=String.valueOf(editTextConfirm.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.length()>0 && password.length()>0){
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent =new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }


            }
        });

        View.OnClickListener listenerEditbutton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(view.getContext(), LoginActivity.class);

                startActivity(intent);
            }
        };
        //Gán Listener cho editbutton
        btnLogin.setOnClickListener(listenerEditbutton);

    }
}
