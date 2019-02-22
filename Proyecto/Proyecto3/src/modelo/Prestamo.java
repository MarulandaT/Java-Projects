/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author l_mar
 */
public class Prestamo implements Serializable{
    private int numPrestamo;
    private Persona solicitante;
    private float ValorPrestamo;
    private Date [] fechas;
    private Date fAutorizacion; 
    private Date fTentEntrega; 

    public Prestamo() {
        this.numPrestamo = 0;
    }
    
    public Prestamo(int numPrestamo, Persona solicitante, 
            float ValorPrestamo, Date[] fechas, 
            Date fAutorizacion, Date fTentEntrega) {
        this.numPrestamo = numPrestamo;
        this.solicitante = solicitante;
        this.ValorPrestamo = ValorPrestamo;
        this.fechas = fechas;
        this.fAutorizacion = fAutorizacion;
        this.fTentEntrega = fTentEntrega;
    }

    
    
    public int getNumPrestamo() {
        return numPrestamo;
    }

    public void setNumPrestamo(int numPrestamo) {
        this.numPrestamo = numPrestamo;
    }

    public Persona getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Persona Solicitante) {
        this.solicitante = Solicitante;
    }

    public float getValorPrestamo() {
        return ValorPrestamo;
    }

    public void setValorPrestamo(float ValorPrestamo) {
        this.ValorPrestamo = ValorPrestamo;
    }

    public Date[] getFechas() {
        return fechas;
    }

    public void setFechas(Date[] fechas) {
        this.fechas = fechas;
    }

    public Date getfAutorizacion() {
        return fAutorizacion;
    }

    public void setfAutorizacion(Date fAutorizacion) {
        this.fAutorizacion = fAutorizacion;
    }

    public Date getfTentEntrega() {
        return fTentEntrega;
    }

    public void setfTentEntrega(Date fTentEntrega) {
        this.fTentEntrega = fTentEntrega;
    }

    @Override
    public String toString() {
        
        return "Prestamo: {\n" + 
                "Numero de Prestamo=" + numPrestamo + "\n" +
                " ID solicitante=" + solicitante.getNroId() + "\n" +
                " Valor del Prestamo=" + ValorPrestamo + "\n" +
                " Fechas de las cuotas=" + Arrays.toString(fechas) +"\n" +
                " Fecha de Autorizacion=" + fAutorizacion + "\n" +
                " Fecha tentativa de entrega=" + fTentEntrega + '}';
    }
    
}
