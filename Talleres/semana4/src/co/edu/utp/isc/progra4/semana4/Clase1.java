/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.progra4.semana4;

import static co.edu.utp.isc.progra4.semana4.Main.num;

/**
 *
 * @author utp
 */
public class Clase1 {
    private static int num=0;
    private String nombre;
    
    public Clase1(){
        num++;
    }
    
    public Clase1(String nom){
        this();
        nombre = nom;
    }
    
    public Clase1(int numero){
        this("");
        num += numero;
    }
    
    public int getNum() {
        return n;
    }
    
}
