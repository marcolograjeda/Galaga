/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author Junior
 */
public class MoverNave extends Thread{
    
    @Override
    public void run(){
        Timer timer = new Timer(10, (ActionEvent e)->{
            switch(PanelJuego.movimiento){
                case 1:
                    if(PanelJuego.naveY>0){
                        PanelJuego.naveY= PanelJuego.naveY-2;
                        PanelJuego.nave.setLocation(0, PanelJuego.naveY);
                    }
                break;
                case 2:
                    if(PanelJuego.naveY<450){
                        PanelJuego.naveY= PanelJuego.naveY+2;
                        PanelJuego.nave.setLocation(0, PanelJuego.naveY);
                    }
                break;
            }
        });
        timer.start();
    }
}
