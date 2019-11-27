package controleur;

import modele.*;

import java.awt.event.*;

public class ControleurBoutonDeal extends ControleurBouton {
    private static final long serialVersionUID = 4L;
    protected ModeleBlackJack modele;

    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     * @param img : l'image du bouton
     * @param modele : acces au modele
     */
    public ControleurBoutonDeal(int x, int y, int width, int height, String img, ModeleBlackJack modele) {
        super();
        this.modele = modele;
        setBounds(x, y, width, height);
        setButtonImage(img);
    }

    /**
     * actionPerformed : effectue un Deal si l'action est permise en jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.estActiver){
            System.out.println("deal");
            int mise = modele.getJoueurCourant().getMainCourant().getMise();
            int miseMin = modele.getRegles().getMiseMin();
            int miseMax = modele.getRegles().getMiseMax();
            if( mise >= miseMin && mise <= miseMax ){
                System.out.println(mise);
                modele.joueurSuivant();
                modele.demarrer();
            }else
                modele.setMessage("The bet must be between "+miseMin+" and "+miseMax);
         }else
            modele.setMessage("This action is not yet allowed");
            

         
        
        this.revalidate();
        this.repaint();
        
    }
}
