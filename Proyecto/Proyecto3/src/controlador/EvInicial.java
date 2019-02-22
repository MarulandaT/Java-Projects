/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import vista.Graficos;
import modelo.Logica;
/**
 *
 * @author l_mar
 */
public class EvInicial {
    Graficos g = new Graficos();
    Logica l = new Logica();
    
    /**
     * Inicializar el panel que determina la tarea que realizará el programa:
     * 1 Prestar
     * 2 Ver prestamos
     * 3 Salir
     * Representa la raíz del proyecto
     * @throws ParseException 
     */
    public void iniciar () throws ParseException {
        boolean Ejecutar = true; 
        while (Ejecutar)
        {
            switch ( g.MenuPpal() ){
                case 0:
                {
                    float vPrestar = g.cant(0);
                    int numPrestamos = g.numPrestamos();

                    if((vPrestar > 0 && numPrestamos > 0)){
                       // String doc = g.leerDoc();
                        if (numPrestamos != 1){
                            float disponible = vPrestar;
                            float acumulado = 0; 
                            for (int i = 0; i < numPrestamos; ) {
                                float estPrestamo = g.cant(i+1);
                                if (disponible > 0 && (estPrestamo <= disponible)) {
                                    l.nuevoPrestamo(estPrestamo,  vPrestar,  g);
                                    disponible = disponible - estPrestamo; 
                                    acumulado = acumulado + estPrestamo; 
                                    g.mostrarTotal(acumulado, vPrestar); 
                                    i++;
                                } else if (disponible == 0) {
                                    i = numPrestamos;
                                }
                            } 
                            
                        } else {
                            l.nuevoPrestamo(vPrestar,  vPrestar, g);
                        }
                    } else {
                        this.iniciar();
                    }
                    break;
                }
                case 1:
                {
                    l.verPrestamos(g);
                    break;
                }
                case 2:
                {
                    Ejecutar = false;
                }
            }
        }
    }
}
