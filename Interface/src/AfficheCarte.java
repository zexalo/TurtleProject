import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AfficheCarte extends JButton {


    public AfficheCarte(){

    }
    public AfficheCarte(Session fen)
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
//                    System.out.println(mouseEvent.getComponent().get);

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
    public void affCompleterProgramme(Board board){

        }


    }



