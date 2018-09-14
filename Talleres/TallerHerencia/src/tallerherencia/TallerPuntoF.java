/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerherencia;

import clases.*;

/**
 *
 * @author l_mar
 */
public class TallerPuntoF {
    public static void main(String[] args) {
        
        //Crear la lista para los discos
         ListaMultimedia l1multimedia = new ListaMultimedia(20);
        
         //Crear tres discos
         Disco disco1 = new Disco("Thiller", "MJ", TipoFormato.mp3, 120, "Pop");
         Disco disco2 = new Disco("Bad", "MJ", TipoFormato.mp3, 150, "Pop");
         Disco disco3 = new Disco("Dangerous", "MJ", TipoFormato.mp3, 100, "Pop");
         
         //Añadirlos a la lista
         l1multimedia.add(disco1);
         l1multimedia.add(disco2);
         l1multimedia.add(disco3);
         
         //Imprimir la información que respecta a cada disco
         System.out.println(l1multimedia.toString());
    }
}
