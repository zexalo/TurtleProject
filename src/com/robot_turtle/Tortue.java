package com.robot_turtle;

import java.util.*;

public class Tortue {
    private Deck deck;
    private Main main;
    //private int posX;
    //private int posY;
    private int score;
    private char direction;
    private char[][] position;
    private int i;
    private int j;
    private int initPosi;
    private int initPosj;
    private ArrayDeque<Cartes> instruction;
    private int nbrCartePile;
    Scanner scanner = new Scanner(System.in);
    char apparence;


    public Tortue() {


    }

    public Tortue(char apparence, int i, int j, int score, char direction) {
        this.deck = new Deck();
        this.main = new Main(this.deck);
        this.i = i;
        this.j = j;
        this.initPosi = i;
        this.initPosj = j;
        this.score = score;
        this.direction = direction;
        this.instruction = new ArrayDeque<Cartes>();
        this.position = new char[8][8];
        this.nbrCartePile = 0;
        this.apparence = apparence;


        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                this.position[a][b] = ' ';

            }
        }
        this.position[i][j] = apparence;

        //this.position=plateau;
    }

    public void avancer(char[][] plateau) {//instruction d'avancement

        if (this.direction == 'E' && plateau[this.i][7] != '0') {//si la direction est east et que le pion n'est pas en position de sortir du terrain par l'east
            plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
            this.j++;// on ajoute 1 a j qui correspond au numero de la colonne
            plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j+1
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();
            //on retire l'instruction

        } else if (this.direction == 'E' && plateau[this.i][7] == '0') {//on prend en compte la position limite de la direction EAST (toute les LIGNES de la DERNIERE colonne)
            this.instruction.pollFirst();// si le pion est dans cette position on retire juste l'instruction
        }
        if (this.direction == 'W' && plateau[this.i][0] != '0') {//si la direction est ouest et que le pion n'est pas en position de sortir du terrain par l'ouest
            plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
            this.j--;// on enleve 1 a j qui correspond au numero de la colonne
            plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la ligne etant inchange le pion sera a la position i/j-1
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (this.direction == 'W' && plateau[this.i][0] == '0') {//on prend en compte la position limite de la direction OUEST (toute les LIGNES de la PREMIERE colonne)
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();
            // si le pion est dans cette position on retire juste l'instruction
        }
        if (this.direction == 'N' && plateau[0][this.j] != '0') {
            plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
            this.i--;// on enleve 1 a i qui correspond au numero de la ligne
            plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i-1/j
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (this.direction == 'N' && plateau[0][this.j] == '0') {//on prend en compte la position limite de la direction NORD (toute les COLONNES de la PREMIERE ligne)
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();
            // si le pion est dans cette position on retire juste l'instruction
        }
        if (this.direction == 'S' && plateau[7][this.j] != '0') {
            plateau[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
            this.i++;// on ajoute 1 a i qui correspond au numero de la ligne
            plateau[this.i][this.j] = '0';// On met 1 a sa nouvelle position ici la colonne etant inchange le pion sera a la position i+1/j
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (this.direction == 'S' && plateau[7][this.j] == '0') {//on prend en compte la position limite de la direction SUD (toute les COLONNES de la DERNIERE ligne)
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
            this.instruction.pollFirst();

        } else if (direction == 'S') {
            direction = 'E';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (direction == 'W') {
            direction = 'S';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (direction == 'N') {
            direction = 'W';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        }
    }


    public void rotationD() {
        //instruction de changement de direction vers la droite
        if (direction == 'E') {
            direction = 'S';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (direction == 'S') {
            direction = 'W';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (direction == 'W') {
            direction = 'N';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        } else if (direction == 'N') {
            direction = 'E';
            this.deck.getDeck_defausse().add(this.instruction.getFirst());
            this.instruction.pollFirst();

        }
    }


    public void utiliserLaser(Board plateau) {
            for (int j = this.getPosY(); j < 8; j++) {
                if (this.getDirection() == 'E') {
                    if (plateau.getPlateau()[this.getPosX()][j] == '#') {
                    plateau.getPlateau()[this.getPosX()][j] = ' ';
                } else if (plateau.getPlateau()[this.getPosX()][j] == '8') {
                    break;
                } else if (plateau.getPlateau()[this.getPosX()][j] == plateau.getJoyaux().get(i).getApparence()) {
                    for (int i = j; i > 0; i--) {
                        if (plateau.getPlateau()[this.getPosX()][i] == '#') {
                            plateau.getPlateau()[this.getPosX()][j] = ' ';
                        } else if (plateau.getPlateau()[this.getPosX()][j] == '8') {
                            break;
                        } else if (plateau.getPlateau()[this.getPosX()][i] == '#') {
                            this.setPosX(initPosi);
                            this.setPosY(initPosj);
                        }

                    }
                }
            }
         else if (this.getDirection() == 'W') {
                if (plateau.getPlateau()[this.getPosX()][j] == '#') {
                    plateau.getPlateau()[this.getPosX()][j] = ' ';
                } else if (plateau.getPlateau()[this.getPosX()][j] == '8') {
                    break;
                }
            }

         else if (this.getDirection() == 'N') {

                if (plateau.getPlateau()[i][this.getPosY()] == '#') {
                    plateau.getPlateau()[i][this.getPosY()] = ' ';
                } else if (plateau.getPlateau()[this.getPosX()][j] == '8') {
                    break;
                }

        } else if (this.getDirection() == 'S') {
                if (plateau.getPlateau()[j][this.getPosY()] == '#') {
                    plateau.getPlateau()[j][this.getPosY()] = ' ';
                } else if (plateau.getPlateau()[this.getPosX()][j] == '8') {
                    break;
                } else if (plateau.getPlateau()[j][this.getPosY()] == plateau.getJoyaux().get(0).getApparence()) {
                    for (int i = j; i > 0; i--) {
                        System.out.println("oui");
                        if (plateau.getPlateau()[i][this.getPosY()] == '#') {
                            plateau.getPlateau()[i][this.getPosY()] = ' ';
                        } else if (plateau.getPlateau()[i][this.getPosY()] == '8') {
                            break;
                        } else if (plateau.getPlateau()[i][this.getPosY()] == this.getApparence()) {
                            System.out.println("oui2");
                            plateau.getPlateau()[this.i][this.j] = ' ';//on met sa position post-deplacement a 0
                            this.setPosX(initPosi);
                            this.setPosY(initPosj);
                            System.out.println(initPosi);
                            System.out.println(initPosj);
                            plateau.getPlateau()[this.i][this.j] = this.getApparence();


                        }

                    }
                }

        }


    }}

    public void placerMur(char[][] plateau) {
        int i;
        int j;
        do {
            System.out.println("Veuiller rentrer le numero de la ligne ou placer le mur ");
            i = scanner.nextInt();
            System.out.println("Veuiller rentrer le numero de la colonne ou placer le mur ");
            j = scanner.nextInt();

        } while (i < 0 || i > 8 || j < 0 || j > 8);
        this.getDeck().getDeckM().remove(this.getDeck().getMur());
        plateau[i][j] = '8';


        //this.deck.getDeckM().remove()

    }

    public void placerMurGlace(char[][] plateau) {
        int i;
        int j;
        do {
            System.out.println("Veuiller rentrer le numero de la ligne ou placer le mur ");
            i = scanner.nextInt();
            System.out.println("Veuiller rentrer le numero de la colonne ou placer le mur ");
            j = scanner.nextInt();

        } while (i < 0 || i > 8 || j < 0 || j > 8);
        this.getDeck().getDeckM().remove(this.getDeck().getMurGlace());
        plateau[i][j] = '#';


    }

    public void retourDepart() {

    }

    public void collision() {

    }

    public void completerProg() {
        String action;
        int pile = 0;
        do {
            System.out.println("Veuillez entrez le nombre de carte que vous desirez placer en instruction");
            nbrCartePile = scanner.nextInt();
            System.out.println(nbrCartePile);
        } while (nbrCartePile < 0 || nbrCartePile > 5);

        while (pile != nbrCartePile) {
            do {
                System.out.println("Veuillez mettre les types de cartes dans la pile d'instruction");
                action = scanner.nextLine();
                if (action.equals("Bleu")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteBleu())) {
                        int b = this.main.getMa_main().indexOf(getDeck().getCarteBleu());
                        this.instruction.addLast(this.main.getMa_main().get(b));
                        this.main.getMa_main().remove(b);
                        this.main.voirMain();
                        pile++;
                    } else {
                        System.out.println("Vous n'avez pas de carte bleu !");
                    }
                } else if (action.equals("Laser")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteLaser())) {
                        int l = this.main.getMa_main().indexOf(getDeck().getCarteLaser());
                        this.instruction.addLast(this.main.getMa_main().get(l));
                        this.main.getMa_main().remove(l);
                        this.main.voirMain();
                        pile++;
                    } else {
                        System.out.println("Vous n'avez pas de carte Laser !");
                    }

                } else if (action.equals("Jaune")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteJaune())) {
                        int j = this.main.getMa_main().indexOf(getDeck().getCarteJaune());
                        this.instruction.addLast(this.main.getMa_main().get(j));
                        this.main.getMa_main().remove(j);
                        this.main.voirMain();
                        pile++;
                    } else {
                        System.out.println("Vous n'avez pas de carte Jaune !");
                    }
                } else if (action.equals("Violet")) {
                    if (this.main.getMa_main().contains(getDeck().getCarteViolet())) {
                        int v = this.main.getMa_main().indexOf(getDeck().getCarteViolet());
                        this.instruction.addLast(this.main.getMa_main().get(v));
                        this.main.getMa_main().remove(v);
                        this.main.voirMain();
                        pile++;
                    } else {
                        System.out.println("Vous n'avez pas de carte Violette !");
                    }
                } else {
                    System.out.println("ENTREZ UNE ACTION VALIDE");
                }
            } while (!action.equals("Bleu") && !action.equals("Jaune") && !action.equals("Violet") && !action.equals("Laser"));


        }
    }

    public void executerProg(Board plateau) {

        for (int i = 0; i < nbrCartePile; i++) {//erreur avec instruction.size() comme modifier dans avancer et rotationD/G boucle non respecter
            if (this.instruction.getFirst().equals(getDeck().getCarteBleu())) {
                avancer(plateau.getPlateau());
            } else if (this.instruction.getFirst().equals(getDeck().getCarteJaune())) {
                rotationG();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteViolet())) {
                rotationD();
            } else if (this.instruction.getFirst().equals(getDeck().getCarteLaser())) {
                utiliserLaser(plateau);
                this.deck.getDeck_defausse().add(this.instruction.getFirst());
                this.instruction.pollFirst(); // a reporter pour rotation et avancer
            }

        }
        System.out.println(this.direction);


    }

    public char getApparence() {
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

    public void voirInstruction() {
        System.out.println(this.instruction.isEmpty());

    }

    public void joyAtteint(Joyaux j) {
        if (this.getPosX() == j.getPosX() && this.getPosY() == j.getPosY()) {
            this.score++;

        }
    }

    public void defausser() {
        int defausse;
        scanner = new Scanner(System.in);
        do {
            System.out.println("Voulez vous defausser vos cartes ? entrer le nombre entre 0 et 5 ");
            defausse = scanner.nextInt();
        } while (defausse < 0 || defausse > 5 && defausse != 9);

        for (int i = 0; i != defausse; i++) {
            int posC;
            scanner = new Scanner(System.in);
            do {
                System.out.println("Choisissez la position de la  carte a defausser ");
                posC = scanner.nextInt();
            } while (posC < 0 || posC > this.getMain().getMa_main().size() - 1);
            System.out.println(defausse);
            this.getMain().defausserM(posC);
            this.getMain().voirMain();
        }
        if (this.getMain().getMa_main().size() != 5) {
            System.out.println(this.getMain().getMa_main().size());
            for (int i = this.getMain().getMa_main().size(); i < 5; i++) {
                System.out.println("oui");
                this.getMain().getMa_main().add(this.getDeck().getDeque_deck().getFirst());
                this.getDeck().getDeque_deck().pollFirst();
            }
        }
        this.getMain().voirMain();
        System.out.println("Nombre carte deck :" + this.getDeck().getNbrCarte());
    }

}
