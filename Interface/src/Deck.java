import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Tortue {
    private Icon cjaune = new ImageIcon(this.getClass().getResource("Images/Cartes/YellowCard2.png"));
    private Icon cbleu = new ImageIcon(this.getClass().getResource("Images/Cartes/BlueCard2.png"));
    private Icon cviolet = new ImageIcon(this.getClass().getResource("Images/Cartes/PurpleCard2.png"));
    private Icon claser = new ImageIcon(this.getClass().getResource("Images/Cartes/LaserCard2.png"));
    private JLabel cj = new JLabel();
    private JLabel cb = new JLabel();
    private JLabel cv = new JLabel();
    private JLabel cl = new JLabel();
    private ArrayList<Cartes>pileDefausse;
    private ArrayList<Cartes> mon_deck;
    private ArrayDeque<Cartes> deque_deck;
    private ArrayList<Cartes> deck_defausse;
    private ArrayList<Mur> deckM;
    private Mur tuile_mur = new Mur("Pierre");
    private Mur tuile_mur_glace = new Mur("Glace");
    private Cartes carte_jaune = new Cartes(cjaune,"jaune");
    private Cartes carte_bleue = new Cartes(cbleu,"bleue");
    private Cartes carte_violet = new Cartes(cviolet,"violet");
    private Cartes carte_laser = new Cartes(claser, "laser");
    public ArrayList<Cartes> getMon_deck() {
        return mon_deck;
    }
    public ArrayList<Mur> getDeckM(){return deckM;}

    public ArrayList<Cartes> getDeck_defausse() {
        return deck_defausse;
    }


    public void setDeckM(ArrayList<Mur> deckM) {
        this.deckM = deckM;
    }

    public void setDeck_defausse(ArrayList<Cartes> deck_defausse) {
        this.deck_defausse = deck_defausse;
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
        this.deck_defausse=new ArrayList<>();


    }
    public void melange(){
        //On melange 6 fois le deck de carte
        for(int i =0; i<6;i++){
            Collections.shuffle(this.mon_deck);
        }
        this.deque_deck=new ArrayDeque<>(mon_deck);





    }
    public void remiseDefausse(){



    }
    public void voirDeck(){
        //On parcour le deck pour afficher chaque carte de celuici
        for (int i = 0; i < this.mon_deck.size()-1; i++){
            System.out.println(this.mon_deck.get(i));
        }

    }
    public void voirDeckDefausse(){
        //On parcour le deck pour afficher chaque carte de celuici
        for (int i = 0; i < this.deck_defausse.size(); i++){
            System.out.println(this.deck_defausse.get(i));
        }

    }
    //public void voirDeckM(Fenetre fen){
//        for (int i = 0; i < this.deckM.size(); i++){
//            if (this.deckM.get(i).equals(this.getMur())){
//                Component c=fen.getPan_tuile().getComponent(i);
//                System.out.println(c);
//                if(c instanceof JButton){
//                    JButton bt = (JButton)c;
//                    bt.setText("Pierre");
//
//                }
//            }else if (this.deckM.get(i).equals(this.getMurGlace())){
//                Component c=fen.getPan_tuile().getComponent(i);
//                System.out.println(c);
//                if(c instanceof JButton){
//                    JButton bt = (JButton)c;
//                    bt.setText("Glace");
//
//                }
//            }


        //}


    //}

    public int getNbrCarte() {
        return this.mon_deck.size();
    }

    public int getNbrGlace(){
        int nbr=0;
        for(int i=0;i<this.deckM.size();i++){
            if (this.deckM.get(i).getType().equals("Glace")){
                nbr++;
            }
        }
        return nbr;
    }
    public int getNbrPierre(){
        int nbr=0;
        for(int i=0;i<this.deckM.size();i++){
            if (this.deckM.get(i).getType().equals("Pierre")){
                nbr++;
            }
        }
        return nbr;
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

    public ArrayDeque<Cartes> getDeque_deck() {
        return deque_deck;
    }
}
