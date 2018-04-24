package com.example.acer.ass;

import  android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by acer on 4/21/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_USERNAME="username";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_PASSWORD="password";
    private static final String COLUMN_CONTACTNO="contact_number";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table contacts(id integer primary key not null  ,"+ "name text not null , username text not null , email text not null ,password text not null , contact_number text not null";

    public DatabaseHelper(Context context)
    {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLE_CREATE);
    this.db=db;
    }

    public void insertContact(Contact c) {
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        String query="select *from contacts";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_CONTACTNO, c.getContact_number());
        values.put(COLUMN_PASSWORD, c.getPassword());
        db.insert(TABLE_NAME, null, values);
        db.close();

    }

 public String searchPass(String uname)
 {
    db= this.getReadableDatabase();
    String query="select uname,pass from"+TABLE_NAME;
     Cursor cursor=db.rawQuery(query, null);
     String a,b;
     b="not found";
     if (cursor.moveToFirst())
     {
         do {
             a=cursor.getString(0);

             if(a.equals(uname))
             {
                 b=cursor.getString(1);
                 break;
             }

         }while (cursor.moveToNext());

     }
    return b;
 }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
