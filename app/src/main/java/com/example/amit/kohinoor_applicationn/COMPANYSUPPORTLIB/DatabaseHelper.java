package com.example.amit.kohinoor_applicationn.COMPANYSUPPORTLIB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Com.db";
    public static final String TABLE_NAME = "List_Data";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";
    public static final String COL3 = "ITEM2";
    public static final String COL4 = "ITEM3";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       /* String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ITEM1 TEXT)";
        db.execSQL(createTable);*/

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(ID  INTEGER PRIMARY KEY AUTOINCREMENT," + COL2 + " TEXT,"
                + COL3 + " TEXT,"
                + COL4 + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item1, String item2, String item3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);
        contentValues.put(COL4, item3);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

}
