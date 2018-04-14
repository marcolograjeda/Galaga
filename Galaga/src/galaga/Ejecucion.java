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
    boolean aTiempo = true;
    boolean puntos = true;
    boolean aVelocidad = true;
    boolean dTiempo = true;
    boolean penalizacion = true;
    boolean congelacion = true;
    int[] opciones = new int[3]; //frecuencia = [0], nivel = [1], tiempoDuracion = [2]
    
    public void iniciarJuego(){
        VistaPrincipal vPrin = new VistaPrincipal();
        vPrin.crearVista();
        opciones[0] = 1;
        opciones[1] = 0;
        opciones[2] = 1;
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
