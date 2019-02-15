/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.MenuPpal;
import Modelo.PiezaBarco;
import Modelo.Barco;
import Vista.Tablero;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author l_mar
 */
public class LogicaJuego {
    public static int tamTablero = 15;
    
    public static int tamBarcoSimple = 1;
    public static int tamBarcoDoble = 2;
    public static int barcoSimple = 6;
    public static int barcoDoble = 6;
    
    private JFrame ventana;
    
    private boolean Ejecutar;
    
    public void Iniciar() {
        ventana = new JFrame();
        int tamfx = 1022;
        int tamfy = 600;
        
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.lightGray);
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setPreferredSize(new Dimension(tamfx,tamfy));
        ventana.setResizable(false);
        
        ventana.pack();
        EjecutarJuego();
    }
    
    public void EjecutarJuego(){
        Ejecutar = true;
        
        MenuPpal MenuInicio = new MenuPpal(ventana);
        MenuInicio.loadTitleScreen();
        while(MenuInicio.EsVVisible()){}
        
        Barco[] j1Barcos = IniciarBarcos(true);
        Barco[] pcBarcos = IniciarBarcos(false);
        JLabel nMovimientos = new JLabel(); 
        JLabel info = new JLabel();
        
        Tablero t = new Tablero(DistribuirBarcos(j1Barcos),DistribuirBarcos(pcBarcos));
        
        t.setSize(1002,496);
        t.setLocation(10,10);
        t.setBackground(Color.LIGHT_GRAY);
        
        nMovimientos.setSize(200,40);
        nMovimientos.setLocation(802, 512 );
        info.setSize(600,40);
        info.setLocation(12,512);
        info.setText("Hay " + Integer.toString(j1Barcos.length) + " Barcos: "
                + Integer.toString(j1Barcos.length/4) + " Horizontales, " +
                Integer.toString(j1Barcos.length/4) + " Verticales y " +
                Integer.toString(j1Barcos.length/2) + " Simples.");
        
        ventana.getContentPane().add(t);
        ventana.getContentPane().add(nMovimientos);
        ventana.getContentPane().add(info);
        
        ventana.addMouseListener(t);
        
        ventana.repaint();
        ventana.setVisible(true);
        
        ciclo(t,j1Barcos,pcBarcos,nMovimientos);
    }
    
    public Barco[] IniciarBarcos(boolean EsJugador1){
        Barco[] barcosSimples = crearBarco(tamBarcoSimple, barcoSimple, EsJugador1);
        Barco[] barcosDobles = crearBarco(tamBarcoDoble, barcoDoble, EsJugador1);
        
        Barco[] barcos = concatArrayBarcos(barcosSimples, barcosDobles);
        return barcos;
    }
    
    public Barco[] crearBarco(int tam, int numElementos, boolean EsJugador1){
        Barco[] listaBarco = new Barco[numElementos];
        for (int i = 0; i < numElementos; i++) {
            PiezaBarco[] BarcoArray = new PiezaBarco[tam];
            for (int j = 0; j < tam; j++){
                PiezaBarco p = new PiezaBarco(EsJugador1);
                BarcoArray[j] = p;
            }
            listaBarco[i] = new Barco(BarcoArray);
        }
        return listaBarco;
    }
    
    public Barco[] concatArrayBarcos(Barco[] s, Barco[] d) {
        int sLen = s.length;
        int dLen = d.length;
        Barco[] c = new Barco[sLen + dLen]; 
        System.arraycopy(s, 0, c, 0, sLen);
        System.arraycopy(d, 0, c, sLen, dLen);
        return c;
    }
    
    public Object[][] DistribuirBarcos(Barco[] b){
        Object[][] resultado = new Object[15][15];
        
        for(int i= 0; i<15; i++){
            for(int  j=0; j<15; j++){
                resultado[i][j] = 0;
            }
        }
        
        int x,y;
        
        for (int i = 9 ; i < 12 ; ) {
            x = (int)Math.floor(Math.random()*14);
            y = (int)Math.floor(Math.random()*15);
            for (int j = 0 ; j < 15 ; j++) {
                for (int k = 0 ; k < 15 ; k++) {
                    if (!resultado[x][y].getClass().getName().equals("Modelo.PiezaBarco")) {
                        resultado[x][y] = b[i].getPiezaBarco()[0];
                        resultado[x+1][y] = b[i].getPiezaBarco()[1];
                        i++;
                    }
                }
            }
        }
        
        for (int i = 6 ; i < 9 ; ) {
            x = (int)Math.floor(Math.random()*15);
            y = (int)Math.floor(Math.random()*14);
            for (int j = 0 ; j < 15 ; j++) {
                for (int k = 0 ; k < 15 ; k++) {
                    if (!resultado[x][y].getClass().getName().equals("Modelo.PiezaBarco")) {
                        resultado[x][y] = b[i].getPiezaBarco()[0];
                        resultado[x][y+1] = b[i].getPiezaBarco()[1];
                        i++;
                    }
                }
            }
        }
        
        for (int i = 0 ; i < 6;) {
            x = (int)Math.floor(Math.random()*15);
            y = (int)Math.floor(Math.random()*15);
            for (int j = 0 ; j < 15 ; j++) {
                for (int k = 0 ; k < 15 ; k++) {
                    if (!resultado[x][y].getClass().getName().equals("Modelo.PiezaBarco")) {
                        resultado[x][y] = b[i].getPiezaBarco()[0];
                        i++;
                    }
                }
            }
        }
        return resultado;
    }
    
    public void ciclo(Tablero t,  Barco[] pc, Barco[] jugador, JLabel Mvtos) {
        
        while(Ejecutar) {
            
            Mvtos.setText("Movimientos restantes: " + Integer.toString(t.getTicks()));
            
            for (int i = 0; i < jugador.length; i++) {
                for (int j = 0; j < jugador[i].getPiezaBarco().length; j++) {
                    if ( jugador[i].getPiezaBarco()[j].pDestruida()) {
                        for ( int k = 0; k < jugador[i].getPiezaBarco().length; k++) {
                            jugador[i].getPiezaBarco()[k].Destruido();
                        }
                    }
                }
            }
            
            for (int i = 0; i < pc.length; i++) {
                for (int j = 0; j < pc[i].getPiezaBarco().length; j++) {
                    if ( pc[i].getPiezaBarco()[j].pDestruida()) {
                        for ( int k = 0; k < pc[i].getPiezaBarco().length; k++) {
                            pc[i].getPiezaBarco()[k].Destruido();
                        }
                    }
                }
            }
            
            boolean todosMuertos1 = true;
            boolean todosMuertos2 = true;
            
            for (int i = 0; i < jugador.length; i++) {
                for (int j = 0; j < jugador[i].getPiezaBarco().length; j++) {
                    if ( !jugador[i].getPiezaBarco()[j].pDestruida()) {
                       todosMuertos1 = false; 
                    }
                }
            }
            
            for (int i = 0; i < pc.length; i++) {
                for (int j = 0; j < pc[i].getPiezaBarco().length; j++) {
                    if ( !pc[i].getPiezaBarco()[j].pDestruida()) {
                       todosMuertos2 = false; 
                    }
                }
            }
            
            if(todosMuertos1 || todosMuertos2 || t.getTicks() == 0) {
                if (todosMuertos1) {
                    
                    Mvtos.setText("Movimientos restantes: " + Integer.toString(0));
                    JLabel res = new JLabel();
                    
                    ventana.getContentPane().remove(t);
                    try { Thread.sleep(5000); 
                    } catch(InterruptedException e ) 
                    { System.out.println("x"); }
                    res.setText("HAS GANADO!");
                    res.setLocation(100, 100);
                    res.setSize(200, 40);
                    ventana.getContentPane().add(res);
                    ventana.repaint();
                    this.setEjecutar(false);
                } else if (todosMuertos2) {
                    Mvtos.setText("Movimientos restantes: " + Integer.toString(0));
                    JLabel res = new JLabel();
                    ventana.getContentPane().remove(t);
                    try { Thread.sleep(5000); 
                    } catch(InterruptedException e ) 
                    { System.out.println("x"); }
                    res.setText("CPU HA GANADO!");
                    res.setLocation(100, 100);
                    res.setSize(200, 40);
                    ventana.getContentPane().add(res);
                    ventana.repaint();
                    this.setEjecutar(false);
                } else if (t.getTicks() == 0) {
                    Mvtos.setText("Movimientos restantes: " + Integer.toString(0));
                    JLabel res = new JLabel();
                    for (int i = 0; i < jugador.length; i++) {
                        for (int j = 0; j < jugador[i].getPiezaBarco().length; j++) {
                            jugador[i].getPiezaBarco()[j].Destruido();
                        }
                    }
                    t.repaint();
                    ventana.getContentPane().remove(t);
                    try { Thread.sleep(5000); 
                    } catch(InterruptedException e ) 
                    { System.out.println("x"); }
                    res.setText("HAS PERDIDO");
                    res.setLocation(100, 100);
                    res.setSize(200, 40);
                    ventana.getContentPane().add(res);
                    ventana.repaint();
                    this.setEjecutar(false);
                }
            }
            t.repaint();
        }
    }
    
    public void setEjecutar(boolean E) {
        Ejecutar = E;
    }
}
