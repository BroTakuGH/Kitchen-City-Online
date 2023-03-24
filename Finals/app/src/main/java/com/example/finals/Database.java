package com.example.finals;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_USER_PASS = "USER_PASS";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_SCHOOLMAIL = "USER_SCHOOLMAIL";

    public Database(@Nullable Context context ) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTableStatement = "CREATE TABLE " + USER_TABLE + " (" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_SCHOOLMAIL + " TEXT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_PASS + " TEXT)";

        db.execSQL(createTableStatement);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
