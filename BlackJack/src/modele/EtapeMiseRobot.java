/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * EtapeMiseRobot
 */
public class EtapeMiseRobot extends EtapeJeu{
	/**
	 * Constructeur logique
	 * @param modele : acces au modele
	 */
    public EtapeMiseRobot( ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.EtapeMiseRobot;
    }
    
    /**
     * demarrer : demarrer la mise du robot
     */
    @Override
    public synchronized void demarrer(){
        if(modele.getQuiterJeu()){return;}
        // ************************************************************************************************
        // ETAPE MISE DES JOUEURS ROOBOTS
        // ON SUPPRIME LE JOUEURS QUI NE PEUVENT PLUS MISER / ET DONC QUI ONT PERDU
        // ************************************************************************************************
        for(JoueurBlackJack joueur: modele.getJoueurs()){
            if(joueur.aPerdu()){
                continue;
            }
                

            if(!joueur.estHumain()){
                joueur.miserHasard();
                System.out.println("mise: "+joueur.getMainCourant().getMise());
            }
        }
        modele.getMoteurJeu().setEtapeJeu(etapeSuivant);
  
        demarrerEtapeSuivant();
    
    }
}
