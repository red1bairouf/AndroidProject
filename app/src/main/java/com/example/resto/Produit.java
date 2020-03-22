package com.example.resto;

public class Produit {
    private int id;
    private String ref;
    private String name ;
    private float prix;
    private int qte;

    public Produit(int id, String ref, String name, float prix, int qte) {
        this.id = id;
        this.ref = ref;
        this.name = name;
        this.prix = prix;
        this.qte = qte;

    }
    public int getQte(){
        return qte;
    }

    public void setQte(int qte){
        this.qte = qte;
    }
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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
