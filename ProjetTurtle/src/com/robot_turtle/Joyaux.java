package com.robot_turtle;

public class Joyaux  {
    private char apparence;
    private int posX;
    private int posY;


    public Joyaux(){

    }

    public Joyaux(char apparence,int posX,int posY){
        this.apparence=apparence;
        this.posX=posX;
        this.posY=posY;

    }

    public char getApparence() {
        return apparence;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

