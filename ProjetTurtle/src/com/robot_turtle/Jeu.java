package com.robot_turtle;

import java.util.Arrays;
import java.util.Scanner;

public class Jeu{
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        int nbrJoueur;
        do{
            System.out.println("Bienvenue sur Robot Turtle ! Combien de Joueur ? :");
            nbrJoueur=scanner.nextInt();

        }while(nbrJoueur<0 || nbrJoueur>4);
        Board plateau=new Board(nbrJoueur);
        boolean jeu=true;
        plateau.initPlacement();//Initialisation du plateau
        int tour =0;
        int joueur =0;// numero de joueur (indice de la liste des tortues)
        for (int i=0;i<plateau.getNbrJoueur();i++){
            // Boucle qui tourne selon le nbr de joueur pour initialiser les mains , les decks , etc
        plateau.getTortue().get(joueur).getDeck().melange();
        plateau.getTortue().get(joueur).getHand().piocheDepart();
        plateau.getTortue().get(joueur).getHand().getMa_main().add(plateau.getTortue().get(joueur).getDeck().getCarteLaser());
        System.out.println(plateau.getTortue().get(joueur).getDeck());
        System.out.println("************************************************");
        System.out.println(plateau.getTortue().get(joueur).getDeck().getCarteJaune());
        System.out.println(plateau.getTortue().get(joueur).getDeck().getCarteBleu());
        System.out.println(plateau.getTortue().get(joueur).getDeck().getCarteViolet());
        System.out.println("************************************************");
        System.out.println("Nombre carte deck :" + plateau.getTortue().get(joueur).getDeck().getNbrCarte());
        System.out.println("Nombre carte Main :" + plateau.getTortue().get(joueur).getHand().getNbrCarteM());
        System.out.println("************************************************");
        plateau.getTortue().get(joueur).getHand().voirMain();
        System.out.println("************************************************");
        joueur++;
        }
        joueur=0;
        // boucle infini de jeu
        while(jeu){
            int selection;
            System.out.println("Tour n°" + tour);
            System.out.println("Joueur n°"+joueur);
            //affichage du plateau
            for (char[] row : plateau.getPlateau()){
                System.out.println(Arrays.toString(row));
            }
            do {
                System.out.println("Voulez vous completer un programme : Tapez 1");
                System.out.println("Voulez vous executer un programme : Tapez 2");
                System.out.println("Voulez vous placer un Mur : Tapez 3");
                selection = scanner.nextInt();}
            while(selection<0||selection>3);

            if (selection==1){
                plateau.getTortue().get(joueur).completerProg();
                plateau.getTortue().get(joueur).defausser();

                //plateau.getTortue().get(joueur).getDeck().voirDeckDefausse();




            }else if (selection==2){
               /*  //Test Pour voir les interactions entre la pile de defausse et la file d'instruction
                System.out.println("avant");
                plateau.getTortue().get(0).voirInstruction();  //voir instruction renvoie true ou false si elle est vide ou non
                plateau.getTortue().get(0).getDeck().voirDeckDefausse();
                System.out.println("apres");
                plateau.getTortue().get(0).voirInstruction();
                plateau.getTortue().get(0).getDeck().voirDeckDefausse();*/
                plateau.getTortue().get(joueur).executerProg(plateau);
                for (char[] row : plateau.getPlateau()){
                    System.out.println(Arrays.toString(row));
                }



            }else{
                String murselec = "";
                scanner= new Scanner(System.in);
                System.out.println("Quelle mur voulez vous place ? glace ou pierre ?");
                murselec = scanner.nextLine();
                if(murselec.equals("pierre")){
                    plateau.getTortue().get(joueur).placerMur(plateau.getPlateau());
                    plateau.getTortue().get(joueur).getDeck().getDeckM().remove(plateau.getTortue().get(0).getDeck().getMur());
                }else if (murselec.equals("glace")){
                    plateau.getTortue().get(joueur).placerMurGlace(plateau.getPlateau());
                    plateau.getTortue().get(joueur).getDeck().getDeckM().remove(plateau.getTortue().get(0).getDeck().getMurGlace());
                }
            }

            // une fois une des instructions faites on verifie si un joyaux est atteint
            for(int i=0;i<plateau.getNbrJoyaux();i++){
                plateau.getTortue().get(joueur).joyAtteint(plateau.getJoyaux().get(i));}
            if (plateau.getTortue().get(joueur).getScore()==1){
                jeu=false;
            }

            //System.out.println(plateau.getTortue().get(joueur).getMain().getNbrCarteM());
            //System.out.println(plateau.getTortue().get(joueur).getDirection());
            //System.out.println(plateau.getTortue().get(joueur).getScore());

            tour++;
            joueur++;
            // si apres l'incrementation le joueur est superieur au nombre de joueur present on remet la variabe a 0 pour redonner la main au premier joueur
           if (joueur>=plateau.getNbrJoueur()){
                joueur=0;
            }

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
