package com.example.android.placementassist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CompanyActivity extends AppCompatActivity {

    private EditText companyNameEt, genReqEt, acadReqEt, expReqEt;
    private FloatingActionButton nextFabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        companyNameEt = findViewById(R.id.editcompany);
        genReqEt = findViewById(R.id.general_req_et);
        acadReqEt = findViewById(R.id.academic_req_et);
        expReqEt = findViewById(R.id.experience_req_et);

        nextFabButton = findViewById(R.id.next_button_fb);

        final String companyName = companyNameEt.getText().toString().trim();
        final String genReq = genReqEt.getText().toString().trim();
        final String acadReq = acadReqEt.getText().toString().trim();
        final String expReq = expReqEt.getText().toString().trim();

        nextFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allInputValid()) {
                    DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(CompanyActivity.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put("name", companyName);
                    values.put("gen_req", genReq);
                    values.put("acad_req", acadReq);
                    values.put("exp_req", expReq);

                    long rowid = db.insert("company_req", null, values);

                    if (rowid != -1) {
                        Toast.makeText(CompanyActivity.this, "New Data Inserted " + rowid,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }
        });


    }

    private boolean allInputValid() {
        if (companyNameEt.getText().toString().trim().isEmpty()) {
            companyNameEt.setError("Please Enter Company Name!");
            return false;
        } else if( genReqEt.getText().toString().trim().isEmpty()) {
            genReqEt.setError("Please Enter General Req.!");
            return false;
        } else if( acadReqEt.getText().toString().trim().isEmpty()) {
            genReqEt.setError("Please Enter Academic Req.!");
            return false;
        } else if( expReqEt.getText().toString().trim().isEmpty()) {
            genReqEt.setError("Please Enter Experience Req.!");
            return false;
        } else return true;
    }
}