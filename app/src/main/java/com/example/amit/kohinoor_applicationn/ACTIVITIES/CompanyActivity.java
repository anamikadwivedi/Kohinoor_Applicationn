package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amit.kohinoor_applicationn.COMPANYSUPPORTLIB.DatabaseHelper;
import com.example.amit.kohinoor_applicationn.COMPANYSUPPORTLIB.ViewListContents;
import com.example.amit.kohinoor_applicationn.R;

public class CompanyActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button btnAdd,btnView;
    EditText editText,editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        editText = (EditText) findViewById(R.id.editText);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                String newEntry1 = editText1.getText().toString();
                String newEntry2 = editText2.getText().toString();

                if(editText.length()!= 0){
                    AddData(newEntry,newEntry1,newEntry2);
                    editText.setText("");
                    editText1.setText("");
                    editText2.setText("");

                }else{
                    Toast.makeText(CompanyActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompanyActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });


    }

    public void AddData(String newEntry,String newEntry1, String newEntry2) {

        boolean insertData = myDB.addData(newEntry,newEntry1,newEntry2);

        if(insertData==true){
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
}
