package com.example.app2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "people_table";
    public static final String COL1 = "STUDENTID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "AGE";
    public static final String COL4 = "BIRTHDAY";
    public static final String COL5 = "ADDRESS";
    public static final String COL6 = "CONTACTNO";
    public static final String COL7 = "EMAIL";
    public static final String COL8 = "PREVIOUSSCHOOL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT, AGE TEXT, BIRTHDAY TEXT, ADDRESS TEXT, CONTACTNO TEXT, EMAIL TEXT, PREVIOUSSCHOOL TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String age, String birthday, String address, String contactno, String email, String previousschool) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, age);
        contentValues.put(COL4, birthday);
        contentValues.put(COL5, address);
        contentValues.put(COL6, contactno);
        contentValues.put(COL7, email);
        contentValues.put(COL8, previousschool);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor showData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

}
