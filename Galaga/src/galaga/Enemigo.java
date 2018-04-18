/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import javax.swing.JLabel;

/**
 *
 * @author Junior
 */
public class Enemigo extends JLabel{
    int vida;
    int tipoEnemigo;
    public Enemigo(int tipo){
        if(tipo == 0){
            vida = 2;
            tipoEnemigo = 0;
        }else if(tipo == 1){
            vida = 3;
            tipoEnemigo = 1;
        }else if(tipo == 2){
            vida = 4;
            tipoEnemigo = 2;
        }        
    }

    public int getVida() {
        return vida;
    }

    public int getTipoEnemigo() {
        return tipoEnemigo;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setTipoEnemigo(int tipoEnemigo) {
        this.tipoEnemigo = tipoEnemigo;
    }
    
    
}
