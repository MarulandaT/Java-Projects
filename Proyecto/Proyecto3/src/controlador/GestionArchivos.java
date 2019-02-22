/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.ListPersonas;
import modelo.ListPrestamos;

/**
 *
 * @author l_mar
 */
public class GestionArchivos {
    
    private File personas;
    private File prestamos;
    private ListPersonas lp;
    private ListPrestamos lpr;
    
    public GestionArchivos() {
        personas = new File("Personas.txt");
        prestamos = new File("Prestamos.txt");
    }
    
    /**
     * Actualizar la lista de personas en el archivo
     * @param p 
     */
    public void updatep(ListPersonas p)
    {
      try {
            FileOutputStream fos = new FileOutputStream(this.personas);
            ObjectOutputStream cos = new ObjectOutputStream(fos);
            this.personas.delete();
            this.personas = new File("Personas.txt");
            cos.writeObject(p);
            fos.close();
            cos.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } 
     }
    
    /**
     * Actualizar la lista de prestamos en el archivo prestamos
     * @param p 
     */
    public void updatepr(ListPrestamos p)
    {
      try {
            FileOutputStream fos = new FileOutputStream(this.prestamos);
            ObjectOutputStream cos = new ObjectOutputStream(fos);
            this.prestamos.delete();
            this.prestamos = new File("Prestamos.txt");
            cos.writeObject(p);
            fos.close();
            cos.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } 
     }
    
    /**
     * Cargar Personas desde el file Personas.txt
     * @return 
     */
    public ListPersonas cargarPersonas() {
        if (this.personas.exists()) {
            try {
                FileInputStream fis = new FileInputStream(this.personas);
                ObjectInputStream ois = new ObjectInputStream(fis);
                this.lp = (ListPersonas)ois.readObject();
                ois.close();
                fis.close();
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        } else {
            this.lp = new ListPersonas();
        }
        return this.lp;
    }
    
    /**
     * Cargar los prestamos registrados posteriormente en el programa
     * @return 
     */
    public ListPrestamos cargarPrestamos() {
        if (this.prestamos.exists()) {
            try {
                FileInputStream fis = new FileInputStream(this.prestamos);
                ObjectInputStream ois = new ObjectInputStream(fis);
                this.lpr = (ListPrestamos)ois.readObject();
                ois.close();
                fis.close();
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        } else {
            this.lpr = new ListPrestamos();
        }
        return this.lpr;
    }
    
}
