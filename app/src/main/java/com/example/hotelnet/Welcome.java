package com.example.hotelnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    private Button login_btn;
    private Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenLoginPage();
            }
        });

        signup_btn = findViewById(R.id.signup_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenSignupPage();
            }
        });

    }

    public void OpenLoginPage() {
        Intent i1 = new Intent(this, Log_In.class);
        startActivity(i1);
    }

    public void OpenSignupPage() {
        Intent i2 = new Intent(this, Sign_Up.class);
        startActivity(i2);
    }

}