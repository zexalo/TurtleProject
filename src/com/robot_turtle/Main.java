package com.robot_turtle;

import java.util.ArrayList;

public class Main extends Tortue {
    private int nbrCarte = 5;
    private ArrayList<Cartes> main ;

    public Main(){

    }

    public Main(int nbrCarte){
        this.nbrCarte=nbrCarte;
    }

    public int getNbrCarte() {
        return nbrCarte;
    }

    public void setNbrCarte(int nbrCarte) {
        this.nbrCarte = nbrCarte;
    }

    public void piocheDepart() {
        for(int i=0;i<6;i++){
        main.add(this.getDeck().getMon_deck().get(0));
        this.getDeck().getMon_deck().remove(0);
    }

    }

    public void piocheCarte () {
        main.add(this.getDeck().getMon_deck().get(0));
        this.getDeck().getMon_deck().remove(0);

    }

    public void defausser (int numeroCarte) {
        main.remove(numeroCarte);

    }




}
