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
        int tiempo = 100-((40*((int)Ejecucion.opciones[1]+1)));
        System.out.println(tiempo);
        System.out.println(Ejecucion.opciones[1]);
        //int posX
        Timer timer = new Timer(5, (ActionEvent e)->{
            switch(PanelJuego.movimiento){
                case 1:
                    if(PanelJuego.naveY>0){
                        PanelJuego.naveY= PanelJuego.naveY-2;
                        PanelJuego.nave.setLocation(10, PanelJuego.naveY);
                    }
                break;
                case 2:
                    if(PanelJuego.naveY<450){
                        PanelJuego.naveY= PanelJuego.naveY+2;
                        PanelJuego.nave.setLocation(10, PanelJuego.naveY);
                    }
                break;
            }
            PanelJuego.nave.setBounds(PanelJuego.naveX, PanelJuego.naveY,50,50);
            //System.out.println("Coordenada de la nave "+PanelJuego.nave.getX()+", "+PanelJuego.nave.getY());
        });
        timer.start();
    }
}
