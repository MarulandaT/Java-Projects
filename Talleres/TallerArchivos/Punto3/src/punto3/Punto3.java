/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto3;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.IOException;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author l_mar
 */
public class Punto3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Crear varios vehiculos
        Vehiculo v1 = new Vehiculo("C1", "Chevrolet", "Verde", "Camaro");
        Vehiculo v2 = new Vehiculo("C2", "Renault", "Rojo", "R9");
        Vehiculo v3 = new Vehiculo("C3", "Chevrolet", "Gris", "AveoGt");
        
        //Crear un vehiculo auxiliar para ir mostrando informacion
        Vehiculo vleido;
        
        //Gestionar las excepciones
        try {
            //Crear un archivo Autos, que sea serializable (reciba objetos como Vehiculo)
            File archivo = new File ("Autos.txt");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream cos = new ObjectOutputStream(fos);
            
            //Registrar los vehiculos en el archivo
            cos.writeObject(v1);
            cos.writeObject(v2);
            cos.writeObject(v3);
            
            //Leer los Vehiculos previamente añadidos 
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            //Mostrar los vehiculos que ya están en el archivo 
            for(int i=0; i<3; i++){
                vleido=(Vehiculo)ois.readObject();
                System.out.println(vleido);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
}
