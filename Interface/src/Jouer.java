import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Jouer extends JFrame {
    private static int nbrJoueur;


    Jouer() {
        // On définit un titre à ma fenêtre
        this.setTitle("Robots Turtles");
        // On définit sa taille en épaisseur et hauteur
        this.setSize(600, 380);
        // On définit sa position de départ au milieu de l'écran
        this.setLocationRelativeTo(null);
        // On désactive le layout pre-défini
        this.getContentPane().setLayout(null);
        // On créer un nouveau panneau
        JPanel panel3 = new JPanel();

        // On accede à la ressource du dossier src (le fond d'écran)
        Icon fond = new ImageIcon(this.getClass().getResource("Images/fondjoueur.png"));
        JLabel image_plateau = new JLabel();
        image_plateau.setIcon(fond);
        image_plateau.setBounds(0,0,600,380);
        panel3.setBounds(0,0,600,380);
        panel3.add(image_plateau);

        //On ajoute maintenant 3 boutons pour 3 modes de jeux : 2, 3 ou 4 joueurs
        JPanel panel2_bouton1 = new JPanel();
        JPanel panel2_bouton2 = new JPanel();
        JPanel panel2_bouton3 = new JPanel();
        // On définit la taille et la postion de chaques boutons
        JButton bouton_2joueurs = new JButton("");
        bouton_2joueurs.setBounds(0, 0, 115, 50);
        JButton bouton_3joueurs = new JButton();
        bouton_3joueurs.setBounds(0,0, 115, 50);
        JButton bouton_4joueurs = new JButton();
        bouton_4joueurs.setBounds(0,0, 115, 50);

        panel2_bouton1.setLayout(null);
        panel2_bouton1.setBounds(25,60,115,50);
        panel2_bouton1.add(bouton_2joueurs);
        bouton_2joueurs.setOpaque(false);
        bouton_2joueurs.setContentAreaFilled(false);
        panel2_bouton1.setOpaque(false);

        panel2_bouton2.setLayout(null);
        panel2_bouton2.setBounds(25,150,115,50);
        panel2_bouton2.add(bouton_3joueurs);
        bouton_3joueurs.setOpaque(false);
        bouton_3joueurs.setContentAreaFilled(false);
        panel2_bouton2.setOpaque(false);

        panel2_bouton3.setLayout(null);
        panel2_bouton3.setBounds(25,243,115,50);
        panel2_bouton3.add(bouton_4joueurs);
        bouton_4joueurs.setOpaque(false);
        bouton_4joueurs.setContentAreaFilled(false);
        panel2_bouton3.setOpaque(false);

        // On définit les actions pour chaques boutons
        bouton_2joueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session fenJeu = new Session();
                nbrJoueur=2;
                fenJeu.jeu();
                fenJeu.setVisible(true);

            }
        });
        bouton_3joueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session fenJeu = new Session();
                nbrJoueur=3;
                fenJeu.jeu();
                fenJeu.setVisible(true);

            }
        });
        bouton_4joueurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session fenJeu = new Session();
                nbrJoueur=4;
                fenJeu.jeu();
                fenJeu.setVisible(true);

            }
        });

        this.add(panel2_bouton1);
        this.add(panel2_bouton2);
        this.add(panel2_bouton3);
        this.add(panel3);

        this.setVisible(true);
    }

    public static int getNbrJoueur() {
        return nbrJoueur;
    }
}

