/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Junior
 */
public class Reloj extends Thread{
    int segundosTranscurridos=0;
    @Override
    public void run(){
        Timer timer = new Timer(1000, (ActionEvent e)->{
            VistaPrincipal.tiempo--;
            int int_minutos = VistaPrincipal.tiempo/60;
            String minutos = (int_minutos<10) ? "0"+int_minutos : Integer.toString(int_minutos); 
            int int_segundos = VistaPrincipal.tiempo%60;
            String segundos = (int_segundos<10) ? "0"+int_segundos : Integer.toString(int_segundos);
            //PanelJuego.elTiempo=();
            //PanelJuego pJ = new PanelJuego();
            VistaPrincipal.time.setText(minutos+":"+segundos);
            segundosTranscurridos++;
            if(segundosTranscurridos%3==0){
                int tipoItem = (int)(Math.random()*6);
                Item item = new Item(tipoItem, PanelJuego.naveY);
                PanelJuego.items.add(item);
                VistaPrincipal.juego.add(item);                
            }
        });
        timer.start();
    }
}
