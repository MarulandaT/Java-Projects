/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import modelo.ListPersonas;
import modelo.ListPrestamos;
import modelo.Persona;
import modelo.Prestamo;
import vista.Graficos;

/**
 *
 * @author l_mar
 */
public class Logica {
    private GestionArchivos ga = new GestionArchivos();
    private ListPersonas l = ga.cargarPersonas();
    private ListPrestamos lp = ga.cargarPrestamos();
    
    
    public Logica () {
    }
    
    /**Crear un nuevo Prestamo, cuando desde el controlador 
     * se me da la orden de generar nuevo prestamo.
     * 
     * @param EstPrestamo
     * @param VaPrestar
     * @param g
     * @throws ParseException 
     */
    public void nuevoPrestamo(float EstPrestamo, 
            float VaPrestar, Graficos g) throws ParseException{
        Persona p; 
        Prestamo pr;
        
        String docPersona = g.leerDoc();
        
        if ( l.posibleAgregar(docPersona, l) ){
            p = l.getPersona(docPersona, l); 
        } else {
            String[] datPersona = g.leerPersona();
            p = new Persona(docPersona,datPersona[0],datPersona[1],
                datPersona[2],datPersona[3],datPersona[4]);
            l.add(p);
            ga.updatep(l);
        }
        
        Date fechaAut = g.datosPrestamo();
        
        int numPrestamo = lp.size()+1;
        int nroCuotas = g.leerCuotas();
        
        if (nroCuotas < 0  || nroCuotas > 6) {
            nroCuotas = 6;
        } 

        Date[] fechasCuotas = new Date[nroCuotas];
        Date fechaEntrega;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaAut);
        if ( EstPrestamo > 1000000 ){
            calendar.add(Calendar.DAY_OF_YEAR, 10);
            fechaEntrega = calendar.getTime();
        } else {
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            fechaEntrega = calendar.getTime();
        }

        if (nroCuotas  <= 6 && nroCuotas > 0) {
            for ( int i = 0; i < nroCuotas; i++) {
                if ( i == 0) {
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(fechaEntrega);
                    calendar1.add(Calendar.DAY_OF_YEAR, 30);
                    fechasCuotas[i] = calendar1.getTime();
                } else {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(fechasCuotas[i-1]);
                    calendar2.add(Calendar.DAY_OF_YEAR, 30);
                    fechasCuotas[i] = calendar2.getTime();
                }
            }
        }         
        
        pr = new Prestamo(numPrestamo,p,
            EstPrestamo, fechasCuotas,
            fechaAut,fechaEntrega);

        lp.add(pr);

        ga.updatepr(lp);

        g.mostrarPrestamo(pr);
    }
    
    /**
     * Verificar los prestamos de una persona específica. 
     * @param g 
     */
    public void verPrestamos(Graficos g) {
        Prestamo p; 
        Persona per; 
        
        for (int i = 0; i < this.lp.size();  i++) {
            p = lp.getPrestamo(lp, i);
            per = lp.getPrestamo(lp, i).getSolicitante();
            
            g.mostrarPrestamo(p);
            g.mostrarPersona(per);
        }
        
    }
    
}
