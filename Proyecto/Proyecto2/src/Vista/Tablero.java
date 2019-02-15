package Vista;

import Modelo.PiezaBarco;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;


public class Tablero extends JPanel implements MouseListener{
    private BufferedImage tableroImage;
    private Object[][] matriz;
    private Object[][] matriz2;
    private int ticks = 21;
    private int puntaje = 0;
    private Clip clip;
    private String path = "/Vista/";
    
    /*
    * Default constructor. Uses an empty array
    */
   public Tablero() {
           this(new Object[15][15], new Object[15][15], "gridLabels.png");
   }

   /*
    * Constructor that takes an array
    */
   public Tablero(Object[][] arr, Object[][] arr2) {
           this(arr, arr2, "gridLabels.png");
   }

   /*
    * constructor that takes an array and a file path.
    */
   public Tablero(Object[][] arr, Object[][] arr2, String path) {
           matriz = arr;
           matriz2 = arr2;
          
           try {
                   tableroImage = ImageIO.read(new File(path));
           } catch (IOException e) {
                   System.out.println("Failed to load image");
           }
   }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawImage(tableroImage, 0, 0, this);
        g2.drawImage(tableroImage, 506, 0, this);

        for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    
                    int px = (2+(33*i));
                    int py = (2+(33*j));
                    if(matriz[i][j].getClass().getName().equals("Modelo.PiezaBarco")){
                        g2.drawImage(((PiezaBarco) matriz[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz[i][j] == 0) {
                        g2.drawImage(new ImageIcon("agua.png").getImage(), px, py, this);
                    } else if (this.matriz[i][j].getClass().getName().equals("Modelo.PiezaBarco")
                        && ((PiezaBarco)this.matriz[i][j]).pDestruida()) {
                        g2.drawImage(((PiezaBarco) matriz[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz[i][j] == 1) {
                        g2.drawImage(new ImageIcon("tirofail.png").getImage(), px, py, this);
                    }
                }
        }
        
        for (int i = 0; i < matriz2.length; i++) {
                for (int j = 0; j < matriz2[i].length; j++) {
                    
                    int px = (506+2+(33*i));
                    int py = (2+(33*j));
                    if(matriz2[i][j].getClass().getName().equals("Modelo.PiezaBarco")){
                        g2.drawImage(((PiezaBarco) matriz2[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz2[i][j] == 0) {
                        g2.drawImage(new ImageIcon("agua.png").getImage(), px, py, this);
                    } else if (this.matriz2[i][j].getClass().getName().equals("Modelo.PiezaBarco")
                        && ((PiezaBarco)this.matriz2[i][j]).pDestruida()) {
                        g2.drawImage(((PiezaBarco) matriz2[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz2[i][j] == 1) {
                        g2.drawImage(new ImageIcon("tirofail.png").getImage(), px, py, this);
                    }
                }
        }

    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        int conversionx;
        int conversiony;
        
        if (this.getTicks() > 0) {
            if (e.getClickCount() == 2){
                if (e.getX() > 516 && e.getX() < 1012) {
                    if (e.getY() > 10 && e.getY() < 526) {
                            conversionx = (int)((e.getX()-518)/33);
                            conversiony = (int)((e.getY()-35)/33);
                            if (this.matriz2[conversionx][conversiony].getClass().getName().equals("Modelo.PiezaBarco")
                                    && !((PiezaBarco)this.matriz2[conversionx][conversiony]).pDestruida()) {
                                ((PiezaBarco)this.matriz2[conversionx][conversiony]).Destruido();
                                dalePlay("bomba");
                                repaint();
                            } else if ((int)this.matriz2[conversionx][conversiony] == 0) {
                                this.matriz2[conversionx][conversiony] = 1;
                                dalePlay("bombamal");
                                repaint();
                            } else if (this.matriz2[conversionx][conversiony].getClass().getName().equals("Modelo.PiezaBarco")
                                    && ((PiezaBarco)this.matriz2[conversionx][conversiony]).pDestruida()) {
                                 ((PiezaBarco)this.matriz2[conversionx][conversiony]).Destruido();
                                System.out.println(conversionx+" "+conversiony);
                                repaint();
                            }
                            this.ticks--;
                            this.puntaje++;
                            esTurnoPc();
                    }
                }
            }
        }
    }
    
    public void esTurnoPc() {
        int pcx = (int)(Math.random() * 15);
        int pcy = (int)(Math.random() * 15);
        if (this.matriz[pcx][pcy].getClass().getName().equals("Modelo.PiezaBarco")
                    && !((PiezaBarco)this.matriz[pcx][pcy]).pDestruida()) {
                ((PiezaBarco)this.matriz[pcx][pcy]).Destruido();
                System.out.println(pcx+" "+pcy);
                repaint();
            } else if ((int)this.matriz[pcx][pcy] == 0) {
                this.matriz[pcx][pcy] = 1;
                repaint();
            } else if (this.matriz[pcx][pcy].getClass().getName().equals("Modelo.PiezaBarco")
                    && ((PiezaBarco)this.matriz[pcx][pcy]).pDestruida()) {
                 ((PiezaBarco)this.matriz[pcx][pcy]).Destruido();
                repaint();
            }
        
    }
    
    @Override 
    public void mouseClicked(MouseEvent e){
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    public int getTicks() {
        return this.ticks;
    }
  
    public int getPuntaje(){
        return this.puntaje;
    }
    
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