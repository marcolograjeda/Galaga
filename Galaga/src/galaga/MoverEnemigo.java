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
public class MoverEnemigo extends Thread {
    static int velocidad = 1;
    @Override
    public void run(){
        Timer timer = new Timer(80/velocidad, (ActionEvent e)->{
            for(int posX= 0;posX<5;posX++){
                if(PanelJuego.enemigos[posX][0]!=null){
                    if(PanelJuego.enemigos[posX][0].getPosicionY()<10&&PanelJuego.enemigos[posX][0].getPosicionY()>-20){
                        PanelJuego.direccion = 1;
                    }
                }else{
                    for(int posY= 0;posY<6;posY++){
                        if(PanelJuego.enemigos[posX][posY]!=null){
                            if(PanelJuego.enemigos[posX][posY].getPosicionY()==0){
                                PanelJuego.direccion = 1;
                            }
                        }
                    }
                }
                if(PanelJuego.enemigos[posX][5]!=null){
                    if(PanelJuego.enemigos[posX][5].getPosicionY()<455&&PanelJuego.enemigos[posX][5].getPosicionY()>445){
                        PanelJuego.direccion = -1;
                    }
                }else{
                    for(int posY= 0;posY<6;posY++){
                        if(PanelJuego.enemigos[posX][posY]!=null){
                            if(PanelJuego.enemigos[posX][posY].getPosicionY()==0){
                                PanelJuego.direccion = -1;
                            }
                        }
                    }
                }
            }
            int contador = 0;
            for(int posicionX= 0;posicionX<5;posicionX++){
                for(int posicionY=0;posicionY<6;posicionY++){
                    if(PanelJuego.enemigos[posicionX][posicionY]!=null){
                        int moverX = -1*((int)Ejecucion.opciones[1]+1);
                        if(PanelJuego.velocidad==((Ejecucion.opciones[1]+1)*1.5)){
                            PanelJuego.enemigos[posicionX][posicionY].setBounds(PanelJuego.enemigos[posicionX][posicionY].getPosicionX()-2,
                                    PanelJuego.enemigos[posicionX][posicionY].getPosicionY()+(10*PanelJuego.direccion), 50, 50);
                            PanelJuego.enemigos[posicionX][posicionY].setPosicionX(PanelJuego.enemigos[posicionX][posicionY].getPosicionX()-2);
                            PanelJuego.enemigos[posicionX][posicionY].setPosicionY(PanelJuego.enemigos[posicionX][posicionY].getPosicionY()+(10*PanelJuego.direccion));
                        }else if(PanelJuego.velocidad==((Ejecucion.opciones[1]+1)*2)){
                            PanelJuego.enemigos[posicionX][posicionY].setBounds(PanelJuego.enemigos[posicionX][posicionY].getPosicionX()-5, 
                                    PanelJuego.enemigos[posicionX][posicionY].getPosicionY()+(10*PanelJuego.direccion), 50, 50);
                            PanelJuego.enemigos[posicionX][posicionY].setPosicionX(PanelJuego.enemigos[posicionX][posicionY].getPosicionX()-5);
                            PanelJuego.enemigos[posicionX][posicionY].setPosicionY(PanelJuego.enemigos[posicionX][posicionY].getPosicionY()+(10*PanelJuego.direccion));
                        }else{
                            PanelJuego.enemigos[posicionX][posicionY].setBounds(PanelJuego.enemigos[posicionX][posicionY].getPosicionX()-1,
                                    PanelJuego.enemigos[posicionX][posicionY].getPosicionY()+(10*PanelJuego.direccion), 50, 50);
                            PanelJuego.enemigos[posicionX][posicionY].setPosicionX(PanelJuego.enemigos[posicionX][posicionY].getPosicionX()-1);
                            PanelJuego.enemigos[posicionX][posicionY].setPosicionY(PanelJuego.enemigos[posicionX][posicionY].getPosicionY()+(10*PanelJuego.direccion));
                        }
                    }
                    /*if(PanelJuego.enemigos[posicionX][posicionY]!=null){
                    int coorX = PanelJuego.enemigos[posicionX][posicionY].getX();
                    int coorY = PanelJuego.enemigos[posicionX][posicionY].getY();
                    System.out.println("Coordenada x "+coorX+" coordenada y "+coorY);
                    int moverX = -1*((int)Ejecucion.opciones[1]+1);
                    PanelJuego.enemigos[posicionX][posicionY].setBounds(coorX-1, coorY+(10*PanelJuego.direccion), 50, 50);
                      */  
                    
                    contador++;
                }
            }
            if(PanelJuego.velocidad==((Ejecucion.opciones[1]+1)*1.5)){
                if(Ejecucion.opciones[1]==0){
                    velocidad = 2;
                }else{
                    velocidad = 4;
                }
            }else if(PanelJuego.velocidad==((Ejecucion.opciones[1]+1)*2)){
                if(Ejecucion.opciones[1]==0){
                    velocidad = 5;
                }else{
                    velocidad = 8;
                }
            }
            
            VistaPrincipal.panel.repaint();
        });
//            for(int posicionX= 0;posicionX<5;posicionX++){
//                for(int posicionY=0;posicionY<6;posicionY++){
//                    if(PanelJuego.enemigos[posicionX][posicionY]!=null){
//                        int coorX = PanelJuego.enemigos[posicionX][posicionY].getX();
//                        int coorY = PanelJuego.enemigos[posicionX][posicionY].getY();
//                        System.out.println("Coordenada x "+coorX+" coordenada y "+coorY);
//                        int moverX = -1*((int)Ejecucion.opciones[1]+1);
//                        PanelJuego.enemigos[posicionX][posicionY].setBounds(coorX-1, coorY+(10*PanelJuego.direccion), 50, 50);
//                    }
//                }
//            }
        timer.start();
    }
}
