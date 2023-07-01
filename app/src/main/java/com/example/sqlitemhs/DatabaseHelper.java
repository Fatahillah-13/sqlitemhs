package com.example.sqlitemhs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String nama_db="DB_MHS";
    public final static String nama_table="mahasiswa";

    public final static String field_01="nim";
    public final static String field_02="nama_mhs";

    public DatabaseHelper(@Nullable Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+nama_table+"(nim text primary key, nama_mhs text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+nama_table);
        onCreate(db);
    }

    public void tambah_data(String xnim, String xnama) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(field_01,xnim);
        contentValues.put(field_02,xnama);

        db.insert(nama_table,null,contentValues);
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+nama_table,null);
        return res;
    }
}
