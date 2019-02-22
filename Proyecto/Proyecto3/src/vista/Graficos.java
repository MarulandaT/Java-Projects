/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Prestamo;


/**
 *
 * @author l_mar
 */
public class Graficos  {
    
    public Graficos () {
    }
 
    /**
     * Mostrar por pantalla el menu principal
     * @return 
     */
    public int MenuPpal() {
        String[] options   = {"Crear Prestamos","Ver los prestamos","Salir"};
        int seleccion = JOptionPane.showOptionDialog(null,
                "Menu Inicial Prestamos:", 
                "Menu de Inicio", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, options, null);   
        return seleccion;
    }
    
    /**
     * Leer cantidades( en este caso a prestar)
     * 
     * @param nPrest
     * @return 
     */
    public float cant(int nPrest) {
        String s;
        float x;
        if (nPrest == 0){
            s = JOptionPane.showInputDialog(null,"Cantidad a prestar:");
        } else {
            s = JOptionPane.showInputDialog(null,"Cantidad a prestar en el Prestamo #"+nPrest);
        }
        if ( s != null && !s.equals("")) {
            x = Float.parseFloat(s);
            return x;
        } else {
            JOptionPane.showMessageDialog(null, "Información Erronea");
        }
        return -1;
    }
    
    /**
     * Leer la cantidad de prestamos que desea el usuario
     * @return 
     */
    public int numPrestamos() {
        String s;
        int x;
        s = JOptionPane.showInputDialog(null,"Numero de prestamos");
        if ( s != null && !s.equals("")) {
            x = Integer.parseInt(s);
            return x;
        } else {
            JOptionPane.showMessageDialog(null, "Numero de prestamos < 0!");
        }
        return -1;
    }
    
    /**
     * Leer la fecha para el prestamo, esta se le entregará al modelo
     * y allí se hará la gestión de creación de datos.
     * @return
     * @throws ParseException 
     */
    public Date datosPrestamo() throws ParseException {
        Calendar c1 = Calendar.getInstance();
        Date fActual = c1.getTime();
        
        String fechaComoTexto = JOptionPane.showInputDialog(null,"Fecha en la que necesita Autorizacion: dd/mm/aaaa");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaAut = sdf.parse(fechaComoTexto);
            
        if (fActual.after(fechaAut) || fechaAut.getDate() > 20) {
            
            fechaAut = fActual;
            
            if (fechaAut.getDate() > 20) {
                fechaAut.setDate(1);
                fechaAut.setMonth(fechaAut.getMonth()+1);
                JOptionPane.showMessageDialog(null, "Los prestamos solo se autorizan antes del 20 de cada mes,"
                        + "por lo que su nueva fecha de autorización es: " + fechaAut.toString());
            } else {
                fechaAut.setDate(fechaAut.getDate()+1);
                JOptionPane.showMessageDialog(null, "Usted ingresó una fecha anterior a la actual, por lo tanto"
                    + "se le autorizará el prestamo para el: " + fechaAut.toString());
            }
        }
        return fechaAut;
    }
    
    /**
     * Lectura de datos de una persona
     * @return 
     */
    public String[] leerPersona () {
        String[] datos = new String [5];
        
        datos[0] = JOptionPane.showInputDialog(null,"Primer Nombre:");
        datos[1] = JOptionPane.showInputDialog(null,"Primer apellido:");
        datos[2] = JOptionPane.showInputDialog(null,"Segundo apellido:");
        datos[3] = JOptionPane.showInputDialog(null,"Telefono Fijo:");
        datos[4] = JOptionPane.showInputDialog(null, "Telefono Movil:");
        
        if ( (datos[0] == null || datos[1] == null || 
            datos[2] == null || datos[3] == null ||
            datos[4] == null) ||
            (datos[0].equals("") || datos[1].equals("") || 
             datos[2].equals("") || datos[3].equals("") ||
             datos[4].equals("") ) ) {
            JOptionPane.showMessageDialog(null, "Informacion errada!");
            leerPersona();  
        } 
        
        return datos; 
    }
    
    /**
     * Lectura del documento de identidad
     * @return 
     */
    public String leerDoc() {
        String doc; 
        doc = JOptionPane.showInputDialog(null,"Ingrese el numero"
                + " de documento de identidad:");
        return doc; 
    }
    
    /**
     * Mostrar un prestamo específicado
     * @param p 
     */
    public void mostrarPrestamo(Prestamo p) {
        String S;
        S = p.toString();
        JOptionPane.showMessageDialog(null, "Prestamo creado exitosamente:\n" + S);
    }

    /**
     * Ventana para leer cuantas cuotas desea la persona
     * @return 
     */
    public int leerCuotas() {
        String c;
        c = JOptionPane.showInputDialog(null,"Numero de Cuotas:");
        return Integer.parseInt(c);
    }
    
    /**
     * Ventana para mostrar los datos de una persona
     * @param p 
     */
    public void mostrarPersona(Persona p) {
        String S; 
        S = p.toString(); 
        JOptionPane.showMessageDialog(null, S);
    }
    
    
    /**
     * Al terminar de crear los prestamos solicitados por el cliente muestra el total
     * que el cliente quedó debiendo
     * @param acumulado 
     * @param valorTotal
     */
    public void mostrarTotal(float acumulado, float valorTotal) {
        JOptionPane.showMessageDialog(null, "Usted prestó en total: " + acumulado + " de "
        + valorTotal +" $COP");
    }
    
}
