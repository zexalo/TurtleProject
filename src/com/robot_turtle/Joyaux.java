package com.robot_turtle;

public class Joyaux extends Board {
    private String couleur_joyaux;
    private int posX;
    private int posY;

    public Joyaux(){

    }

    public Joyaux(String couleur_joyaux,int posX,int posY){
        this.couleur=couleur_joyaux;
        this.posX=posX;
        this.posY=posY;
    }

    public String getCouleur() {
        return couleur_joyaux;
    }

    public void setCouleur(String couleur) {
        this.couleur_joyaux = couleur_joyaux;
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
