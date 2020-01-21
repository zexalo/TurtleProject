import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board{
    private int nbrJoueur;
    private int nbrMur;
    private int nbrJoyaux;
    private int nbrMurGlace;
    private int taille;
    private JButton[][] plateau;
    private Tortue t1;
    private Tortue t2;
    private Tortue t3;
    private Tortue t4;
    private Joyaux j1;
    private Joyaux j2;
    private Joyaux j3;
    private JPanel pan1;
    private Mode mode;
    //Icones mur
    private  Icon m1;
    private Icon m2;
    private JLabel pierre;
    private JLabel glace ;



    public Fenetre getFe() {
        return fe;
    }

    public Fenetre fe;

    public Board(int nbrJoueur) {
        this.mode = Mode.JEU;
        this.nbrJoueur = nbrJoueur;
        //On creer les icon des Tortue
        Icon i1 = new ImageIcon(this.getClass().getResource("Images/Turtle/turtle_1.png"));
        Icon i2 = new ImageIcon(this.getClass().getResource("Images/Turtle/turtle_2.png"));
        Icon i3 = new ImageIcon(this.getClass().getResource("Images/Turtle/turtle_3.png"));
        Icon i4 = new ImageIcon(this.getClass().getResource("Images/Turtle/turtle_4.png"));
        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        JLabel l3=new JLabel();
        JLabel l4=new JLabel();
        l1.setIcon(i1);
        l2.setIcon(i2);
        l3.setIcon(i3);
        l4.setIcon(i4);

        //Icone du joyau
        Icon j1=new ImageIcon(this.getClass().getResource("Images/Murs/ruby2.png"));
        JLabel ruby = new JLabel();
        ruby.setIcon(j1);

        //Icones mur



        switch (nbrJoueur) {
            //Switch case qui construit le plateau selon le nombre de joueur demander
            case 2:
                this.t1 = new Tortue(i1, 0, 1, 0, 'S');
                this.t2 = new Tortue(i2, 0, 5, 0, 'S');
                this.j1 = new Joyaux(ruby, 7, 3);

                break;
            case 3:
                this.t1 = new Tortue(i1, 0, 0, 0, 'S');
                this.t2 = new Tortue(i2, 0, 3, 0, 'S');
                this.t3 = new Tortue(i3, 0, 6, 0, 'S');
                this.j1 = new Joyaux(ruby, 7, 0);
                this.j2 = new Joyaux(ruby, 7, 3);
                this.j3 = new Joyaux(ruby, 7, 6);
                break;
            case 4:
                this.t1 = new Tortue(i1, 0, 0, 0, 'S');
                this.t2 = new Tortue(i2, 0, 2, 0, 'S');
                this.t3 = new Tortue(i3, 0, 5, 0, 'S');
                this.t4 = new Tortue(i4, 0, 7, 0, 'S');
                this.j1 = new Joyaux(ruby, 7, 1);
                this.j2 = new Joyaux(ruby, 7, 6);
                break;

        }



        /*
        this.nbrJoueur=nbrJoueur;
        this.nbrMur=nbrMur;
        this.taille=taille;
        this.nbrJoyaux=nbrJoyaux;
        this.nbrMurGlace=nbrMurGlace;*/


    }

    public void initPlacement(Fenetre fen) {
        pan1 = new JPanel();//Creation du panel pour la grille de case
        m1=new ImageIcon(this.getClass().getResource("Images/Murs/Wall brick.png"));
        m2=new ImageIcon(this.getClass().getResource("Images/Murs/ice wall.png"));
        pierre = new JLabel();
        glace = new JLabel();
        pierre.setIcon(m1);
        glace.setIcon(m2);
        JPanel panPlat = new JPanel();//Creation du panel qui contiendra l'image de fond du plateau
        Icon imgplateau = new ImageIcon(this.getClass().getResource("image/plateauGrille.png"));//Importation de l'image du plateau
        JLabel imageP = new JLabel();// creation du label de l'image du plateau
        plateau = new JButton[8][8];
        switch (this.nbrJoueur) {

            case 2:
                pan1.setLayout(new GridLayout(8, 8, 3, 3));
                pan1.setBounds(9, 5, 503, 503);
                pan1.setOpaque(false);
                panPlat.setLayout(null);
                panPlat.setBounds(5, 0, 510, 510);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        plateau[i][j] = new AfficheCase(i,j,"", this);
                        plateau[i][j].setName("Vide");
                        plateau[i][j].setOpaque(true);
                        plateau[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
                        pan1.add(plateau[i][j]);

                    }
                    plateau[i][7].setBackground(Color.BLACK);
                    plateau[i][7].setName("Mur");
                }
                initTortueSurPlat(this.t1);
                initTortueSurPlat(this.t2);
                initJoyauxSurPlat(this.j1);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        System.out.println(plateau[i][j].getName());
                    }}
                imageP.setIcon(imgplateau);
                imageP.setBounds(5, 0, 510, 510);
                panPlat.add(imageP);
                panPlat.add(pan1);
                fen.add(pan1);
                fen.add(panPlat);
                break;

            case 3:
                pan1.setLayout(new GridLayout(8, 8, 3, 3));
                pan1.setBounds(9, 5, 503, 503);
                pan1.setOpaque(false);
                panPlat.setLayout(null);
                panPlat.setBounds(5, 0, 510, 510);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
