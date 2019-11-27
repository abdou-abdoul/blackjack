/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Panneau : super-classe des panneaux
 */
public class Panneau extends JPanel{
    
    private static final long serialVersionUID = 888;
    
    protected Image IMG_FOND;
    
    /**
     * Constructeur par defaut
     */
    public Panneau(){
       setLayout(null);
       setSize(new Dimension(1282,760));
    }
    
    /**
     * Constructeur logique
     * @param fond : l'image de fond
     */
    public Panneau(String fond){
       IMG_FOND = new ImageIcon(fond).getImage();
       setLayout(null);
       setSize(new Dimension(1282,760));
    }
    
    /**
     * Mutateur de l'image de fond
     * @param bg: l'image de fond
     */
    public void setBackground(Image bg){
        this.IMG_FOND = bg;
    }
    
    /**
     * mise a jour de la vue
     */
    public void mettreAJour(){
        revalidate();
        repaint();
    }
    

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(IMG_FOND, 0, 0,1282 ,760 , this);
    }  
}
