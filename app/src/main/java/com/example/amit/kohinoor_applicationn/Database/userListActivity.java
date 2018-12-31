package com.example.amit.kohinoor_applicationn.Database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.amit.kohinoor_applicationn.ACTIVITIES.MaterialActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.UserActivity;
import com.example.amit.kohinoor_applicationn.R;

public class userListActivity extends AppCompatActivity {


    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.NAME, DatabaseHelper.DESC, DatabaseHelper.QUALITY, DatabaseHelper.TAX };

    final int[] to = new int[] { R.id.id, R.id.title, R.id.desc };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

            setContentView(R.layout.fragment_emp_list);

            dbManager = new DBManager(this);
            dbManager.open();
            Cursor cursor = dbManager.fetch();

            listView = (ListView) findViewById(R.id.list_view);
            listView.setEmptyView(findViewById(R.id.empty));

            adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
            adapter.notifyDataSetChanged();

            listView.setAdapter(adapter);

            // OnCLickListiner For List Items
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                    TextView idTextView = (TextView) view.findViewById(R.id.id);
                    TextView titleTextView = (TextView) view.findViewById(R.id.title);
                    TextView descTextView = (TextView) view.findViewById(R.id.desc);

                    String id = idTextView.getText().toString();
                    String title = titleTextView.getText().toString();
                    String desc = descTextView.getText().toString();

                    Intent modify_intent = new Intent(getApplicationContext(), ModifyUserActivity.class);
                    modify_intent.putExtra("title", title);
                    modify_intent.putExtra("desc", desc);
                    modify_intent.putExtra("id", id);

                    startActivity(modify_intent);
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();
            if (id == R.id.btnAdd_data) {

                Intent add_mem = new Intent(this, MaterialActivity.class);
                startActivity(add_mem);

            }
            return super.onOptionsItemSelected(item);
        }

    }


