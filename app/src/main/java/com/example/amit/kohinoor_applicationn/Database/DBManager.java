package com.example.amit.kohinoor_applicationn.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name,String quality,String desc,String tax) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.NAME, name);
        contentValue.put(DatabaseHelper.QUALITY, quality);
        contentValue.put(DatabaseHelper.DESC, desc);
        contentValue.put(DatabaseHelper.TAX, tax);

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID,  };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String quality, String desc, String tax) {
        ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.NAME, name);
            contentValues.put(DatabaseHelper.QUALITY, quality);
            contentValues.put(DatabaseHelper.DESC, desc);
            contentValues.put(DatabaseHelper.TAX, tax);

       // contentValues.put(DatabaseHelper.SUBJECT, name);
        //contentValues.put(DatabaseHelper.DESC, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }


}
