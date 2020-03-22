package com.example.resto.SQLitePackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.resto.Commande;
import com.example.resto.Produit;
import com.example.resto.User;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class MyDbClasse extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    Context context;

    public MyDbClasse(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<Produit> getAllData() {
        try {
            ArrayList<Produit> objDbModelClassArrayList = new ArrayList<>();
            SQLiteDatabase objSqLiteDatabase = getReadableDatabase();
            if (objSqLiteDatabase != null) {
                Cursor objCursor = objSqLiteDatabase.rawQuery("select * from Produit order by id", null);
                if (objCursor.moveToNext()) {
                    while (objCursor.moveToNext()) {
                        int id = objCursor.getInt(0);
                        String ref = objCursor.getString(3);
                        String name = objCursor.getString(1);
                        float prix = objCursor.getFloat(2);
                        objDbModelClassArrayList.add(
                                new Produit(
                                        id, ref, name, prix, 0
                                )
                        );
                    }
                    return objDbModelClassArrayList;
                } else {
                    Toast.makeText(context, "No data is retrieved...", Toast.LENGTH_SHORT).show();
                    return null;
                }
            } else {
                Toast.makeText(context, "Data is null.", Toast.LENGTH_SHORT).show();
                return null;
            }

        } catch (Exception e) {
            Toast.makeText(context, "getAllData:-" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public ArrayList<Commande> getAllDataCmd(int begin) {
        try {
            ArrayList<Commande> objDbModelClassArrayList = new ArrayList<>();
            SQLiteDatabase objSqLiteDatabase = getReadableDatabase();
            if (objSqLiteDatabase != null) {
                Cursor objCursor = objSqLiteDatabase.rawQuery("select * from Commande order by id", null);
                if (objCursor.moveToNext()) {
                    while (objCursor.moveToNext()) {
                        int id = objCursor.getInt(0);
                        int id_produit = objCursor.getInt(1);
                        int qte = objCursor.getInt(2);
                        String date = objCursor.getString(3);
                        int id_utilisateur = objCursor.getInt(4);
                        String nom = "";
                        float prix = 0;
                        Cursor nameCursor = objSqLiteDatabase.rawQuery("select designation,prix from Produit where id=?", new String[]{Integer.toString(id_produit)});
                        if (nameCursor.moveToNext()) {
                                nom = nameCursor.getString(0);
                                prix = nameCursor.getFloat(1);
                            if (id >= begin) {
                                objDbModelClassArrayList.add(
                                        new Commande(
                                                id, id_produit, qte, date, id_utilisateur, nom, prix
                                        )
                                );
                            }
                        }


                    }
                    return objDbModelClassArrayList;
                } else {
                    Toast.makeText(context, "No data is retrieved...", Toast.LENGTH_SHORT).show();
                    return null;
                }
            } else {
                Toast.makeText(context, "Data is null.", Toast.LENGTH_SHORT).show();
                return null;
            }

        } catch (Exception e) {
            Toast.makeText(context, "getAllData:-" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public int lastId() {
        Commande commande;
        SQLiteDatabase objSqLiteDatabase = getReadableDatabase();
        if (objSqLiteDatabase != null) {
            Cursor objCursor = objSqLiteDatabase.rawQuery("select * from Commande order by id", null);
            return objCursor.getCount()+1;
        } else {
            Toast.makeText(context, "Data is null.", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }

    public boolean cmd(ArrayList<Produit> objProduitArrayList) {
        Produit currentProd;
        SQLiteDatabase objSqLiteDatabase = this.getWritableDatabase();
        boolean Rtrn= true;
        if (objSqLiteDatabase != null) {
            Cursor objCursor = objSqLiteDatabase.rawQuery("select * from commande order by id", null);
            int nbre = objCursor.getCount();
            for (int j = 0; j < objProduitArrayList.size(); j++) {
                currentProd = objProduitArrayList.get(j);
                Date currentTime = Calendar.getInstance().getTime();
                if (currentProd.getQte() > 0) {
                    ContentValues contentValues = new ContentValues();
                    nbre = nbre + 1;
                    contentValues.put("id", nbre);
                    contentValues.put("id_produit", currentProd.getId());
                    contentValues.put("quantite", currentProd.getQte());
                    contentValues.put("date", DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(currentTime));
                    contentValues.put("id_utilisateur", 1);
                    long ins = objSqLiteDatabase.insert("commande", null, contentValues);
                    if (ins == -1) Rtrn= false;
                }
            }

        }
        return Rtrn;
    }
    public float prixTot(ArrayList<Commande> objDbModelClassArrayList) {
        float prix = 0;
        Commande commande;
        for (int i = 0; i < objDbModelClassArrayList.size(); i++) {
            commande = objDbModelClassArrayList.get(i);
            prix = prix + commande.getPrix()*commande.getQuantite();
        }
        return prix;
    }

    public int qteTot(ArrayList<Commande> objDbModelClassArrayList) {
        int qte = 0;
        Commande commande;
        for (int i = 0; i < objDbModelClassArrayList.size(); i++) {
            commande = objDbModelClassArrayList.get(i);
            qte = qte + commande.getQuantite();
        }
        return qte;
    }

    public ArrayList<User> getAllDataUser() {
        try {
            ArrayList<User> objDbModelClassArrayList = new ArrayList<>();
            SQLiteDatabase objSqLiteDatabase = getReadableDatabase();
            if (objSqLiteDatabase != null) {
                Cursor objCursor = objSqLiteDatabase.rawQuery("select * from Utilisateur order by id", null);
                if (objCursor.moveToNext()) {
                    while (objCursor.moveToNext()) {
                        int id = objCursor.getInt(0);
                        String nom = objCursor.getString(1);
                        String mdp = objCursor.getString(2);
                        String type = objCursor.getString(3);
                        objDbModelClassArrayList.add(
                                new User(
                                        id, nom, mdp, type
                                        )
                                );
                            }
                    return objDbModelClassArrayList;
                } else {
                    Toast.makeText(context, "No data is retrieved...", Toast.LENGTH_SHORT).show();
                    return null;
                }
            } else {
                Toast.makeText(context, "Data is null.", Toast.LENGTH_SHORT).show();
                return null;
            }

        } catch (Exception e) {
            Toast.makeText(context, "getAllData:-" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    public boolean loginCheck(String name, String password,ArrayList<User> UserList){
        UserList=getAllDataUser();
        User currentUser;
        int nbre = UserList.size();
        for (int j = 0; j < UserList.size(); j++) {
            currentUser = UserList.get(j);
            if (currentUser.getNom().equals(name) && currentUser.getMdp().equals(password))
                return true;
        }
        return false;
    }

}

