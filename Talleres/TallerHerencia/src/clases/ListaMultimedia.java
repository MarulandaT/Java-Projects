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
public class ListaMultimedia {
        
    public Multimedia [] List;
    public int contador = 0;

    //Variables utiles en algun momento
    public int tamanho;
    public int anhadidos;
    
    public ListaMultimedia(int Tamanho)
    {
        this.tamanho=Tamanho;
        this.List = new Multimedia[Tamanho];
        this.contador = 0;
        this.anhadidos = 0;
    }
    
    public int Size()
    {
        this.contador=0;
        for(int i=0; i<this.tamanho; i++)
        {
            if(this.List[i]!=null)
            {
                this.contador++;
            }
        }        
        return this.contador;
    }
    
    
    private boolean sinEspacio()
    {
        if(Size()==this.tamanho)
        {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean add(Multimedia objeto)
    {
        if(sinEspacio())
        {
            System.out.println("Paila no se pudo");
            return false; 
        } else {
            //System.out.println("Aun puede añadir");
            this.List[this.anhadidos] = objeto;
            this.anhadidos++;
            return true;
        }
    }
    
    public Multimedia get(int posicion)
    {
        return this.List[posicion];
    }
    
    @Override
    public String toString()
    {
        String infolist = "";
        for(int i=0; i<this.anhadidos; i++)
        {
            infolist = infolist + this.List[i].toString() + "\n";
        }
        return infolist;
    }
    
}
