package com.androidapp.hotelnet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

public class PaymentDBHelper extends SQLiteOpenHelper {

    private static final String TAG = "MyActivity";

    public PaymentDBHelper(Context context) {
        super(context, "Payment.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table PaymentDetails(hotelName TEXT primary key, location TEXT, roomPrice TEXT, roomCount TEXT, totPrice TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists PaymentDetails");
    }

    public Cursor getdata()
    {
        int validator = 1;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from PaymentDetails", null);
        
        /*while (cursor.moveToNext() && (validator == 1)) {
            Log.e(TAG, "Hotel Name : " + cursor.getString(0) + "Location : " + cursor.getString(1) + "Room Price : " + cursor.getString(2) + "Room Count : " + cursor.getString(3) + "Total Price :" + cursor.getString(4));
            validator++;
        }*/
        
        return cursor;
    }

    public Boolean insertpaymentdata(String hotelName, String location, String roomPrice, String roomCount, String totPrice)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hotelName", hotelName);
        contentValues.put("location", location);
        contentValues.put("roomPrice", roomPrice);
        contentValues.put("roomCount", roomCount);
        contentValues.put("totPrice", totPrice);

        long result = DB.insert("PaymentDetails", null, contentValues);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

}
