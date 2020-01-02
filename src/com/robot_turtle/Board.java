package com.robot_turtle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board extends Jeu {
    public int nbrJoueur;
    private int nbrMur;
    private int nbrJoyaux;
    private int nbrMurGlace;
    private int taille;
    private char [][] plateau;
    private Tortue t1 ;
    private Tortue t2 ;
    private Tortue t3 ;
    private Tortue t4 ;






    public Board(int nbrJoueur){
        this.nbrJoueur=nbrJoueur;
        switch(nbrJoueur){
            case 1:
                this.t1 = new Tortue('0',0,0,0,'S');
            case 2:
                this.t1 = new Tortue('0',0,0,0,'S');
                this.t2 = new Tortue('1',0,2,0,'S');
            case 3:
                this.t1 = new Tortue('0',0,0,0,'S');
                this.t2 = new Tortue('1',0,2,0,'S');
                this.t3 = new Tortue('2',0,4,0,'S');
            case 4:
                this.t1 = new Tortue('0',0,0,0,'S');
                this.t2 = new Tortue('1',0,2,0,'S');
                this.t3 = new Tortue('2',0,4,0,'S');
                this.t4 = new Tortue('3',0,6,0,'S');

        }



        /*
        this.nbrJoueur=nbrJoueur;
        this.nbrMur=nbrMur;
        this.taille=taille;
        this.nbrJoyaux=nbrJoyaux;
        this.nbrMurGlace=nbrMurGlace;*/


    }

    public void initPlacement(){
        plateau = new char [8][8];


        for (int i=0; i<8 ;i++){
            for(int j=0;j<8;j++){
                plateau[i][j]=' ';




            }
        }



    }
    public void initTortueSurPlat(Tortue t){
        plateau[t.getPosX()][t.getPosY()]=t.getApparence();
    }

    public char[][] getPlateau (){ return plateau;}

    public void setPlateau(char[][] plateau) {
        this.plateau = plateau;
    }

    public void initCarte(){

    }
    public void affichage(){

    }



    public int getNbrJoueur() {
        return nbrJoueur;
    }

    public void setNbrJoueur(int nbrJoueur) {
        this.nbrJoueur = nbrJoueur;
    }

    public int getNbrJoyaux() {
        return nbrJoyaux;
    }

    public void setNbrJoyaux(int nbrJoyaux) {
        this.nbrJoyaux = nbrJoyaux;
    }

    public int getNbrMur() {
        return nbrMur;
    }

    public void setNbrMur(int nbrMur) {
        this.nbrMur = nbrMur;
    }

    public int getNbrMurGlace() {
        return nbrMurGlace;
    }

    public void setNbrMurGlace(int nbrMurGlace) {
        this.nbrMurGlace = nbrMurGlace;
    }

    public int getTaille() {
        return taille;
    }
    public ArrayList<Tortue> getTortue() {
        ArrayList<Tortue> listortue=new ArrayList<>();
        switch(nbrJoueur){
            case 1:
                listortue.add(t1);
            case 2:
                listortue.add(t1);
                listortue.add(t2);
            case 3:
                listortue.add(t1);
                listortue.add(t2);
                listortue.add(t3);
            case 4:
                listortue.add(t1);
                listortue.add(t2);
                listortue.add(t3);
                listortue.add(t4);

    }return listortue;}

    public void setTaille(int taille) {
        this.taille = taille;
    }


}
