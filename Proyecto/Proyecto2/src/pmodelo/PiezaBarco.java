/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pmodelo;
import java.awt.*;
import javax.swing.ImageIcon;
/**
 *
 * @author l_mar
 */
public class PiezaBarco {
    private Image PiezaSana;
    private boolean PiezaMuerta;
    boolean EsJugador1;

    public PiezaBarco(boolean EsJugador1) {
        this.EsJugador1 = EsJugador1;
        
        if(EsJugador1)
            PiezaSana = new ImageIcon("Player1.png").getImage();
        else 
            PiezaSana = new ImageIcon("Player2.png").getImage();
        PiezaMuerta = false;
    }
    
    public void setBarcoImage(String file) {
        PiezaSana = new ImageIcon(file).getImage();
    }
    
    public Image getShipImage() {
        return PiezaSana;
    }
    
    public void Destruido() {
        PiezaMuerta = true;
        if(EsJugador1) {
            setBarcoImage("Player1Hit.png");
        } else {
            setBarcoImage("Player2Hit.png");
        }
    }
    
    public boolean pDestruida() {
        return PiezaMuerta;
    }
    
}
