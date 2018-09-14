/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author l_mar
 */
public class Disco extends Multimedia {
    //Atributos de clase
    public String Genero="";
    
    //Constructor
    public Disco(String titulo, String autor, TipoFormato formato, int duracion, String genero) {
        super(titulo, autor, formato, duracion);
        this.Genero=genero;
    }
    
    //Obtener los diferentes elementos
    public String getGenero()
    {
        return this.Genero;
    }
    
    @Override
    public String toString()
    {
        return this.Titulo+","+this.Autor+","+this.Formato+","+this.Duracion+"min,"+this.Genero;
    }
    
}
