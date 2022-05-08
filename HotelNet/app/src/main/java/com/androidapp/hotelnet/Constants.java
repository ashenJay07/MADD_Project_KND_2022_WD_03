package com.androidapp.hotelnet;

public class Constants {

    //DB Name
    public static final String DB_NAME = "Login.db";

    //DB Version
    public static final int DB_VERSION = 1;

    //DB Table
    public static final String TABLE_NAME = "HOTEL_INFO_TABLE";

    //Table Columns
    public static final String ID = "ID";
    public static final String HotelName = "HotelName";
    public static final String Location = "Location";
    public static final String RoomPrice = "RoomPrice;";
    public static final String Image = "Image";

    //Create query for table
    public static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + " ("
            + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + HotelName + "TEXT,"
            + Location + "TEXT,"
            + RoomPrice + "TEXT,"
            + Image + "TEXT"
            + ");";
}
