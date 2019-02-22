/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author l_mar
 */
public class Persona implements Serializable{
    private String nroId;
    private String prNombre;
    private String prApellido;
    private String sgApellido;
    private String telMovil;
    private String telCasa;

    public Persona(){
        
    }
    
    public Persona(String nroId, String prNombre, String prApellido, String sgApellido, String telMovil, String telCasa) {
        this.nroId = nroId;
        this.prNombre = prNombre;
        this.prApellido = prApellido;
        this.sgApellido = sgApellido;
        this.telMovil = telMovil;
        this.telCasa = telCasa;
    }
    
    public String getNroId() {
        return nroId;
    }

    public void setNroId(String nroId) {
        this.nroId = nroId;
    }

    public String getPrNombre() {
        return prNombre;
    }

    public void setPrNombre(String prNombre) {
        this.prNombre = prNombre;
    }

    public String getPrApellido() {
        return prApellido;
    }

    public void setPrApellido(String prApellido) {
        this.prApellido = prApellido;
    }

    public String getSgApellido() {
        return sgApellido;
    }

    public void setSgApellido(String sgApellido) {
        this.sgApellido = sgApellido;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    @Override
    public String toString() {
        return "Sus datos:{" + "\nDocumento de identidad:" + nroId 
                + ", \nPrimer Nombre:" + prNombre 
                + ", \nPrimer Apellido:" + prApellido 
                + ", \nSegundo Apellido:" + sgApellido 
                + ", \nTelefono Movil:" + telMovil 
                + ", \nTelefono Fijo:" + telCasa + '}';
    }
    
    
}
