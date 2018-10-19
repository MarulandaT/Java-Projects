
package proyecto1;

import Clases.*;
import javax.swing.JOptionPane;

import javax.swing.JTextArea;
import javax.swing.JFrame;

import java.awt.FlowLayout;

public class Proyecto1 {
    
    public static ListContacto MenuPpal(ListContacto lc, ArchivoContactos Archivo)
    {
        boolean ejecutar = true;
        
        while(ejecutar){
        String x = lc.ImprimirLista();
        String[] options = {"Agregar un contacto","Modificar un contacto","Eliminar un contacto",
        "Buscar en la agenda","Importar contactos","Exportar contactos","Guardar y salir"};
        
        JFrame frame = new JFrame("Agenda de contactos Actualizada");
        frame.setLayout(new FlowLayout());
        String text =x;
        JTextArea textAreal = new JTextArea(text, 30,70);
        
        frame.add(textAreal);
        frame.pack();
        frame.setVisible(true);
        
        int seleccion = JOptionPane.showOptionDialog(null,
        "Seleccione una opcion:", 
        "Menu de Inicio", 
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        options, null);
        
        switch(seleccion)
            {
                case 0:
                {
                    lc.MenuAgregar(lc);
                    frame.dispose();
                    break;
                }
                case 1:
                {
                    lc.Modificar();
                    frame.dispose();
                    break;
                }
                case 2:
                {
                    lc.Eliminar();
                    frame.dispose();
                    break;
                }
                case 3:
                {
                    lc.Buscar();
                    frame.dispose();
                    break;
                }
                case 4:
                {
                    Archivo.Importar(lc);
                    frame.dispose();
                    break;
                }
                case 5:
                {
                    Archivo.Exportar(lc);
                    frame.dispose();
                    break;
                }
                case 6:
                {
                    frame.dispose();
                    ejecutar = false;
                }
                default:
                {
                    frame.dispose();
                    break;
                } 
            }
        }
        return lc; 
    }
    
    public static void main(String[] args) {
        
        ArchivoContactos A = new ArchivoContactos();
        ListContacto L = A.CargarAgenda();
        ListContacto Final; 
        Final = MenuPpal(L,A);
        A.Update(Final);
        
    }
}
