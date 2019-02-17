/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pmodelo;

import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author l_mar
 */
public class Barco {
    private PiezaBarco[] piezas;
    private Point PuntoInicial;
    
    public Barco(PiezaBarco[] lista){
        piezas = lista;
        PuntoInicial = new Point(0,0);
    }
    
    public Barco(ArrayList<PiezaBarco> lista){
        piezas = lista.toArray(new PiezaBarco[0]);
        PuntoInicial = new Point(0,0);
    }
    
    public boolean verificarVida(){
        boolean estaMuerto = true;
        for (int i = 0; i < piezas.length; i++) {
            if (!piezas[i].pDestruida()) {
                estaMuerto = false;
            }
        }
        return estaMuerto;
    }
    
    public PiezaBarco[] getPiezaBarco() {
        return piezas;
    }
    
    public void setPosicionInicial(Point PI){
        PuntoInicial = PI;
    }
    
    public Point getPuntoInicial() {
        return PuntoInicial;
    }
}
