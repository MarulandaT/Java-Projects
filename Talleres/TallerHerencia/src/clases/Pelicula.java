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
public class Pelicula extends Multimedia {
    
    //Atributos de clase
    public String actorPrincipal="Unknow";
    public String actrizPrincipal="Unknow";

    //Constructor de clase
    public Pelicula(String titulo, String autor, TipoFormato formato, int Duracion, String Actor, String Actriz) {
        super(titulo, autor, formato, Duracion);
        this.actorPrincipal = Actor;
        this.actrizPrincipal = Actriz;
    }
    
    //Constructor cuidando si los atributos de actor o actriz estan vacios
    public Pelicula(String titulo, String autor, TipoFormato formato, int Duracion, String Actor, int aux)
    {
        super(titulo,autor,formato,Duracion);
        if(aux == 0)
        {
            this.actorPrincipal = Actor;
        }
        else if (aux == 1)
        {
            this.actrizPrincipal = Actor;
        }
    }
    
    //Metodos para obtener los diferentes datos
    public String getActor()
    {
        return this.actorPrincipal;
    }
    
    public String getActriz()
    {
        return this.actrizPrincipal;
    }
    
    //Metodo toString
    @Override 
    public String toString ()
    {
        return this.Titulo+","+this.Autor+","+this.Formato+","+this.Duracion+"min,"+this.actorPrincipal+","+this.actrizPrincipal;
    }
}
