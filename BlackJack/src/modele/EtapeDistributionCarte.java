/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import cartes.Carte;
import cartes.Face;

/**
 * EtapeDistributionCarte : l'etape de distribution des cartes
 */
public class EtapeDistributionCarte extends EtapeJeu{
	/**
	 * Constructeur logique
	 * @param modele : acces au modele
	 */
    public EtapeDistributionCarte( ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.EtapeDistributionCarte;
    }

    /**
     * demarrer : demarrer l'etape de distribution des cartes
     */
    @Override
    public synchronized void demarrer(){
        //modele.distribuerCarte();
        new Thread(){
            @Override
            public void run() {
                try {
                    if(modele.getQuiterJeu()){return;}
                    // si assez de cartes pour tous les joueurs
                    if(modele.getPioche().getCartes().size()>modele.getNbJoueursEnJeu()*2){
                        // distribue les cartes des joueurs
                        for(int i=0;i<2;i++){
                            for(int j=0;j<modele.getJoueurs().size();j++){
                                modele.setIndexJoueurCourant(j);
                                JoueurBlackJack joueur = modele.getJoueurCourant();
                                // si le joueur n'a pas perdu
                                if(!joueur.getAPerduJeu()){
                                    joueur.getMainCourant().getJeu().ajouterDessus(modele.getPioche().retirerDessus(Face.RECTO));
                                    Thread.sleep(10);
                                }
                            }

                        }

                        modele.setCroupierJoue(true);
                        // distribue les cartes du croupier;
                        modele.getCroupier().getMainCourant().getJeu().ajouterDessus(modele.getPioche().retirerDessus(Face.RECTO));
                        modele.getCroupier().getMainCourant().getJeu().ajouterDessus(modele.getPioche().retirerDessus(Face.VERSO));
                        modele.setIndexJoueurCourant(0);
                        modele.setCroupierJoue(false);
                        demarrerEtapeSuivant();
                        

                    }
                    // sinon on remplie la pioche avec les cartes de la defausse
                    else{
                        for(Carte carte:modele.getDefausse().getCartes()){
                            carte.setFaceCarte(Face.VERSO);
                            modele.getPioche().ajouterDessous(carte);
                        }
                        modele.getDefausse().vider();
                        modele.getPioche().melanger();
                        demarrer();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return;
    
    }
}
