import javafx.scene.shape.DrawMode;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.transform.Source;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Fenetre extends JFrame implements ActionListener {

    private int numt;
    private JButton buttonCompleter;
    private JButton buttonExecuter;
    private JButton buttonPlacer;
    private JButton valider;
    private int compteur_instruction;

    private JLabel tourN;
    private JLabel info;
    private Board plateau;
    private JPanel panMain;
    private JPanel panInfo;
    private JPanel pan2;
    private JPanel pan_instruction;
    private int tour;


    public Fenetre() {
        this.compteur_instruction=0;
        this.numt = 0;
        this.tour = 0;
        this.setTitle("Test Turtle");
        int width = 1920;
        int height = 820;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);



        //Panel Boutton 3 Actions
        pan2 = new JPanel();
        buttonCompleter = new JButton("Completer Programme");
        buttonExecuter = new JButton("Executer Programme");
        buttonPlacer = new JButton("Placer Tuile");
        valider= new JButton("Valider !");
        tourN = new JLabel("Tour N° " + tour);
        pan2.setLayout(new GridLayout(3, 1));
        pan2.add(buttonCompleter);
        pan2.add(buttonExecuter);
        pan2.add(buttonPlacer);
        pan2.add(valider);
        valider.setVisible(false);
        pan2.setBounds(1000, 0, 400, 100);
        pan2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
        pan2.add(tourN);


        buttonCompleter.addActionListener(this);
        buttonExecuter.addActionListener(this);
        buttonPlacer.addActionListener(this);
        valider.addActionListener(this);


        //Panel Joueur
        panMain = new JPanel();
        panMain.setLayout(new GridLayout(1, 5, 5, 5));

        for (int i=0;i<5;i++){
            panMain.add(new Cartes(this));

        }
        panMain.setBounds(1000, 580, 500, 200);
        panMain.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));

        //Panel Info
        panInfo = new JPanel();
        info = new JLabel();
        panInfo.setBounds(0, 550, 550, 230);
        panInfo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
        panInfo.add(info);

        //Panel instruction
        pan_instruction=new JPanel();
        pan_instruction.setLayout(new GridLayout());
        pan_instruction.setBounds(1000,300,500,250);
        pan_instruction.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));

        for(int i=0;i<5;i++){
            Cartes carte_instruction = new Cartes();
            carte_instruction.setVisible(false);
            pan_instruction.add(carte_instruction);

        }




        this.add(pan_instruction);
        this.add(panMain);
        this.add(panInfo);
        this.add(pan2);

    }

    public JPanel getPanMain() {
        return panMain;
    }


    public JPanel getPan_instruction() {
        return pan_instruction;
    }

    public void creationPlateau() {
        plateau = new Board(2);
        plateau.initPlacement(this);


    }

    public int getCompteur_instruction() {
        return compteur_instruction;
    }

    public void increCompteur_instruction(int compteur_instruction) {
        this.compteur_instruction = compteur_instruction+1;
    }

    public void jeu() {
        plateau.getTortue().get(0).getDeck().melange();
        plateau.getTortue().get(0).getMain().piocheDepart();
        plateau.getTortue().get(1).getDeck().melange();
        plateau.getTortue().get(1).getMain().piocheDepart();
        plateau.getTortue().get(0).getMain().voirMain(this);

    }



    public void actionPerformed(ActionEvent actionEvent) {
        Tortue tortue = plateau.getTortue().get(numt);

            if (actionEvent.getSource() == buttonCompleter) {
                info.setText("Selectionner les cartes a mettre en instruction puis valider");
                plateau.setMode(Mode.COMPLETER);
                modeCompleter();

//

            } else if (actionEvent.getSource() == buttonExecuter) {

                System.out.println(plateau.getTortue().get(0).getInstruction());
                plateau.getTortue().get(0).executerProg(plateau.getPlateau());
                this.setCompteur_instruction(0);
                for (int i=0;i<5;i++){
                    pan_instruction.getComponent(i).setVisible(false);
                }
                System.out.println(plateau.getTortue().get(0).getInstruction());

            } else if (actionEvent.getSource() == buttonPlacer && plateau.getTortue().get(0).getDeck().getDeckM().size()!=0) {
                info.setText("<html>Selectionnez la case ou placer le mur,click gauche = mur de pierre et click droit = mur de glace<br>" +
                        "Vous avez "+plateau.getTortue().get(0).getDeck().getNbrPierre()+" Mur de pierre "
                        +plateau.getTortue().get(0).getDeck().getNbrGlace()+" mur Glace</html>\n");
                plateau.setMode(Mode.PLACEMENT);
                modePlacement();

                tour++;
                numt++;
                if (numt == plateau.getNbrJoueur()) {
                    numt = 0;
                }

                tourN.setText("Tour N° " + tour);
            } else if (actionEvent.getSource() == buttonPlacer && plateau.getMode() == Mode.JEU&& plateau.getTortue().get(0).getDeck().getDeckM().size()==0) {
                info.setText(" Vous n'avez plus de mur");
            }else if (actionEvent.getSource() == valider && plateau.getMode().equals(Mode.COMPLETER)){
                System.out.println(plateau.getMode());
                plateau.setMode(Mode.DEFAUSSE);
                modeDefausse();
                info.setText("Selectionner les cartes a defausser");
            }else if (actionEvent.getSource() == valider && plateau.getMode().equals(Mode.DEFAUSSE)){
                info.setText("");
                plateau.getTortue().get(0).getMain().piocheCarte();
                plateau.setMode(Mode.JEU);
                plateau.getTortue().get(0).getMain().voirMain(this);
                for(int i=0;i<5;i++){
                    panMain.getComponent(i).setVisible(true);
                }
                modeJeu();

            }else if (actionEvent.getSource() == valider && plateau.getMode().equals(Mode.JEU)){
                modeJeu();
                info.setText("");

            }



    }

    public void modePlacement(){
        if (plateau.getMode() == Mode.PLACEMENT) {
            buttonCompleter.setVisible(false);
            buttonExecuter.setVisible(false);
            buttonPlacer.setVisible(false);
            valider.setVisible(true);
        }

    }
    public void modeJeu(){
        if (plateau.getMode() == Mode.JEU) {
            buttonCompleter.setVisible(true);
            buttonExecuter.setVisible(true);
            buttonPlacer.setVisible(true);
            valider.setVisible(false);
        }

    }

    public void modeCompleter(){
        if (plateau.getMode() == Mode.COMPLETER) {
            buttonCompleter.setVisible(false);
            buttonExecuter.setVisible(false);
            buttonPlacer.setVisible(false);
            valider.setVisible(true);
        }
    }
    public void modeDefausse(){
        if (plateau.getMode() == Mode.DEFAUSSE) {
            buttonCompleter.setVisible(false);
            buttonExecuter.setVisible(false);
            buttonPlacer.setVisible(false);
            valider.setVisible(true);
        }
    }


    public Board getPlateau() {
        return plateau;
    }

    public void setCompteur_instruction(int compteur_instruction) {
        this.compteur_instruction = compteur_instruction;
    }
}