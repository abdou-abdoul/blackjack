package controleur;

import java.awt.event.ActionEvent;

import vue.*;

public class ControleurBoutonOptions extends ControleurBouton {
    private static final long serialVersionUID = 11L;
    private BlackJackGui vue;
    
    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     * @param vue : acces a la vue
     */
    public ControleurBoutonOptions(int x, int y, int width, int height, BlackJackGui vue) {
        super();
        setBounds(x, y, width, height);
        this.vue = vue;
    }

    /**
     * actionPerformed : affiche les options dans la vue
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        vue.afficherOptions();
    }
}
