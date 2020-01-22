import javax.swing.*;

public class Joyaux  {
    private Icon apparence;
    private int posX;
    private int posY;


    public Joyaux(){

    }

    public Joyaux(Icon apparence, int posX, int posY){
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

    public Icon getApparenceJ() {
        return apparence;
    }
}

