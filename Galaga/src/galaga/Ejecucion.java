/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

/**
 *
 * @author Junior
 */
public class Ejecucion {
    static boolean aTiempo = true;
    static boolean puntos = true;
    static boolean aVelocidad = true;
    static boolean dTiempo = true;
    static boolean penalizacion = true;
    static boolean congelacion = true;
    static double[] opciones = new double[3]; //frecuencia = [0], nivel = [1], tiempoDuracion = [2]
    
    public void iniciarJuego(){
        opciones[0] = 1;
        opciones[1] = 0;
        opciones[2] = 1;
        VistaPrincipal vPrin = new VistaPrincipal();
        vPrin.crearVista();
        
    }
    
    public void editarConfiguracion(boolean tiempoA, boolean puntosExtra, boolean aumentoVel, 
            boolean tiempoD, boolean pena, boolean cong, int frecuencia, int nivel, double tiempoDura){
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
