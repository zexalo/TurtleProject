package com.robot_turtle;


public class Cartes extends Tortue {
    private String couleur;
    private String obstacles;

    public Cartes(){

    }

    public Cartes(String type_carte, String value){
        if(type_carte == "couleur"){
            this.couleur = value;
        } else if (type_carte == "obstacle"){
            this.obstacles = value;
        } else {
            System.out.println("je ne reconnais pas le type");
        }
    }

  /*  public Cartes(String couleur, String obstacles){
        this.couleur=couleur;
        this.couleur=obstacles;
    }
*/



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
