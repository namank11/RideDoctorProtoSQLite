package com.example.naman.ridedoctor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Register.db";
    public static final String TABLE_NAME="Users";
    public static final String COL_1="Id";
    public static final String COL_2="Name";
    public static final String COL_3="Email";
    public static final String COL_4="Phone";
    public static final String COL_5="Password";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Email TEXT,Phone TEXT,Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
