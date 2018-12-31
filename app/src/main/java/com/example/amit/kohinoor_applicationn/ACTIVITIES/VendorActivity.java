package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amit.kohinoor_applicationn.R;

public class VendorActivity extends AppCompatActivity implements android.view.View.OnClickListener {
    SQLiteDatabase db;
    EditText editsearchname,editcp,edittextphone,edittextemail,edittextcomments,edittextstatus;
    Button Add, Delete, Modify, View,search ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        //Create database,EmployeeDB database name
        db=openOrCreateDatabase("USERDB", Context.MODE_PRIVATE, null);
        //create table Employee
        db.execSQL("CREATE TABLE IF NOT EXISTS VendorDetail(EmpId INTEGER PRIMARY KEY AUTOINCREMENT,EmpName VARCHAR,ContactPerson VARCHAR,PhoneNumber VARCHAR,Email VARCHAR, Comments VARCHAR, Status VARCHAR);");
        editsearchname = (EditText) findViewById(R.id.Username_text);
        editcp =(EditText) findViewById(R.id.ContactPerson_text);
        edittextphone =(EditText) findViewById(R.id.Phone_text);
        edittextemail =(EditText) findViewById(R.id.Email_text);
        edittextcomments =(EditText) findViewById(R.id.Comments_button);
        edittextstatus =(EditText) findViewById(R.id.status_button);

        Add = (Button) findViewById(R.id.Save_data);
        Delete= (Button) findViewById(R.id.Delete_button);
        Modify= (Button) findViewById(R.id.update_button);
        View= (Button) findViewById(R.id.Show_data );
        search=(Button) findViewById(R.id. btnselect_perticular);
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
        if(v.getId()==R.id.Save_data)
        {
            // code for save data
            if(editsearchname.getText().toString().trim().length()==0||
                    edittextemail.getText().toString().trim().length()==0||
                    edittextphone.getText().toString().trim().length()==0||
                    editcp.getText().toString().trim().length()==0||
                    edittextcomments.getText().toString().trim().length()==0||
                     edittextstatus.getText().toString().trim().length()==0)

            {
                msg(this, "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO VendorDetail(EmpName,ContactPerson,PhoneNumber,Email, Comments, Status)VALUES('"+ editsearchname.getText()+"','"+ editcp.getText()+ "','"+ edittextphone.getText()+ "','"+ edittextemail.getText()+ "','"+ edittextcomments.getText()+ "','"+    edittextstatus.getText()+"');");
            msg(this, "Record added");
        }

        else if(v.getId()==R.id.update_button)
        {
            //code for update data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, "Enter VendorDetail  Name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM VendorDetail WHERE EmpName='"+ editsearchname.getText()+"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE VendorDetail  SET EmpName ='"+ editsearchname.getText()+"', ContactPerson='"+ editcp.getText()+"', PhoneNumber='"+ edittextphone.getText()+"', Email='"+ edittextemail.getText()+"',Comments='"+edittextcomments.getText()+"', Status='"+ edittextstatus.getText()+"' WHERE EmpName ='"+editsearchname.getText()+"'");
                msg(this, "Record Modified");
            }
            else
            {
                msg(this, "Invalid vendor Name");
            }
        }
        else if(v.getId()==R.id.Delete_button)
        {
            //code for delete data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, " Please enter Vandor  Name ");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM VendorDetail WHERE EmpName ='"+ editsearchname.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM VendorDetail WHERE EmpName ='"+ editsearchname.getText()+"'");
                msg(this, "Record Deleted");
            }
            else
            {
                msg(this, "Invalid Vandor Name ");
            }
        }
        else if (v.getId() == R.id.Show_data)
        {
            //code for select all data
            Cursor c=db.rawQuery("SELECT * FROM VendorDetail", null);
            if(c.getCount()==0)
            {
                msg(this, "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Employee Name: "+c.getString(1)+"\n");
                buffer.append("Contact Person: "+c.getString(2)+"\n\n");
                buffer.append("Phone Number: "+c.getString(3)+"\n\n");
                buffer.append("Email: "+c.getString(4)+"\n");
                buffer.append("Comments: "+c.getString(5)+"\n\n");
                buffer.append("Status: "+c.getString(6)+"\n\n");
            }
            msg(this, buffer.toString());
        }
        else if(v.getId()==R.id.btnselect_perticular)
        {
            //code for select particular data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, "Enter Vandor Name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM VendorDetail WHERE EmpName='"+editsearchname.getText()+"'", null);
            if(c.moveToFirst())
            {
                editsearchname.setText(c.getString(1));
                editcp.setText(c.getString(2));
                edittextphone.setText(c.getString(3));
                edittextemail.setText(c.getString(4));
                edittextcomments.setText(c.getString(5));
                edittextstatus.setText(c.getString(6));
            }
            else
            {
                msg(this, "Invalid Vandor Name");
            }
        }
    }
}
