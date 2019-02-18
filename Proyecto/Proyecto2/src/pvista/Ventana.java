/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pvista;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author l_mar
 */
public class Ventana extends JFrame{
    public  JFrame vJuego;
    
    //Darle dimensiones graficas a la ventana 
    public void DimensionVentana(JFrame ventana) {
        vJuego = ventana;
        vJuego.getContentPane().setLayout(null);
        vJuego.getContentPane().setBackground(Color.lightGray);
        vJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vJuego.setPreferredSize(new Dimension (1022,600));
        vJuego.setResizable(false);
        vJuego.pack();
        vJuego.setVisible(true);
        vJuego.repaint();
    }
    
    public Ventana() {
    }
    
    //Cargar todo elemento grafico en la ventana 
    public void CargarElementos(JFrame ventana, Tablero t, JLabel nMovimientos) {
        
        JLabel info = new JLabel();
        nMovimientos.setSize(200,40);
        nMovimientos.setLocation(802, 512 );
        
        info.setSize(600,40);
        info.setLocation(12,512);
        
        t.setSize(1002,496);
        t.setLocation(10, 10);
        t.setBackground(Color.red);
        
        info.setText("Hay " + Integer.toString(12) + " Barcos: "
                + Integer.toString(12/4) + " Horizontales, " +
                Integer.toString(12/4) + " Verticales y " +
                Integer.toString(12/2) + " Simples.");
        
        ventana.getContentPane().add(nMovimientos);
        ventana.getContentPane().add(info);
        
        ventana.getContentPane().add(t);
        ventana.addMouseListener(t);
        
        ventana.repaint();
        ventana.setVisible(true);
    }
    
    //Pintar el fin del juego.
    public void finalizar(JFrame v, Tablero t, JLabel m, int caso) {
        JLabel res = new JLabel();
        m.setText("Movimientos restantes: " + Integer.toString(0));
        v.getContentPane().remove(t);
        
        switch (caso){
            case 0: {
            
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            res.setText("HAS GANADO!");
            res.setLocation(100, 100);
            res.setSize(200, 40);
            v.getContentPane().add(res);
            v.repaint();
            }
            case 1: {
            
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            res.setText("CPU HA GANADO!");
            res.setLocation(100, 100);
            res.setSize(200, 40);
            v.getContentPane().add(res);
            v.repaint();
            }
            case 2: {
            
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            res.setText("Has perdido");
            res.setLocation(100, 100);
            res.setSize(200, 40);
            v.getContentPane().add(res);
            v.repaint();
            }
        
        }
    }
}
