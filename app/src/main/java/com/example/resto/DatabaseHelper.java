package com.example.resto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    Context context;

    public DatabaseHelper(Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE utilisateur(id INTEGER NOT NULL primary key, nom varchar(20), mdp varchar(20), type varchar(8))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists utilisateur");
    }

    public boolean loginpassword(String name,String password){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from utilisateur order by id",null);
            if (cursor.moveToNext()) {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String nom = cursor.getString(1);
                    String mdp = cursor.getString(2);
                    String type = cursor.getString(3);
                    if(nom.equals(name)&&mdp.equals(password)) return true;
                }
                 return false;
            } else {
                return false;

        }
    }
}
