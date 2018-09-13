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
public class Multimedia {
    
    public String Titulo; 
    public String Autor;
    public String Formato;
    public int Duracion;
    /*static final String w = "wav";
    static final String m = "mp3";
    static final String d = "midi";
    static final String a = "avi";
    static final String o = "mov";
    static final String p = "mpg";
    static final String c = "cdAudio";
    static final String v = "dvd";*/
    
    
    public Multimedia (String titulo, String autor, String formato, int duracion)
    {
        this.Titulo = titulo;
        this.Autor = autor;
        this.Formato = formato;
        this.Duracion = duracion;
    }
    
    public String getTitulo()
    {
        return this.Titulo;
    }
    
    public String getAutor()
    {
        return this.Autor;
    }
    
    public String getFormato()
    {
        return this.Formato;
    }
    
    public int getduracion()
    {
        return this.Duracion;
    
    }
    
    @Override 
    public String toString ()
    {
        return this.Autor+" "+this.Formato+" "+this.Titulo+" "+this.Duracion;
    }
    
    
    public boolean equals()
    {
        if(this.Titulo == this.Autor)
        {
            return true;
        } else {
            return false;
        }
    }
    
}
