package com.example.android.placementassist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FeedbackDb {

    public static final String tableQuery ="CREATE TABLE `feedback` (\n" +
            "\t`_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`roll`\tTEXT,\n" +
            "\t`isPlaced\tTEXT,\n" +
            "\t`attend_w`\tTEXT,\n" +
            "\t`attend_f`\tTEXT,\n" +
            "\t`clg_mks_w`\tTEXT,\n" +
            "\t`clg_mks_f`\tTEXT,\n" +
            "\t`lab_imp_w`\tTEXT,\n" +
            "\t`lab_imp_f`\tTEXT,\n" +
            "\t`self_study_w`\tTEXT,\n" +
            "\t`self_study_f`\tTEXT,\n" +
            "\t`coaching_w`\tTEXT,\n" +
            "\t`coaching_f`\tTEXT,\n" +
            "\t`event_w`\tTEXT,\n" +
            "\t`event_f`\tTEXT,\n" +
            "\t`project_w`\tTEXT,\n" +
            "\t`project_f`\tTEXT,\n" +
            "\t`team_w`\tTEXT,\n" +
            "\t`team_f`\tTEXT,\n" +
            "\t`gk_w`\tTEXT,\n" +
            "\t`gk_f`\tTEXT,\n" +
            "\t`certificate_w`\tTEXT,\n" +
            "\t`certificate_f`\tTEXT,\n" +
            "\t`comm_class_w`\tTEXT,\n" +
            "\t`comm_class_f`\tTEXT\n" +
            ");";

    public static final String tablename ="feedback";


    public static long insertData(SQLiteDatabase sqLiteDatabase, ContentValues contentValues)
    {
        return sqLiteDatabase.insert(tablename, null, contentValues);

    }

    public static Cursor fatchData(SQLiteDatabase sqLiteDatabase, String whereClouse){

        return sqLiteDatabase.query(tablename, null, whereClouse, null, null, null,null, null);


    }
}
