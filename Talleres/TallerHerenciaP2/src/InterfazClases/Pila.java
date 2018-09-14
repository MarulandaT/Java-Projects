/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazClases;
import java.util.NoSuchElementException;

/**
 *
 * @author l_mar
 */
public class Pila implements ColeccionInterfaz{
    private Object[] array;
    private int contador;
    
    public Pila(int capacidad)
    {
        this.array=new Object[capacidad];
        this.contador=0;
    }
    
    @Override
    public boolean estaVacia(){
        return this.contador==0;
    }
    
    @Override
    public boolean anhadir(Object objeto)
    {
        if(this.array.length == this.contador)
        {
            System.out.println("No se puede añadir elemento, lista llena");
            return false;
        } else {
            this.array[this.contador]=objeto;
            this.contador++;
            return true;
        }
    }
    
    @Override
    public Object extraer(){
        if(estaVacia())
        {
            throw new NoSuchElementException();
        } else {
            this.contador--;
            return this.array[this.contador];
            
        }
    }
    
    @Override 
    public Object primero(){
        if(estaVacia())
        {
            throw new NoSuchElementException();
        } else 
        {
            return this.array[this.contador-1];
        }
    }
    
}
