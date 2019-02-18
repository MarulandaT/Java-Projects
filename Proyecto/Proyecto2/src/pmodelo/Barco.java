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
    
    /**
     * Por si se desean construir barcos en base a un vector de piezas
     * @param lista 
     */
    public Barco(PiezaBarco[] lista){
        piezas = lista;
        PuntoInicial = new Point(0,0);
    }
    
    /**
     * Constructor de barco con una lista de piezas
     * @param lista 
     */
    public Barco(ArrayList<PiezaBarco> lista){
        piezas = lista.toArray(new PiezaBarco[0]);
        PuntoInicial = new Point(0,0);
    }
    
    /**
     * Verificar si a un barco aun le quedan piezas
     * @return 
     */
    public boolean verificarVida(){
        boolean estaMuerto = true;
        for (int i = 0; i < piezas.length; i++) {
            if (!piezas[i].pDestruida()) {
                estaMuerto = false;
            }
        }
        return estaMuerto;
    }
    
    /**
     * Obtener el conjunto de piezas del barco
     * @return 
     */
    public PiezaBarco[] getPiezaBarco() {
        return piezas;
    }
    
    /**
     * Cambiar la posicion inicial del barco
     * @param PI 
     */
    public void setPosicionInicial(Point PI){
        PuntoInicial = PI;
    }
    
    /**
     * Obtener el punto inicial del barco
     * @return 
     */
    public Point getPuntoInicial() {
        return PuntoInicial;
    }
}
