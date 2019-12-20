package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Deck extends Tortue {
    private ArrayList<Cartes>pileDefausse;
    private ArrayList<Cartes> mon_deck;

    public ArrayList<Cartes> getMon_deck() {
        return mon_deck;
    }

    public void setMon_deck(ArrayList<Cartes> mon_deck) {
        this.mon_deck = mon_deck;
    }

    public Deck(){
        this.mon_deck = new ArrayList<>();
        Cartes carte_jaune = new Cartes("couleur", "jaune");
        Cartes carte_bleue = new Cartes("couleur", "bleue");
        Cartes carte_violet = new Cartes( "couleur" ,"violet");
        for (int i = 0; i < 8; i++){
            this.mon_deck.add(carte_jaune);
        }
        for (int i = 0; i < 8; i++){
            this.mon_deck.add(carte_violet);
        }
        for (int i = 0; i < 18; i++){
            this.mon_deck.add(carte_bleue);
        }
    }
    public void melange(){
        for(int i =0; i<3;i++){
            Collections.shuffle(this.mon_deck);
        }



    }
    public void remiseDefausse(){


    }

    public int getNbrCarte() {
        return this.mon_deck.size();
    }



}
