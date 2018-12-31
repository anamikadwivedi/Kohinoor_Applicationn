package com.example.amit.kohinoor_applicationn.ACTIVITIES;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.amit.kohinoor_applicationn.MACHINERYDETAIL.Product;
import com.example.amit.kohinoor_applicationn.MACHINERYDETAIL.ProductAdapter;
import com.example.amit.kohinoor_applicationn.MACHINERYDETAIL.SqliteDatabase;
import com.example.amit.kohinoor_applicationn.MainActivity;
import com.example.amit.kohinoor_applicationn.R;

import java.util.List;

public class MachineryActivity extends AppCompatActivity {
    private static final String TAG = MachineryActivity.class.getSimpleName();
    private SqliteDatabase mDatabase;

    // EditText name;
    //Button saveBtn;
    //Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machinery);

            FrameLayout fLayout = (FrameLayout) findViewById(R.id.activity_to_do);
            RecyclerView productView = (RecyclerView) findViewById(R.id.product_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            productView.setLayoutManager(linearLayoutManager);
            productView.setHasFixedSize(true);
            mDatabase = new SqliteDatabase(this);
            List<Product> allProducts = mDatabase.listProducts();
            if (allProducts.size() > 0) {
                productView.setVisibility(View.VISIBLE);
                ProductAdapter mAdapter = new ProductAdapter(this, allProducts);
                productView.setAdapter(mAdapter);
            } else {
                productView.setVisibility(View.GONE);
                Toast.makeText(this, "There is no product in the database. Start adding now", Toast.LENGTH_LONG).show();
            }
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // add new quick task
                    addTaskDialog();
                }
            });
        }
        private void addTaskDialog () {
            LayoutInflater inflater = LayoutInflater.from(this);
            View subView = inflater.inflate(R.layout.add_product_layout, null);
            final EditText nameField = (EditText) subView.findViewById(R.id.enter_name);
            final EditText quantityField = (EditText) subView.findViewById(R.id.enter_quantity);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add new product");
            builder.setView(subView);
            builder.create();
            builder.setPositiveButton("ADD PRODUCT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final String name = nameField.getText().toString();
                    final int quantity = Integer.parseInt(quantityField.getText().toString());
                    if (TextUtils.isEmpty(name) || quantity <= 0) {
                        Toast.makeText(MachineryActivity.this, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
                    } else {
                        Product newProduct = new Product(name, quantity);
                        mDatabase.addProduct(newProduct);
                        //refresh the activity
                        finish();
                        startActivity(getIntent());
                    }
                }
            });
            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MachineryActivity.this, "Task cancelled", Toast.LENGTH_LONG).show();
                }
            });
            builder.show();
        }
        @Override
        protected void onDestroy () {
            super.onDestroy();
            if (mDatabase != null) {
                mDatabase.close();
            }
        }
    }







      /*  name = (EditText) findViewById(R.id.name_text);
        //delete = (Button) findViewById(R.id.btn_Delete);

        saveBtn = (Button) findViewById(R.id.btn_login);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString() + "\n";

                DbHandler dbHandler = new DbHandler(MachineryActivity.this);
                dbHandler.insertUserDetails(username);
                intent = new Intent(MachineryActivity.this, DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}*/