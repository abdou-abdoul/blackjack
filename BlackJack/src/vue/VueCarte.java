/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Carte;
import cartes.Face;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * VueCarte
 */
public class VueCarte extends JPanel implements Observer{
    private static final long serialVersionUID = 13;
    private Carte carte;
    private String versoCarte;
    
    /**
     * Constructeur logique
     * @param posX : position x de la vue
     * @param posY : position y de la vue
     * @param width : largeur de la vue
     * @param height : longueur de la vue
     * @param carte : acces a la carte
     * @param versoCarte : ressource verso de la carte
     */
    public VueCarte(int posX, int posY,int width,int height,Carte carte,String versoCarte){
        this.carte = carte;
        this.versoCarte = versoCarte;
        this.setBounds(posX, posY, width, height);
        carte.addObserver(this);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        if(carte.getFaceCarte() == Face.RECTO){
            Image IMG_FOND = new ImageIcon("ressources/"+carte.getHauteur()+carte.getCouleur()+".png").getImage();
            g.drawImage(IMG_FOND, 0, 0,getWidth() ,getHeight() , this);
        }else{
            Image IMG_FOND = new ImageIcon("ressources/"+versoCarte).getImage();
            g.drawImage(IMG_FOND, 0, 0,getWidth() ,getHeight() , this);
        }     
    }

    @Override
    public void update(Observable o, Object arg) {
        revalidate();
        repaint();
    }

}
