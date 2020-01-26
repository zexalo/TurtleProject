import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Session extends JFrame implements ActionListener {

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
    private JPanel panFond;
    private JPanel pan_instruction;
    private static int tour=0;
    private static int joueur=0;


    public Session() {
        this.plateau=new Board(Jouer.getNbrJoueur());
        //plateau.setNbrJoueur(Jouer.getNbrJoueur());
        this.compteur_instruction=0;
        this.setTitle("Test Turtle");
        int width = 1400;
        int height = 820;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);


        panFond=new JPanel();
        panFond.setBounds(0,0,1400,820);
        Icon fond = new ImageIcon(this.getClass().getResource("Images/fondjeu.jpg"));
        JLabel fondl =new JLabel();
        fondl.setIcon(fond);
        panFond.add(fondl);

        //Panel Boutton 3 Actions
        pan2 = new JPanel();
        tourN = new JLabel("Tour N° " + tour);
        tourN.setForeground(Color.white);
        buttonCompleter = new JButton("Completer Programme");
        buttonExecuter = new JButton("Executer Programme");
        buttonPlacer = new JButton("Placer Tuile");
        valider= new JButton("Valider !");

        pan2.setLayout(new GridLayout(3, 1));
        pan2.setOpaque(false);
        pan2.add(buttonCompleter);
        pan2.add(buttonExecuter);
        pan2.add(buttonPlacer);
        pan2.add(valider);
        valider.setVisible(false);
        pan2.setBounds(900, 0, 400, 100);
        pan2.add(tourN);


        buttonCompleter.addActionListener(this);
        buttonExecuter.addActionListener(this);
        buttonPlacer.addActionListener(this);
        valider.addActionListener(this);


        //Panel Joueur
        panMain = new JPanel();
        panMain.setOpaque(false);
        panMain.setLayout(new GridLayout(1, 5, 2, 2));

        for (int i=0;i<5;i++){
            panMain.add(new Cartes(this));

        }
        panMain.setBounds(800, 580, 570, 175);
        panMain.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));

        //Panel Info
        panInfo = new JPanel();
        info = new JLabel();
        info.setText("Joueur n° " + joueur);
        info.setForeground(Color.white);
        info.setSize(200,200);
        panInfo.setBounds(0, 550, 500, 230);
        panInfo.setOpaque(false);
        panInfo.add(info);

        //Panel instruction
        pan_instruction=new JPanel();
        pan_instruction.setLayout(new GridLayout(1,5,2,2));
        pan_instruction.setOpaque(false);
        pan_instruction.setBounds(800,300,570,175);
        pan_instruction.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));


        Icon fondDosCarte = new ImageIcon(this.getClass().getResource("Images/Cartes/doscartes.jpg"));
        for(int i=0;i<5;i++){
            Cartes carte_instruction = new Cartes();
            carte_instruction.setVisible(false);
            carte_instruction.setIcon(fondDosCarte);
            pan_instruction.add(carte_instruction);

        }





        this.add(pan_instruction);
        this.add(panMain);
        this.add(panInfo);
        this.add(pan2);
        plateau.initPlacement(this);
        this.add(panFond);


        this.setVisible(true);

    }

    public JPanel getPanMain() {
        return panMain;
    }


    public JPanel getPan_instruction() {
        return pan_instruction;
    }

    public void creationPlateau() {




    }

    public int getCompteur_instruction() {
        return compteur_instruction;
    }

    public void increCompteur_instruction(int compteur_instruction) {
        this.compteur_instruction = compteur_instruction+1;
    }

    public void jeu() {
        plateau.setNbrJoueur(Jouer.getNbrJoueur());
        switch (plateau.getNbrJoueur()) {
            //Switch case qui construit le plateau selon le nombre de joueur demander
            case 2:
                plateau.getTortue().get(0).getDeck().melange();
                plateau.getTortue().get(0).getHand().piocheDepart();
                plateau.getTortue().get(1).getDeck().melange();
                plateau.getTortue().get(1).getHand().piocheDepart();

                break;
            case 3:
                plateau.getTortue().get(0).getDeck().melange();
                plateau.getTortue().get(0).getHand().piocheDepart();
                plateau.getTortue().get(1).getDeck().melange();
                plateau.getTortue().get(1).getHand().piocheDepart();
                plateau.getTortue().get(2).getDeck().melange();
                plateau.getTortue().get(2).getHand().piocheDepart();

                break;
            case 4:
                plateau.getTortue().get(0).getDeck().melange();
                plateau.getTortue().get(0).getHand().piocheDepart();
                plateau.getTortue().get(1).getDeck().melange();
                plateau.getTortue().get(1).getHand().piocheDepart();
                plateau.getTortue().get(2).getDeck().melange();
                plateau.getTortue().get(2).getHand().piocheDepart();
                plateau.getTortue().get(3).getDeck().melange();
                plateau.getTortue().get(3).getHand().piocheDepart();

                break;

        }
        plateau.getTortue().get(0).getHand().voirMain(this);
    }




    public void actionPerformed(ActionEvent actionEvent) {
        Tortue tortue = plateau.getTortue().get(joueur);

            if (actionEvent.getSource() == buttonCompleter) {
                info.setText("Selectionner les cartes a mettre en instruction puis valider");
                plateau.setMode(Mode.COMPLETER);
                modeCompleter();

//

            } else if (actionEvent.getSource() == buttonExecuter && !plateau.getTortue().get(joueur).getInstruction().isEmpty()) {

                plateau.getTortue().get(joueur).executerProg(plateau);
                this.changementTour();
                plateau.getTortue().get(joueur).getHand().voirMain(this);
                System.out.println(joueur);


            } else if (actionEvent.getSource() == buttonPlacer && plateau.getTortue().get(0).getDeck().getDeckM().size()!=0) {
                info.setText("<html>Selectionnez la case ou placer le mur,click gauche = mur de pierre et click droit = mur de glace<br>" +
                        "Vous avez "+plateau.getTortue().get(joueur).getDeck().getNbrPierre()+" Mur de pierre "
                        +plateau.getTortue().get(joueur).getDeck().getNbrGlace()+" mur Glace</html>\n");
                plateau.setMode(Mode.PLACEMENT);
                modePlacement();




                tourN.setText("Tour N° " + tour);
            } else if (actionEvent.getSource() == buttonPlacer && plateau.getMode() == Mode.JEU&& plateau.getTortue().get(0).getDeck().getDeckM().size()==0) {
                info.setText(" Vous n'avez plus de mur");
            }else if (actionEvent.getSource() == valider && plateau.getMode().equals(Mode.COMPLETER)){

                plateau.setMode(Mode.DEFAUSSE);
                modeDefausse();
                info.setText("Selectionner les cartes a defausser");
            }else if (actionEvent.getSource() == valider && plateau.getMode().equals(Mode.DEFAUSSE)){
                this.setCompteur_instruction(0);
                for (int i=0;i<5;i++){
                    pan_instruction.getComponent(i).setVisible(false);
                }
                info.setText("Joueur n " + joueur);
                plateau.getTortue().get(joueur).getHand().piocheCarte();
                plateau.setMode(Mode.JEU);
                plateau.getTortue().get(joueur).getHand().voirMain(this);
                for(int i=0;i<5;i++){
                    panMain.getComponent(i).setVisible(true);
                }
                modeJeu();
                this.changementTour();
                plateau.getTortue().get(joueur).getHand().voirMain(this);
                System.out.println(tour);
                System.out.println(joueur);

            }else if (actionEvent.getSource() == valider && plateau.getMode().equals(Mode.JEU)){
                modeJeu();
                info.setText("Joueur n " + joueur);
                this.changementTour();
               plateau.getTortue().get(joueur).getHand().voirMain(this);
                System.out.println(tour);
                System.out.println(joueur);

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

    public int getJoueur() {
        return joueur;
    }

    public void changementTour(){

        tour++;
        joueur++;
        if (joueur == plateau.getNbrJoueur()) {
            joueur = 0;
        }
        plateau.getTortue().get(joueur).getHand().voirMain(this);
        tourN.setText("Tour N° " + tour);
        info.setText("Joueur n " + joueur);
    }

    public void setCompteur_instruction(int compteur_instruction) {
        this.compteur_instruction = compteur_instruction;
    }
}