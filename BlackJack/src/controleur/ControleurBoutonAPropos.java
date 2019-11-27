package controleur;

import java.awt.event.*;

import vue.*;

public class ControleurBoutonAPropos extends ControleurBouton {
    private static final long serialVersionUID = 2L;
	protected BlackJackGui vue;

	/**
	 * Constructeur logique
	 * @param x : position x du bouton
	 * @param y : position y du bouton
	 * @param width : largeur du bouton
	 * @param height : longueur du bouton
	 * @param vue : acces a la vue
	 */
    public ControleurBoutonAPropos(int x, int y, int width, int height, BlackJackGui vue) {
        super();
    	this.vue = vue;
        setBounds(x, y, width, height);
    }

    /**
     * actionPerformed : affichage de l'A Propos dans la vue
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("A Propos");
        vue.afficherAPropos();
    }
}
