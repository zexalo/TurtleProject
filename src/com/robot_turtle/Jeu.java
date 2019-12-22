package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Jeu {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Board plateau=new Board();
        Deck deck1=new Deck();
        Main main=new Main(deck1);
        Tortue T1 = new Tortue(0,0,0,main,'E',deck1);
        boolean jeu=true;
        plateau.initPlacement();
        deck1.melange();
        main.piocheDepart();
        deck1.voirDeck();
        System.out.println("************************************************");
        System.out.println(deck1.getCarteJaune());
        System.out.println(deck1.getCarteBleu());
        System.out.println(deck1.getCarteViolet());
        System.out.println("************************************************");
        System.out.println("Nombre carte deck :" + deck1.getNbrCarte());
        System.out.println("Nombre carte Main :" + main.getNbrCarteM());
        System.out.println("************************************************");
        main.voirMain();
        System.out.println("************************************************");
        while(jeu){
            int tour=0;
            int selection;
            do {
                System.out.println("Voulez vous completez un programme : Tapez 1");
                System.out.println("Voulez vous executez un programme : Tapez 2");
                System.out.println("Voulez vous placez un Mur : Tapez 3");
                selection = scanner.nextInt();}while(selection<0||selection>3);
            if (selection==1){
                T1.completerProg();
            }else if (selection==2){
                T1.executerProg();
                for (char[] row : plateau.getPlateau()){
                    System.out.println(Arrays.toString(row));
                }
            }else{
                T1.placerMur();
            }
            for (char[] row : plateau.getPlateau()){
                System.out.println(Arrays.toString(row));
            }

            System.out.println(main.getNbrCarteM());
            System.out.println(T1.getDirection());
            tour+=1;
            System.out.println(tour);
        }



        //while(jeu){


            /*ArrayDeque<String> instruction = creationFile();
            deplacement(instruction);
            System.out.println(instruction.size());
            for (int[] row : position){
                System.out.println(Arrays.toString(row));
            }
            System.out.println(direction);*/
        //}
    }
    public Jeu(){

    }

    public void lancementJeu(){

    }
    public void finDePartie(){

    }
    public void menuJeu(){

    }
    public void choixNbrJoueur(){

    }
    public void tourJeu(){

    }
}
