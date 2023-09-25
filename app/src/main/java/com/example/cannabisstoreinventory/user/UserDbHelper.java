package com.example.cannabisstoreinventory.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME ="Users.db";
    private static final String TABLE_NAME="users";
    private static final String ID_COL="id";
    private static final String NAME_COL="name";
    private static final String PASSWORD_COL="password";
    private static final String ADMIN_COL="admin";
    private static final String AVATARURI_COL="avatarUri";



    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME +" ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_COL + " TEXT UNIQUE NOT NULL,"
                + PASSWORD_COL+ " TEXT NOT NULL,"
                + ADMIN_COL + " INTEGER NOT NULL,"
                + AVATARURI_COL + " TEXT)";
        db.execSQL(query);
    }

    public void addNewUser(User user){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(NAME_COL, user.getName());
        values.put(PASSWORD_COL,user.getPassword());
        values.put(ADMIN_COL,user.getAdmin());
        values.put(AVATARURI_COL,user.getAvatarUri());

        db.insert(TABLE_NAME,null,values);

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
