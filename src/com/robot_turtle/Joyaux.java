package com.robot_turtle;

public class Joyaux extends Board {
    private String couleur;
    private int posX;
    private int posY;

    public Joyaux(){

    }

    public Joyaux(String couleur,int posX,int posY){
        this.couleur=couleur;
        this.posX=posX;
        this.posY=posY;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
