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
public class Revista extends Material{
    //Atributos
    private int Numero;
    
    //Constructor
    public Revista(String cod, String titulo, int year, int numero) {
        super(cod, titulo, year);
        this.Numero = numero;
    }
    
    //Metodo toString
    @Override
    public String toString()
    {
        return this.Titulo+" "+this.Codigo+" "+this.Year+" "+this.Numero;
    }
    
}
