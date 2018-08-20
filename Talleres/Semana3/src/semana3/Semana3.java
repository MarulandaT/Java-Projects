/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana3;

/**
 *
 * @author utp
 */
public class Semana3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /* ESCOJA EL CASO QUE CORRESPONDE:
        1. Determinar si un numero es par o impar
        2. Encontrar el factorial de un numero
        3. Encontrar la serie fibonacci para un determinado numero
        4. Resolver potencias n^m=n*n*n*...*(m veces)
        5. Verificar si un numero es primo
        6. Pasar de un numero de horas a su equivalencia en semana,dia,hora
        7. Calcular raices de polinomios de segundo grado
        */
        
        //Determine el caso;
        int caso=1;
        
        
        switch (caso){
            case 1:
            {
                //Variable a la cual le deseo determinar si es par o no
                int x=5;
                
                if((x%2)==0){
                    System.out.println(x + " Es numero Par");
                } else {
                    System.out.println(x + " Es numero Impar");
                }
                break;
            }
            case 2:
            {
                //variable a la que deseo encontrarle el factorial
                int x=5;
                System.out.println("Factorial de " + x + ":");
                //el factorial por definicion f(0)=1
                int factorial=1;
                
                while(x>0){
                    factorial=factorial*x;
                    x--;
                }  
                System.out.println(factorial);
                break;
            }
            case 3:
            {
                //variable a la que deseo encontrarle el fibonacci
                int x=6;
                //fibonacci por definicion f(0)=1, f(1)=1;
                int fib0=1;
                int fib1=1;
                //acumulador para determinar la sumatoria de la serie:
                int aux=0;
                
                System.out.println("La serie fibonacci esta dada por:");
                System.out.println("0");
                System.out.println(fib0);
                for (int i=2; i<=x; i++){
                    System.out.println(fib1);
                    fib1=fib0+fib1;
                    fib0=fib1-fib0;
                    aux=fib0+aux;
                }
                System.out.println("El resultado es:");
                System.out.println(aux+1);
                break;
            }
            case 4:
            {
                //variable base para la potenciacion
                int n=4;
                //potencia
                int m=3;
                //acumulador
                int resultado=1;
                
                System.out.println(n + "^" + m + ":");
                while(m>0){
                    resultado=resultado*n;
                    m--;
                }
                System.out.println(resultado);
                break;
            }
            case 5:
            {
                //variable para determinar si es numero primo o no
                int x=13;
                //numero con el cual voy a ir comparando en cada iteracion
                int comp = x;
                //numero de veces que podria dividirse el numero, en el ciclo
                int cont=0;
                
                while(cont<3 && comp>=1){
                    if((x % comp) == 0){
                        cont++;
                    }
                    comp--;
                }
                
                //si solo dos residuos(div 0  y div 1) son 0, entonces es primo, de lo contrario no
                if(cont < 3){
                    System.out.println(x + " es primo");
                } else {
                    System.out.println(x + " No es primo");
                }
                break;
            }
            case 6:
            {
                //convertir de horas a semanas,dias,hora
                System.out.println("Conversor de horas a semana-dias-horas");
                int hrs=1000;
                int semanas;
                int dias;
                int auxhoras;
                semanas = hrs/168;
                dias = (hrs -(semanas * 168))/24;
                auxhoras = hrs -(semanas*168) -(dias *24);
                System.out.println(hrs + " horas " + " = " + semanas + " semanas " + dias + " dias " + auxhoras + " horas ");
                break;
            }
            case 7:
            {
                //Valores ax^2+bx+c, a,b,c reales
                double a=1,b=2,c=1;
                //variables para los resultados
                double x1,x2;
                if((Math.sqrt((b*b)-(4*a*c)))>=0){
                    x1=(-b+Math.sqrt((b*b)-(4*a*c)))/(2*a);
                    x2=(-b-Math.sqrt((b*b)-(4*a*c)))/(2*a);
                    System.out.println("Raiz 1: x=" + x1);
                    System.out.println("Raiz 2: x=" + x2);
                } else {
                    System.out.println("Raices imaginarias");
                }
                break;
            }
            default:
                break;
        }
    }
}
