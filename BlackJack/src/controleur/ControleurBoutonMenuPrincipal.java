package controleur;

import vue.*;

import java.awt.event.*;
import modele.ModeleBlackJack;

public class ControleurBoutonMenuPrincipal extends ControleurBouton {
    private static final long serialVersionUID = 8L;
    protected BlackJackGui vue;
    protected ModeleBlackJack modele;

    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     * @param img : l'image de fond
     * @param v : acces a la vue
     * @param modele : le modele
     */
    public ControleurBoutonMenuPrincipal(int x, int y, int width, int height, String img, BlackJackGui v,ModeleBlackJack modele) {
        super();
    	this.vue = v;
        this.modele = modele;
        setBounds(x, y, width, height);
        setButtonImage(img);
    }

    /**
     * actionPerformed : affiche le menu principal dans la vue
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estActiver){
            modele.setMessage("");
            modele.setQuiterJeu(true);
            vue.afficherAccueil();
            
        }

    }
 }
