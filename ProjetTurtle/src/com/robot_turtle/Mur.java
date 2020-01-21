package com.robot_turtle;

public class Mur {
    private int posi;
    private int posj;
    private char type;
    public Mur(char type){
        this.type = type;


    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getPosi() {
        return posi;
    }

    public void setPosi(int posi) {
        this.posi = posi;
    }

    public int getPosj() {
        return posj;
    }

    public void setPosj(int posj) {
        this.posj = posj;
    }
}
