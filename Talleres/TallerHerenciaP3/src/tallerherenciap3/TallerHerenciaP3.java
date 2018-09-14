/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerherenciap3;
import Recursos.*;
import java.util.Vector;

/**
 *
 * @author l_mar
 */
public class TallerHerenciaP3 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        //Variables que sirven a futuro
        int prestado=0;
        int anteriora=0;
        
        //Creacion de libros
        Libro l1 = new Libro("1088", "Harry Potter", 1998);
        Libro l2 = new Libro("1090", "Secretos del tercer milenio", 2000);
        Libro l3 = new Libro("1033", "La Maria", 1985);
        
        //Creacion de revistas
        Revista r1 = new Revista("10100", "Semana", 2011, 1);
        Revista r2 = new Revista("10200", "Actualizar", 2013, 2);
        Revista r3 = new Revista("10300", "El mañanero", 1990, 33);
   
        //Definir un array para libros, prestar 2, y guardarlos en publicaciones
        Vector<Libro> publicacionesl = new Vector<Libro>();
        l1.prestar();
        l2.prestar();
        publicacionesl.addElement(l1);
        publicacionesl.addElement(l2);
        publicacionesl.addElement(l3);
        
        //Contar los libros prestados
        prestado=cuentaPrestados(publicacionesl);
        System.out.println("El numero de libros prestados es:   " + prestado);

        //Crear un array para las revistas,  y guardarlas en publicaciones
        Vector<Revista> publicacionesr = new Vector<Revista>();
        publicacionesr.addElement(r1);
        publicacionesr.addElement(r2);
        publicacionesr.addElement(r3);
        
        //Determinar el numero de elementos de antes de 1990
        anteriora=publicacionesAnterioresA(publicacionesl, publicacionesr, 1990);
        System.out.println("Numero de material de antes de 1990:    " + anteriora);
        
    }
    
    //Contar los elementos que he prestado
    public static int cuentaPrestados(Vector v)
    {
        int contador = 0;
        Vector<Libro> v1 = v;
        for (int i=0; i<v1.size(); i++)
        {
            if(v1.get(i).Prestado){
                contador++;
            } 
        }
        return contador;
    }
    
    //Contar los elementos de antes de determinado año
    public static int publicacionesAnterioresA(Vector vl, Vector vr,  int año)
    {
        int contador = 0;
        Vector<Libro> v1 = vl;
        Vector<Revista> v2 = vr;
        
        for (int i=0; i<v1.size(); i++)
        {
            if(v1.get(i).getAño() < año){
                contador++;
            }
        }
        for (int i=0; i<v2.size(); i++)
        {
            if(v2.get(i).getAño() < año){
                contador++;
            }
        }
        return contador;
    }
}
