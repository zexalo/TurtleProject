package com.robot_turtle;

public class Deck extends Board{
    private int nbrCarte = 37;
    private int nbrDeck=nbrJoueur;

    public Deck(){

    }

    public Deck(int nbrCarte,int nbrDeck){
        this.nbrCarte=nbrCarte;
        this.nbrDeck=nbrDeck;
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
