package com.example.cannabisstoreinventory.user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME ="Users.db";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UserConctract.UserEntry.TABLE_NAME +
                "("+
                UserConctract.UserEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                UserConctract.UserEntry.ID + " TEXT NOT NULL," +
                UserConctract.UserEntry.NAME + " TEXT NOT NULL," +
                UserConctract.UserEntry.PASSWORD + " TEXT NOT NULL,"+
                UserConctract.UserEntry.ADMIN + " BOOLEAN NOT NULL CHECK("+ UserConctract.UserEntry.ADMIN+"IN (0,1)),"+
                UserConctract.UserEntry.AVATAR_URI + " TEXT," +
                " UNIQUE (" + UserConctract.UserEntry.ID
                +"))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
