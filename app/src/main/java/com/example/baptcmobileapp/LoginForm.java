package com.example.baptcmobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginForm extends AppCompatActivity {
    Button btnLogintomain, buttonsubmit;
    EditText username, password;
    FirebaseAuth mFireBaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        //redo
        mFireBaseAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        buttonsubmit = findViewById(R.id.btnsubmit);
        btnLogintomain = findViewById(R.id.btnLogintomain);

        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pwd = password.getText().toString();
                if(uname.isEmpty()){
                    username.setError("Please enter username");
                    username.requestFocus();
                }
                else if(pwd.isEmpty()){
                    password.setError("Please enter password");
                    password.requestFocus();
                }
                else {
                    mFireBaseAuth.createUserWithEmailAndPassword(uname, pwd).addOnCompleteListener(LoginForm.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(LoginForm.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(LoginForm.this,"Sign up unsuccessful,Try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        btnLogintomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginForm.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}