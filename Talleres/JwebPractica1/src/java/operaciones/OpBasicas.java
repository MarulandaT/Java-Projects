/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

/**
 *
 * @author l_mar
 */
public class OpBasicas {
    
    public static int suma(String num1, String num2){
        int v1 = Integer.parseInt(num1);
        int v2 = Integer.parseInt(num2);
        return (v1+v2);
    }
    
    public static int resta(String num1, String num2){
        int v1 = Integer.parseInt(num1);
        int v2 = Integer.parseInt(num2);
        return (v1-v2);
    }
    
    public static int producto(String num1, String num2){
        int v1 = Integer.parseInt(num1);
        int v2 = Integer.parseInt(num2);
        return (v1*v2);
    }
    
    public static int division(String num1, String num2){
        if(Integer.parseInt(num2) == 0){
            return 0;
        } else {
            int v1 = Integer.parseInt(num1);
            int v2 = Integer.parseInt(num2);
            return (v1/v2);
        }
    }
    
    public static int residuo(String num1, String num2){
        if(Integer.parseInt(num2) == 0){
            return 0;
        } else {
            int v1 = Integer.parseInt(num1);
            int v2 = Integer.parseInt(num2);
            return (v1%v2);
        }
    }
}
