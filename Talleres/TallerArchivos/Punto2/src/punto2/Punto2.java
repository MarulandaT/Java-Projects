/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto2;

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author l_mar
 */

public class Punto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Atributos (variables) utiles en la ejecucion
        int contador=0;
        int acumulador=0;
        int promedio;
        
        //Establecer excepciones de posibles problemas con los archivos
        try {
            
            //Apertura y proceso de lectura del archivo
            File archivo = new File("numeros2.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader (fr);
            String cadena;
            
            //Imprimir los numeros a la vez que se hace el proceso para el promedio
            System.out.println("Los numeros en el archivo:");

            while((cadena=br.readLine())!=null){
                System.out.println(cadena);
                acumulador=acumulador + Integer.valueOf(cadena);
                contador++;
            }
            
            //Calcular y mostrar el promedio
            promedio = acumulador / contador;
            System.out.println("El promedio de estos numeros es =   " + promedio);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
