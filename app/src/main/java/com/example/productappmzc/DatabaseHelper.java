package com.example.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String Dbname="Company.db";
    static String TableName="products";
    static String col1="id";
    static String col2="pcode";
    static String col3="pname";
    static String col4="price";
    public DatabaseHelper( Context context) {

        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+TableName+"("+
                col1+" integer primary key autoincrement,"+
                col2+" text,"+
                col3+" text,"+
                col4+" text)";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  boolean insertValues(String code,String name,String price)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put(col2,code);
        c.put(col3,name);
        c.put(col4,price);
        long status=db.insert(TableName,null,c);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}
