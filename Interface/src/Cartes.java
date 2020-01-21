import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cartes extends JButton {
    private String couleur;
    private String obstacles;
    private Icon skin;

    public Cartes(Fenetre fen)
    {

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                if ( fen.getPlateau().getMode().equals(Mode.COMPLETER)){
                    //i est le compteur pour pouvoir rendre les cartes visible dans le panel des cartes d'instruction
                    mouseEvent.getComponent().setVisible(false);
                    int i=fen.getCompteur_instruction();
                    fen.getPan_instruction().getComponent(i).setVisible(true);
                    String name=mouseEvent.getComponent().getName();
                    fen.getPan_instruction().getComponent(i).setName(name);
                    fen.increCompteur_instruction(i);
                    fen.getPlateau().getTortue().get(0).completerProg(name);
                    System.out.println(fen.getPlateau().getTortue().get(0).getInstruction());

                }
                if ( fen.getPlateau().getMode().equals(Mode.DEFAUSSE)){
                    System.out.println(fen.getPlateau().getTortue().get(0).getMain().getMa_main());
                    mouseEvent.getComponent().setVisible(false);
                    String name=mouseEvent.getComponent().getName();
                    fen.getPlateau().getTortue().get(0).getMain().defausser(name);


                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }
    public Cartes(){

    }

    public Cartes(Icon skin,String value){
            this.couleur = value;
            this.skin =skin;

    }

  /*  public Cartes(String couleur, String obstacles){
        this.couleur=couleur;
        this.couleur=obstacles;
    }
*/


    public Icon getSkin() {
        return skin;
    }

    public void setSkin(Icon skin) {
        this.skin = skin;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }


    public String getObstacles() {
        return obstacles;
    }

    public void setObstacles(String obstacles) {
        this.obstacles = obstacles;
    }

}
