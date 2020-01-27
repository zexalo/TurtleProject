package com.robot_turtle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board extends Jeu {
    private int nbrJoueur;
    private int nbrMur;
    private int nbrJoyaux;
    private int nbrMurGlace;
    private int taille;
    private char[][] plateau;
    private Tortue t1;
    private Tortue t2;
    private Tortue t3;
    private Tortue t4;
    private Joyaux j1;
    private Joyaux j2;
    private Joyaux j3;


    public Board(int nbrJoueur) {
        this.nbrJoueur = nbrJoueur;
        //on construit le plateau selon le nombre de joueur
        switch (nbrJoueur) {
            case 2:
                this.t1 = new Tortue('0', 0, 1, 0, 'S');
                this.t2 = new Tortue('1', 0, 5, 0, 'S');
                this.j1 = new Joyaux('A',7,3);
                this.nbrJoyaux=1;

                break;
            case 3:
                this.t1 = new Tortue('0', 0, 0, 0, 'S');
                this.t2 = new Tortue('1', 0, 3, 0, 'S');
                this.t3 = new Tortue('2', 0, 6, 0, 'S');
                this.j1 = new Joyaux('A',7,0);
                this.j2 = new Joyaux('B',7,3);
                this.j3 = new Joyaux('C',7,6);
                this.nbrJoyaux=3;
                break;
            case 4:
                this.t1 = new Tortue('0', 0, 0, 0, 'S');
                this.t2 = new Tortue('1', 0, 2, 0, 'S');
                this.t3 = new Tortue('2', 0, 5, 0, 'S');
                this.t4 = new Tortue('3', 0, 7, 0, 'S');
                this.j1 = new Joyaux('A',7,1);
                this.j2 = new Joyaux('B',7,6);
                this.nbrJoyaux=2;
                break;

        }




        //this.nbrJoueur=nbrJoueur;
        //this.nbrMur=nbrMur;
        //this.taille=taille;
        this.nbrJoyaux=nbrJoyaux;
        //this.nbrMurGlace=nbrMurGlace;*/


    }

    public void initPlacement() {
        plateau = new char[8][8];
        // on initialise le plateau selon le nombre d ejoueur
        switch (this.nbrJoueur) {

            case 2:

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        plateau[i][j] = ' ';
                        plateau[i][7] = '8';


                    }
                }
                initTortueSurPlat(this.t1);
                initTortueSurPlat(this.t2);
                plateau[j1.getPosX()][j1.getPosY()] = j1.getApparence();
                break;
            case 3:
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        plateau[i][j] = ' ';
                        plateau[i][7] = '8';


                    }
                }
                initTortueSurPlat(this.t1);
                initTortueSurPlat(this.t2);
                initTortueSurPlat(this.t3);
                plateau[j1.getPosX()][j1.getPosY()] = j1.getApparence();
                plateau[j2.getPosX()][j2.getPosY()] = j2.getApparence();
                plateau[j3.getPosX()][j3.getPosY()] = j3.getApparence();
                break;

            case 4:
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        plateau[i][j] = ' ';


                    }
                }
                initTortueSurPlat(this.t1);
                initTortueSurPlat(this.t2);
                initTortueSurPlat(this.t3);
                initTortueSurPlat(this.t4);
                plateau[j1.getPosX()][j1.getPosY()] = j1.getApparence();
                plateau[j2.getPosX()][j2.getPosY()] = j2.getApparence();
                break;

        }


    }

    public void initTortueSurPlat(Tortue t) {
        plateau[t.getPosX()][t.getPosY()] = t.getApparence();
    }

    public char[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(char[][] plateau) {
        this.plateau = plateau;
    }

    public void initCarte() {

    }

    public void affichage() {

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

    //on recuperer une liste de tortue (notre liste de joueur )
    public ArrayList<Tortue> getTortue() {
        ArrayList<Tortue> listortue = new ArrayList<>();
        switch (nbrJoueur) {
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

        }
        return listortue;
    }
    //on recup la liste de joyaux
    public ArrayList<Joyaux> getJoyaux() {
        ArrayList<Joyaux> listjoyaux = new ArrayList<>();
        switch (nbrJoueur) {
            case 2:
                listjoyaux.add(j1);

            case 3:
                listjoyaux.add(j1);
                listjoyaux.add(j2);
                listjoyaux.add(j3);
            case 4:
                listjoyaux.add(j1);
                listjoyaux.add(j2);


        }
        return listjoyaux;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }




}
