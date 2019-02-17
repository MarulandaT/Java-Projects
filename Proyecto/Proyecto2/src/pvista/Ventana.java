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
}
