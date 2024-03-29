/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Junior
 */
public class PanelJuego extends JPanel implements KeyListener{
    
    static int juegoIniciado = 0;
    static JLabel nave = new JLabel();
    static int movimiento, naveX, naveY, bala, puntos;
    static boolean pausa, congelado = false;
    static ArrayList<Bala> balas = new ArrayList<Bala>();
    static ArrayList<Item> items = new ArrayList<Item>();
    static Enemigo[][] enemigos = new Enemigo[5][6];
    static int direccion =1;
    static String elTiempo = "";
    static double velocidad;
    URL url = getClass().getResource("/img/arena.jpg");
    Image image = new ImageIcon(url).getImage();

    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(),getHeight(), this);
        setOpaque(false);
        super.paint(g);
        
    }
    public PanelJuego(){
        int tipoEnemigo = 0;
        this.addKeyListener(this);
        this.setBounds(0, 0, 800, 500);
        this.add(nave);
        naveX = 10;
        naveY = 20;
        puntos = 0;
        int int_minutos = VistaPrincipal.tiempo/60;
        String minutos = (int_minutos<10) ? "0"+int_minutos : Integer.toString(int_minutos); 
        int int_segundos = VistaPrincipal.tiempo%60;
        String segundos = (int_segundos<10) ? "0"+int_segundos : Integer.toString(int_segundos);
        VistaPrincipal.time.setText(minutos+":"+segundos);
        velocidad = Ejecucion.opciones[1]+1;
        nave.setBounds(naveX, naveY, 50, 50);
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
                        enemigo.setPosicionX(500+x*60);
                        enemigo.setPosicionY(20+60*y);
                        enemigos[x][y] = enemigo;
                        this.add(enemigos[x][y]);
                    break;
                    case 1:
                        enemigo.setBounds(500+x*60, 20+60*y, 50, 50);
                        enemigo.setBackground(Color.GRAY);
                        enemigo.setPosicionX(500+x*60);
                        enemigo.setPosicionY(20+60*y);
                        enemigos[x][y] = enemigo;
                        this.add(enemigos[x][y]);
                    break;
                    case 2:
                        enemigo.setBounds(500+x*60, 20+60*y, 50, 50);
                        enemigo.setBackground(Color.WHITE);
                        enemigo.setPosicionX(500+x*60);
                        enemigo.setPosicionY(20+60*y);
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
        MoverEnemigo me = new MoverEnemigo();
        Reloj rel = new Reloj();
        MoverItem mi = new MoverItem();
        
        //time.setVisible(true);
        
        if(juegoIniciado==0){
            mi.start();
            mb.start();
            mn.start();
            me.start();
            rel.start();
            juegoIniciado=1;
        }else{
            mi.stop();
            mb.stop();
            mn.stop();
            me.stop();
            me.start();
            mb.start();
            mn.start();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        naveX = 10;
        naveY = nave.getY();

        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(!congelado){
                movimiento = 2;
            }
            movimiento = 1;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(!congelado){
                movimiento = 2;
            }
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(!congelado){
                bala = 1;
                Disparar disparar = new Disparar();
                disparar.start();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            MoverNave mn = new MoverNave();
            MoverBala mb = new MoverBala();
            MoverEnemigo me = new MoverEnemigo();
            try{
                synchronized(mn){
                    mn.wait();
                }
                synchronized(me){
                    me.wait();
                }
                synchronized(mb){
                    mb.wait();
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
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
