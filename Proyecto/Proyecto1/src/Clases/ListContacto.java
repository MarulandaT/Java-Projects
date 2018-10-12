
package Clases;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ListContacto implements Serializable{
    private ArrayList<Contacto> Lista; 
    private ArrayList<Contacto> Resultado;
    private Contacto CAux;
    
    public ListContacto()
    {
        this.Lista=new ArrayList<Contacto>();
        this.Resultado=new ArrayList<Contacto>();
    }
     
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
    
    public void Eliminar()
    {
        String id;
        id = JOptionPane.showInputDialog("Nombre del contacto a Eliminar:");
        boolean resultado = false;
        if(id != null){
            for(int i=0; i<this.Lista.size(); i++){
                if(this.Lista.get(i).getNombre().equals(id)){
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
    
    public void Modificar()
    {
        String id;
        id = JOptionPane.showInputDialog("Nombre del contacto a modificar:");
        boolean resultado = false;
        
        for (int i=0; i<this.Lista.size(); i++)
        {
            if(this.Lista.get(i).getNombre().equals(id))
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
                    JOptionPane.showMessageDialog(null, "¡Ingreso valores erroneos!", 
                "Error", JOptionPane.ERROR_MESSAGE);
                    resultado = true;
                }
            }
        }
        if(!resultado){
            JOptionPane.showMessageDialog(null, "No hay contactos con ese Nombre.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int Size()
    {
        return this.Lista.size();
    }
    
    public Contacto getContacto(int pos)
    {
        return this.Lista.get(pos);
    }
    
    public void Buscar()
    {
        this.Resultado.clear();
        String SAux;
        boolean R = false;
        SAux=JOptionPane.showInputDialog("Busque NOMBRE, TELEFONO,"
                + "CORREO, DIRECCION O ALIAS");
        if(SAux != null){
            for (int i=0; i<this.Lista.size(); i++) {
                this.CAux=this.Lista.get(i);
                if(this.CAux.getNombre().contains(SAux)){
                    this.Resultado.add(CAux);
                } else if (this.CAux.getTelefono().contains(SAux))
                {
                    this.Resultado.add(CAux);
                } else if (this.CAux.getCorreo().contains(SAux))
                {
                    this.Resultado.add(CAux);
                } else if (this.CAux.getDireccion().contains(SAux))
                {
                    this.Resultado.add(CAux);
                } else if (this.CAux.getAlias().contains(SAux))
                {
                    this.Resultado.add(CAux);
                }
                R = true;
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "¡Ingrese un valor válido para buscar!", 
                "Error", JOptionPane.WARNING_MESSAGE);
            R=true;
        }
        
        if(R)
        {
            System.out.println("\n RESULTADO DE BUSQUEDA:");
            for(int i=0; i<this.Resultado.size(); i++)
            {
                System.out.println(Resultado.get(i).toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe el contacto", 
                "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void ImprimirLista()
    {
        for(int i=0; i<this.Lista.size(); i++)
        {
            System.out.println(this.Lista.get(i).toString());
        }
    }
    
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

