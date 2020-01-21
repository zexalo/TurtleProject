import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private int i;

    public Menu(){
        this.setTitle("Turtle Game");
        this.setSize(1280, 760);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        //Panel du plateau image
        JPanel pan1 =new JPanel();
        Icon plateau = new ImageIcon(this.getClass().getResource("image/backMenu.jpg"));
        Icon t1 = new ImageIcon(this.getClass().getResource("image/playButton.PNG"));
        JLabel imageP = new JLabel();
        JLabel imageT1 = new JLabel();

        pan1.setLayout(null);
        pan1.setBackground(Color.BLACK);
        pan1.setBounds(0,0,1280,720);
        JButton button=new JButton("Start");
        button.setBounds(640,360,220,220);
        button.setEnabled(false);
        button.setBackground(new Color(0, 0, 0, 0));
        imageP.setIcon(plateau);
        imageT1.setIcon(t1);
        imageP.setBounds(0,0,1300,720);
        imageT1.setBounds(10,10,60,60);
        pan1.add(imageP);
        pan1.add(button);




        this.add(pan1);
        this.setVisible(true); //On peut enfin afficher le tout
    }
}
