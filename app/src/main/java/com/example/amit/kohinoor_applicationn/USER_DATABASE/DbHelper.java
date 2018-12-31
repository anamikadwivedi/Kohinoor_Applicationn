package com.example.amit.kohinoor_applicationn.USER_DATABASE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static String CREATE_TABLE1;

    //    Database name
    static String DATABASE_NAME = "DATASHEET";

    //    Talble name
    public static final String TABLE1_NAME = "User_Info";

    //      Fields for table
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DOC = "dateofcreation";
    public static final String USER_TYPE = "usertype";
    public static final String PAGE_ACCESS = "pageaccess";




    //      Required resorces to manage database
    private ContentValues cValues;
    private SQLiteDatabase dataBase = null;
    private Cursor cursor;

    public DbHelper(Context context) {
        super(context, context.getExternalFilesDir(null).getAbsolutePath()
                + "/" + DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CREATE_TABLE1 = "CREATE TABLE " + TABLE1_NAME + "(" + ID
                + " INTEGER PRIMARY KEY autoincrement, " + NAME + " TEXT, "+ DOC + " TEXT, " + USER_TYPE + " TEXT, " + PAGE_ACCESS + " TEXT)";


        db.execSQL(CREATE_TABLE1);
        System.out
                .println("Table is created...........................!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);

        onCreate(db);
    }

    public void inserRecord(String name, String dateofcreation,String usertype, String pageaccess) {

        dataBase = getWritableDatabase();
        cValues = new ContentValues();

        cValues.put(NAME, name);
        cValues.put(DOC, dateofcreation);
        cValues.put(USER_TYPE, usertype);
        cValues.put(PAGE_ACCESS, pageaccess);


        // insert data into database
        dataBase.insert(TABLE1_NAME, null, cValues);

        dataBase.close();
    }

    public void updateRecord(String name, String dateofcreation,String usertype, String pageaccess) {

        dataBase = getWritableDatabase();

        cValues = new ContentValues();

        cValues.put(NAME, name);
        cValues.put(DOC, dateofcreation);
        cValues.put(USER_TYPE, usertype);
        cValues.put(PAGE_ACCESS, pageaccess);
//    Update data from database table
        dataBase.update(DbHelper.TABLE1_NAME, cValues,
                null, null);

        dataBase.close();
    }

    public Cursor selectRecords() {

        dataBase = getReadableDatabase();

//    Getting data from database table
        cursor = dataBase.rawQuery("select * from " + TABLE1_NAME, null);
        return cursor;
    }

    public void deleteRecord() {

        dataBase = getWritableDatabase();

//    Deleting all records from database table
        dataBase.delete(TABLE1_NAME, null, null);

        dataBase.close();
    }


}
