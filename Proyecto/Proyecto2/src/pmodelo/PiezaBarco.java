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
    private Image PiezaSana; //imagen de la pieza que no ha sido atacada
    private boolean PiezaMuerta; //imagen de la pieza atacada
    boolean EsJugador1; //determinar de que jugador se trata 

    //Construir una pieza en base a que jugador es
    public PiezaBarco(boolean EsJugador1) {
        this.EsJugador1 = EsJugador1;
        
        if(EsJugador1)
            PiezaSana = new ImageIcon("Player1.png").getImage();
        else 
            PiezaSana = new ImageIcon("Player2.png").getImage();
        PiezaMuerta = false;
    }
    
    //Cambiar la imagen de la pieza, por ejemplo cuando le disparan
    public void setBarcoImage(String file) {
        PiezaSana = new ImageIcon(file).getImage();
    }
    
    //Obtener la imagen de la pieza
    public Image getShipImage() {
        return PiezaSana;
    }
    
    //Cuando la pieza se destruye su imagen cambia
    public void Destruido() {
        PiezaMuerta = true;
        if(EsJugador1) {
            setBarcoImage("Player1Hit.png");
        } else {
            setBarcoImage("Player2Hit.png");
        }
    }
    
    //Verificar si una pieza esta destruida 
    public boolean pDestruida() {
        return PiezaMuerta;
    }
    
}
