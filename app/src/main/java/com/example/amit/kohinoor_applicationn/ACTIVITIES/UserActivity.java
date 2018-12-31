package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amit.kohinoor_applicationn.R;
import com.example.amit.kohinoor_applicationn.USER_DATABASE.DbHelper;

public class UserActivity extends AppCompatActivity  implements android.view.View.OnClickListener {
    SQLiteDatabase db;
    EditText editsearchname,editdoc,editusertype,editpageaccess,id;
    Button Add, Delete, Modify, View,search ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //Create database,EmployeeDB database name
        db=openOrCreateDatabase("CompanyDb", Context.MODE_PRIVATE, null);
        //create table Employee
        db.execSQL("CREATE TABLE IF NOT EXISTS UserDetail(UserId INTEGER PRIMARY KEY AUTOINCREMENT,UserName VARCHAR,Doc VARCHAR,UserType VARCHAR,PageAccess VARCHAR);");
        editsearchname = (EditText) findViewById(R.id.Username_text);
        editdoc = (EditText) findViewById(R.id.DOC_text);
        editusertype = (EditText) findViewById(R.id.User_type_text);
        editpageaccess = (EditText) findViewById(R.id.Page_Access_text);
        Add = (Button) findViewById(R.id.btnAdd_data);
        Delete= (Button) findViewById(R.id.btndel);
        Modify= (Button) findViewById(R.id.btnupdate);
        View= (Button) findViewById(R.id. btnselect);
        search=(Button) findViewById(R.id. btnselectperticular);
        Add.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Modify.setOnClickListener(this);
        View.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    public void msg(Context context,String str)
    {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnAdd_data)
        {
            // code for save data
            if(editsearchname.getText().toString().trim().length()==0||
                    editdoc.getText().toString().trim().length()==0||
                    editusertype.getText().toString().trim().length()==0||
                    editpageaccess.getText().toString().trim().length()==0)

            {
                msg(this, "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO UserDetail(UserName,Doc,UserType,PageAccess)VALUES('"+ editsearchname.getText()+"','"+ editdoc.getText()+ "','"+ editusertype.getText()+ "','"+    editpageaccess.getText()+"');");
            msg(this, "Record added");
        }

        else if(v.getId()==R.id.btnupdate)
        {
            //code for update data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, "Enter User  Name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM UserDetail WHERE UserName='"+ editsearchname.getText()+"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE UserDetail  SET UserName ='"+ editsearchname.getText()+"', Doc='"+ editdoc.getText()+"', UserType='"+ editusertype.getText()+"'  ,PageAccess='"+      editpageaccess.getText()+"' WHERE UserName ='"+editsearchname.getText()+"'");
                msg(this, "Record Modified");
            }
            else
            {
                msg(this, "Invalid User Name");
            }
        }
        else if(v.getId()==R.id.btndel)
        {
            //code for delete data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, " Please enter User  Name ");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM UserDetail WHERE UserName ='"+ editsearchname.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM UserDetail WHERE UserName ='"+ editsearchname.getText()+"'");
                msg(this, "Record Deleted");
            }
            else
            {
                msg(this, "Invalid user Name ");
            }
        }
        else if (v.getId() == R.id.btnselect)
        {
            //code for select all data
            Cursor c=db.rawQuery("SELECT * FROM UserDetail", null);
            if(c.getCount()==0)
            {
                msg(this, "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("user Name: "+c.getString(1)+"\n");
                buffer.append("Date Of Creation: "+c.getString(2)+"\n\n");
                buffer.append("User Type: "+c.getString(3)+"\n\n");
                buffer.append("Page Access: "+c.getString(4)+"\n\n");
            }
            msg(this, buffer.toString());
        }
        else if(v.getId()==R.id.btnselectperticular)
        {
            //code for select particular data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, "Enter user Name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM UserDetail WHERE UserName='"+editsearchname.getText()+"'", null);
            if(c.moveToFirst())
            {
                editsearchname.setText(c.getString(1));
                editdoc.setText(c.getString(2));
                editusertype.setText(c.getString(3));
                editpageaccess.setText(c.getString(4));
            }
            else
            {
                msg(this, "Invalid user Name");
            }
        }
    }
}

                //Create database,EmployeeDB database name

