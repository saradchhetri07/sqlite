package com.example.sqlite;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName="studentdb";
    private static final String tableName="student";
    private static final int dbVersion=1;
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,dbName,null,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableName+"(uname VARCHAR(10),passw VARCHAR(10));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String uname,String passw)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("uname",uname);
        cv.put("passw",passw);
        long res=sqLiteDatabase.insert(tableName,null,cv);
        sqLiteDatabase.close();
        return res;
    }
    public String display()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+tableName,null);
        String finalres="";
        while(cursor.moveToNext())
        {
            finalres=finalres+cursor.getString(0)+":"+cursor.getString(1);
        }
        return finalres;
    }

    public void update(String uname,String passw){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); //6(a)
        sqLiteDatabase.execSQL("UPDATE "+tableName+" SET passw="+"'"+passw+"'"+" where uname='"+uname+"' ;");
        sqLiteDatabase.close();
    }

    public void delete(String uname)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM student WHERE uname='"+uname+"' ;");
        sqLiteDatabase.close();
    }
}