/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

/**
 *
 * @author l_mar
 */
public interface Prestable {
    //Definir los metodos para que no sean alterados en otras funciones 
    public void prestar();
    public void devolver();
    public boolean prestado();
}
