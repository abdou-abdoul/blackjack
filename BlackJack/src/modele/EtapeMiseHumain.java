/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * EtapeMiseHumain
 */
public class EtapeMiseHumain extends EtapeJeu{
	/**
	 * Constructeur logique
	 * @param modele : acces au modele
	 */
    public EtapeMiseHumain(ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.EtapeMiseHumain;
    }
    
    /**
     * demarrer : demarrer la mise humain
     */
    @Override
    public synchronized void demarrer(){
        if(modele.getQuiterJeu()){return;}
        //-------------------------------------------------
        // On ne fait pas une boucle ici pour que l'observer
        // puisse acceder a son observé et se mettre a jour
        //-------------------------------------------------
        if(modele.getJoueurCourant().getMainCourant().getMise() == 0 && modele.getJoueurCourant().estHumain() && !modele.getJoueurCourant().aPerdu()){
            modele.setMessage(modele.getJoueurCourant().getNom()+" put your bet");
            return;
        }

        // on fait joueur suivant tant que le joueur courant n'est pas humain
        while(modele.hasJoueurSuivant() && !modele.getJoueurCourant().estHumain()){
            modele.joueurSuivant();
        }
        // 
        if(modele.getJoueurCourant().getMainCourant().getMise() == 0 && modele.getJoueurCourant().estHumain()&& !modele.getJoueurCourant().aPerdu()){
            modele.setMessage(modele.getJoueurCourant().getNom()+" put your bet");
            return;
        }

        modele.getMoteurJeu().setEtapeJeu(etapeSuivant);
        modele.setIndexJoueurCourant(0);
        demarrerEtapeSuivant();
        if(modele.getQuiterJeu()){return;}
    }
}
