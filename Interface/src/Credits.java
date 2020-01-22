import javax.swing.*;

class Credits extends JFrame {

    Credits() {
        // On définit un titre à ma fenêtre
        this.setTitle("Robot Turtles");
        // On définit sa taille en épaisseur et hauteur
        this.setSize(600, 380);
        // On définit sa position de départ au milieu de l'écran
        this.setLocationRelativeTo(null);
        // On désactive le layout pre-défini
        this.getContentPane().setLayout(null);
        // On créer un nouveau panneau
        JPanel panel2 = new JPanel();

        // On accede à la ressource du dossier src (le fond d'écran)
        Icon fond = new ImageIcon(this.getClass().getResource("Images/creditspng.png"));
        JLabel image_plateau = new JLabel();
        image_plateau.setIcon(fond);
        image_plateau.setBounds(0,0,600,380);
        panel2.setBounds(0,0,600,380);
        panel2.add(image_plateau);

        this.add(panel2);
        this.setVisible(true);


    }
}
