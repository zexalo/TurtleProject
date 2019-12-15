package com.robot_turtle;

import java.util.Deque;

public class Deck extends Board{
    private int nbrCarte = 37;
    private int nbrDeck=nbrJoueur;
    private Deque<Cartes> pileDefausse;

    public Deck(){

    }

    public Deck(int nbrCarte,int nbrDeck, Deque<Cartes> pileDefausse){
        this.nbrCarte=nbrCarte;
        this.nbrDeck=nbrDeck;
        this.pileDefausse=pileDefausse;
    }
    public void melange(){


    }
    public void remiseDefausse(){


    }

    public int getNbrCarte() {
        return nbrCarte;
    }

    public void setNbrCarte(int nbrCarte) {
        this.nbrCarte = nbrCarte;
    }

    public int getNbrDeck() {
        return nbrDeck;
    }

    public void setNbrDeck(int nbrDeck) {
        this.nbrDeck = nbrDeck;
    }
}
