package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Tortue extends Board {
    private Main main;
    private int posX;
    private int posY;
    private int score;
    private List orientation;
    private List<Cartes> action;
    ArrayDeque<String> instruction = new ArrayDeque<>();
    Scanner scanner = new Scanner(System.in);
    public Cartes cartes = new Cartes();

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

    public void utiliserLaser(){

    }
    public void placerMur(){

    }
    public void placerMurGlace(){

    }
    public void retourDepart(){

    }
    public void collision(){

    }
    public void completerProg(){
        String action ;
        int pile=0;
        while( pile !=5){
            do {
                System.out.println("Veuillez mettre les types de cartes dans la pile d'instruction");
                action = scanner.nextLine();
                cartes.setCouleur(action);
            }while (!action.equals("Bleu")&&!action.equals("Jaune")&&!action.equals("Violet"));
            instruction.addLast(action);
            pile++;


    }}
    public void executerProg(){

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
