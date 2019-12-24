package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Jeu{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tortue t1 = new Tortue('0',0,0,0,'E');
        Board plateau=new Board(t1);
        boolean jeu=true;
        plateau.initPlacement();
        t1.getDeck().melange();
        t1.getMain().piocheDepart();
        System.out.println("************************************************");
        System.out.println(t1.getDeck().getCarteJaune());
        System.out.println(t1.getDeck().getCarteBleu());
        System.out.println(t1.getDeck().getCarteViolet());
        System.out.println("************************************************");
        System.out.println("Nombre carte deck :" + t1.getDeck().getNbrCarte());
        System.out.println("Nombre carte Main :" + t1.getMain().getNbrCarteM());
        System.out.println("************************************************");
        t1.getMain().voirMain();
        System.out.println("************************************************");
        while(jeu){
            int tour=0;
            int selection;
            System.out.println(t1.getPosY());
            System.out.println(t1.getPosX());
            for (char[] row : plateau.getPlateau()){
                System.out.println(Arrays.toString(row));
            }
            do {
                System.out.println("Voulez vous completez un programme : Tapez 1");
                System.out.println("Voulez vous executez un programme : Tapez 2");
                System.out.println("Voulez vous placez un Mur : Tapez 3");
                selection = scanner.nextInt();}while(selection<0||selection>3);
            if (selection==1){
                t1.completerProg();
            }else if (selection==2){
                t1.executerProg();
                plateau.initPlacement();
                System.out.println(t1.getPosY());
                System.out.println(t1.getPosX());
                for (char[] row : plateau.getPlateau()){
                    System.out.println(Arrays.toString(row));
                }
            }else{
                t1.placerMur();
            }

            System.out.println(t1.getMain().getNbrCarteM());
            System.out.println(t1.getDirection());
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
