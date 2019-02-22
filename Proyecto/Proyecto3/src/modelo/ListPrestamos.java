/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author l_mar
 */
public class ListPrestamos extends ArrayList implements Serializable {
    private ArrayList<Prestamo> p;
    
    public ListPrestamos () {
        p = new ArrayList<Prestamo>();
    }
    
    /**
     * Retorna true en caso de que existan prestamos cuya persona tenga el id
     * que se le pasa a la función.
     * @param documento
     * @param prestamos
     * @return 
     */
    public boolean existenPrestamos(String documento, ArrayList<Prestamo> prestamos) {
        boolean r = false; 
        for ( int i = 0; i < prestamos.size(); i++) {
            if ( prestamos.get(i).getSolicitante().getNroId().equals(documento)) {
                r = true;
            }
        }
        return r; 
    }
    
    /**
     * Devuelve el prestamo asociado a una persona en determinada posicion
     * de la lista de prestamos
     * @param prestamos
     * @param pos
     * @return 
     */
    public Prestamo getPrestamo (ArrayList<Prestamo> prestamos, int pos) {
        
        return prestamos.get(pos);
    }
    
}
