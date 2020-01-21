import javax.swing.*;
import java.awt.*;
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
            this.deck.getDeque_deck().pollFirst();
        }


    }

    public void piocheCarte () {
        if (ma_main.size() != 5) {
            for (int i = ma_main.size(); i < 5; i++) {
                ma_main.add(deck.getDeque_deck().getFirst());
                deck.getDeque_deck().pollFirst();
            }
        }

    }

    public void defausser (String action) {
        if (action.equals("bleu")) {
            if (this.ma_main.contains(deck.getCarteBleu())) {
                int b = ma_main.indexOf(deck.getCarteBleu());
                this.deck.getDeck_defausse().add(ma_main.get(b));
                this.ma_main.remove(b);


            }

        } else if (action.equals("laser")) {
            if (this.ma_main.contains(deck.getCarteLaser())) {
                int l = ma_main.indexOf(deck.getCarteLaser());
                this.deck.getDeck_defausse().add(ma_main.get(l));
                this.ma_main.remove(l);


            }

        } else if (action.equals("jaune")) {
            if (this.ma_main.contains(deck.getCarteJaune())) {
                int j = this.getMa_main().indexOf(deck.getCarteJaune());
                this.deck.getDeck_defausse().add(ma_main.get(j));
                ma_main.remove(j);


            }
        } else if (action.equals("violet")) {
            if (this.ma_main.contains(deck.getCarteViolet())) {
                int v = this.getMa_main().indexOf(deck.getCarteViolet());
                this.deck.getDeck_defausse().add(ma_main.get(v));
                ma_main.remove(v);


            }
        }



    }
    public void voirMain(Fenetre fen ){
        // on parcour les bouton representant les cartes de la main pour leur assigner le nom et apparence correspondant
        for (int i = 0; i < this.ma_main.size(); i++){
            if (this.ma_main.get(i).equals(this.deck.getCarteBleu())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton) c;
                    bt.setIcon(this.deck.getCarteBleu().getSkin());
                    bt.setName("bleu");


                }
            }else if (this.ma_main.get(i).equals(this.deck.getCarteJaune())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton) c;
                    bt.setIcon(this.deck.getCarteJaune().getSkin());
                    bt.setName("jaune");


                }
            }else if(this.ma_main.get(i).equals(this.deck.getCarteViolet())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton) c;
                    bt.setIcon(this.deck.getCarteViolet().getSkin());
                    bt.setName("violet");


                }
            }else if (this.ma_main.get(i).equals(this.deck.getCarteLaser())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton)c;
                    bt.setIcon(this.deck.getCarteLaser().getSkin());
                    bt.setName("laser");

                }
            }

            System.out.println(this.ma_main.get(i));
        }

    }




}
