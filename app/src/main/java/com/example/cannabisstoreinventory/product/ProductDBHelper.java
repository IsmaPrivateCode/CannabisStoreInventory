package com.example.cannabisstoreinventory.product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.contentcapture.ContentCaptureCondition;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProductDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME ="Users.db";
    private static final String TABLE_NAME="products";
    private static final String ID_COL="id";
    private static final String NAME_COL="name";
    private static final String QUANTITY_COL="queantity";
    private static final String AVATARPRODUCT_COL="avatarProduct";

    public ProductDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME + " ("
                +ID_COL+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_COL + " TEXT UNIQUE NOT NULL,"
                + QUANTITY_COL + " INTEGER NOT NULL,"
                + AVATARPRODUCT_COL + " TEXT)";
        db.execSQL(query);
    }

    public void addNewProduct(Product product){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(NAME_COL,product.getName());
        values.put(QUANTITY_COL,0);
        values.put(AVATARPRODUCT_COL,product.getAvatar_product());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<Product>readProducts(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursorProducts=db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        ArrayList<Product>productsArrayList=new ArrayList<>();
        if(cursorProducts.moveToFirst()){
            do {
                productsArrayList.add(new Product(cursorProducts.getString(1),
                                            cursorProducts.getInt(2),
                                            cursorProducts.getString(3)));
            }while (cursorProducts.moveToNext());
        }
        cursorProducts.close();
        return productsArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
