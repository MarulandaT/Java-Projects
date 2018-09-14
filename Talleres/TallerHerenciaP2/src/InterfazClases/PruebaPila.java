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


    public static void Rellenar(ColeccionInterfaz objeto)
    {
        for (int i = 1; i <= 10; i++)
        {
            objeto.anhadir(i);
        }
    }
    
    
    public static void ImprimiryVaciar(ColeccionInterfaz objeto)
    {
        while(!objeto.estaVacia())
        {
            System.out.println(objeto.extraer());
        }
        System.out.println("\n");
    }
    

}
