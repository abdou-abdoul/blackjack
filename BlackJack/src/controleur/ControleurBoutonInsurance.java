package controleur;

import java.awt.event.*;

import modele.*;

public class ControleurBoutonInsurance extends ControleurBouton {
    private static final long serialVersionUID = 7L;
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
    public ControleurBoutonInsurance(int x, int y, int width, int height, String img, ModeleBlackJack modele) {
        super();
        this.modele = modele;
        setBounds(x, y, width, height);
        setButtonImage(img);
    }

    /**
     * actionPerformed : effectue Insurance si l'action est permise en jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estActiver){
            JoueurBlackJack joueur = modele.getJoueurCourant();
            System.out.println("assurance");
            if(joueur.estAssure()){
               joueur.setAssurance(false);
               int mise = joueur.getMainCourant().getMise()*2;
               joueur.getMainCourant().setMise(mise);
            }
            else{joueur.applicationInsurance();}
        }
        else
            modele.setMessage("This action is not yet allowed");
        
    }
    
}
