import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Tortue{
    private Deck deck;
    private Hand hand;
    //private int posX;
    //private int posY;
    private int score;
    private char direction;
    private char[][] position;
    public int i;
    public int j;
    private int initPosi;
    private int initPosj;
    private ArrayDeque<Cartes> instruction;
    private int nbrCartePile=0;
    private Board board;
    Scanner scanner = new Scanner(System.in);
    Icon apparence;


    public Tortue() {

    }

    public Tortue(Icon apparence, int i, int j, int score, char direction,Board board) {
        this.deck = new Deck();
        this.hand = new Hand(this.deck);
        this.i = i;
        this.j = j;
        this.initPosi = i;
        this.initPosj = j;
        this.score = score;
        this.direction = direction;
        this.instruction = new ArrayDeque<Cartes>();
        this.position = new char[8][8];
        this.apparence = apparence;
        this.board =board;


    }

    public void avancer(JButton[][] plateau) {//instruction d'avancement

        if (this.direction == 'E' && !plateau[this.i][7].getName().equals("Tortue")&& !plateau[this.i][this.j+1].getName().equals("Mur")&& !plateau[this.i][this.j+1].getName().equals("Glace")) {//si la direction est east et que le pion n'est pas en position de sortir du terrain par l'east
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);
            this.j++;//
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());
            this.deck.getDeck_defausse().add(this.instruction.getFirst());




        } else if (this.j!=7&&plateau[this.i][this.j+1].getName().equals("Mur")&& plateau[this.i][this.j+1].getName().equals("Glace")) {
            this.direction = 'W';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        }
        if (this.direction == 'W' && !plateau[this.i][7].getName().equals("Tortue")&& !plateau[this.i][this.j-1].getName().equals("Mur")&& !plateau[this.i][this.j-1].getName().equals("Glace")) {//si la direction est ouest et que le pion n'est pas en position de sortir du terrain par l'ouest
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);//on met sa position post-deplacement a 0
            this.j--;// on enleve 1 a j qui correspond au numero de la colonne
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j-1
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if(this.j!=0&&plateau[this.i][this.j-1].getName().equals("Mur")&& plateau[this.i][this.j-1].getName().equals("Glace")) {//on prend en compte la position limite de la direction OUEST (toute les LIGNES de la PREMIERE colonne)
            this.direction = 'E';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

            // si le pion est dans cette position on retire juste l'instruction
        }
        if (this.direction == 'N' && !plateau[0][this.j].getName().equals("Tortue")&& !plateau[this.i-1][this.j].getName().equals("Mur")&& !plateau[this.i-1][this.j].getName().equals("Glace")) {
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);//on met sa position post-deplacement a 0
            this.i--;// on enleve 1 a i qui correspond au numero de la ligne
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i-1/j
            this.deck.getDeck_defausse().add(this.instruction.getFirst());



        } else if (this.i!=0&&plateau[this.i-1][this.j].getName().equals("Mur")&& plateau[this.i-1][this.j].getName().equals("Glace")) {//on prend en compte la position limite de la direction NORD (toute les COLONNES de la PREMIERE ligne)
            this.direction = 'S';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

            // si le pion est dans cette position on retire juste l'instruction
        }
        if (this.direction == 'S' && !plateau[7][this.j].getName().equals("Tortue")&& plateau[this.i+1][this.j].getName().equals("Vide")||plateau[this.i+1][this.j].getName().equals("Joyaux")) {
            plateau[this.i][this.j].setName("Vide");
            plateau[this.i][this.j].setIcon(null);
            this.i++;// on ajoute 1 a i qui correspond au numero de la ligne
            plateau[this.i][this.j].setName("Tortue");
            plateau[this.i][this.j].setIcon(this.getApparence());// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i+1/j
            //this.deck.getDeck_defausse().add(this.instruction.getFirst());




        } else if(this.i!=7&&plateau[this.i+1][this.j].getName().equals("Mur")&& plateau[this.i+1][this.j].getName().equals("Glace")){//on prend en compte la position limite de la direction SUD (toute les COLONNES de la DERNIERE ligne)
            this.direction = 'N';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();
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


    public void utiliserLaser(Board plateau) {
        for (int j = this.getPosY(); j < 8; j++) {
            if (this.getDirection() == 'E') {
                if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Glace")) {
                    plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                    plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                    break;
                } else if (plateau.getPlateau()[this.getPosX()][j] == plateau.getJoyaux().get(i).getApparenceJ()) {
                    for (int i = j; i > 0; i--) {
                        if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                            plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                        } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                            break;
                        } else if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            this.setPosX(initPosi);
                            this.setPosY(initPosj);
                        }

                    }
                }
            }
            else if (this.getDirection() == 'W') {
                if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Glace")) {
                    plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                    plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                    break;
                } else if (plateau.getPlateau()[this.getPosX()][j] == plateau.getJoyaux().get(i).getApparenceJ()) {
                    for (int i = j; i > 0; i--) {
                        if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                            plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                        } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                            break;
                        } else if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            this.setPosX(initPosi);
                            this.setPosY(initPosj);
                        }

                    }
                }
            }

            else if (this.getDirection() == 'N') {

                if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Glace")) {
                    plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                    plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                    break;
                } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Joyaux")) {
                    for (int i = j; i > 0; i--) {
                        if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                            plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                        } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                            break;
                        } else if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            this.setPosX(initPosi);
                            this.setPosY(initPosj);
                        }

                    }
                }

            } else if (this.getDirection() == 'S') {
                if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Glace")) {
                    plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                    plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                    break;
                } else if (plateau.getPlateau()[this.getPosX()][j] == plateau.getJoyaux().get(i).getApparenceJ()) {
                    for (int i = j; i > 0; i--) {
                        if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                            plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                        } else if (plateau.getPlateau()[this.getPosX()][j].getText().equals("Mur")) {
                            break;
                        } else if (plateau.getPlateau()[this.getPosX()][i].getText().equals("Glace")) {
                            plateau.getPlateau()[this.getPosX()][j].setText("Vide");
                            plateau.getPlateau()[this.getPosX()][j].setIcon(null);
                            this.setPosX(initPosi);
                            this.setPosY(initPosj);

                        }

                    }
                }
            }


    }}


    public void retourDepart() {

    }

    public void collision() {

    }


    public void completerProg(String action) {
        int pile = 0;



                if (action.equals("bleu")) {
                    if (this.hand.getMa_main().contains(getDeck().getCarteBleu())) {
                        int b = this.hand.getMa_main().indexOf(getDeck().getCarteBleu());
                        this.instruction.addLast(this.hand.getMa_main().get(b));
                        this.hand.getMa_main().remove(b);



                    } else {
                        System.out.println("Vous n'avez pas de carte bleu !");
                    }
                } else if (action.equals("laser")) {
                    if (this.hand.getMa_main().contains(getDeck().getCarteLaser())) {
                        int l = this.hand.getMa_main().indexOf(getDeck().getCarteLaser());
                        this.instruction.addLast(this.hand.getMa_main().get(l));
                        this.hand.getMa_main().remove(l);



                    } else {
                        System.out.println("Vous n'avez pas de carte Laser !");
                    }

                } else if (action.equals("jaune")) {
                    if (this.hand.getMa_main().contains(getDeck().getCarteJaune())) {
                        int j = this.hand.getMa_main().indexOf(getDeck().getCarteJaune());
                        this.instruction.addLast(this.hand.getMa_main().get(j));
                        this.hand.getMa_main().remove(j);



                    } else {
                        System.out.println("Vous n'avez pas de carte Jaune !");
                    }
                } else if (action.equals("violet")) {
                    if (this.hand.getMa_main().contains(getDeck().getCarteViolet())) {
                        int v = this.hand.getMa_main().indexOf(getDeck().getCarteViolet());
                        this.instruction.addLast(this.hand.getMa_main().get(v));
                        this.hand.getMa_main().remove(v);


                    } else {
                        System.out.println("Vous n'avez pas de carte Violette !");
                    }
                }
                nbrCartePile++;
                this.joyAtteint();



        }


    public void executerProg(Board plateau) {

        for (int i = nbrCartePile; i > 0; i--) {//erreur avec instruction.size() comme modifier dans avancer et rotationD/G boucle non respecter
            nbrCartePile=0;
            if (this.instruction.getFirst().equals(getDeck().getCarteBleu())) {
                avancer(plateau.getPlateau());
                this.instruction.pollFirst();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteJaune())) {
                rotationG();
                this.instruction.pollFirst();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteViolet())) {
                rotationD();
                this.instruction.pollFirst();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteLaser())) {
                utiliserLaser(plateau);
                this.deck.getDeck_defausse().add(this.instruction.getFirst());
                this.instruction.pollFirst(); // a reporter pour rotation et avancer
            }


        }
        this.joyAtteint();



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

    public Hand getHand() {
        return this.hand;
    }

    public ArrayDeque<Cartes> getInstruction() {
        return this.instruction;
    }

    public int getNbrCartePile() {
        return nbrCartePile;
    }
    public void joyAtteint() {
        System.out.println(board.getJ1());
        if (this.getPosX() == board.getJ1().getPosXJ() && this.getPosY() == board.getJ1().getPosYJ()) {
            this.score++;
            System.out.println("Votre score augmente : " +this.score);

        }

    }


    public void voirInstruction(Session fen) {

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
