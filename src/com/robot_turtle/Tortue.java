package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Tortue extends Board {
    //private Board board = new Board();
    private Deck deck;
    private Main main;
    //private int posX;
    //private int posY;
    private int score;
    private char direction;
    private char[][] position;
    public int i;
    public int j;
    private ArrayDeque<Cartes> instruction;
    private int nbrCartePile;
    Scanner scanner = new Scanner(System.in);


    public Tortue() {


    }

    public Tortue(char apparence,int i, int j, int score, char direction) {
        this.deck =new Deck();
        this.main=new Main(this.deck);
        this.i = i;
        this.j= j;
        this.score = score;
        this.direction = direction;
        this.instruction= new ArrayDeque<Cartes>();
        this.position = new char [8][8];
        this.nbrCartePile=0;


        for (int a=0; a<8 ;a++){
            for(int b=0;b<8;b++){
                this.position[a][b]=' ';

            }
        }
        this.position[i][j]=apparence;

        //this.position=plateau;
    }

    public void avancer(ArrayDeque<Cartes> instructions) {//instruction d'avancement

            if (this.direction == 'E' && this.position[this.i][7] != '0') {//si la direction est east et que le pion n'est pas en position de sortir du terrain par l'east
                this.position[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.j++;// on ajoute 1 a j qui correspond au numero de la colonne
                this.position[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j+1
                instructions.pollFirst();//on retire l'instruction

            } else if (this.direction == 'E' && this.position[this.i][7] == '0') {//on prend en compte la position limite de la direction EAST (toute les LIGNES de la DERNIERE colonne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
            if (this.direction == 'W' && this.position[this.i][0] != '0') {//si la direction est ouest et que le pion n'est pas en position de sortir du terrain par l'ouest
                this.position[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.j--;// on enleve 1 a j qui correspond au numero de la colonne
                this.position[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j-1
                instructions.pollFirst();
            } else if (this.direction == 'W' && this.position[this.i][0] == '0') {//on prend en compte la position limite de la direction OUEST (toute les LIGNES de la PREMIERE colonne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
            if (this.direction == 'N' && this.position[0][this.j] != '0') {
                this.position[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.i--;// on enleve 1 a i qui correspond au numero de la ligne
                this.position[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i-1/j
                instructions.pollFirst();
            } else if (this.direction == 'N' && this.position[0][this.j] == '0') {//on prend en compte la position limite de la direction NORD (toute les COLONNES de la PREMIERE ligne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
            if (this.direction == 'S' && this.position[7][this.j] != '0') {
                this.position[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.i++;// on ajoute 1 a i qui correspond au numero de la ligne
                this.position[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i+1/j
                instructions.pollFirst();
            } else if (this.direction == 'S' && this.position[7][this.j] == '0') {//on prend en compte la position limite de la direction SUD (toute les COLONNES de la DERNIERE ligne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
        }



    public void rotationG(ArrayDeque<Cartes> instructions) {
        //instruction de changement de direction vers la Gauche
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



    public void rotationD(ArrayDeque<Cartes> instructions) {
        //instruction de changement de direction vers la droite
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
                    this.instruction.addLast(this.main.getMa_main().get(b));
                    this.main.getMa_main().remove(b);
                    this.main.voirMain();
                    pile++;
                    }else{
                        System.out.println("Vous n'avez pas de carte bleu !");
                    }
                }else if (action.equals("Jaune")) {
                    if(this.main.getMa_main().contains(getDeck().getCarteJaune())){
                        int j = this.main.getMa_main().indexOf(getDeck().getCarteJaune());
                        this.instruction.addLast(this.main.getMa_main().get(j));
                        this.main.getMa_main().remove(j);
                        this.main.voirMain();
                        pile++;
                    }else{
                        System.out.println("Vous n'avez pas de carte Jaune !");
                    }
                }else if (action.equals("Violet")){
                    if(this.main.getMa_main().contains(getDeck().getCarteViolet())){
                        int v = this.main.getMa_main().indexOf(getDeck().getCarteViolet());
                        this.instruction.addLast(this.main.getMa_main().get(v));
                        this.main.getMa_main().remove(v);
                        this.main.voirMain();
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
        for (int i=0;i<nbrCartePile;i++){//erreur avec instruction.size() comme modifier dans avancer et rotationD/G boucle non respecter
            System.out.println(this.instruction);
            if (this.instruction.getFirst().equals(getDeck().getCarteBleu())) {
                avancer(this.instruction);
            }
            else if (this.instruction.getFirst().equals(getDeck().getCarteJaune())) {
            rotationG(this.instruction);
            }
            else if (this.instruction.getFirst().equals(getDeck().getCarteViolet())) {
                rotationD(this.instruction);
            }

        }
        System.out.println(this.direction);


    }


    public int getPosX() {
        return this.i;
    }

    public int getPosY() {
        return this.j;
    }

    public void setPosX(int posX) {
        this.i = posX;
    }

    public void setPosY(int posY) {
        this.j= posY;
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
        return this.deck;
    }
    public Main getMain() {
        return this.main;
    }
}
