package com.example.app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OldDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Oldstudent.db";
    public static final String TABLE_NAME = "Oldpeople_table";
    public static final String COL1 = "OLDSTUDENTNO";
    public static final String COL2 = "OLDNAME";
    public static final String COL3 = "OLDAGE";
    public static final String COL4 = "OLDBIRTHDAY";
    public static final String COL5 = "OLDADDRESS";
    public static final String COL6 = "OLDCONTACTNO";
    public static final String COL7 = "OLDEMAIL";
    public static final String COL8 = "OLDSTRAND";
    public static final String COL9 = "OLDYRLEVEL";

    public OldDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " OLDNAME TEXT, OLDAGE TEXT, OLDBIRTHDAY TEXT, OLDADDRESS TEXT, OLDCONTACTNO TEXT, OLDEMAIL TEXT, OLDSTRAND TEXT, OLDYRLEVEL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean OldaddData(String Oldname, String Oldage, String Oldbirthday, String Oldaddress, String Oldcontactno, String Oldemail, String Oldstrand, String Oldyrlevel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, Oldname);
        contentValues.put(COL3, Oldage);
        contentValues.put(COL4, Oldbirthday);
        contentValues.put(COL5, Oldaddress);
        contentValues.put(COL6, Oldcontactno);
        contentValues.put(COL7, Oldemail);
        contentValues.put(COL8, Oldstrand);
        contentValues.put(COL9, Oldyrlevel);

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
