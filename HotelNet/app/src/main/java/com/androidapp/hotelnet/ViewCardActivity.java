package com.androidapp.hotelnet;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewCardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name, email, age;
    CardDBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_card);

        DB = new CardDBHelper(this);
        name = new ArrayList<>();
        email = new ArrayList<>();
        age = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, name, email, age);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

        private void displaydata()
        {
            Cursor cursor = DB.getdata();
            if(cursor.getCount()==0)
            {
                Toast.makeText(ViewCardActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                return;
            }
            else
            {
                while(cursor.moveToNext())
                {
                    name.add(cursor.getString(0));
                    email.add(cursor.getString(1));
                    age.add(cursor.getString(2));
                }
            }

    }
}