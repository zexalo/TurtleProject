package com.robot_turtle;

import java.util.List;

public class Tortue {
    private Main main;
    private int posX;
    private int posY;
    private int score;
    private List orientation;

    public Tortue(){

    }

    public Tortue(int posX,int posY,int score,Main main,List orientation){
        this.main=main;
        this.posX=posX;
        this.posY=posY;
        this.score=score;
        this.orientation=orientation;
    }

    public void avancer(){

    }
    public void rotationG(){

    }
    public void rotationD(){

    }
    public void pioche(){

    }
    public void defausser(){

    }
    public void utiliserLaser(){

    }
    public void placerObstacle(){

    }
    public void nikeOuss(){
        // va te faire enculer sale filsd eputelpzslkjfhoep^qkopf
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List getOrientation() {
        return orientation;
    }

    public void setOrientation(List orientation) {
        this.orientation = orientation;
    }
}
