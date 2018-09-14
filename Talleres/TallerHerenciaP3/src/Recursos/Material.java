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
    String Codigo;
    String Titulo;
    int Year;
    
    public Material(String cod, String titulo, int year)
    {
        this.Codigo=cod;
        this.Titulo=titulo;
        this.Year=year;
    }
    
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
