package com.example.edeleon8425.midterm_prog3210;

/**
 * Created by edeleon8425 on 12/21/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import java.util.ArrayList;

public class SQLiteDB extends SQLiteOpenHelper {

    //Db Version
    private static final int Db_Version = 1;

    //Db Name
    private static final String Db_Name = "Midterm";

    //table names
    public static final String Table_Name = "Comments";

    //Creating Users Columns
    public static final String User_id = "id";
    public static final String User_name = "name";
    public static final String User_comment = "comment";


    public SQLiteDB(Context context) {
        super(context, Db_Name, null, Db_Version);

    }

    //creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        // writing command for sqlite to create table with required columns
         String Create_Table = "CREATE TABLE " + Table_Name + "(" + User_id
                + " INTEGER PRIMARY KEY," + User_name + " TEXT," + User_comment + " TEXT" + ")";
        db.execSQL(Create_Table);
    }


    //Upgrading the Db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        //create the table again
        onCreate(db);
    }

    //Add new User by calling this method
    public void addUser(User usr) {
        // getting db instance for writing the user
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(User_name, usr.getName());
        cv.put(User_comment, usr.getComment());
        //inserting row
        db.insert(Table_Name, null, cv);
        //close the database to avoid any leak
        db.close();
    }

    public int checkUser(User us) {
        int id = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM Comments WHERE uname=? and comment=?", new String[]{us.getName(), us.getComment()});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

    public ArrayList<User> getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<User> use= new ArrayList<User>();
        Cursor result = db.rawQuery("select * from "+Table_Name , null);
        while(result.moveToNext()){
            use.add( new User(result.getString(result.getColumnIndex(User_name)), result.getString(result.getColumnIndex(User_comment))));

        }
        return use;
    }
}

