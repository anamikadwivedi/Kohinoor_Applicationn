package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amit.kohinoor_applicationn.R;
import com.example.amit.kohinoor_applicationn.SITEACTIVITYDETYAIL.DbHandler;
import com.example.amit.kohinoor_applicationn.SITEACTIVITYDETYAIL.DetailsActivity;

public class SiteActivity extends AppCompatActivity{
    EditText sitename, companyname, contactpersonname,Phone_number,Email_id,Address;
    Button insert;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        sitename = (EditText)findViewById(R.id.Site_Nametext);
        companyname = (EditText)findViewById(R.id.Company_name);
        contactpersonname = (EditText)findViewById(R.id.Contact_persontxt);
        Phone_number = (EditText) findViewById(R.id.Contact_no);
        Email_id = (EditText)findViewById(R.id.Email_Id);
        Address = (EditText)findViewById(R.id.Address_txt);

        insert = (Button)findViewById(R.id.btn_save);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sitename.getText().toString()+"\n";
                String Company_name = companyname.getText().toString();
                String Contact_Person = contactpersonname.getText().toString();
                String Contact_Number = Phone_number.getText().toString();
                String EMAIL_ID = Email_id.getText().toString();
                String ADDRESS = Address.getText().toString();

                DbHandler dbHandler = new DbHandler(SiteActivity.this);
                dbHandler.insertUserDetails(name,Company_name,Contact_Person,Contact_Number,EMAIL_ID,ADDRESS);
                intent = new Intent(SiteActivity.this,DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}