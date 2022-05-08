package com.androidapp.hotelnet;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    Button addInfo;
    RecyclerView recyclerView;
    ArrayList<String> name, email, age;
    HotelDBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DB = new HotelDBHelper(this);
        name = new ArrayList<>();
        email = new ArrayList<>();
        age = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, name, email, age);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        /*addInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddHotelActivity.class));
            }
        });*/

    }
        private void displayData() {

            Cursor cursor = DB.getdata();
            if (cursor.getCount() == 0) {
                Toast.makeText(HomeActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            } else {
                while (cursor.moveToNext()) {
                    name.add(cursor.getString(0));
                    email.add(cursor.getString(1));
                    age.add(cursor.getString(2));
                }
            }
        }

}