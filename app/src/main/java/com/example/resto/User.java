package com.example.resto;

public class User {
    private int id;
    private String nom;
    private String mdp;
    private String type;

    public User(int id, String name, String mdp, String type){
        this.id=id;
        this.nom=name;
        this.mdp=mdp;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
