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
            Bala bala = new Bala(PanelJuego.naveY);
        }
    }
}
