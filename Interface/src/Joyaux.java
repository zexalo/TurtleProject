import javax.swing.*;

public class Joyaux  {
    private JLabel apparence;
    private int posX;
    private int posY;


    public Joyaux(){

    }

    public Joyaux(JLabel apparence, int posX, int posY){
        this.apparence=apparence;
        this.posX=posX;
        this.posY=posY;

    }

    public int getPosXJ() {
        return posX;
    }

    public int getPosYJ() {
        return posY;
    }

    public JLabel getApparenceJ() {
        return apparence;
    }
}

