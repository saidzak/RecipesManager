package com.example.recipesmanager;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB_Sqlite extends SQLiteOpenHelper {

    public static final String RECETTE_TABLE = "RECETTE_TABLE";
    public static final String COL_ID = "COL_ID";
    public static final String COL_TITRE = "COL_TITRE";
    public static final String COL_TYPE = "COL_TYPE";
    public static final String COL_NBPERS = "COL_NBPERS";
    public static final String COL_NIVEAU = "COL_NIVEAU";
    public static final String COL_ING = "COL_ING";
    public static final String COL_INS = "COL_INS";

    public DB_Sqlite(Context context) {
        super(context, "recette.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + RECETTE_TABLE + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TITRE + " TEXT, " + COL_TYPE + " TEXT, " + COL_NBPERS + " TEXT, " + COL_NIVEAU + " TEXT, " + COL_ING + " TEXT, " + COL_INS + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS RECETTE_TABLE");
        onCreate(db);
    }

    public boolean AddOne(Recette recette) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_TITRE, recette.getTitre());
        cv.put(COL_TYPE, recette.getType());
        cv.put(COL_NBPERS, recette.getNbpersonnes());
        cv.put(COL_NIVEAU, recette.getNiveau());
        cv.put(COL_ING, recette.getIngredients());
        cv.put(COL_INS, recette.getInstruction());

        long insert = db.insert(RECETTE_TABLE, null, cv);

        if (insert == -1) return false;
        else return true;
    }


    public boolean modifyOne(Recette recette) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COL_TITRE, recette.getTitre());
        cv.put(COL_TYPE, recette.getType());
        cv.put(COL_NBPERS, recette.getNbpersonnes());
        cv.put(COL_NIVEAU, recette.getNiveau());
        cv.put(COL_ING, recette.getIngredients());
        cv.put(COL_INS, recette.getInstruction());

        long result = db.update(RECETTE_TABLE, cv,COL_ID+" = '"+recette.getId() +"'", null);

        db.close();

        if (result == -1) return false;
        else return true;
    }


    public List<Recette> getAllReceips() {
        List<Recette> returnlist = new ArrayList<Recette>();

        String queryString = "SELECT * FROM " + RECETTE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
//            Retirer la liste des recettes
            do {
                int recetteid = cursor.getInt(0);
                String recettetitre = cursor.getString(1);
                String recettetype = cursor.getString(2);
                int recettenbpers = cursor.getInt(3);
                String recetteniveau = cursor.getString(4);
                String recetteing = cursor.getString(5);
                String recetteins = cursor.getString(6);

                Recette marecette = new Recette(recetteid, recettetitre, recettetype, recettenbpers, recetteniveau, recetteing, recetteins);
                returnlist.add(marecette);
            } while (cursor.moveToNext());

        } else {
//          rien ne sera a joute a la liste
        }

        cursor.close();
        db.close();
        return returnlist;
    }





    public void deleteOne(int id) {
        SQLiteDatabase mydb = this.getWritableDatabase();

        mydb.delete(RECETTE_TABLE, "COL_ID = ?", new String[] {String.valueOf(id)});
    }






    public Recette getRecetteById(int id){
        Recette marecette = null;
        SQLiteDatabase mydb = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + RECETTE_TABLE + " WHERE " + COL_ID + " = " + id+";";
        Cursor cursor = mydb.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
//            Retirer la liste des recettes
                int recetteid = cursor.getInt(0);
                String recettetitre = cursor.getString(1);
                String recettetype = cursor.getString(2);
                int recettenbpers = cursor.getInt(3);
                String recetteniveau = cursor.getString(4);
                String recetteing = cursor.getString(5);
                String recetteins = cursor.getString(6);

                marecette = new Recette(recetteid, recettetitre, recettetype, recettenbpers, recetteniveau, recetteing, recetteins);
        } else {
//          rien ne sera a joute a la liste
        }
        return marecette;
    }


}



