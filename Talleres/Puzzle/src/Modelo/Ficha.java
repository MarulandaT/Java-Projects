/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import javax.swing.ImageIcon;
/**
 *
 * @author l_mar
 */
public class Ficha {

    public int Numero;
    public ImageIcon imagen;
    
    public Ficha(int nro){
        this.imagen = new ImageIcon(Integer.toString(nro)+".png");
    }
    
    public ImageIcon getimg(){
        return this.imagen;
    }
}
