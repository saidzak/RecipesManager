package com.example.recipesmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Sqlite extends SQLiteOpenHelper {
    public static final String DBname = "data.db";


    public DB_Sqlite(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table recette (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titre TEXT, type TEXT, nbpersonnes INT, niveau TEXT, ingredients TEXT, instruction TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS recette");
        onCreate(db);
    }

    public boolean insertData(String titre, String type, int nbpersonnes, String niveau, String ingredients, String instruction){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titre",titre);
        contentValues.put("type",type);
        contentValues.put("nbpersonnes",nbpersonnes);
        contentValues.put("niveau",niveau);
        contentValues.put("ingredients",ingredients);
        contentValues.put("instruction",instruction);
        long result = db.insert("recette", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}



