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
    static int tipo1, tipo2, tipo3;
    @Override
    public void run(){
        
        tipo1 = 6;
        tipo2 = 12;
        Timer timer = new Timer(5, (ActionEvent e)->{
            for(int x=0;x<PanelJuego.balas.size();x++){
                boolean matarEnemigo = false;
                for(int posicionX= 0;posicionX<5;posicionX++){
                    for(int posicionY=0;posicionY<6;posicionY++){
                        if(PanelJuego.balas.size()>0&&PanelJuego.enemigos[posicionX][posicionY]!=null){
                            if(PanelJuego.enemigos[posicionX][posicionY].getBounds().intersects(
                                PanelJuego.balas.get(x).getBounds())){
                                if(PanelJuego.enemigos[posicionX][posicionY].getVida()==1){
                                    VistaPrincipal.juego.remove(PanelJuego.enemigos[posicionX][posicionY]);
                                    System.out.println(PanelJuego.enemigos[posicionX][posicionY].getTipoEnemigo());
                                    switch(PanelJuego.enemigos[posicionX][posicionY].getTipoEnemigo()){
                                        case 0:
                                            PanelJuego.puntos=PanelJuego.puntos+10;
                                            VistaPrincipal.puntuacion.setText(Integer.toString(PanelJuego.puntos));
                                            tipo1 =tipo1-1;
                                            if(tipo1==0){
                                                PanelJuego.velocidad = (Ejecucion.opciones[1]+1)*1.5;
                                            }
                                        break;
                                        case 1:
                                            PanelJuego.puntos=PanelJuego.puntos+20;
                                            VistaPrincipal.puntuacion.setText(Integer.toString(PanelJuego.puntos));
                                            tipo2 =tipo2-1;
                                            if(tipo2==0){
                                                PanelJuego.velocidad = (Ejecucion.opciones[1]+1)*2;
                                            }
                                        break;
                                        case 2:
                                            PanelJuego.puntos=PanelJuego.puntos +30;
                                            VistaPrincipal.puntuacion.setText(Integer.toString(PanelJuego.puntos));
                                        break;
                                    }
                                    PanelJuego.enemigos[posicionX][posicionY] = null;
                                    VistaPrincipal.juego.remove(PanelJuego.balas.get(x));
                                    PanelJuego.balas.remove(x);
                                    matarEnemigo = true;
                                    posicionX=5;
                                    posicionY=6;
                                }else{
                                    if(posicionX!=0){
                                        boolean revisarColumna=false;
                                        for(int reviCol = 0; reviCol<6;reviCol++){
                                            if(PanelJuego.enemigos[posicionX-1][reviCol]==null){
                                                revisarColumna=true;
                                            }else{
                                                revisarColumna=false;
                                                reviCol = 6;
                                            }
                                        }
                                        if(revisarColumna){
                                            PanelJuego.enemigos[posicionX][posicionY].setVida(PanelJuego.enemigos[posicionX][posicionY].getVida()-1);
                                            VistaPrincipal.juego.remove(PanelJuego.balas.get(x));
                                            PanelJuego.balas.remove(x);
                                            matarEnemigo = true;
                                            posicionX=5;
                                            posicionY=6;
                                        }
                                    }else{
                                        PanelJuego.enemigos[posicionX][posicionY].setVida(PanelJuego.enemigos[posicionX][posicionY].getVida()-1);
                                        VistaPrincipal.juego.remove(PanelJuego.balas.get(x));
                                        PanelJuego.balas.remove(x);
                                        matarEnemigo = true;
                                        posicionX=5;
                                        posicionY=6;
                                    }
                                }
                            }
                        } 
                    }
                }
                if(!matarEnemigo){
                    if(PanelJuego.balas.get(x).getX()<795){
                        PanelJuego.balas.get(x).setBounds(PanelJuego.balas.get(x).getX()+2, 
                        PanelJuego.balas.get(x).getY(), 10, 5);
                    }else{
                        VistaPrincipal.juego.remove(PanelJuego.balas.get(x));
                        PanelJuego.balas.remove(x);
                    }
                }
                VistaPrincipal.juego.repaint();
            }
        });
        timer.start();
    }
}