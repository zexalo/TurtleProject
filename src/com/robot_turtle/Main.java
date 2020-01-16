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
            this.ma_main.add(this.deck.getDeque_deck().getFirst());
            this.deck.getMon_deck().pollFirst();
        }


    }

    public void piocheCarte () {
        this.ma_main.add(this.getDeck().getDeque_deck().getFirst());

    }

    public void defausserM (int numeroCarte) {
        this.deck.getDeck_defausse().add(this.ma_main.get(numeroCarte));
        this.ma_main.remove(numeroCarte);

    }
    public void voirMain(){
        for (int i = 0; i < this.ma_main.size(); i++){
            System.out.println(this.ma_main.get(i));
        }

    }




}
