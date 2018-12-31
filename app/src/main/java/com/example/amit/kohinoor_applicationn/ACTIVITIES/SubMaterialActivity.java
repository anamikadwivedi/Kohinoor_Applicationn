package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amit.kohinoor_applicationn.R;

public class SubMaterialActivity extends AppCompatActivity implements android.view.View.OnClickListener {
    SQLiteDatabase db;
    EditText editsearchname,editMaterial,editsubmaterial;
    Button Add ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_material);

        //Create database,EmployeeDB database name
        db=openOrCreateDatabase("SMaterialDB", Context.MODE_PRIVATE, null);
        //create table Employee
        db.execSQL("CREATE TABLE IF NOT EXISTS MaterialDetail(UserId INTEGER PRIMARY KEY AUTOINCREMENT,UserName VARCHAR,Material VARCHAR,SubMaterial VARCHAR);");
        editsearchname = (EditText) findViewById(R.id.Username_text);
        editMaterial = (EditText) findViewById(R.id.Material_text);
        editsubmaterial = (EditText) findViewById(R.id.SubMaterial_text);

        Add = (Button) findViewById(R.id.btnAdd_data);

        Add.setOnClickListener(this);

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
                    editMaterial.getText().toString().trim().length()==0||
                    editsubmaterial.getText().toString().trim().length()==0)
            {
                msg(this, "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO MaterialDetail(UserName,Material,SubMaterial)VALUES('"+ editsearchname.getText()+"','"+ editMaterial.getText()+ "','"+    editsubmaterial.getText()+"');");
            msg(this, "Record added");
        }

    }
}
