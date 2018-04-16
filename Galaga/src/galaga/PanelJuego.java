/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Junior
 */
public class PanelJuego extends JPanel implements KeyListener{
    static int juegoIniciado = 0;
    static JLabel nave = new JLabel();
    static int movimiento, naveX, naveY, bala;
    static ArrayList<JLabel> balas = new ArrayList<JLabel>();
    static Enemigo[][] enemigos = new Enemigo[5][6];
    static int direccion =1;
    public PanelJuego(){
        int tipoEnemigo = 0;
        this.addKeyListener(this);
        this.setBounds(50, 75, 800, 500);
        this.setBackground(Color.cyan);
        this.add(nave);
        nave.setBounds(10, 20, 50, 50);
        nave.setOpaque(true);
        nave.setBackground(Color.black);
        for(int x=0;x<5;x++){
            for(int y=0;y<6;y++){
                Enemigo enemigo = new Enemigo(tipoEnemigo);
                enemigo.setOpaque(true);
                switch(tipoEnemigo){
                    case 0:
                        enemigo.setBounds(500+x*60, 20+60*y, 50, 50);
                        enemigo.setBackground(Color.YELLOW);
                        enemigos[x][y] = enemigo;
                        this.add(enemigos[x][y]);
                    break;
                    case 1:
                        enemigo.setBounds(500+x*60, 20+60*y, 50, 50);
                        enemigo.setBackground(Color.GRAY);
                        enemigos[x][y] = enemigo;
                        this.add(enemigos[x][y]);
                    break;
                    case 2:
                        enemigo.setBounds(500+x*60, 20+60*y, 50, 50);
                        enemigo.setBackground(Color.WHITE);
                        enemigos[x][y] = enemigo;
                        this.add(enemigos[x][y]);
                    break;
                }
            }
            
            if(x==0||x==2){
                tipoEnemigo++;
            }
        }
        MoverNave mn = new MoverNave();
        MoverBala mb = new MoverBala();
        if(juegoIniciado==0){
            mb.start();
            mn.start();
            juegoIniciado=1;
        }else{
            mb.stop();
            mn.stop();
            mb.start();
            mn.start();
        }
        //VerificarEnemigo ve = new VerificarEnemigo();
        //ve.start();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        naveX = nave.getX();
        naveY = nave.getY();

        if(e.getKeyCode() == KeyEvent.VK_UP){
            movimiento = 1;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            movimiento = 2;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            bala = 1;
            Disparar disparar = new Disparar();
            disparar.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP ||e.getKeyCode() == KeyEvent.VK_DOWN){
            movimiento =0;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            bala = 0;
        }
    }
    
}
