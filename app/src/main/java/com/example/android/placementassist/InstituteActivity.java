package com.example.android.placementassist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InstituteActivity extends AppCompatActivity {

    EditText editname, editbranch, edityear, editroll, editpercent, editoverall;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute);

        editname = findViewById(R.id.editname);
        editbranch = findViewById(R.id.editbranch);
        editoverall = findViewById(R.id.editoverall);
        editroll = findViewById(R.id.editroll);
        edityear = findViewById(R.id.edityear);
        editpercent = findViewById(R.id.editpercent);

        findViewById(R.id.buttonnext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editname.getText().toString();
                String branch = editbranch.getText().toString();
                String roll = editroll.getText().toString();
                String year = edityear.getText().toString();
                String percent = editpercent.getText().toString();
                String overall = editoverall.getText().toString();

                DatabaseOpenHelper myDatabase = new DatabaseOpenHelper(InstituteActivity.this);
                SQLiteDatabase sqLiteDatabase = myDatabase.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", name);
                contentValues.put("branch", branch);
                contentValues.put("year", year);
                contentValues.put("roll", roll);
                contentValues.put("percentage", percent);
                contentValues.put("overall", overall);


                long i = StudentToBePlacedDb.insertData(sqLiteDatabase, contentValues);

                if (i > 0) {
                    Toast.makeText(InstituteActivity.this, "Successfully saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(InstituteActivity.this, ShowActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(InstituteActivity.this, "not saved", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
