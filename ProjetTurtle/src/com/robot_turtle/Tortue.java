package com.robot_turtle;

import java.util.List;

public class Tortue {
    private Main main;
    private int posX;
    private int posY;
    private int score;
    private List orientation;

    public Tortue(int posX,int posY,int score,Main main,List orientation){
        this.main=main;
        this.posX=posX;
        this.posY=posY;
        this.score=score;
        this.orientation=orientation;
    }
}
