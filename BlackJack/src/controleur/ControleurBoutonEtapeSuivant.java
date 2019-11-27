/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import modele.ModeleBlackJack;

/**
 *
 * @author Abdoul
 */
public class ControleurBoutonEtapeSuivant extends ControleurBouton {
    private static final long serialVersionUID = 1L;
    protected ModeleBlackJack modele;
    
    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     * @param img : l'image de fond
     * @param modele : acces au modele
     */
    public ControleurBoutonEtapeSuivant(int x, int y, int width, int height, String img, ModeleBlackJack modele) {
        super();
        this.modele = modele;
        setBounds(x, y, width, height);
        setButtonImage(img);
    }
    
    /**
     * actionPerformed : demarre l'etape suivante du jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        modele.demarrer();
        this.remove(this);
    }
}
