package controleur;

import modele.*;

import java.awt.event.*;

/**
 * @author 21614263
 */

public class ControleurBoutonMise extends ControleurBouton {
    private static final long serialVersionUID = 9L;
    protected final ModeleBlackJack modele;
    protected int mise;

    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     * @param img : l'image de fond
     * @param mise : la mise associee au bouton
     * @param modele : acces au modele
     */
    public ControleurBoutonMise(int x, int y, int width, int height, String img, int mise, ModeleBlackJack modele) {
        super();
        this.modele = modele;
        this.mise = mise;

        // dimension
        setBounds(x,y,width,height);
        // image
        if(img != "")
            setButtonImage(img);
    }

    /**
     * actionPerformed : ajoute la mise au joueur si l'action est permise en jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estActiver){
            modele.setMessage("");
            if(mise>0) {
                ajouterMise();
            } else {
                modele.getJoueurCourant().miserHasard();
            }
        } else {
            modele.setMessage("This action is not yet allowed");
        }
        
    }

    /**
     * ajouterMise : ajoute la mise associee au bouton au joueur
     */
    protected void ajouterMise(){
        // on regarde si le joueur a assez de credit
        int credit = modele.getJoueurCourant().getCredit();
        // si credit non suffisant
        if(credit < mise)
            return;
        // si la mise dÃ©passe la mise maximale
        int miseJoueurCourant = modele.getJoueurCourant().getMainCourant().getMise();
        int nouvelleMise = miseJoueurCourant+mise;
        int miseMax = modele.getRegles().getMiseMax();
        if(nouvelleMise > miseMax){
            mise = miseMax-miseJoueurCourant;
            nouvelleMise = miseMax; 
        }

        modele.getJoueurCourant().getMainCourant().setMise(nouvelleMise);
        modele.getJoueurCourant().setCredit(credit-mise);

        System.out.println(modele.getJoueurCourant().getNom()+" mise "+mise);
    }
}