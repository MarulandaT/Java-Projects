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
        
         ListaMultimedia l1multimedia = new ListaMultimedia(20);
        
         Disco disco1 = new Disco("Thiller", "MJ", "Mp3", 120, "Pop");
         Disco disco2 = new Disco("Bad", "MJ", "Mp3", 150, "Pop");
         Disco disco3 = new Disco("Dangerous", "MJ", "Mp3", 100, "Pop");
         
         l1multimedia.add(disco1);
         l1multimedia.add(disco2);
         l1multimedia.add(disco3);
         
         System.out.println(l1multimedia.toString());
    }
}
