package com.androidapp.hotelnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    EditText hotelName, location, roomPrice;
    Button insert, view, delete, update;
    CardDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        hotelName = findViewById(R.id.hotelName);
        location= findViewById(R.id.location);
        roomPrice = findViewById(R.id.roomPrice);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);
        update = findViewById(R.id.btnUpdate);

        DB = new CardDBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddCardActivity.this, ViewCardActivity.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = hotelName.getText().toString();
                String emailTXT = location.getText().toString();
                String ageTXT = roomPrice.getText().toString();

                Boolean checkinsertdata  = DB.insertuserdata(nameTXT, emailTXT, ageTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(AddCardActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddCardActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = hotelName.getText().toString();
                String contactTXT = location.getText().toString();
                String dobTXT = roomPrice.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AddCardActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddCardActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = hotelName.getText().toString();

                Boolean checkdeletedata  = DB.deleteuserdata(nameTXT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(AddCardActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddCardActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}