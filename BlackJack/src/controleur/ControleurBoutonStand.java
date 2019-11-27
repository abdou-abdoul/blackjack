package controleur;

import java.awt.event.*;

import modele.*;

public class ControleurBoutonStand extends ControleurBouton {
    private static final long serialVersionUID = 15L;
    protected ModeleBlackJack modele;

    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     * @param img : l'image de fond du bouton
     * @param modele : acces au modele
     */
    public ControleurBoutonStand(int x, int y, int width, int height, String img, ModeleBlackJack modele) {
        super();
        this.modele = modele;
        setBounds(x, y, width, height);
        setButtonImage(img);
    }

    /**
     * actionPerformed : effectue un Stand si l'action est permise en jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estActiver){
            System.out.println("stand");
            modele.getJoueurCourant().applicationStand();
            if(modele.getJoueurCourant().hasMainSuivant()) {
                modele.getJoueurCourant().mainSuivant();
                modele.demarrer();
            }else{ 
                modele.joueurSuivant();
                modele.demarrer();
            }
        }
        else
            modele.setMessage("This action is not yet allowed");
    }
}
