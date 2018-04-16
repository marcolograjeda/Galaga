/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author Junior
 */
public class VistaPrincipal {
    static JPanel panel;
    static PanelJuego juego;
    
    public void crearVista(){
        JFrame vistaPrincipal = new JFrame();
        vistaPrincipal.setSize(900,650);
        vistaPrincipal.setLayout(null);
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaPrincipal.setTitle("Odisea Espacial");
        panel = new JPanel(null);
        vistaPrincipal.setLayout(new BorderLayout());
        vistaPrincipal.getContentPane().add(panel, BorderLayout.CENTER);
        vistaPrincipal.setLocationRelativeTo(null);
        
        JMenuBar menu = new JMenuBar();
        JMenuItem itmComenzar, itmConfiguracion, itmPuntuacion, itmSalir; 
        
        itmComenzar = new JMenuItem("Iniciar Juego");
        itmConfiguracion = new JMenuItem("Configuración");
        itmPuntuacion = new JMenuItem("Puntuación");
        itmSalir = new JMenuItem("Salir");
        
        //vistaPrincipal.add(nave);
        menu.add(itmComenzar);
        menu.add(itmConfiguracion);
        menu.add(itmPuntuacion);
        menu.add(itmSalir);
        
        
        itmConfiguracion.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed (ActionEvent e){
                    Configuracion config = new Configuracion();
                    System.out.println("Entre");
                    JDialog configuracion = config.crearConfiguracion(Ejecucion.aTiempo, Ejecucion.puntos, Ejecucion.aVelocidad, 
                            Ejecucion.dTiempo, Ejecucion.penalizacion, Ejecucion.congelacion, (int)Ejecucion.opciones[0], 
                            (int)Ejecucion.opciones[1], Ejecucion.opciones[2]);
                    configuracion.show();
                    configuracion.setSize(400, 600);
                }
            }
        );
        itmComenzar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed (ActionEvent e){
                    nuevoJuego();
                }
            }
        );
        
        eventos(itmPuntuacion);
        eventos(itmSalir);
        
        vistaPrincipal.getContentPane().add(menu, BorderLayout.NORTH);
        //vistaPrincipal.setJMenuBar(menu);
        vistaPrincipal.setVisible(true);
        
    }
    
    public void eventos(JMenuItem itmDelMenu){
        ActionListener accion = new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                showMessageDialog(null, itmDelMenu.getText());
            }
        };
        itmDelMenu.addActionListener(accion);
    }
    
    public void nuevoJuego(){
        if (juego != null) {            
            panel.remove(juego);
            juego = null;
        }
        juego = new PanelJuego();        
        panel.add(juego);
        juego.requestFocus();
        panel.repaint();
    }
    
    /*public void editarConfiguracion(boolean tiempoA, boolean puntosExtra, boolean aumentoVel, 
            boolean tiempoD, boolean pena, boolean cong, int frecuencia, int nivel, int tiempoDura){
        aTiempo = tiempoA;
        puntos = puntosExtra;
        aVelocidad = aumentoVel;
        dTiempo = tiempoD;
        penalizacion = pena;
        congelacion = cong;
        opciones[0] = frecuencia;
        opciones[1] = nivel;
        opciones[2] = tiempoDura;
    }*/
}
