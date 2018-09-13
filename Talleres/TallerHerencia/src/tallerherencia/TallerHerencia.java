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
public class TallerHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         ListaMultimedia lmultimedia = new ListaMultimedia(10);
        
         Pelicula pelicula1 = new Pelicula("Titanic", "Autor1", "mp4", 320, "actor1", 0);
         Pelicula pelicula2 = new Pelicula("Spider Man", "Autor2", "mp4", 200, "actor2",0);
         Pelicula pelicula3 = new Pelicula("Harry Potter", "Autor3", "mp4", 300, "actor3", "actriz1");
         
         
         lmultimedia.add(pelicula1);
         lmultimedia.add(pelicula2);
         lmultimedia.add(pelicula3);
         
         System.out.println(lmultimedia.toString());
    }
}
