package co.edu.utp.progra4.semana5.punto1;

public class Animal {

    //atributos
    private String Nombre;
    private int edad;
    private int hambre;

    //constructor
    public Animal(String Nombre, int edad) {
        this.Nombre = Nombre;
        this.edad = edad;
        this.hambre = 100;
    }

    public int getEdad() {
        return this.edad;
    }

    public void Alimentar(int comida) {
        if (this.hambre <= (100 - comida)) {
            this.hambre += comida;
        }
    }

    public int getHambre() {
        return this.hambre;
    }

    public void setHambre(int comida) {
        this.hambre = comida;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void Crecer() {
        this.edad++;
    }
}
