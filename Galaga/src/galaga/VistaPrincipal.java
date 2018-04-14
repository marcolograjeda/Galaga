/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JToolBar;

/**
 *
 * @author Junior
 */
public class VistaPrincipal {

    static boolean aTiempo = true;
    static boolean puntos = true;
    static boolean aVelocidad = true;
    static boolean dTiempo = true;
    static boolean penalizacion = true;
    static boolean congelacion = true;
    static int[] opciones = new int[3]; //frecuencia = [0], nivel = [1], tiempoDuracion = [2]
    
    public void crearVista(){
        opciones[0] = 1;
        opciones[1] = 0;
        opciones[2] = 1;
        JFrame vistaPrincipal = new JFrame();
        vistaPrincipal.setSize(1000,650);
        vistaPrincipal.setLayout(null);
        vistaPrincipal.setResizable(false);
        vistaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaPrincipal.setTitle("Odisea Espacial");
        
        JMenuBar menu = new JMenuBar();
        JMenuItem itmComenzar, itmConfiguracion, itmPuntuacion, itmSalir; 
        
        itmComenzar = new JMenuItem("Iniciar Juego");
        itmConfiguracion = new JMenuItem("Configuración");
        itmPuntuacion = new JMenuItem("Puntuación");
        itmSalir = new JMenuItem("Salir");
        
        menu.add(itmComenzar);
        menu.add(itmConfiguracion);
        menu.add(itmPuntuacion);
        menu.add(itmSalir);
        eventos(itmComenzar);
        itmConfiguracion.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed (ActionEvent e){
                    Configuracion config = new Configuracion();
                    System.out.println("Entre");
                    Ejecucion ejec = new Ejecucion();
                    
                    JDialog configuracion = config.crearConfiguracion(aTiempo, puntos, aVelocidad, 
                            dTiempo, penalizacion, congelacion, opciones[0], 
                            opciones[1], opciones[2]);
                    configuracion.show();
                    configuracion.setSize(400, 600);
                }
            }
        );
        
        eventos(itmPuntuacion);
        eventos(itmSalir);
        
        vistaPrincipal.setJMenuBar(menu);
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
    
    public void editarConfiguracion(boolean tiempoA, boolean puntosExtra, boolean aumentoVel, 
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
    }
}
