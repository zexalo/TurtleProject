package com.robot_turtle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Deck extends Tortue {
    private ArrayList<Cartes>pileDefausse;
    private ArrayList<Cartes> mon_deck;
    private ArrayList<Mur> deckM;
    private Mur tuile_mur = new Mur('8');
    private Mur tuile_mur_glace = new Mur('#');
    private Cartes carte_jaune = new Cartes("couleur", "jaune");
    private Cartes carte_bleue = new Cartes("couleur", "bleue");
    private Cartes carte_violet = new Cartes( "couleur" ,"violet");
    private Cartes carte_laser = new Cartes( "couleur" ,"laser");
    public ArrayList<Cartes> getMon_deck() {
        return mon_deck;
    }
    public ArrayList<Mur> getDeckM(){return deckM;}
    public void setMon_deck(ArrayList<Cartes> mon_deck) {
        this.mon_deck = mon_deck;
    }
    public void setDeckM(ArrayList<Mur> deckM) {
        this.deckM = deckM;
    }

    public Deck(){
        //On creer le deck de carte  dans le constructeur
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
        for (int i = 0; i < 3; i++){
            this.mon_deck.add(carte_laser);
        }
  // on creer le deck de mur
        this.deckM= new ArrayList<>();
        for (int i = 0; i < 3; i++){
            this.deckM.add(tuile_mur);
        }
        for (int i = 0; i < 2; i++){
            this.deckM.add(tuile_mur_glace);
        }
    }
    public void melange(){
        //On melange 6 fois le deck de carte
        for(int i =0; i<6;i++){
            Collections.shuffle(this.mon_deck);
        }





    }
    public void remiseDefausse(){



    }
    public void voirDeck(){
        //On parcour le deck pour afficher chaque carte de celuici
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
    public Cartes getCarteLaser(){
        return carte_laser;
    }
    public Mur getMur(){return tuile_mur;}
    public Mur getMurGlace(){return tuile_mur_glace;}


}
