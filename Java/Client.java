package com.example.paramedics.test;

public class Client {
    String cid;
    String nom;
    String prenom;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Client(String cid, String nom, String prenom) {
        this.cid = cid;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client() {

    }
}
