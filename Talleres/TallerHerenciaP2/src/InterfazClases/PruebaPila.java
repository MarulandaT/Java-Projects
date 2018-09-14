/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazClases;

/**
 *
 * @author l_mar
 */
public class PruebaPila {

    //Rellenar con numeros aleatorios de 1 a 10 utilizando esta funcion
    public static void Rellenar(ColeccionInterfaz objeto)
    {
        for (int i = 1; i <= 10; i++)
        {
            objeto.anhadir(i);
        }
    }
    
    //Imprimir  e ir vaciando (sacando los elementos de la pila)
    public static void ImprimiryVaciar(ColeccionInterfaz objeto)
    {
        while(!objeto.estaVacia())
        {
            System.out.println(objeto.Extraer());
        }
        System.out.println("\n");
    }
    

}
