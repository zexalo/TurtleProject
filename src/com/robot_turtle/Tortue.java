package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Tortue extends Board {
    private Board board = new Board();
    private Main main;
    private int posX;
    private int posY;
    private int score;
    private char direction;
    private char[][] position;
    static int i = 0;
    static int j = 0;
    private List<Cartes> action;
    private ArrayDeque<Cartes> instruction = new ArrayDeque<>();
    Scanner scanner = new Scanner(System.in);
    private Deck deck;

    public Tortue() {

    }

    public Tortue(int posX, int posY, int score, Main main, char direction, char[][] position) {
        this.main = main;
        this.posX = posX;
        this.posY = posY;
        this.score = score;
        this.direction = direction;
        this.position = position;
        this.deck=new Deck();
    }

    /*public void avancer(ArrayDeque<Cartes> instructions) {
        initPlacement();
        this.position[i][j] = ' ';
        if (instructions.getFirst()==) {//instruction d'avancement

            if (direction == 'E' && this.position[i][7] != '0') {//si la direction est east et que le pion n'est pas en position de sortir du terrain par l'east
                this.position[i][j] = ' ';//on met sa position post-deplacement a 0
                j++;// on ajoute 1 a j qui correspond au numero de la colonne
                position[i][j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j+1
                instructions.pollFirst();//on retire l'instruction

            } else if (direction == 'E' && position[i][7] == '0') {//on prend en compte la position limite de la direction EAST (toute les LIGNES de la DERNIERE colonne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
            if (direction == 'W' && position[i][0] != '0') {//si la direction est ouest et que le pion n'est pas en position de sortir du terrain par l'ouest
                position[i][j] = ' ';//on met sa position post-deplacement a 0
                j--;// on enleve 1 a j qui correspond au numero de la colonne
                position[i][j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j-1
                instructions.pollFirst();
            } else if (direction == 'W' && position[i][0] == '0') {//on prend en compte la position limite de la direction OUEST (toute les LIGNES de la PREMIERE colonne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
            if (direction == 'N' && position[0][j] != '0') {
                position[i][j] = ' ';//on met sa position post-deplacement a 0
                i--;// on enleve 1 a i qui correspond au numero de la ligne
                position[i][j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i-1/j
                instructions.pollFirst();
            } else if (direction == 'N' && position[0][j] == '0') {//on prend en compte la position limite de la direction NORD (toute les COLONNES de la PREMIERE ligne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
            if (direction == 'S' && position[7][j] != '0') {
                position[i][j] = ' ';//on met sa position post-deplacement a 0
                i++;// on ajoute 1 a i qui correspond au numero de la ligne
                position[i][j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i+1/j
                instructions.pollFirst();
            } else if (direction == 'S' && position[7][j] == '0') {//on prend en compte la position limite de la direction SUD (toute les COLONNES de la DERNIERE ligne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
        }

    }*/

    public void rotationG(ArrayDeque<Cartes> instructions) {
        if (instructions.getFirst().equals("Jaune")) {//instruction de changement de direction vers la Gauche
            if (direction == 'E') {
                direction = 'N';
                instructions.pollFirst();
            } else if (direction == 'S') {
                direction = 'E';
                instructions.pollFirst();
            } else if (direction == 'W') {
                direction = 'S';
                instructions.pollFirst();
            } else if (direction == 'N') {
                direction = 'W';
                instructions.pollFirst();
            }
        }

    }

    public void rotationD(ArrayDeque<String> instructions) {
        if (instructions.getFirst().equals("Violet")) {//instruction de changement de direction vers la droite
            if (direction == 'E') {
                direction = 'S';
                instructions.pollFirst();
            } else if (direction == 'S') {
                direction = 'W';
                instructions.pollFirst();
            } else if (direction == 'W') {
                direction = 'N';
                instructions.pollFirst();
            } else if (direction == 'N') {
                direction = 'E';
                instructions.pollFirst();
            }
        }

    }

    public void utiliserLaser() {

    }

    public void placerMur() {

    }

    public void placerMurGlace() {

    }

    public void retourDepart() {

    }

    public void collision() {

    }

    /*public void completerProg() {
        String action;
        int pile = 0;
        while (pile != 5) {
            do {
                System.out.println("Veuillez mettre les types de cartes dans la pile d'instruction");
                action = scanner.nextLine();
                cartes.setCouleur(action);
            } while (!action.equals("Bleu") && !action.equals("Jaune") && !action.equals("Violet"));
            instruction.addLast(action);
            pile++;


        }
    }*/

    public void executerProg() {

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

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    public Deck getDeck() {
        return deck;
    }
}
