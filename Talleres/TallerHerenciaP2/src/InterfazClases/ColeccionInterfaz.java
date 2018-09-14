/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazClases;

/**
 *
 * @author l_mar
 */
public interface ColeccionInterfaz {
    //Definir los metodos que utilizaremos con la pila
    public boolean estaVacia();
    public Object Extraer();
    public boolean anhadir(Object objeto);
    public Object primero();
    
}
