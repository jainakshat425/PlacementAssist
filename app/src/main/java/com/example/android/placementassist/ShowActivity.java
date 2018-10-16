package com.example.android.placementassist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
EditText editroll;
TextView textname,textbranch,textyear,textroll,textoverall,textpercent;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        editroll = findViewById(R.id.editroll);
        textname=findViewById(R.id.textname);
        textbranch=findViewById(R.id.textbranch);
        textyear=findViewById(R.id.textyear);
        textoverall=findViewById(R.id.textoverall);
        textroll=findViewById(R.id.textroll);
        textpercent=findViewById(R.id.textpercent);
        button= findViewById(R.id.go);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String roll = editroll.getText().toString();

                DatabaseOpenHelper myDatabase = new DatabaseOpenHelper(ShowActivity.this);
                SQLiteDatabase sqLiteDatabase = myDatabase.getReadableDatabase();

                String whereClause = "roll = '" + roll + "'";

                Cursor cursor = StudentToBePlacedDb.fatchData(sqLiteDatabase, whereClause);
                Log.d("1234", "onClick: " + cursor.getCount());


                if (cursor.moveToNext()) {


                    String aroll = cursor.getString(4);
                    String aname = cursor.getString(1);
                    String abranch = cursor.getString(2);
                    String ayear = cursor.getString(3);
                    String apercentage = cursor.getString(5);
                    String aoverall = cursor.getString(6);


                    textname.setText(aname);
                    textroll.setText(aroll);
                    textbranch.setText(abranch);
                    textoverall.setText(aoverall);
                    textpercent.setText(apercentage);
                    textyear.setText(ayear);
                }


            }
        });



    }
}
