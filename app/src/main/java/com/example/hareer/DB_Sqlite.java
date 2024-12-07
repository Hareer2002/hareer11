package com.example.now;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB_Sqlite extends SQLiteOpenHelper {
    public  static final String DBname = "data.db";

    public DB_Sqlite(@Nullable Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS mytable");
        onCreate(db);
    }
    public  boolean insertdata(String name,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        long result=db.insert("mytable",null,contentValues);
        if (result == -1)
            return  false;
        else
            return true;
    }
    public ArrayList getallrecord(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from mytable",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            String t1=res.getString(0);
            String t2=res.getString(1);
            String t3=res.getString(2);
            arrayList.add(t1+" - "+t2+"  :  "+t3);
            res.moveToNext();
        }
        return arrayList;
    }
    public boolean updateData(String id,String name,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);

        db.update("mytable",contentValues,"id=?",new String[]{id});
        return true;
    }
    public Integer Delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("mytable","id = ?",new  String[]{id});
    }
}
