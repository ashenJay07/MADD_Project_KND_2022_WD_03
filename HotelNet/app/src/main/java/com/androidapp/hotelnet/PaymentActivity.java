package com.androidapp.hotelnet;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    TextView hotelName, location, displayRoomPrice, displayRoomCount, displayTotalPrice;
    String varHotelName;

    Button paybtn;

    PaymentDBHelper DB = new PaymentDBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        paybtn = findViewById(R.id.payBtn);

        hotelName = findViewById(R.id.hotelName);
        location = findViewById(R.id.location);
        displayRoomPrice = findViewById(R.id.displayRoomPrice);
        displayRoomCount = findViewById(R.id.displayRoomCount);
        displayTotalPrice = findViewById(R.id.displayTotalPrice);

        displayData();

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentActivity.this, AddCardActivity.class));

            }
        });

    }

    private void displayData() {

        int validator = 1;

        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(PaymentActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                if( validator == 1) {
                    hotelName.setText(cursor.getString(0));
                    location.setText(cursor.getString(1));
                    displayRoomPrice.setText(cursor.getString(2));
                    displayRoomCount.setText(cursor.getString(3));
                    displayTotalPrice.setText(cursor.getString(4));

                    validator++;
                }

            }

        }

        /**/
        /*while (cursor.moveToNext()) {
                hotelName.setText(cursor.getString(0));
                location.setText(cursor.getString(1));
                displayRoomPrice.setText(cursor.getString(2));
                displayRoomCount.setText(cursor.getString(3));
                displayTotalPrice.setText(cursor.getString(4));



                varHotelName = cursor.getString(0);

           }*/

    }
}