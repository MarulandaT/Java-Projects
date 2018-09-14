/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerherenciap2;
import InterfazClases.*;

/**
 *
 * @author l_mar
 */
public class TallerHerenciaP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila p = new Pila(20);
        PruebaPila.Rellenar(p);
        System.out.println("Su pila:    " + p );
        PruebaPila.ImprimiryVaciar(p);
        System.out.println("La nueva pila:  " + p);
        
    }
    
}
