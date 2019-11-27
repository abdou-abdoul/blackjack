/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import modele.ModeleBlackJack;

/**
 * VueMessageJeu
 */
public class VueMessageJeu extends Vue{
    private static final long serialVersionUID = 10;
    private ModeleBlackJack modele;
    /**
     * temps d'afficharge de la vue
     */
    private int time;

    /**
     * Constructeur logique
     * @param posX: position x
     * @param posY: position y
     * @param width: largeur
     * @param height: hauteur
     * @param modele: le modele
     * @param time : temps d'afficharge de la vue
     * @param bg: de fond
     */
    public VueMessageJeu(int posX, int posY,int width,int height,ModeleBlackJack modele,int time,Color bg){
        setBounds(posX, posY, width, height);
        this.modele = modele;
        this.time = time;
        modele.addObserver(this);
        this.setOpaque(true);
        this.setBackground(bg);
        paintComponent();
    }
    
    @Override
    public void paintComponent(){
        this.setText(modele.getMessage());
        Vue panel = this;
        if(modele.getMessage()!=""){
            this.setText(modele.getMessage());
            this.setVisible(true);
            this.mettreAJour();
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(time);
                        modele.setMessage("");
                        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start(); 
            
        }else
            panel.setVisible(false);
        //System.out.println("messagiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");   
      
        
   }
    
}
