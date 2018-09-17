/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto3;
import java.io.Serializable;

/**
 *
 * @author l_mar
 */
public class Vehiculo implements Serializable {
    private String Placa;
    private String Marca;
    private String Color;
    private String Modelo; 
    
    public Vehiculo (String placa, String marca, String color, String modelo)
    {
        this.Placa = placa;
        this.Marca = marca;
        this.Color = color;
        this.Modelo = modelo;
    }
    
    public String getPlaca()
    {
        return this.Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public String getColor() {
        return Color;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "Placa=" + Placa + ", Marca=" + Marca + ", Color=" + Color + ", Modelo=" + Modelo + '}';
    }
    
}
