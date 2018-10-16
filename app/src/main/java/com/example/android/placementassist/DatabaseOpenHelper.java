package com.example.android.placementassist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper{

    public static final String myDatabase = "placement_help";
    public static final int version_code = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, myDatabase, null, version_code);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String COMPANY_TABLE = "CREATE TABLE company_req (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "gen_req TEXT, " +
                "acad_req TEXT, " +
                "exp_req TEXT);";
        sqLiteDatabase.execSQL(COMPANY_TABLE);
        sqLiteDatabase.execSQL(FeedbackDb.tableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
