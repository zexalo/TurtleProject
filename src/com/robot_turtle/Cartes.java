package com.robot_turtle;


public class Cartes extends Tortue {
    public String couleur;
    private String obstacles;

    public Cartes(){

    }

    public Cartes(String couleur, String obstacles){
        this.couleur=couleur;
        this.couleur=obstacles;
    }




    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getObstacles() {
        return obstacles;
    }

    public void setObstacles(String obstacles) {
        this.obstacles = obstacles;
    }
}
