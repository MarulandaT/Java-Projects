/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcontrolador;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import pmodelo.PiezaBarco;

/**
 *
 * @author l_mar
 */
public class Disparo {
    private int ticks = 50; //Numero de movimientos con el que se inicializa el juego
    private int puntaje = 0; //Puntos Acumulados
    private Clip clip; //Sonido por emitir
    private final String path = "/pcontrolador/"; //Ruta para el sonido
    
    
    public Disparo(){
    }
    
    /**
     * Verificar que ha pasado en el tablero tras dar un 'disparo'.
     * @param matriz1
     * @param matriz2
     * @param px
     * @param py 
     */
    public void Actualizar(Object[][] matriz1, Object[][] matriz2, int px, int py) {
        int conversionx;
        int conversiony;
        conversionx = (int)((px-518)/33);
        conversiony = (int)((py-35)/33);
        if(this.getTicks() > 0){
            if (matriz2[conversionx][conversiony].getClass().getName().equals("pmodelo.PiezaBarco")
                    && !((PiezaBarco)matriz2[conversionx][conversiony]).pDestruida()) {
                ((PiezaBarco)matriz2[conversionx][conversiony]).Destruido();
                dalePlay("bomba");

            } else if ((int)matriz2[conversionx][conversiony] == 0) {
                matriz2[conversionx][conversiony] = 1;
                dalePlay("bombamal");
            } else if (matriz2[conversionx][conversiony].getClass().getName().equals("pmodelo.PiezaBarco")
                    && ((PiezaBarco)matriz2[conversionx][conversiony]).pDestruida()) {
                 ((PiezaBarco)matriz2[conversionx][conversiony]).Destruido();
                System.out.println(conversionx+" "+conversiony);
            } 
            
        this.ticks--;
        this.puntaje++;
        esTurnoPc(matriz1);
        }
    }
    
    /**
     * Darle el turno al pc pasandole la matriz que le corresponde
     * @param matriz 
     */
    public void esTurnoPc(Object[][] matriz) {
        int pcx = (int)(Math.random() * 15);
        int pcy = (int)(Math.random() * 15);
        if (matriz[pcx][pcy].getClass().getName().equals("pmodelo.PiezaBarco")
                    && !((PiezaBarco)matriz[pcx][pcy]).pDestruida()) {
                ((PiezaBarco)matriz[pcx][pcy]).Destruido();
                System.out.println(pcx+" "+pcy);
                
            } else if ((int)matriz[pcx][pcy] == 0) {
                matriz[pcx][pcy] = 1;
                
            } else if (matriz[pcx][pcy].getClass().getName().equals("pmodelo.PiezaBarco")
                    && ((PiezaBarco)matriz[pcx][pcy]).pDestruida()) {
                 ((PiezaBarco)matriz[pcx][pcy]).Destruido();
                
            }
        
    }
    
    /**
     * Obtener los movimientos restantes
     * @return 
     */
    public int getTicks() {
        return this.ticks;
    }
  
    /**
     * Obtener el puntaje que se ha obtenido
     * @return 
     */
    public int getPuntaje(){
        return this.puntaje;
    }
    
    /**
     * Sonar cuando se dispare
     * @param value 
     */
    public void dalePlay(String value){
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path+value+".wav")));
            clip.loop(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
