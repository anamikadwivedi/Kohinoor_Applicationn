package com.example.amit.kohinoor_applicationn.COMPANYSUPPORTLIB;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.amit.kohinoor_applicationn.R;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_contents);

            ListView listView = (ListView) findViewById(R.id.listView);
            myDB = new DatabaseHelper(this);

            //populate an ArrayList<String> from the database and then view it
            ArrayList<String> theList = new ArrayList<>();
            Cursor data = myDB.getListContents();
            if(data.getCount() == 0){
                Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
                theList.clear();
            }else{
                while(data.moveToNext()){
                    theList.add(data.getString(1));
                    theList.add(data.getString(2));
                    theList.add(data.getString(3));
                    ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                    listView.setAdapter(listAdapter);
                }
            }



    }
}
