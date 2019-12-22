package com.robot_turtle;

import java.util.ArrayList;

public class Main extends Tortue {
    private ArrayList<Cartes> ma_main ;
    private Deck deck;


    public ArrayList<Cartes> getMa_main() {
        return ma_main;
    }

    public void setMa_main(ArrayList<Cartes> ma_main) {
        this.ma_main = ma_main;
    }

    Main(Deck deck){
        this.deck = deck;
        this.ma_main = new ArrayList<>();


    }


    public int getNbrCarteM() {
        return ma_main.size();
    }


    public void piocheDepart() {
        for(int i=0;i<5;i++){
            this.ma_main.add(this.deck.getMon_deck().get(i));
            this.deck.getMon_deck().remove(i);
        }


    }

    public void piocheCarte () {
        ma_main.add(this.getDeck().getMon_deck().get(0));
        this.getDeck().getMon_deck().remove(0);

    }

    public void defausser (int numeroCarte) {
        ma_main.remove(numeroCarte);

    }
    public void voirMain(){
        for (int i = 0; i < this.ma_main.size(); i++){
            System.out.println(this.ma_main.get(i));
        }

    }




}
