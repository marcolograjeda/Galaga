/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import static galaga.PanelJuego.nave;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Junior
 */
public class Disparar extends Thread{
    JLabel bala;
    
    @Override
    public void run(){
        if(PanelJuego.bala==1){
            System.out.println("Dispare :v "+nave.getY()+" " +(nave.getY()+2));
            JLabel bala = new JLabel();
            bala.setOpaque(true);
            bala.setBackground(Color.red);
            bala.setBounds(50, nave.getY()+24, 10, 5);
            VistaPrincipal.panel.add(bala);
            VistaPrincipal.panel.repaint();
            PanelJuego.balas.add(bala);
            VistaPrincipal.juego.add(bala);
            VistaPrincipal.juego.repaint();
        }
    }
}
