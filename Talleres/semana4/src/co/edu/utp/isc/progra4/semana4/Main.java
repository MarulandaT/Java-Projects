/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.progra4.semana4;

/**
 *
 * @author utp
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.print("Argumentos: ");
        for(int i=0; i < args.length; i++){
            System.out.print(args[i]);
        }
        
        Clase1 cesar = new Clase1();
        cesar.setNombre ("Cesar");
        
        System.out.println("cesar.nombre: " + cesar.getNombre());
        System.out.println("cesar.num: " + cesar.getNum());
        
        Clase1 augusto = new Clase1("Augusto");
        
        System.out.println("augusto.nombre: " + augusto.getNombre());
        System.out.println("augusto.num: " + augusto.getNum());
        
        System.out.println("num: " + Clase1.getNum());
        
        Clase1 andres = new Clase1(25);
        andres.setNombre("Andres");
        System.out.println("andres.nombre: " + andres.getNombre());
        System.out.println("andres.num: " + andres.getNum());
        
        /*System.out.println("num: " + num);
        System.out.println("cesar.num: " + num);*/
    }
}
