package controleur;

import javax.swing.*;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;

public class ControleurBouton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;
    protected boolean estActiver;
    private final Cursor disabled;
    
    /**
     * Constructeur par defaut
     */
    public ControleurBouton() {
        this.estActiver = true;
        // curseur
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(true);
        // on masque le boutton
        setContentAreaFilled(false);
        setBorderPainted(false);
        // Ajout du bouton comme controleur de lui-meme
        addActionListener(this);
        disabled = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("ressources/cancel.png").getImage(), new Point(12,12), "disabled");
    }

    /**
     * setButtonImage : definir l'image de fond du bouton
     * @param img : l'image de fond
     */
    public void setButtonImage(String img) {
        if(img=="") { return; }
        Image image = new ImageIcon(img).getImage();
        // redimensionne l'image
        int width = this.getWidth();
        int height = this.getHeight();
        image = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        setIcon(imageIcon);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * setBouttonHover : definir l'image de fond lorsque la souris passe sur le bouton
     * @param img1 : l'image lorsque la souris n'est pas sur le bouton
     * @param img2 : l'image lorsque la souris est sur le bouton
     * @param JL_LEGENDE : le label contenant la legende
     * @param legend : la legende qui s'affiche en tant qu'aide lorsque la souris reste immobile sur le bouton
     */
    public void setBouttonHover(String img1, String img2,JLabel JL_LEGENDE,String legend){
        setButtonImage(img1);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setButtonImage(img2);
                JL_LEGENDE.setText(legend); 
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setButtonImage(img1);
                JL_LEGENDE.setText("");
            }
        });
        this.revalidate();
        this.repaint();
    }
    
    /**
     * activer : rend le bouton actif donc cliquable
     * @param img1 son image desactivee.
     * @param img2 son image activee.
     * @param label_legend le label qui va afficher la legende boutton
     * @param legend sa legende.
     */
    public void activer(String img1, String img2,JLabel label_legend,String legend){
        setBouttonHover(img1,img2,label_legend,legend);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setEstActiver(true);
    }
    
    /**
     * desactiver : rend le bouton inactif (incliquable)
     * @param img son image lorsqu'il est desactive.
     */
    public void desactiver(String img){
        this.setCursor(disabled);
        setBouttonHover(img,img,new JLabel(),"");
        setEstActiver(false);
    }
    
    /**
     * setEstActiver : le mutateur de l'attribut estActiver
     * @param val : la nouvelle valeur de EstActiver
     */
    public void setEstActiver(boolean val){
        this.estActiver = val;
    }
    
    /**
     * La redefinition de l'actionPerformed est laissee aux classes derivees
     */
    @Override
    public  void actionPerformed(ActionEvent e) {
    }

}
