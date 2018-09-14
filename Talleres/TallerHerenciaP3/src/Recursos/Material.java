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
public class Material {
    //Creacion de Atributos
    String Codigo;
    String Titulo;
    int Year;
    
    //Implementacion del constructor
    public Material(String cod, String titulo, int year)
    {
        this.Codigo=cod;
        this.Titulo=titulo;
        this.Year=year;
    }
    
    
    //Metodos para la obtensión de la informacion
    public String getCodigo()
    {
        return this.Codigo;
    }
    
    public String getTitulo()
    {
        return this.Titulo;
    }
    
    public int getAño()
    {
        return this.Year;
    }
}
