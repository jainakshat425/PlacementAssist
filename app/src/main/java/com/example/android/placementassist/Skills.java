package com.example.android.placementassist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Skills {

    public static final String tableQuery ="CREATE TABLE `skill` (\n" +
            "\t`sid`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`comm`\tTEXT,\n" +
            "\t`gd`\tTEXT,\n" +
            "\t`aptitude`\tTEXT,\n" +
            "\t`roll`\tTEXT,\n" +
            "\t`eventpart`\tTEXT,\n" +
            "\t`extracurr`\tTEXT\n" +
            ");";

    public static final String tablename ="skill";


    public static long insertData(SQLiteDatabase sqLiteDatabase, ContentValues contentValues)
    {
        return sqLiteDatabase.insert(tablename, null, contentValues);

    }

    public static Cursor fatchData(SQLiteDatabase sqLiteDatabase, String whereClouse){

        return sqLiteDatabase.query(tablename, null, whereClouse, null, null, null,null, null);


    }
}
