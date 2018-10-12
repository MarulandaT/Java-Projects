
package proyecto1;

import Clases.*;
import javax.swing.JOptionPane;

public class Proyecto1 {
    
    public static ListContacto MenuPpal(ListContacto lc, ArchivoContactos Archivo)
    {
        boolean ejecutar = true;
        
        while(ejecutar){
        String[] options = {"Listar los contactos","Agregar un contacto",
        "Modificar un contacto","Eliminar un contacto",
        "Buscar en la agenda","Importar contactos",
        "Exportar contactos","Guardar y salir"};
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
                    lc.ImprimirLista();
                    break;
                }
                case 1:
                {
                    lc.MenuAgregar(lc);
                    break;
                }
                case 2:
                {
                    lc.Modificar();
                    break;
                }
                case 3:
                {
                    lc.Eliminar();
                    break;
                }
                case 4:
                {
                    lc.Buscar();
                    break;
                }
                case 5:
                {
                    Archivo.Importar(lc);
                    break;
                }
                case 6:
                {
                    Archivo.Exportar(lc);
                    break;
                }
                case 7:
                {
                    ejecutar = false;
                }
                default: break;
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
