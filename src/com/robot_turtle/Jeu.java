package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Jeu{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Board plateau=new Board(2);
        boolean jeu=true;
        plateau.initPlacement();
        plateau.initTortueSurPlat(plateau.getTortue().get(0));
        plateau.initTortueSurPlat(plateau.getTortue().get(1));
        //position[8][0]
        plateau.getTortue().get(0).getDeck().melange();
        plateau.getTortue().get(0).getMain().piocheDepart();
        plateau.getTortue().get(1).getDeck().melange();
        plateau.getTortue().get(1).getMain().piocheDepart();
        System.out.println("************************************************");
        System.out.println(plateau.getTortue().get(0).getDeck().getCarteJaune());
        System.out.println(plateau.getTortue().get(0).getDeck().getCarteBleu());
        System.out.println(plateau.getTortue().get(0).getDeck().getCarteViolet());
        System.out.println(" ");
        System.out.println(plateau.getTortue().get(1).getDeck().getCarteJaune());
        System.out.println(plateau.getTortue().get(1).getDeck().getCarteBleu());
        System.out.println(plateau.getTortue().get(1).getDeck().getCarteViolet());
        System.out.println("************************************************");
        System.out.println("Nombre carte deck :" + plateau.getTortue().get(0).getDeck().getNbrCarte());
        System.out.println("Nombre carte Main :" + plateau.getTortue().get(0).getMain().getNbrCarteM());
        System.out.println("************************************************");
        plateau.getTortue().get(0).getMain().voirMain();
        System.out.println(" ");
        plateau.getTortue().get(1).getMain().voirMain();
        System.out.println("************************************************");
        while(jeu){
            int tour=0;
            int selection;
            System.out.println(plateau.getTortue().get(0).getPosY());
            System.out.println(plateau.getTortue().get(0).getPosX());
            for (char[] row : plateau.getPlateau()){
                System.out.println(Arrays.toString(row));
            }
            do {
                System.out.println("Voulez vous completez un programme : Tapez 1");
                System.out.println("Voulez vous executez un programme : Tapez 2");
                System.out.println("Voulez vous placez un Mur : Tapez 3");
                selection = scanner.nextInt();}
            while(selection<0||selection>3);

            if (selection==1){
                int defausse;
                plateau.getTortue().get(0).completerProg();
                scanner= new Scanner(System.in);
                do{System.out.println("Voulez vous defausser vos cartes ? entrer le nombre entre 0 et 5 ou 9 pour ne pas defausser ");
                defausse=scanner.nextInt();}while(defausse<0||defausse>5&&defausse!=9);
                if (defausse==9){
                    break;
                }else {
                    for(int i=defausse-1;i!=-1;i--){
                        System.out.println(defausse);
                        //System.out.println(t1.getMain().getNbrCarteM());
                        plateau.getTortue().get(0).getMain().defausser(i);
                    }
                }
                plateau.getTortue().get(0).getMain().voirMain();
                plateau.getTortue().get(0).getDeck().voirDeckDefausse();



            }else if (selection==2){
                plateau.getTortue().get(0).executerProg(plateau.getPlateau());
                System.out.println(plateau.getTortue().get(0).getPosY());
                System.out.println(plateau.getTortue().get(0).getPosX());
                for (char[] row : plateau.getPlateau()){
                    System.out.println(Arrays.toString(row));
                }
            }else{
                String murselec = "";
                scanner= new Scanner(System.in);
                System.out.println("Quelle mur voulez vous place ? glace ou pierre ?");
                murselec = scanner.nextLine();
                if(murselec.equals("pierre")){
                    plateau.getTortue().get(0).placerMur(plateau.getPlateau());
                    plateau.getTortue().get(0).getDeck().getDeckM().remove(plateau.getTortue().get(0).getDeck().getMur());
                }else if (murselec.equals("glace")){
                    plateau.getTortue().get(0).placerMurGlace(plateau.getPlateau());
                    plateau.getTortue().get(0).getDeck().getDeckM().remove(plateau.getTortue().get(0).getDeck().getMurGlace());
                }
            }

            System.out.println(plateau.getTortue().get(0).getMain().getNbrCarteM());
            System.out.println(plateau.getTortue().get(0).getDirection());
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
