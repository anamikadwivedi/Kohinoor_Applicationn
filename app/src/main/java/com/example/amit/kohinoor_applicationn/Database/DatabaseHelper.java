package com.example.amit.kohinoor_applicationn.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "material";

    // Table columns
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String QUALITY = "quality";
    public static final String TAX = "tax";
    public static final String DESC = "description";

    // Database Information
    static final String DB_NAME = "JOURNALDEV_COUNTRIES.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " +QUALITY + " TEXT NOT NULL, " + TAX + " INTEGER NOT NULL, " + DESC + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
