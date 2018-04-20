/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import static galaga.PanelJuego.nave;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Junior
 */
public class Bala extends JLabel{
    int posicionX, posicionY;
    public Bala(int posY){
        setOpaque(true);
        setBackground(Color.red);
        setBounds(60, posY+24, 10, 5);
        setPosicionY(posY+24);
        /*VistaPrincipal.panel.add(this);
        VistaPrincipal.panel.repaint();*/
        PanelJuego.balas.add(this);
        VistaPrincipal.juego.add(this);
        VistaPrincipal.juego.repaint();
    }
    
    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }
    
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
