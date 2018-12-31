package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.amit.kohinoor_applicationn.R;
import com.example.amit.kohinoor_applicationn.UOMACTIVITYDATA.Student;
import com.example.amit.kohinoor_applicationn.UOMACTIVITYDATA.StudentOperations;

import java.util.List;

public class UomActivity extends  ListActivity {

    private StudentOperations studentDBoperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uom);


            studentDBoperation = new StudentOperations(this);
            studentDBoperation.open();

            List values = studentDBoperation.getAllStudents();



            // Use the SimpleCursorAdapter to show the
            // elements in a ListView
            ArrayAdapter adapter = new ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);
        }

        public void addUser(View view) {

            ArrayAdapter adapter = (ArrayAdapter) getListAdapter();

            EditText text = (EditText) findViewById(R.id.editText1);
            Student stud = studentDBoperation.addStudent(text.getText().toString());
           // ListView listView = (ListView) findViewById(R.id.list);

            adapter.add(stud);

        }

        public void deleteFirstUser(View view) {

            ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
            Student stud = null;

            if (getListAdapter().getCount() > 0) {
                stud = (Student) getListAdapter().getItem(0);
                studentDBoperation.deleteStudent(stud);
                adapter.remove(stud);
            }

        }

        @Override
        protected void onResume() {
            studentDBoperation.open();
            super.onResume();
        }

        @Override
        protected void onPause() {
            studentDBoperation.close();
            super.onPause();
        }

    }
