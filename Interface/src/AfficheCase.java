import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AfficheCase extends JButton {



    public AfficheCase(int x, int y, String nom, Board board)
    {
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                int buttondown = mouseEvent.getButton();

                if ( board.getMode().equals(Mode.PLACEMENT) && buttondown==MouseEvent.BUTTON1 && board.getTortue().get(0).getDeck().getNbrGlace()!=0){
                        placerMurGlace(board);

                }

                if ( board.getMode().equals(Mode.PLACEMENT) && buttondown==MouseEvent.BUTTON3 && board.getTortue().get(0).getDeck().getNbrPierre()!=0){
                        placerMur(board);

                }

                board.setMode(Mode.JEU);

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
    public void placerMurGlace(Board board){
        System.out.println(Mode.PLACEMENT);
        int index = board.getTortue().get(0).getDeck().getDeckM().indexOf(board.getTortue().get(0).getDeck().getMurGlace());
        AfficheCase.this.add(board.getGlace());
        AfficheCase.this.setOpaque(true);
        AfficheCase.this.repaint();
        AfficheCase.this.revalidate();
        board.getTortue().get(0).getDeck().getDeckM().remove(index);
    }
    public void placerMur(Board board){
        System.out.println(Mode.PLACEMENT);
        int index = board.getTortue().get(0).getDeck().getDeckM().indexOf(board.getTortue().get(0).getDeck().getMur());
        AfficheCase.this.add(board.getPierre());
        AfficheCase.this.setOpaque(true);
        AfficheCase.this.repaint();
        AfficheCase.this.revalidate();
        board.getTortue().get(0).getDeck().getDeckM().remove(index);

    }


}
