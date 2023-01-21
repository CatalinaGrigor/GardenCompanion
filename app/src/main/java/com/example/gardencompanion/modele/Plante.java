package com.example.gardencompanion.modele;

import java.util.Arrays;
import java.util.List;

public class Plante {
    private String nom;
    private String description;
    private String bonCompagnons;
    private String mauvaisCompagnons;

    public Plante() {
    }

    public Plante(String nom, String description, String bonCompagnons, String mauvaisCompagnons) {
        this.nom = nom;
        this.description = description;
        this.bonCompagnons = bonCompagnons;
        this.mauvaisCompagnons = mauvaisCompagnons;
    }

    public Plante(int id, String nom, String description, String bonCompagnons, String mauvaisCompagnons) {
        this.nom = nom;
        this.description = description;
        this.bonCompagnons = bonCompagnons;
        this.mauvaisCompagnons = mauvaisCompagnons;
    }


    public Plante(String nom, String Compagnons, boolean bon) {
        this.nom = nom;

        if(bon) {
            this.bonCompagnons = Compagnons;
        } else {
            this.mauvaisCompagnons = Compagnons;
        }

    }

    public Plante(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBonCompagnons() {
        return bonCompagnons;
    }

    public void setBonCompagnons(String bonCompagnons) {
        this.bonCompagnons = bonCompagnons;
    }

    public String getMauvaisCompagnons() {
        return mauvaisCompagnons;
    }

    public void setMauvaisCompagnons(String mauvaisCompagnons) {
        this.mauvaisCompagnons = mauvaisCompagnons;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", bonCompagnons=" +bonCompagnons +
                ", mauvaisCompagnons=" + mauvaisCompagnons +
                '}';
    }
}

