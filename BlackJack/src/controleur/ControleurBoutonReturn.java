package controleur;

import java.awt.event.*;

import modele.*;

public class ControleurBoutonReturn extends ControleurBouton {
    private static final long serialVersionUID = 14L;
    protected ModeleBlackJack modele;

    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longeur du bouton
     * @param img : l'image de fond
     * @param modele : acces au modele
     */
    public ControleurBoutonReturn(int x, int y, int width, int height, String img, ModeleBlackJack modele) {
        super();
        this.modele = modele;
        setBounds(x, y, width, height);
        setButtonImage(img);
    }

    /**
     * actionPerformed : reinitialise la mise si l'action est permise en jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estActiver){
            System.out.println("Return");
            modele.getJoueurCourant().getMainCourant().setMise(0);
            modele.setMessage("");
        }
        else
            modele.setMessage("This action is not yet allowed");
    }
}
