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
        Timer timer = new Timer(tiempo, (ActionEvent e)->{
            //System.out.println(tiempo);
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
            for(int posicionX= 0;posicionX<5;posicionX++){
                for(int posicionY=0;posicionY<6;posicionY++){
                    if(PanelJuego.enemigos[posicionX][posicionY]!=null){
                        int x = PanelJuego.enemigos[posicionX][posicionY].getX();
                        int y = PanelJuego.enemigos[posicionX][posicionY].getY();
                        //System.out.println("Coordenada x "+x+" coordenada y "+y);
                        int moverX = -1*((int)Ejecucion.opciones[1]+1);
                        PanelJuego.enemigos[posicionX][posicionY].setBounds(x-1, y+(10*PanelJuego.direccion), 50, 50);
                        
                    }
                }
            }
            switch(PanelJuego.movimiento){
                case 1:
                    if(PanelJuego.naveY>0){
                        PanelJuego.naveY= PanelJuego.naveY-10;
                        PanelJuego.nave.setLocation(10, PanelJuego.naveY);
                    }
                break;
                case 2:
                    if(PanelJuego.naveY<450){
                        PanelJuego.naveY= PanelJuego.naveY+10;
                        PanelJuego.nave.setLocation(10, PanelJuego.naveY);
                    }
                break;
            }
        });
        timer.start();
    }
}
