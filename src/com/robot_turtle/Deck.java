package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Deck extends Tortue {
    private ArrayList<Cartes>pileDefausse;
    private ArrayList<Cartes> mon_deck;
    private Cartes carte_jaune = new Cartes("couleur", "jaune");
    private Cartes carte_bleue = new Cartes("couleur", "bleue");
    private Cartes carte_violet = new Cartes( "couleur" ,"violet");

    public ArrayList<Cartes> getMon_deck() {
        return mon_deck;
    }

    public void setMon_deck(ArrayList<Cartes> mon_deck) {
        this.mon_deck = mon_deck;
    }

    public Deck(){
        this.mon_deck = new ArrayList<>();
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
        for(int i =0; i<6;i++){
            Collections.shuffle(this.mon_deck);
        }





    }
    public void remiseDefausse(){



    }
    public void voirDeck(){
        for (int i = 0; i < this.mon_deck.size()-1; i++){
            System.out.println(this.mon_deck.get(i));
        }

    }

    public int getNbrCarte() {
        return this.mon_deck.size();
    }

    public Cartes getCarteBleu(){
        return carte_bleue;
    }
    public Cartes getCarteJaune(){
        return carte_jaune;
    }
    public Cartes getCarteViolet(){
        return carte_violet;
    }


}
