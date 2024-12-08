package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context){
        super(context,"Db" , null , 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS emp(id TEXT , name TEXT , age TEXT ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS emp");
    }

    public boolean insertData(String id , String name , String age ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name" , name);
        cv.put("id" , id);
        cv.put("age" , age);
       long res =  db.insert("emp" , null ,cv );

        if(res == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public Cursor ShowData(){
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cr = db.rawQuery("SELECT * FROM emp",null);
       return cr ;
    }

    public boolean updateData(String ID, String Name, String Age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", Name);
        contentValues.put("age", Age);
        db.update("emp", contentValues, "id="+ID ,null);
        return true;
    }

    public boolean delData(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("emp", "id=" + ID, null);
        return true;
    }
}
