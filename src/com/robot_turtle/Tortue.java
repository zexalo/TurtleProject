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
    private ArrayDeque<Cartes> instruction;
    Scanner scanner = new Scanner(System.in);
    private Deck deck;

    public Tortue() {

    }

    public Tortue(int posX, int posY, int score, Main main, char direction,Deck deck) {
        this.main = main;
        this.posX = posX;
        this.posY = posY;
        this.score = score;
        this.direction = direction;
        this.deck=deck;
        this.instruction= new ArrayDeque<Cartes>();
        //this.position=plateau;
    }

    public void avancer(ArrayDeque<Cartes> instructions) {
        this.position[i][j] = ' ';
        if (instructions.getFirst().equals(getDeck().getCarteBleu())) {//instruction d'avancement

            if (this.direction == 'E' && this.position[i][7] != '0') {//si la direction est east et que le pion n'est pas en position de sortir du terrain par l'east
                this.position[i][j] = ' ';//on met sa position post-deplacement a 0
                j++;// on ajoute 1 a j qui correspond au numero de la colonne
                this.position[i][j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j+1
                instructions.pollFirst();//on retire l'instruction

            } else if (this.direction == 'E' && this.position[i][7] == '0') {//on prend en compte la position limite de la direction EAST (toute les LIGNES de la DERNIERE colonne)
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
            } else if (this.direction == 'S' && this.position[7][j] == '0') {//on prend en compte la position limite de la direction SUD (toute les COLONNES de la DERNIERE ligne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
        }

    }

    public void rotationG(ArrayDeque<Cartes> instructions) {
        if (instructions.getFirst().equals(getDeck().getCarteJaune())) {//instruction de changement de direction vers la Gauche
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

    public void rotationD(ArrayDeque<Cartes> instructions) {
        if (instructions.getFirst().equals(getDeck().getCarteViolet())) {//instruction de changement de direction vers la droite
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

    public void completerProg() {
        String action;
        int pile = 0;
        int nbrCartePile=0;
        do {
            System.out.println("Veuillez entrez le nombre de carte que vous desirez placer en instruction");
            nbrCartePile = scanner.nextInt();
            System.out.println(nbrCartePile);
        }while(nbrCartePile<0||nbrCartePile>5);

        while (pile != nbrCartePile) {
            do {
                System.out.println("Veuillez mettre les types de cartes dans la pile d'instruction");
                action = scanner.nextLine();
                if (action.equals("Bleu")) {
                    if(this.main.getMa_main().contains(getDeck().getCarteBleu())){
                    int b = this.main.getMa_main().indexOf(getDeck().getCarteBleu());
                    this.main.getMa_main().remove(b);
                    this.main.voirMain();
                    this.instruction.addLast(this.main.getMa_main().get(b));
                    pile++;
                    }else{
                        System.out.println("Vous n'avez pas de carte bleu !");
                    }
                }else if (action.equals("Jaune")) {
                    if(this.main.getMa_main().contains(getDeck().getCarteJaune())){
                        int j = this.main.getMa_main().indexOf(getDeck().getCarteJaune());
                        this.main.getMa_main().remove(j);
                        this.main.voirMain();
                        this.instruction.addLast(this.main.getMa_main().get(j));
                        pile++;
                    }else{
                        System.out.println("Vous n'avez pas de carte Jaune !");
                    }
                }else if (action.equals("Violet")){
                    if(this.main.getMa_main().contains(getDeck().getCarteViolet())){
                        int v = this.main.getMa_main().indexOf(getDeck().getCarteViolet());
                        this.main.getMa_main().remove(v);
                        this.main.voirMain();
                        this.instruction.addLast(this.main.getMa_main().get(v));
                        pile++;
                    }else{
                        System.out.println("Vous n'avez pas de carte Violette !");
                    }
                }else{
                    System.out.println("ENTREZ UNE ACTION VALIDE");
                }
            } while (!action.equals("Bleu") && !action.equals("Jaune") && !action.equals("Violet"));



        }
    }

    public void executerProg() {

        for (int i=0;i<this.instruction.size();i++){
            System.out.println(this.instruction);
        rotationD(this.instruction);
        rotationG(this.instruction);
        }
        System.out.println(this.direction);


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
