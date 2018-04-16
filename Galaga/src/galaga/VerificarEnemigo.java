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
public class VerificarEnemigo extends Thread{
    @Override
    public void run(){
        Timer timer = new Timer(1, (ActionEvent e)->{
            for(int posX= 0;posX<5;posX++){
                if(PanelJuego.enemigos[posX][0]!=null){
                    if(PanelJuego.enemigos[posX][0].getY()==0){
                        PanelJuego.direccion = 1;
                    }
                }
                if(PanelJuego.enemigos[posX][5]!=null){
                    if(PanelJuego.enemigos[posX][5].getY()==450){
                        PanelJuego.direccion =-1;
                    }
                }
            }
        });
        timer.start();
    }
}
