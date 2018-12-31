package com.example.amit.kohinoor_applicationn.Database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.amit.kohinoor_applicationn.R;

public class ModifyUserActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText titleText;
    private Button updateBtn, deleteBtn;
    private EditText descText,QulityText,taxedittext;

    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);


                setTitle("Modify Record");

                dbManager = new DBManager(this);
                dbManager.open();

                titleText = (EditText) findViewById(R.id.subject_edittext);
                descText = (EditText) findViewById(R.id.description_edittext);
                QulityText = (EditText)findViewById(R.id.quality_text);
                taxedittext = (EditText) findViewById(R.id.Tax_text);

                updateBtn = (Button) findViewById(R.id.btn_update);
                deleteBtn = (Button) findViewById(R.id.btn_delete);

                Intent intent = getIntent();
                String id = intent.getStringExtra("id");
                String name = intent.getStringExtra("title");
                String desc = intent.getStringExtra("desc");

                _id = Long.parseLong(id);

                titleText.setText(name);
                descText.setText(desc);

                updateBtn.setOnClickListener(this);
                deleteBtn.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_update:
                        String title = titleText.getText().toString();
                        String desc = descText.getText().toString();
                        String quality = QulityText.getText().toString();
                        String tax = taxedittext.getText().toString();


                        dbManager.update(_id, title, desc,quality,tax);
                        this.returnHome();
                        break;

                    case R.id.btn_delete:
                        dbManager.delete(_id);
                        this.returnHome();
                        break;
                }
            }

            public void returnHome() {
                Intent home_intent = new Intent(getApplicationContext(), userListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home_intent);
            }
        }


