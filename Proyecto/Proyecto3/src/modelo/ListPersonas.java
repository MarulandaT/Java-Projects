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
public class ListPersonas extends ArrayList implements Serializable{
    private ArrayList <Persona> l; 
    public ListPersonas () {
        l = new ArrayList <Persona>();
    }
    
    /**
     * returna true si false si es posible agregar
     * (no hay registros con dicho id) 
     * @param documento
     * @param l
     * @return 
     */
    public boolean posibleAgregar(String documento, ArrayList<Persona> l) {
        boolean r = false;
        for ( int i = 0; i < l.size(); i++) {
            if ( l.get(i).getNroId().equals(documento)) {
                r = true;
            } 
        }
        return r; 
    }
    
    /**
     * Retorna una persona cuando conozco su documento.
     * @param documento
     * @param l
     * @return 
     */
    public Persona getPersona ( String documento, ArrayList<Persona> l ) {
        Persona P; 
        
        P = new Persona();
        for ( int i = 0; i < l.size(); i ++) {
            if ( l.get(i).getNroId().equals(documento) ) {
                P = l.get(i);
            }  
        }
        
        return P;
    }
    
}
