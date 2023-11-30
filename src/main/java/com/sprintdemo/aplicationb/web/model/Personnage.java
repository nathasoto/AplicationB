package com.sprintdemo.aplicationb.web.model;

public class Personnage {


    private String nom;

    private String type;

    private int point_de_vie;

    public Personnage() {
    }

    public Personnage(String nom, int point_de_vie, String type) {

        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.type = type;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getpointDeVie() {
        return point_de_vie;
    }

    public void setpointDeVie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                ", nom='" + nom + '\'' +
                //", type='" + type + '\'' +
                //", point_de_vie=" + point_de_vie +
                '}';
    }

}
