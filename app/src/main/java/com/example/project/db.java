package com.example.project;

import android.annotation.*;
import android.content.Context;
import android.content.*;
import android.database.sqlite.*;
import android.database.*;


import java.util.ArrayList;
public class db extends SQLiteOpenHelper {
    private static final String dbname = "prj.db";
    private static final String Table_name = "tbl_user";
    private static final int db_version = 3;
    private static final String Key_ID = "id";
    private static final String Key_name = "name";
    private static final String Key_pass = "pass";
    private static final String Key_price="price";

    public db(Context context) {
        super(context, dbname, null, db_version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table_name + "(" + Key_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Key_name + " TEXT, " + Key_pass + " TEXT, " + Key_price + " TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name); // Corrected
        onCreate(db);
    }
    public String addUser(String name, String pass, String price) {
        SQLiteDatabase data = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_name, name);
        values.put(Key_pass, pass);
        values.put(Key_price, price);

        try {
            long res = data.insert(Table_name, null, values);
            if (res == -1) {
                return "Failed to add user.";
            } else {
                return "Successfully Inserted";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error adding user: " + e.getMessage();
        }
    }

    public String addUser(String name, String pass) {
        SQLiteDatabase data = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_name, name);
        values.put(Key_pass, pass);
        data.insert(Table_name,null,values);
        data.close();
        data.update(Table_name,values,"name=?",new String[]{name});

        try {
            long res = data.insert(Table_name, null, values);
            if (res == -1) {
                return "Failed to add user.";
            } else {
                return "Successfully Inserted";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error adding user: " + e.getMessage();
        }
    }
    public ArrayList<dbEmp> addUser()
    {
        SQLiteDatabase data = this.getReadableDatabase();
        Cursor cursor = data.rawQuery("SELECT * FROM "+ Table_name, null);
        ArrayList<dbEmp> arrayList = new ArrayList<>();
        while (cursor.moveToNext())
        {
            dbEmp dbEmp = new dbEmp();
            dbEmp.id = cursor.getInt(0);
            dbEmp.name=cursor.getString(1);
            dbEmp.pass=cursor.getString(2);

            arrayList.add(dbEmp);
        }
        return arrayList;
    }
    @SuppressLint("Range")
    public String getUserPassword(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {Key_pass};
        String selection = Key_name + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(Table_name, columns, selection, selectionArgs, null, null, null);
        String password = null;
        if (cursor != null && cursor.moveToFirst()) {
            password = cursor.getString(cursor.getColumnIndex(Key_pass));
            cursor.close();
        }
        return password;
    }
    public boolean storePrice(String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_price, price);
        long result = db.insert(Table_name, null, values);
        db.close();
        return result != -1;
    }


}
