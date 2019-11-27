/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdoul
 */
public class ControleurBoutonRegles2 extends ControleurBouton {
    private static final long serialVersionUID = 13L;

    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     */
    public ControleurBoutonRegles2(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
    }

    /**
     * actionPerformed : ouvre une fenetre pop-up avec l'url de l'article wikipedia sur le BlackJack
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("Regles2");
        JOptionPane.showMessageDialog(this, 
				      "Go to https://fr.wikipedia.org/wiki/Blackjack_(jeu)", 
				      "Rules", 
				      JOptionPane.INFORMATION_MESSAGE);
    }
}