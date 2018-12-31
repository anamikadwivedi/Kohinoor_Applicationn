package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


import com.example.amit.kohinoor_applicationn.Database.DBManager;
import com.example.amit.kohinoor_applicationn.Database.userListActivity;
import com.example.amit.kohinoor_applicationn.R;

import java.util.ArrayList;
import java.util.List;

public class MaterialActivity extends AppCompatActivity  implements View.OnClickListener    {

    private Button addTodoBtn;
    private EditText nameEditText;
    private EditText qualityEditText;
    private EditText descEditText;
  //  private EditText unitofmeasurment;
    private EditText editTexttax;
    private Spinner spinner1;
    //String[] UOM = { "Bags", "Boxes", "Brass", "KG", "Ltrs", "Mtrs"};

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);


        setTitle("Add Record");

        nameEditText = (EditText) findViewById(R.id.name_text);
        descEditText = (EditText) findViewById(R.id.Description_text);
        qualityEditText = (EditText) findViewById(R.id.Quality_text);
        editTexttax = (EditText) findViewById(R.id.Tax_text);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn = (Button) findViewById(R.id.btnAdd_data);

        addTodoBtn.setOnClickListener(this);
        // Spinner element
     /*   Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener((OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        list.add("Android");
        list.add("Java");
        list.add("Spinner Data");
        list.add("Spinner Adapter");
        list.add("Spinner Example");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        // Button click Listener
        addListenerOnButton();


    }

    // Add spinner data

    public void addListenerOnSpinnerItemSelection(){

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //get the selected dropdown list value

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner);

        addTodoBtn = (Button) findViewById(R.id.btnAdd_data);

        addTodoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MaterialActivity.this,
                        "On Button Click : " +
                                "\n" + String.valueOf(spinner1.getSelectedItem()) ,
                        Toast.LENGTH_LONG).show();
            }

        });*/

    }


@Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAdd_data:

                        final String name = nameEditText.getText().toString();
                        final String desc = descEditText.getText().toString();
                        final String qulity = qualityEditText.getText().toString();
                        final String tax = editTexttax.getText().toString();

                        dbManager.insert(name, desc,qulity,tax);

                        Intent main = new Intent(MaterialActivity.this, userListActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        startActivity(main);
                        break;
                }
            }

        }