package com.androidapp.hotelnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RoomActivity extends AppCompatActivity {

    String hotelName, location, roomPrice, roomCountString, totPriceString;
    int roomCountINT;
    double roomPriceDOUBLE, totPrice;

    EditText roomCount;
    Button bookNowBtn;

    PaymentDBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        DB = new PaymentDBHelper(this);

        bookNowBtn = findViewById(R.id.bookNowBtn2);

        Intent i = getIntent();

        hotelName = i.getStringExtra("hotelName");
        location = i.getStringExtra("location");
        roomPrice = i.getStringExtra("roomPrice");

        roomPriceDOUBLE = Double.parseDouble(roomPrice);

        totPrice = roomPriceDOUBLE * roomCountINT;
        totPrice = Math.round(totPrice * 100)/100.0;
        totPriceString = String.valueOf(totPrice);

        // ------------------------------------------------------------------------------

        bookNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                roomCount = findViewById(R.id.roomCount);
                roomCountString = roomCount.getText().toString();
                roomCountINT = Integer.parseInt(roomCountString);

                totPrice = roomPriceDOUBLE * roomCountINT;
                totPriceString = String.valueOf(totPrice);

                Boolean checkinsertdata  = DB.insertpaymentdata(hotelName, location, roomPrice, roomCountString, totPriceString);
                if(checkinsertdata==true)
                {
                    //Toast.makeText(RoomActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RoomActivity.this, PaymentActivity.class));
                }
                else
                {
                    Toast.makeText(RoomActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}