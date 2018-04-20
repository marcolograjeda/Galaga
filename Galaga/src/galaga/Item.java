/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaga;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Junior
 */
public class Item extends JLabel{
    int tipoItem, posicionX, posicionY;
    
    public Item(int tipoItem, int posicionY) {
        this.tipoItem = tipoItem;
        this.setBounds(850, posicionY, 20,20);
        this.setOpaque(true);
        this.setPosicionX(850);
        this.setPosicionY(posicionY);
        if(tipoItem == 0){
            if(Ejecucion.aTiempo){
                this.setBackground(Color.DARK_GRAY);
            }
        }else if(tipoItem == 1){
            if(Ejecucion.puntos){
                this.setBackground(Color.WHITE);
            }
        }else if(tipoItem == 2){
            if(Ejecucion.aVelocidad){
                this.setBackground(Color.MAGENTA);
            }
        }else if(tipoItem == 3){
            if(Ejecucion.dTiempo){
                this.setBackground(Color.pink);
            }
        }else if(tipoItem == 4){
            if(Ejecucion.penalizacion){
                this.setBackground(Color.orange);
            }
        }else if(tipoItem == 5){
            if(Ejecucion.congelacion){
                this.setBackground(Color.blue);
            }
        }
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(int tipoItem) {
        this.tipoItem = tipoItem;
    }
    
}
