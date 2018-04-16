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
public class MoverBala extends Thread{
    
    @Override
    public void run(){
        Timer timer = new Timer(5, (ActionEvent e)->{
            for(int x=0;x<PanelJuego.balas.size();x++){
                System.out.println("Soy la bala " + x);
                if(PanelJuego.balas.get(x).getX()<795){
                    PanelJuego.balas.get(x).setBounds(PanelJuego.balas.get(x).getX()+2, 
                    PanelJuego.balas.get(x).getY(), 10, 5);
                }else{
                    System.out.println("Me elimine :'v " + x);
                    VistaPrincipal.juego.remove(PanelJuego.balas.get(x));
                    PanelJuego.balas.remove(x);
                }
                VistaPrincipal.juego.repaint();
            }
        });
        timer.start();
    }
}