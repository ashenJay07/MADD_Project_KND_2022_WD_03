package com.androidapp.hotelnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddHotelActivity extends AppCompatActivity {

    EditText hotelName, location, roomPrice;
    Button insert, view, delete, update;
    HotelDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);

        hotelName = findViewById(R.id.hotelName);
        location= findViewById(R.id.location);
        roomPrice = findViewById(R.id.roomPrice);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);
        update = findViewById(R.id.btnUpdate);

        DB = new HotelDBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddHotelActivity.this, HomeActivity.class));
            }
        });


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hotelNameTXT = hotelName.getText().toString();
                String locationTXT = location.getText().toString();
                String roomPriceTXT = roomPrice.getText().toString();

                Boolean checkinsertdata  = DB.insertuserdata(hotelNameTXT, locationTXT, roomPriceTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(AddHotelActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddHotelActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hotelNameTXT = hotelName.getText().toString();
                String locationTXT = location.getText().toString();
                String roomPriceTXT = roomPrice.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(hotelNameTXT, locationTXT, roomPriceTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AddHotelActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddHotelActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hotelNameTXT = hotelName.getText().toString();

                Boolean checkdeletedata  = DB.deleteuserdata(hotelNameTXT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(AddHotelActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddHotelActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}