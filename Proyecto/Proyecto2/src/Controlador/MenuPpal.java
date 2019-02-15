/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author l_mar
 */
public class MenuPpal {
    private JFrame Ventana;
    private JButton Jugar;
    private JButton AcercaDe;
    private JButton Ayuda;
    private JButton Salir;
    private volatile boolean EsVisible;
    
    public MenuPpal(JFrame forma){
        Ventana = forma;
        EsVisible = true;
    }

    public void loadTitleScreen() {
        int tbx = 200;
        int tby = 40;
        Jugar = new JButton("Jugar");
        Jugar.setSize(tbx,tby);
        Jugar.setLocation((Ventana.getSize().width/2)-(Jugar.getSize().width/2),200);    
        Jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Ventana.remove(Jugar);
                Ventana.remove(Ayuda);
                Ventana.remove(AcercaDe);
                Ventana.remove(Salir);
                Ventana.getContentPane().revalidate();
                
                Ventana.repaint();
                EsVisible = false;
            }
        });
        
        AcercaDe = new JButton("Acerca del Juego");
        AcercaDe.setSize(tbx,tby);
        AcercaDe.setLocation((Ventana.getSize().width/2)-(AcercaDe.getSize().width/2),300);
        AcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Juego Realizado Por: Luis Miguel Marulanda Torres\n"
                        + "Fecha:Febrero de 2019");
            }
        });
        
        Ayuda = new JButton("Ayuda");
        Ayuda.setSize(tbx,tby);
        Ayuda.setLocation((Ventana.getSize().width/2)-(Ayuda.getSize().width/2),400);
        Ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"REGLAS DE JUEGO:\n"
                        + "*Verás dos tableros ubicados a la derecha e izquierda de la pantalla,\n"
                        + "sin embargo, solo podrás interactuar con el tablero del lado derecho.\n"
                        + "*El tablero izquierdo contiene tú juego, es decir, los barcos que te \n"
                        + "pertenecen y que la cpu debe atacar.\n"
                        + "*Deberás atacar el tablero de la CPU, donde se encuentran los barcos\n"
                        + "de manera invisible para ti, y que se revelarán solo si al disparar la\n"
                        + "casilla que elejiste contiene una pieza de barco.\n"
                        + "*Los Barcos dobles serán destruidos con solamente atacar una de sus \n"
                        + "partes.\n"
                        + "*Un disparo es válido solo sí das doble clic.\n"
                        + "*En todo momento podrás ver la cantidad de movimientos que te quedan\n"
                        + "y la cantidad total de barcos en el tablero.");
            }
        });
        
        Salir = new JButton("Salir");
        Salir.setSize(tbx,tby);
        Salir.setLocation((Ventana.getSize().width/2)-(Salir.getSize().width/2),500);
        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        Jugar.setVisible(true);
        AcercaDe.setVisible(true);
        Ayuda.setVisible(true);
        Salir.setVisible(true);
        
        Ventana.getContentPane().add(Jugar);
        Ventana.getContentPane().add(AcercaDe);
        Ventana.getContentPane().add(Ayuda);
        Ventana.getContentPane().add(Salir);
        Ventana.setVisible(true);
    }
    
    public boolean EsVVisible(){
        return EsVisible;
    }
}
