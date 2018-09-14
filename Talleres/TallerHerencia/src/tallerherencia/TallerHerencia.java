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
        
        //Crear la lista multimedia de 10 elementos
         ListaMultimedia lmultimedia = new ListaMultimedia(10);
        
         //Crear tres peliculas
         Pelicula pelicula1 = new Pelicula("Titanic", "Autor1", TipoFormato.mov, 320, "actor1", 0);
         Pelicula pelicula2 = new Pelicula("Spider Man", "Autor2", TipoFormato.mov, 200, "actor2",0);
         Pelicula pelicula3 = new Pelicula("Harry Potter", "Autor3", TipoFormato.mov, 300, "actor3", "actriz1");
         
         //Añadir tres peliculas
         lmultimedia.add(pelicula1);
         lmultimedia.add(pelicula2);
         lmultimedia.add(pelicula3);
         
         //Imprimir su respectiva información
         System.out.println(lmultimedia.toString());
    }
}
