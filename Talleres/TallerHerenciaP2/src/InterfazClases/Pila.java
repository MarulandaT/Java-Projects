/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazClases;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 *
 * @author l_mar
 */
public class Pila implements ColeccionInterfaz{
    //Definir un elemento dinamico para que cumpla la funcion de pila 
    //Definir todos los atributos
    private Vector<Object> array = new Vector<Object>();
    private int contador;
    
    //Implementar los metodos de Coleccion
    @Override
    public boolean estaVacia(){
        return this.contador==0;
    }
    
    @Override
    public boolean anhadir(Object objeto)
    {
        
        this.array.addElement(objeto);
        this.contador++;
        return true;
        
    }
    
    @Override
    public Object Extraer(){
        
        if(estaVacia())
        {
            throw new NoSuchElementException();
        } else {
            this.contador--;
            return this.array.elementAt(contador);
        }
        
    }
    
    @Override 
    public Object primero(){
        if(estaVacia())
        {
            throw new NoSuchElementException();
        } else 
        {
            return this.array.elementAt(this.contador-1);
        }
    }
}
