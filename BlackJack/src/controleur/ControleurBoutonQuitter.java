package controleur;

import java.awt.event.ActionEvent;

public class ControleurBoutonQuitter extends ControleurBouton {
    private static final long serialVersionUID = 12L;
    
    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     */
    public ControleurBoutonQuitter(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
    }

    /**
     * actionPerformed : quitte l'application
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
