
package Clases;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListContacto implements Serializable{
    private ArrayList<Contacto> Lista; 
    private ArrayList<Contacto> Resultado;
    private Contacto CAux;
    
    /**
     * Constructor de la clase Lista de Contactos
     */
    public ListContacto()
    {
        this.Lista=new ArrayList<Contacto>();
        this.Resultado=new ArrayList<Contacto>();
    }
     
    /**
     * Agregar desde el JavaOptionPane
     * Guarda contactos en la lista!
     * @param lc 
     */
    public void MenuAgregar(ListContacto lc)
    {
        String n,t,c,d,a;
        n = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
        t = JOptionPane.showInputDialog("Ingrese el telefono del contacto:");
        c = JOptionPane.showInputDialog("Ingrese el correo eléctronico del contacto:");
        d = JOptionPane.showInputDialog("Ingrese la dirección de contacto:");
        a = JOptionPane.showInputDialog("Ingrese el Alias de contacto:");
        if((n != null) && (t != null) && 
                (c != null) && (d != null) && (a != null)){
           lc.Agregar(n, t, c, d, a);
        } else {
           JOptionPane.showMessageDialog(null, "Has ingresado valores no permitidos, contacto no guardado", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Agregar contactos verificando si el telefono está repetido en la agenda
     * @param Nombre
     * @param Telefono
     * @param Correo
     * @param Direccion
     * @param Alias 
     */
    public void Agregar(String Nombre, String Telefono, String Correo, String Direccion, String Alias)
    {
        this.CAux = new Contacto(Nombre, Telefono, Correo, Direccion, Alias);
        if(VerTelRepetido(this.Lista,CAux)){
            this.Lista.add(CAux);
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un contacto con ese télefono!,"
                    + "Contacto no guardado!", 
                 "Error", JOptionPane.WARNING_MESSAGE);        
        }
    }
    
    /**
     * Elimina un contacto especificando su nombre.
     */
    public void Eliminar()
    {
        String id;
        id = JOptionPane.showInputDialog("Numero de telefono del contacto a Eliminar:");
        boolean resultado = false;
        if(id != null){
            for(int i=0; i<this.Lista.size(); i++){
                if(this.Lista.get(i).getTelefono().equals(id)){
                    this.CAux = this.Lista.get(i);
                    this.Lista.remove(this.CAux);
                    resultado = true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Campo de busqueda en blanco!", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(!resultado){
            JOptionPane.showMessageDialog(null, "No existe el contacto", 
                "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Modifica un contacto específicando su nombre
     * Por defecto tiene los valores que tenía el contacto previamente
     */
    public void Modificar()
    {
        String id;
        id = JOptionPane.showInputDialog("Número de telefono del contacto a modificar:");
        boolean resultado = false;
        
        for (int i=0; i<this.Lista.size(); i++)
        {
            if(this.Lista.get(i).getTelefono().equals(id))
            {
                String n,t,c,d,a;
                n = JOptionPane.showInputDialog("Nuevo nombre del contacto:",
                        this.Lista.get(i).getNombre());
                t = JOptionPane.showInputDialog("Nuevo telefono del contacto:",
                        this.Lista.get(i).getTelefono());
                c = JOptionPane.showInputDialog("Nuevo correo eléctronico del contacto:",
                        this.Lista.get(i).getCorreo());
                d = JOptionPane.showInputDialog("Nueva dirección de contacto:",
                        this.Lista.get(i).getDireccion());
                a = JOptionPane.showInputDialog("Nuevo Alias de contacto:",
                        this.Lista.get(i).getAlias());
                if((n != null) && (t != null) && 
                (c != null) && (d != null) && (a != null)){
                    this.Lista.get(i).setNombre(n);
                    this.Lista.get(i).setTelefono(t);
                    this.Lista.get(i).setCorreo(c);
                    this.Lista.get(i).setDireccion(d);
                    this.Lista.get(i).setAlias(a);
                    resultado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "¡Ingreso valores erroneos o un télefono"
                            + " ya existente en la agenda!", "Error", JOptionPane.ERROR_MESSAGE);
                    resultado = true;
                }
            }
        }
        if(!resultado){
            JOptionPane.showMessageDialog(null, "No hay contactos con ese Nombre.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Obtiene el tamaño del ListContacto
     * @return 
     */
    public int Size()
    {
        return this.Lista.size();
    }
    
    /**
     * Obtener un contacto conociendo su posición en lista
     * @param pos
     * @return 
     */
    public Contacto getContacto(int pos)
    {
        return this.Lista.get(pos);
    }
    
    /**
     * Busca por cualquier campo, verifica existencias e imprime resultados
     */
    public void Buscar()
    {
        this.Resultado.clear();
        String SAux,cadenar="Resultado de búsqueda:\n";
        boolean R = false;
        SAux=JOptionPane.showInputDialog("Busque NOMBRE, TELEFONO,"
                + "CORREO, DIRECCION O ALIAS");
        if(SAux != null){
            for (int i=0; i<this.Lista.size(); i++) {
                this.CAux=this.Lista.get(i);
                if(this.CAux.getNombre().contains(SAux)){
                    this.Resultado.add(CAux);
                    R = true;
                } else if (this.CAux.getTelefono().contains(SAux))
                {
                    this.Resultado.add(CAux);
                    R = true;
                } else if (this.CAux.getCorreo().contains(SAux))
                {
                    this.Resultado.add(CAux);
                    R = true;
                } else if (this.CAux.getDireccion().contains(SAux))
                {
                    this.Resultado.add(CAux);
                    R = true;
                } else if (this.CAux.getAlias().contains(SAux))
                {
                    this.Resultado.add(CAux);
                    R = true;
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "¡Ingrese un valor válido para buscar!", 
                "Error", JOptionPane.WARNING_MESSAGE);
            R=true;
        }
        
        if(R)
        {
            for(int i=0; i<this.Resultado.size(); i++)
            {
                cadenar = cadenar + Resultado.get(i).toString() 
                        + "\n";
            }
            JOptionPane.showMessageDialog(null, cadenar, 
                "Resultado de busqueda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No existe el contacto", 
                "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Convierte la lista de contactos en un string, para poder mostrarla en el jframe.
     * @return 
     */
    public String ImprimirLista()
    {
        String salida = "LISTA DE CONTACTOS:";
        for(int i=0; i<this.Lista.size(); i++)
        {
            this.CAux = this.Lista.get(i);
            salida = salida  + "\nNombre:" + this.CAux.getNombre()
                    +", Telefono:" + this.CAux.getTelefono()
                    +", Correo:" + this.CAux.getCorreo()
                    +", Dirección:" + this.CAux.getDireccion()
                    +", Alias:" + this.CAux.getAlias();
        }
        return salida;
    }
    
    /**
     * Verifica que no hayan telefonos repetidos
     * @param lc
     * @param c
     * @return 
     */
    public boolean VerTelRepetido(ArrayList<Contacto> lc,Contacto c)
    {
        boolean r=true;
        for(int i=0;i<lc.size();i++)
        {
            if(c.getTelefono().equals(lc.get(i).getTelefono()))
            {
                r=false;
            }
        }
        return r;
    }
    
}

