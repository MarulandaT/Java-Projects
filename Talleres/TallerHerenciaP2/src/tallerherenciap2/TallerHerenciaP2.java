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
        
        //Crear la pila 
        Pila p = new Pila();
        
        //Rellenar con los numeros del 1 al 10
        PruebaPila.Rellenar(p);
        
        //Mostrar la pila
        System.out.println("Su pila:    " + p );
        
        //Imprimir e ir vaciando
        PruebaPila.ImprimiryVaciar(p);
        
        //Mostrar la nueva pila 
        System.out.println("La nueva pila:  " + p);
        
    }
    
}
