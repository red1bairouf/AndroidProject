package com.example.resto;

import java.util.Date;

public class Commande {
    private int id;
    private int id_produit;
    private int  quantite ;
    private String date;
    private int id_utilisateur;
    private String name;
    private float prix;

    public Commande(int id, int id_produit,int quantite,String date,int id_utilisateur,String name, float prix) {
        this.id = id;
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.date = date;
        this.id_utilisateur = id_utilisateur;
        this.name = name;
        this.prix = prix;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
