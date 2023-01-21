package com.example.gardencompanion.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;

public class PlanteDbHelper extends SQLiteOpenHelper {

    //declaration de constante
    public static  final String BD_Nom="tp";
    public static final int Version=4;

    //Tables
    public  static final String TABLE_PLANTES="PLANTES";
    public  static final String COL_ID="_id";
    public  static final String COL_NOM="nom";
    public  static final String COL_DESCRIPTION="description";
    public  static final String COL_BONCOMPAGNONS="bonCompagnons";
    public  static final String COL_MAUVAISCOMPAGNONS="mauvaisCompagnons";


    SQLiteDatabase mDB;

    public PlanteDbHelper(Context context) {
        super(context, BD_Nom, null, Version);
        mDB = this.getWritableDatabase();
    }
    //DDL de table


    public static final String DDL_PLANTE = "create table " + TABLE_PLANTES+ "(" + COL_ID +
            "	integer primary key autoincrement," + COL_NOM + " TEXT," + COL_DESCRIPTION + " TEXT,"
            + COL_BONCOMPAGNONS +" TEXT," + COL_MAUVAISCOMPAGNONS + " TEXT" +")";

    public PlanteDbHelper(@Nullable Context context, @Nullable String BD_Nom,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, BD_Nom, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTES);
        sqLiteDatabase.execSQL(DDL_PLANTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTES);
        onCreate(sqLiteDatabase);
    }


}