//                        plateau[i][j] = new JButton("");
//                        plateau[i][7] = new JButton("Mur");
                        plateau[i][j].setOpaque(false);
//                        plateau[i][j].setContentAreaFilled(false);
                        plateau[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
                        pan1.add(plateau[i][j]);

                    }
                }

                initTortueSurPlat(this.t1);
                initTortueSurPlat(this.t2);
                initTortueSurPlat(this.t3);
                initJoyauxSurPlat(this.j1);
                initJoyauxSurPlat(this.j2);
                initJoyauxSurPlat(this.j3);

                imageP.setIcon(imgplateau);
                imageP.setBounds(5, 0, 510, 510);
                panPlat.add(imageP);
                panPlat.add(pan1);
                fen.add(pan1);
                fen.add(panPlat);
                fen.setVisible(true);
                break;


            case 4:
                pan1.setLayout(new GridLayout(8, 8, 3, 3));
                pan1.setBounds(9, 5, 503, 503);
                pan1.setOpaque(false);
                panPlat.setLayout(null);
                panPlat.setBounds(5, 0, 510, 510);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        //plateau[i][j] = new JButton("");
                        plateau[i][j].setOpaque(false);
                        //plateau[i][j].setContentAreaFilled(false);
                        plateau[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
                        pan1.add(plateau[i][j]);

                    }
                }

                initTortueSurPlat(this.t1);
                initTortueSurPlat(this.t2);
                initTortueSurPlat(this.t3);
                initTortueSurPlat(this.t4);
                initJoyauxSurPlat(this.j1);
                initJoyauxSurPlat(this.j2);

                imageP.setIcon(imgplateau);
                imageP.setBounds(5, 0, 510, 510);
                panPlat.add(imageP);
                panPlat.add(pan1);
                fen.add(pan1);
                fen.add(panPlat);
                fen.setVisible(true);
                break;

        }


    }

    public void initTortueSurPlat(Tortue t) {
              plateau[t.getPosX()][t.getPosY()].setIcon(t.getApparence());
              plateau[t.getPosX()][t.getPosY()].setName("Tortue");
    }

    public void initJoyauxSurPlat(Joyaux j) {
        plateau[j.getPosXJ()][j.getPosYJ()].add(j.getApparenceJ());
        plateau[j.getPosXJ()][j.getPosYJ()].setName("Joyaux");
    }

    public JButton[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(JButton[][] plateau) {
        this.plateau = plateau;
    }

    public void initCarte() {

    }

    public void affichage() {

    }

    public void updatePlateau(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                pan1.add(plateau[i][j]);


            }
        }

    }


    public int getNbrJoueur() {
        return nbrJoueur;
    }

    public void setNbrJoueur(int nbrJoueur) {
        this.nbrJoueur = nbrJoueur;
    }

    public int getNbrJoyaux() {
        return nbrJoyaux;
    }

    public void setNbrJoyaux(int nbrJoyaux) {
        this.nbrJoyaux = nbrJoyaux;
    }

    public int getNbrMur() {
        return nbrMur;
    }

    public void setNbrMur(int nbrMur) {
        this.nbrMur = nbrMur;
    }

    public int getNbrMurGlace() {
        return nbrMurGlace;
    }

    public void setNbrMurGlace(int nbrMurGlace) {
        this.nbrMurGlace = nbrMurGlace;
    }

    public int getTaille() {
        return taille;
    }

    public JLabel getPierre() {
        return pierre;
    }

    public JLabel getGlace() {
        return glace;
    }

    public ArrayList<Tortue> getTortue() {
        ArrayList<Tortue> listortue = new ArrayList<>();
        switch (nbrJoueur) {
            case 1:
                listortue.add(t1);
            case 2:
                listortue.add(t1);
                listortue.add(t2);
            case 3:
                listortue.add(t1);
                listortue.add(t2);
                listortue.add(t3);
            case 4:
                listortue.add(t1);
                listortue.add(t2);
                listortue.add(t3);
                listortue.add(t4);

        }
        return listortue;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }


}

