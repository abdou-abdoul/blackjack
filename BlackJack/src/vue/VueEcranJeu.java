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
 * 
 * @author 21003711
 */
public class VueEcranJeu extends JPanel{
    
    private static final long serialVersionUID = 888;
    
    private Image IMG_FOND;
    /**
     * Constructeur logique
     * @param fond : l'image de fond
     */
    public VueEcranJeu(String fond){
       IMG_FOND = new ImageIcon(fond).getImage();
       setLayout(null);
       setSize(new Dimension(1282,760));
    }
   
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(IMG_FOND, 0, 0,1282 ,760 , this);
        repaint();
        revalidate();
    }  
}
