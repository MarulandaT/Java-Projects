/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 *
 * @author l_mar
 */
public class Punto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Implementar Scanner para las lecturas
        Scanner reader = new Scanner(System.in);
        //Variable que se irá guardando en la ejecución del programa
        int aux;        
        
        try {
            //Creación del archivo e implementacion de metodos de escritura         
            File archivo = new File("numeros.txt");
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            //Guardar los numeros ingresados por teclados
            for(int i=1; i<=10; i++)
            {
                System.out.println("Ingrese un número: ");
                aux = reader.nextInt();
                bw.write(Integer.toString(aux));
                bw.newLine();
            }
            
            //Especificar que se terminó la escritura en el archivo 
            bw.close();
            
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
     }
       
}
