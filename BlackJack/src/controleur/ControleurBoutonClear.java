package controleur;

import java.awt.event.*;

import modele.*;

public class ControleurBoutonClear extends ControleurBouton {
    private static final long serialVersionUID = 3L;
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
	public ControleurBoutonClear(int x, int y, int width, int height, String img, ModeleBlackJack modele) {
		super();
		this.modele = modele;
		setBounds(x, y, width, height);
		setButtonImage(img);
	}
	
	/**
	 * actionPerformed : effectue un Clear si m'action est permise en jeu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
            if(this.estActiver){
                System.out.println("clear");
                JoueurBlackJack joueur = modele.getJoueurCourant();
                int credit = modele.getJoueurCourant().getCredit();
                int mise= modele.getJoueurCourant().getMainCourant().getMise();
                joueur.setCredit(credit + mise);
                joueur.getMainCourant().setMise(0);
                modele.setMessage("");
            }
            else
                modele.setMessage("This action is not yet allowed");
           
	}
}
