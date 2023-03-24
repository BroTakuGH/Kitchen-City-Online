package com.example.finals;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    PublicMethods publicMethods = new PublicMethods();
    public static final String USER_TABLE = "USER_TABLE";
    public static final String ID = "ID";

    public static final String COLUMN_USER_PASS = "USER_PASS";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_SCHOOLMAIL = "USER_SCHOOLMAIL";
    public static final String COLUMN_USER_ID = "USER_ID";


    public Database(@Nullable Context context ) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTableStatement = "CREATE TABLE " + USER_TABLE + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_ID + " TEXT " + COLUMN_USER_SCHOOLMAIL + " TEXT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_PASS + " TEXT)";

        db.execSQL(createTableStatement);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public boolean addOne(PublicMethods publicMethods){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_ID, publicMethods.GetUserID());
        cv.put(COLUMN_USER_SCHOOLMAIL, publicMethods.GetUserSchoolMail());
        cv.put(COLUMN_USER_NAME, publicMethods.GetUserName());
        cv.put(COLUMN_USER_PASS, publicMethods.GetUserPass());

        long insert = db.insert(USER_TABLE,null ,cv);
        if (insert ==-1){
            return false;
        }else {return true;}

    }
}
