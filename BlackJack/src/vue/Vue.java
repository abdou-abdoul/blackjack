/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * Vue
 */
public class Vue extends JLabel implements Observer{
    private static final long serialVersionUID = 13;
    /**
     * personnaliserText : changer la police et la couleur
     * @param font : la police
     * @param couleur : la couleur
     */
    public void personnaliserText(Font font,Color couleur ){
        setFont(font);
        setForeground(couleur);
    }
    
    /**
     * Mutateur de l'image de fond du label
     * @param img : la nouvelle image
     */
    public void setLabelImage(String img){
        Image image = new ImageIcon(img).getImage();
        // redimensionne l'image
        int width = this.getWidth();
        int height = this.getHeight();
        image = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        this.setIcon(imageIcon);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * mise a jour de la vue
     */
    public void mettreAJour(){
        revalidate();
        repaint();
    }
    
    public void paintComponent(){}
    
    @Override
    public void update(Observable o, Object arg) {
        paintComponent();
        mettreAJour();
    }
    
}
