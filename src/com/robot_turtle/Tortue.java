package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tortue  {
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
    char apparence;


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
        this.apparence=apparence;


        for (int a=0; a<8 ;a++){
            for(int b=0;b<8;b++){
                this.position[a][b]=' ';

            }
        }
        this.position[i][j]=apparence;

        //this.position=plateau;
    }

    public void avancer(ArrayDeque<Cartes> instructions,char [][]plateau) {//instruction d'avancement

            if (this.direction == 'E' && plateau[this.i][7] != '0') {//si la direction est east et que le pion n'est pas en position de sortir du terrain par l'east
                plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.j++;// on ajoute 1 a j qui correspond au numero de la colonne
                plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j+1
                this.deck.getDeck_defausse().add(instructions.getFirst());
                //on retire l'instruction

            } else if (this.direction == 'E' && plateau[this.i][7] == '0') {//on prend en compte la position limite de la direction EAST (toute les LIGNES de la DERNIERE colonne)
                instructions.pollFirst();// si le pion est dans cette position on retire juste l'instruction
            }
            if (this.direction == 'W' && plateau[this.i][0] != '0') {//si la direction est ouest et que le pion n'est pas en position de sortir du terrain par l'ouest
                plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.j--;// on enleve 1 a j qui correspond au numero de la colonne
                plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j-1
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (this.direction == 'W' && plateau[this.i][0] == '0') {//on prend en compte la position limite de la direction OUEST (toute les LIGNES de la PREMIERE colonne)
                this.deck.getDeck_defausse().add(instructions.getFirst());
                // si le pion est dans cette position on retire juste l'instruction
            }
            if (this.direction == 'N' && plateau[0][this.j] != '0') {
                plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.i--;// on enleve 1 a i qui correspond au numero de la ligne
                plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i-1/j
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (this.direction == 'N' && plateau[0][this.j] == '0') {//on prend en compte la position limite de la direction NORD (toute les COLONNES de la PREMIERE ligne)
                this.deck.getDeck_defausse().add(instructions.getFirst());
                // si le pion est dans cette position on retire juste l'instruction
            }
            if (this.direction == 'S' && plateau[7][this.j] != '0') {
                plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                this.i++;// on ajoute 1 a i qui correspond au numero de la ligne
                plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i+1/j
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (this.direction == 'S' && plateau[7][this.j] == '0') {//on prend en compte la position limite de la direction SUD (toute les COLONNES de la DERNIERE ligne)
                this.deck.getDeck_defausse().add(instructions.getFirst());
                // si le pion est dans cette position on retire juste l'instruction
            }
        }



    public void rotationG(ArrayDeque<Cartes> instructions) {
        //instruction de changement de direction vers la Gauche
            if (direction == 'E') {
                direction = 'N';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (direction == 'S') {
                direction = 'E';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (direction == 'W') {
                direction = 'S';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (direction == 'N') {
                direction = 'W';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            }
        }



    public void rotationD(ArrayDeque<Cartes> instructions) {
        //instruction de changement de direction vers la droite
            if (direction == 'E') {
                direction = 'S';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (direction == 'S') {
                direction = 'W';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (direction == 'W') {
                direction = 'N';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            } else if (direction == 'N') {
                direction = 'E';
                this.deck.getDeck_defausse().add(instructions.getFirst());

            }
        }



    public void utiliserLaser() {

    }

    public void placerMur(char [][] plateau) {
        int i;
        int j;
        do{
            System.out.println("Veuiller rentrer le numero de la ligne ou placer le mur ");
            i = scanner.nextInt();
            System.out.println("Veuiller rentrer le numero de la colonne ou placer le mur ");
            j = scanner.nextInt();
            plateau[i][j]='8';
        }while(i<0 || i>8 ||j<0 ||j>8);



        //this.deck.getDeckM().remove()

    }

    public void placerMurGlace(char [][] plateau) {
        int i;
        int j;
        do{
            System.out.println("Veuiller rentrer le numero de la ligne ou placer le mur ");
            i = scanner.nextInt();
            System.out.println("Veuiller rentrer le numero de la colonne ou placer le mur ");
            j = scanner.nextInt();
            plateau[i][j]='#';
        }while(i<0 || i>8 ||j<0 ||j>8);


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

    public void executerProg(char [][] plateau) {

        for (int i=0;i<nbrCartePile;i++){//erreur avec instruction.size() comme modifier dans avancer et rotationD/G boucle non respecter
            if (this.instruction.getFirst().equals(getDeck().getCarteBleu())) {
                avancer(this.instruction,plateau);
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

    public char getApparence() {
        return apparence;
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
