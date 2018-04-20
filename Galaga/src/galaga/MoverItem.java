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
public class MoverItem extends Thread{
    @Override
    public void run(){
        Timer timer = new Timer(80, (ActionEvent e)->{
            for(int x=0;x<PanelJuego.items.size();x++){
                boolean contactoNave = false;
                if(PanelJuego.items.size()>0){
                    if(PanelJuego.nave.getBounds().intersects(PanelJuego.items.get(x).getBounds())){
                        contactoNave = true;
                        switch(PanelJuego.items.get(x).getTipoItem()){
                            case 0:
                                VistaPrincipal.tiempo = VistaPrincipal.tiempo +10;
                                System.out.println("Tiempo: "+VistaPrincipal.tiempo);
                                VistaPrincipal.juego.remove(PanelJuego.items.get(x));
                                PanelJuego.items.remove(x);
                            break;
                            case 1:
                                PanelJuego.puntos =PanelJuego.puntos+10;
                                //VistaPrincipal.puntuacion.setText(Integer.toString(PanelJuego.puntos));
                                System.out.println("Puntos: " +PanelJuego.puntos);
                                VistaPrincipal.juego.remove(PanelJuego.items.get(x));
                                PanelJuego.items.remove(x);
                            break;
                            case 2:
                                
                            break;
                            case 3:
                                VistaPrincipal.tiempo = VistaPrincipal.tiempo -10;
                                VistaPrincipal.juego.remove(PanelJuego.items.get(x));
                                System.out.println("Tiempo: "+VistaPrincipal.tiempo);
                                PanelJuego.items.remove(x);
                            break;
                            case 4:
                                if(PanelJuego.puntos>0){
                                    PanelJuego.puntos =PanelJuego.puntos-10;
                                }
                                //VistaPrincipal.puntuacion.setText(Integer.toString(PanelJuego.puntos));
                                System.out.println("Puntos: " +PanelJuego.puntos);
                                VistaPrincipal.juego.remove(PanelJuego.items.get(x));
                                PanelJuego.items.remove(x);
                            break;
                            case 5:
                                
                            break;
                        }
                    }
                    if(!contactoNave){
                        if(PanelJuego.items.get(x).getX()>10){
                            PanelJuego.items.get(x).setBounds(PanelJuego.items.get(x).getPosicionX()-10, 
                            PanelJuego.items.get(x).getPosicionY(), 20, 20);
                            PanelJuego.items.get(x).setPosicionX(PanelJuego.items.get(x).getPosicionX()-10);
                        }else{
                            VistaPrincipal.juego.remove(PanelJuego.items.get(x));
                            PanelJuego.items.remove(x);
                        }
                    }
                    VistaPrincipal.juego.repaint();
                }
            }
        });
        timer.start();
    }
    
}
