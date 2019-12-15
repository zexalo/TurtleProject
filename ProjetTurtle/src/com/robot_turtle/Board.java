package com.robot_turtle;

public class Board {
    int nbrJoueur;
    int nbrMur;
    int nbrJoyaux;
    int nbrMurGlace;
    int taille;

    public Board(int nbrJoueur, int nbrMur,int taille,int nbrJoyaux,int nbrMurGlace){
        this.nbrJoueur=nbrJoueur;
        this.nbrMur=nbrMur;
        this.taille=taille;
        this.nbrJoyaux=nbrJoyaux;
        this.nbrMurGlace=nbrMurGlace;

    }
}
