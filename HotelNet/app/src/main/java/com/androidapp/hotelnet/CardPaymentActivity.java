package com.androidapp.hotelnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CardPaymentActivity extends AppCompatActivity {

    Button confirmPaymentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payment);

        confirmPaymentBtn = findViewById(R.id.confirmPaymentBtn);

        confirmPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardPaymentActivity.this, HomeActivity.class));
            }
        });

    }
}