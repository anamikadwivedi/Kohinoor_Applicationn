package com.example.amit.kohinoor_applicationn.SITEACTIVITYDETYAIL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler  extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "adminDb";
    private static final String TABLE_Users = "detail";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_COMPANY_NAME = "company_name";
    private static final String KEY_CONTACT_PERSON = "Contact_Person";
    private static final String KEY_PHONENO = "phoneno";
    private static final String KEY_EMAIL = "emailid";
    private static final String KEY_ADDRESS = "address";

    public DbHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_COMPANY_NAME + " TEXT,"+KEY_CONTACT_PERSON + " TEXT, "+ KEY_PHONENO + "TEXT," +KEY_EMAIL + " TEXT, "
                + KEY_ADDRESS + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        // Create tables again
        onCreate(db);
    }
    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    // Adding new User Details
    public void insertUserDetails(String name, String Company_name, String Contact_Person, String Contact_Number, String EMAIL_ID, String ADDRESS){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_COMPANY_NAME, Company_name);
        cValues.put(KEY_CONTACT_PERSON, Contact_Person);
        cValues.put(KEY_PHONENO, Contact_Number);
        cValues.put(KEY_EMAIL, EMAIL_ID);
        cValues.put(KEY_ADDRESS, ADDRESS);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users,null, cValues);
        db.close();
    }

    // Get User Details
    // Get User Details
    public ArrayList<HashMap<String, String>> GetUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name,ADDRESS , Company_name FROM "+ TABLE_Users;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("address",cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
            user.put("companyname",cursor.getString(cursor.getColumnIndex(KEY_COMPANY_NAME)));
            userList.add(user);
        }
        return  userList;
    }

    // Get User Details based on userid
    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name, company_name, contact_person, phone_no, email_id, address  FROM "+ TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_NAME, KEY_COMPANY_NAME, KEY_CONTACT_PERSON,KEY_PHONENO, KEY_EMAIL, KEY_ADDRESS}, KEY_ID+ "=?",new String[]{String.valueOf(userid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("company_name",cursor.getString(cursor.getColumnIndex(KEY_COMPANY_NAME)));
            user.put("contact_person",cursor.getString(cursor.getColumnIndex(KEY_CONTACT_PERSON)));
            user.put("phone_no",cursor.getString(cursor.getColumnIndex(KEY_PHONENO)));
            user.put("Email",cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            user.put("Address",cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
            userList.add(user);
        }
        return  userList;
    }
    // Delete User Details
    public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_ID+" = ?",new String[]{String.valueOf(userid)});
        db.close();
    }
    // Update User Details
    public int UpdateUserDetails(String company_name, String email, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_COMPANY_NAME, company_name);
        cVals.put(KEY_EMAIL, email);
        int count = db.update(TABLE_Users, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }

}
