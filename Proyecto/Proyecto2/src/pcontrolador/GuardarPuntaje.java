/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcontrolador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author l_mar
 */
public class GuardarPuntaje {
    File Informacion;
    public boolean runFile() throws IOException{
        Informacion = new File("puntaje.txt");
        return true;
    }
    
    /**
     * Escribir el puntaje en el archivo que se tiene destinado
     * @param puntaje
     * @throws Exception 
     */
    public void savePuntaje (String puntaje) throws Exception{
        try {
            FileOutputStream fos = new FileOutputStream(Informacion,true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(puntaje);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ha sucedido un error al ingresar"
                       + " el puntaje " + e);
        }
    }
    
}