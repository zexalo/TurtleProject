import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Fenetre extends JFrame {

    Fenetre() {
        // On définit un titre à ma fenêtre
        this.setTitle("Robot Turtles");
        // On définit sa taille en épaisseur et hauteur
        this.setSize(600, 380);
        // On programme la fenêtre pour sa fermeture lorsque on la quitte
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // On définit sa position de départ au milieu de l'écran
        this.setLocationRelativeTo(null);
        // On désactive le layout pre-défini
        this.getContentPane().setLayout(null);
        // On créer un nouveau panneau
        JPanel panel1 = new JPanel();

        // On accede à la ressource du dossier src
        Icon fond = new ImageIcon(this.getClass().getResource("Images/background.png"));
        JLabel image_plateau = new JLabel();
        image_plateau.setIcon(fond);
        image_plateau.setBounds(0,0,600,380);
        panel1.setBounds(0,0,600,1380);
        panel1.add(image_plateau);

        JPanel panel_bouton1 = new JPanel();
        JPanel panel_bouton2 = new JPanel();
        JPanel panel_bouton3 = new JPanel();
        // On définit la taille et la postion de chaques boutons
        JButton bouton_jouer = new JButton("");
        bouton_jouer.setBounds(0, 0, 115, 50);
        JButton bouton_quitter = new JButton();
        bouton_quitter.setBounds(0,0, 115, 50);
        JButton bouton_credits = new JButton();
        bouton_credits.setBounds(0,0, 115, 50);

        panel_bouton1.setLayout(null);
        panel_bouton1.setBounds(25,60,115,50);
        panel_bouton1.add(bouton_jouer);
        bouton_jouer.setOpaque(false);
        bouton_jouer.setContentAreaFilled(false);
        panel_bouton1.setOpaque(false);

        panel_bouton2.setLayout(null);
        panel_bouton2.setBounds(25,150,115,50);
        panel_bouton2.add(bouton_quitter);
        bouton_quitter.setOpaque(false);
        bouton_quitter.setContentAreaFilled(false);
        panel_bouton2.setOpaque(false);

        panel_bouton3.setLayout(null);
        panel_bouton3.setBounds(25,243,115,50);
        panel_bouton3.add(bouton_credits);
        bouton_credits.setOpaque(false);
        bouton_credits.setContentAreaFilled(false);
        panel_bouton3.setOpaque(false);



        // On définit les actions pour chaque boutons
        bouton_jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jouer fenJoueur = new Jouer();


            }
        });
        bouton_quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bouton_credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Credits credits = new Credits();
            }
        });

        this.add(panel_bouton1);
        this.add(panel_bouton2);
        this.add(panel_bouton3);
        this.add(panel1);


        this.setVisible(true);
    }
}