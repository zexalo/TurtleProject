import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Tortue {
    private Deck deck;
    private Main main;
    //private int posX;
    //private int posY;
    private int score;
    private char direction;
    private char[][] position;
    public int i;
    public int j;
    private ArrayDeque<Cartes> instruction;
    private int nbrCartePile=0;
    Scanner scanner = new Scanner(System.in);
    Icon apparence;


    public Tortue() {


    }

    public Tortue(Icon apparence, int i, int j, int score, char direction) {
        this.deck = new Deck();
        this.main = new Main(this.deck);
        this.i = i;
        this.j = j;
        this.score = score;
        this.direction = direction;
        this.instruction = new ArrayDeque<Cartes>();
        this.position = new char[8][8];
        this.apparence = apparence;



        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                this.position[a][b] = ' ';

            }
        }
        //this.position[i][j] = apparence;

        //this.position=plateau;
    }

    public void avancer(JButton[][] plateau) {//instruction d'avancement

        if (this.direction == 'E' && !plateau[this.i][7].getName().equals("Tortue")) {//si la direction est east et que le pion n'est pas en position de sortir du terrain par l'east
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);//on met sa position post-deplacement a 0
            this.j++;// on ajoute 1 a j qui correspond au numero de la colonne
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j+1
            this.deck.getDeck_defausse().add(this.instruction.getFirst());




        } else if (this.direction == 'E' && plateau[this.i][7].getName().equals("Tortue")) {
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            //on prend en compte la position limite de la direction EAST (toute les LIGNES de la DERNIERE colonne)

        }
        if (this.direction == 'W' && !plateau[this.i][7].getName().equals("Tortue")) {//si la direction est ouest et que le pion n'est pas en position de sortir du terrain par l'ouest
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);//on met sa position post-deplacement a 0
            this.j--;// on enleve 1 a j qui correspond au numero de la colonne
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j-1
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (this.direction == 'W' && plateau[this.i][0].getName().equals("Tortue")) {//on prend en compte la position limite de la direction OUEST (toute les LIGNES de la PREMIERE colonne)
            this.deck.getDeck_defausse().add(this.instruction.getFirst());


            // si le pion est dans cette position on retire juste l'instruction
        }
        if (this.direction == 'N' && !plateau[0][this.j].getName().equals("Tortue")) {
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);//on met sa position post-deplacement a 0
            this.i--;// on enleve 1 a i qui correspond au numero de la ligne
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i-1/j
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (this.direction == 'N' && plateau[0][this.j].getName().equals("Tortue")) {//on prend en compte la position limite de la direction NORD (toute les COLONNES de la PREMIERE ligne)
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

            // si le pion est dans cette position on retire juste l'instruction
        }
        if (this.direction == 'S' && !plateau[7][this.j].getName().equals("Tortue")) {
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);//on met sa position post-deplacement a 0
            this.i++;// on ajoute 1 a i qui correspond au numero de la ligne
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i+1/j
            this.deck.getDeck_defausse().add(this.instruction.getFirst());




        } else if (this.direction == 'S' && plateau[7][this.j].getName().equals("Tortue")) {//on prend en compte la position limite de la direction SUD (toute les COLONNES de la DERNIERE ligne)
            this.deck.getDeck_defausse().add(this.instruction.getFirst());


            // si le pion est dans cette position on retire juste l'instruction
        }
    }


    public void rotationG() {
        //instruction de changement de direction vers la Gauche
        if (direction == 'E') {
            direction = 'N';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (direction == 'S') {
            direction = 'E';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (direction == 'W') {
            direction = 'S';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (direction == 'N') {
            direction = 'W';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        }
    }


    public void rotationD() {
        //instruction de changement de direction vers la droite
        if (direction == 'E') {
            direction = 'S';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (direction == 'S') {
            direction = 'W';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (direction == 'W') {
            direction = 'N';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (direction == 'N') {
            direction = 'E';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());


        }
    }


    public void utiliserLaser(char[][] plateau) {
        if (this.getDirection() == 'E') {
            for (int j = this.getPosY(); j < 8; j++) {
                if (plateau[this.getPosX()][j] == '#') {
                    plateau[this.getPosX()][j] = ' ';
                }
            }
        } else if (this.getDirection() == 'W') {
            for (int j = getPosY(); j > 0; j--) {
                if (plateau[this.getPosX()][j] == '#') {
                    plateau[this.getPosX()][j] = ' ';
                }
            }

        } else if (this.getDirection() == 'N') {
            for (int i = getPosX(); i > 0; i--) {
                if (plateau[i][this.getPosY()] == '#') {
                    plateau[i][this.getPosY()] = ' ';
                }
            }
        } else if (this.getDirection()=='S'){
            for (int i = this.getPosX(); i < 8; i++) {
                if (plateau[i][this.getPosY()] == '#') {
                    plateau[i][this.getPosY()] = ' ';
                }else{
                    System.out.println("pas glace");
                }
            }
        }


    }


    public void retourDepart() {

    }

    public void collision() {

    }


    public void completerProg(String action) {
        int pile = 0;



                if (action.equals("bleu")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteBleu())) {
                        int b = this.main.getMa_main().indexOf(getDeck().getCarteBleu());
                        this.instruction.addLast(this.main.getMa_main().get(b));
                        this.main.getMa_main().remove(b);



                    } else {
                        System.out.println("Vous n'avez pas de carte bleu !");
                    }
                } else if (action.equals("laser")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteLaser())) {
                        int l = this.main.getMa_main().indexOf(getDeck().getCarteLaser());
                        this.instruction.addLast(this.main.getMa_main().get(l));
                        this.main.getMa_main().remove(l);



                    } else {
                        System.out.println("Vous n'avez pas de carte Laser !");
                    }

                } else if (action.equals("jaune")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteJaune())) {
                        int j = this.main.getMa_main().indexOf(getDeck().getCarteJaune());
                        this.instruction.addLast(this.main.getMa_main().get(j));
                        this.main.getMa_main().remove(j);



                    } else {
                        System.out.println("Vous n'avez pas de carte Jaune !");
                    }
                } else if (action.equals("violet")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteViolet())) {
                        int v = this.main.getMa_main().indexOf(getDeck().getCarteViolet());
                        this.instruction.addLast(this.main.getMa_main().get(v));
                        this.main.getMa_main().remove(v);


                    } else {
                        System.out.println("Vous n'avez pas de carte Violette !");
                    }
                }
                nbrCartePile++;



        }


    public void executerProg(JButton[][] plateau) {

        for (int i = nbrCartePile; i > 0; i--) {//erreur avec instruction.size() comme modifier dans avancer et rotationD/G boucle non respecter
            nbrCartePile=0;
            if (this.instruction.getFirst().equals(getDeck().getCarteBleu())) {
                avancer(plateau);
                this.instruction.pollFirst();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteJaune())) {
                rotationG();
                this.instruction.pollFirst();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteViolet())) {
                rotationD();
                this.instruction.pollFirst();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteLaser())) {
                //utiliserLaser(plateau);
                this.deck.getDeck_defausse().add(this.instruction.getFirst());
                this.instruction.pollFirst(); // a reporter pour rotation et avancer
            }


        }



    }

    public void setNbrCartePile(int nbrCartePile) {
        this.nbrCartePile = nbrCartePile;
    }

    public Icon getApparence() {
        return apparence;
    }

    public int getPosX() {
        return this.i;
    }


    public int getPosY() {
        return this.j;
    }

    public void setPosX(int posX) {
        this.i = posX;
    }

    public void setPosY(int posY) {
        this.j = posY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public Main getMain() {
        return this.main;
    }

    public ArrayDeque<Cartes> getInstruction() {
        return this.instruction;
    }

    public int getNbrCartePile() {
        return nbrCartePile;
    }

    public void voirInstruction(Fenetre fen) {

        for (int i = 0; i < this.instruction.size(); i++){
            if (this.instruction.getFirst().equals(this.deck.getCarteBleu())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton) c;
                    bt.setIcon(this.deck.getCarteBleu().getSkin());
                    bt.setName("bleu");


                }
            }else if (this.instruction.getFirst().equals(this.deck.getCarteJaune())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton) c;
                    bt.setIcon(this.deck.getCarteJaune().getSkin());
                    bt.setName("jaune");


                }
            }else if(this.instruction.getFirst().equals(this.deck.getCarteViolet())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton) c;
                    bt.setIcon(this.deck.getCarteViolet().getSkin());
                    bt.setName("violet");


                }
            }else if (this.instruction.getFirst().equals(this.deck.getCarteLaser())){
                Component c=fen.getPanMain().getComponent(i);
                System.out.println(c);
                if(c instanceof JButton){
                    JButton bt = (JButton)c;
                    bt.setIcon(this.deck.getCarteLaser().getSkin());
                    bt.setName("laser");

                }
            }


            System.out.println(this.instruction.getFirst());
        }

    }
}
