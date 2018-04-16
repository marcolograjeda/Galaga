/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Junior
 */
public class PanelJuego extends JPanel implements KeyListener{
    static JLabel nave = new JLabel();
    static int movimiento, naveX, naveY, bala;
    static ArrayList<JLabel> balas = new ArrayList<JLabel>();
    
    public PanelJuego(){
        this.addKeyListener(this);
        this.setBounds(50, 75, 800, 500);
        this.setBackground(Color.cyan);
        this.add(nave);
        nave.setBounds(0, 0, 50, 50);
        nave.setOpaque(true);
        nave.setBackground(Color.black);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        naveX = nave.getX();
        naveY = nave.getY();

        if(e.getKeyCode() == KeyEvent.VK_UP){
            movimiento = 1;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            movimiento = 2;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            bala = 1;
            Disparar disparar = new Disparar();
            disparar.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP ||e.getKeyCode() == KeyEvent.VK_DOWN){
            movimiento =0;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            bala = 0;
        }
    }
    
}
