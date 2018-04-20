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
    int posX, posY;
    @Override
    public void run(){
        int tiempo = 100-((40*((int)Ejecucion.opciones[1]+1)));
        System.out.println(tiempo);
        System.out.println(Ejecucion.opciones[1]);
        posX = 10;
        posY = 10;
        Timer timer = new Timer(5, (ActionEvent e)->{
            switch(PanelJuego.movimiento){
                case 1:
                    if(PanelJuego.naveY>0){
                        PanelJuego.naveX = PanelJuego.naveX;
                        PanelJuego.naveY= PanelJuego.naveY-2;
                        posY  = posY-2;
                        PanelJuego.nave.setBounds(10, posY,50,50);
                    }
                break;
                case 2:
                    if(PanelJuego.naveY<450){
                        PanelJuego.naveX = PanelJuego.naveX;
                        PanelJuego.naveY= PanelJuego.naveY+2;
                        posY  = posY+2;
                        PanelJuego.nave.setBounds(10, posY,50,50);
                    }
                break;
            }
            PanelJuego.nave.setBounds(posX, posY,50,50);
        });
        timer.start();
    }
}
