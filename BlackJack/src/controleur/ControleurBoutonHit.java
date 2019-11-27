package controleur;

import modele.*;

import java.awt.event.*;

public class ControleurBoutonHit extends ControleurBouton {
    private static final long serialVersionUID = 6L;
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
    public ControleurBoutonHit(int x, int y, int width, int height, String img, ModeleBlackJack modele) {
        super();
        this.modele = modele;
        setBounds(x, y, width, height);
        setButtonImage(img);
    }

    /**
     * actionPerformed : effectue un Hit si l'action est permise en jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estActiver){
            System.out.println("Hit: "+modele.getJoueurCourant().getMainCourant().getJeu().toString());
            modele.getJoueurCourant().applicationHit(modele.getPioche());
            
            if( modele.getJoueurCourant().getMainCourant().estBlackJack() || modele.getJoueurCourant().getMainCourant().est21() || modele.getJoueurCourant().getMainCourant().estPerdu()) {
                if(modele.getJoueurCourant().hasMainSuivant()){
                    modele.getJoueurCourant().mainSuivant();
                }
                else{ 
                    modele.joueurSuivant();
                }
                modele.demarrer();
            }
        }
        else
            modele.setMessage("This action is not yet allowed");
    }
}
