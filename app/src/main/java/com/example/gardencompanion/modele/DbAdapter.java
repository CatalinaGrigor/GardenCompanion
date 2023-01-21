package com.example.gardencompanion.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import java.util.ArrayList;

public class DbAdapter {
    private SQLiteDatabase dbase;
    private PlanteDbHelper dbHelper;
    private Context context;

    public DbAdapter(Context context) {
        this.context = context;
        this.dbHelper = new PlanteDbHelper(context, PlanteDbHelper.BD_Nom,
                null, PlanteDbHelper.Version);

    }

    public void openBd() {

        dbase = dbHelper.getWritableDatabase();
    }

    public void fermerBd() {

        dbase.close();
    }

    public ArrayList<String> getInfoPlante(String nom) {
        openBd();

        String[] cols = { PlanteDbHelper.COL_DESCRIPTION};

        String whereclause = PlanteDbHelper.COL_NOM + "=?";
        String[] whereargs = new String[]{String.valueOf(nom)};
        Cursor curseur = dbase.query(PlanteDbHelper.TABLE_PLANTES, cols,  whereclause, whereargs,
                null, null, null);

        curseur.moveToFirst();

        ArrayList<String> registreInfoPlante = new ArrayList<>();

        String description = curseur.getString(0);

        registreInfoPlante.add(description);

        fermerBd();
        return registreInfoPlante;

    }



    public ArrayList<String> getBonCompagnonPlante(String nom) {
        openBd();
        String[] cols = {PlanteDbHelper.COL_BONCOMPAGNONS};
        String whereclause = PlanteDbHelper.COL_NOM + "=?";
        String[] whereargs = new String[]{String.valueOf(nom)};
        Cursor curseur = dbase.query(PlanteDbHelper.TABLE_PLANTES, cols, whereclause, whereargs,
                null, null, null);
        curseur.moveToFirst();
        ArrayList<String> registreBonCompagnon = new ArrayList<>();


        String bonCompagnons = curseur.getString(0);


        registreBonCompagnon.add( bonCompagnons);

        fermerBd();
        return registreBonCompagnon;
    }

    public ArrayList<String> getMauvaisCompagnons(String nom) {
        openBd();
        //indiquer les colonnes du select
        String[] cols = {PlanteDbHelper.COL_MAUVAISCOMPAGNONS};
        String whereclause = PlanteDbHelper.COL_NOM + "=?";
        String[] whereargs = new String[]{String.valueOf(nom)};
        Cursor curseur = dbase.query(PlanteDbHelper.TABLE_PLANTES, cols,  whereclause, whereargs,
                null, null, null);

        curseur.moveToFirst();

        ArrayList<String> registreMauvaisCompagnons = new ArrayList<>();

        String mauvaisCompagnons = curseur.getString(0);

        registreMauvaisCompagnons.add(mauvaisCompagnons);

        fermerBd();
        return registreMauvaisCompagnons;

    }

    public ArrayList<String> getComparerCompagnons(String nom1, String nom2) {
        openBd();
        //indiquer les colonnes du select
        // String[] cols = {PlanteDbHelper.COL_NOM, PlanteDbHelper.COL_BONCOMPAGNONS};

        String query = "SELECT * FROM PLANTES WHERE nom LIKE ? AND bonCompagnons LIKE ?";
        Cursor curseur = dbase.rawQuery(query,new String[]{nom1, "%" + nom2 + "%"});

        curseur.moveToFirst();

        ArrayList<String> registreComparateur = new ArrayList<>();

        if (curseur.getCount() > 0) {
            registreComparateur.add("Ce sont des bons compagnons.");
            curseur.close();
        } else {
            curseur.close();
            query = "SELECT * FROM PLANTES WHERE nom LIKE ? AND mauvaisCompagnons LIKE ?";
            curseur = dbase.rawQuery(query,new String[]{nom1, "%" + nom2 + "%"});
            curseur.moveToFirst();
            if (curseur.getCount() > 0){
                registreComparateur.add("Ce ne sont pas de bons compagnons. Mieux evitez de les " +
                        "planter ensemble");
            } else {
                registreComparateur.add("Informations manquante. Un essai a faire et en voir le resultat");
            }

        }

        fermerBd();
        return registreComparateur;

    }


    public void ajouterPlante(Plante plante) {
        openBd();

        ContentValues cv = new ContentValues();
        cv.put(PlanteDbHelper.COL_NOM, plante.getNom());
        cv.put(PlanteDbHelper.COL_DESCRIPTION, plante.getDescription());
        cv.put(PlanteDbHelper.COL_BONCOMPAGNONS, plante.getBonCompagnons());
        cv.put(PlanteDbHelper.COL_MAUVAISCOMPAGNONS, plante.getMauvaisCompagnons());

        dbase.insert(PlanteDbHelper.TABLE_PLANTES, null, cv);
        fermerBd();
    }

    public void deleteAll()
    {
        // ne marche pas dbase.execSQL("DROP TABLE IF EXISTS " + PlanteDbHelper.TABLE_PLANTES);

        try {

            dbase.execSQL("DELETE FROM " + PlanteDbHelper.TABLE_PLANTES);

        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }


// les methodes suivantes ne sont pas utiliser dans notre applications
    /*public ArrayList<Plante> getToutesPlantes() {
        openBd();
        //indiquer les colonnes du select
        String[] cols = {PlanteDbHelper.COL_ID, PlanteDbHelper.COL_NOM,
                PlanteDbHelper.COL_DESCRIPTION, PlanteDbHelper.COL_BONCOMPAGNONS,
                PlanteDbHelper.COL_MAUVAISCOMPAGNONS};
        Cursor curseur = dbase.query(PlanteDbHelper.TABLE_PLANTES, cols, null, null, null, null, null);
        //parcourir le curseur
        curseur.moveToFirst();
        ArrayList<Plante> registre = new ArrayList<>();
        while (!curseur.isAfterLast()) {
            int id = curseur.getInt(0);
            String nom = curseur.getString(1);
            String description = curseur.getString(2);
            String bonCompagnons = curseur.getString(3);
            String mauvaisCompagnons = curseur.getString(4);

            registre.add(new Plante(id, nom, description, bonCompagnons, mauvaisCompagnons));
            curseur.moveToNext();
        }
        fermerBd();
        return registre;
    }

    public String getNomPlante() {
        openBd();
        //indiquer les colonnes du select
        String[] cols = {PlanteDbHelper.COL_NOM};
        Cursor curseur = dbase.query(PlanteDbHelper.TABLE_PLANTES, cols, null, null, null, null, null);
        //parcourir le curseur
        curseur.moveToFirst();
        String nomPlante = new String();
        while (!curseur.isAfterLast()) {
            //int id =curseur.getInt(0);
            String nom = curseur.getString(1);

            // String boncompagnons= curseur.getString(3);
            // String mauvaiscompagnons= curseur.getString(4);
            nomPlante = nom;

            curseur.moveToNext();
        }
        fermerBd();
        return nomPlante;

    }*/


}
