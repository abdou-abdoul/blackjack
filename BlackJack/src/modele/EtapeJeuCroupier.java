/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import cartes.Carte;
import cartes.Face;

/**
 * EtapeJeuCroupier
 */
public class EtapeJeuCroupier extends EtapeJeu{
    /**
     * Constructeur logique
     * @param modele : acces au modele
     */
    public EtapeJeuCroupier( ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.EtapeJeuCroupier;
    }
    
    /**
     * demarrer : demarer l'etape de jeu du croupier
     */
    @Override
    public synchronized void demarrer(){
        new Thread(){
            @Override
            public void run() {
                try {
                    if(modele.getQuiterJeu()){return;}
                    // si plus de carte
                    if(modele.getPioche().getCartes().size() < 1){
                        for(Carte carte:modele.getDefausse().getCartes()){
                            carte.setFaceCarte(Face.VERSO);
                            modele.getPioche().ajouterDessous(carte);
                        }
                        modele.getDefausse().vider();
                        modele.getPioche().melanger();
                    }
                    
                    // si joueur croupier peut plus jouer
                    if( modele.getCroupier().getMainCourant().estBlackJack() || modele.getCroupier().getMainCourant().estPerdu() 
                            || modele.getCroupier().getMainCourant().getStand() || modele.getCroupier().getMainCourant().est21() ) {
                        modele.getMoteurJeu().setEtapeJeu(etapeSuivant);
                        modele.setMessage("Payment step");
                        modele.setIndexJoueurCourant(0);
                        for(JoueurBlackJack j:modele.getJoueurs()){
                            j.setIndexMainCourant(0);
                        }
                        Thread.sleep(3000);
                        demarrerEtapeSuivant();
                    }
                    else{
                        
                        modele.getCroupier().jouer(modele.getPioche(),modele.getDefausse());
                        Thread.sleep(3000);
                        demarrer();
                    }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }.start();
    
    }
}
