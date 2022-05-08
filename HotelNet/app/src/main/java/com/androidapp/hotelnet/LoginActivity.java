package com.androidapp.hotelnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username , password ;
    Button btnlogin ;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button)  findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "PLEASE ENETER ALL FIELDS", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkusernamepassword(user , pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "SIGN SUCCESFULLY", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext() , AddHotelActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "INVALID", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}