package com.androidapp.hotelnet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CardDBHelper extends SQLiteOpenHelper {

    public CardDBHelper(Context context) {
        super(context, "Carddata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Carddetails(name TEXT primary key, email TEXT, age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Carddetails");
    }

    public Boolean insertuserdata(String name, String email, String age)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("age", age);
        long result = DB.insert("Carddetails", null, contentValues);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Carddetails", null);
        return cursor;
    }

    public Boolean updateuserdata(String name, String contact, String dob)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", contact);
        contentValues.put("age", dob);
        Cursor cursor = DB.rawQuery("Select * from Carddetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Carddetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deleteuserdata(String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Carddetails where name = ?", new String[]{name});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("Carddetails", "name=?", new String[]{name});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }
}
