package com.example.android.placementassist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentToBePlacedDb {

    public static final String tableQuery ="CREATE TABLE `student` (\n" +
            "\t`sid`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`name`\tTEXT,\n" +
            "\t`branch`\tTEXT,\n" +
            "\t`year`\tTEXT,\n" +
            "\t`roll`\tTEXT,\n" +
            "\t`percentage`\tTEXT,\n" +
            "\t`overall`\tTEXT\n" +
            ");";

    public static final String tablename ="student";


    public static long insertData(SQLiteDatabase sqLiteDatabase, ContentValues contentValues)
    {
        return sqLiteDatabase.insert(tablename, null, contentValues);

    }

    public static Cursor fatchData(SQLiteDatabase sqLiteDatabase, String whereClouse){

        return sqLiteDatabase.query(tablename, null, whereClouse, null, null, null,null, null);


    }

}
