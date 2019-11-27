/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import cartes.Carte;
import cartes.Face;
/**
 * EtapeJeuJoueur
 *
 */
public class EtapeJeuJoueur extends EtapeJeu{
    /**
     * Constructeur logique
     * @param modele : acces au modele
     */
	public EtapeJeuJoueur( ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.EtapeJeuJoueur;
    }
    
    /**
     * demarrer l'etape de jeu
     */
    @Override
    public synchronized void demarrer(){
        if(modele.getQuiterJeu()){return;}
        modele.getMoteurJeu().setEtapeJeu(this);
        // apercu dans le termial pour debuger
        System.out.println("-----------------nom joueur: "+modele.getJoueurCourant().getNom());
        System.out.print("    humain: "+modele.getJoueurCourant().estHumain());
        System.out.print("    stand: "+modele.getJoueurCourant().getMainCourant().getStand());
        System.out.print("    perdu: "+modele.getJoueurCourant().getMainCourant().estPerdu());
        System.out.print("    blackjack: "+modele.getJoueurCourant().getMainCourant().estBlackJack());
        System.out.println("    jeu: "+modele.getJoueurCourant().getMainCourant().getJeu().toString());
        //-------------------------------------------------
        // On ne fait pas une boucle ici pour que l'observer
        // puisse acceder a son observé et se mettre a jour
        //-------------------------------------------------
        new Thread(){
            @Override
            public void run() {
                try {
                    // si plus de carte
                    if(modele.getPioche().getCartes().size() < 1){
                        for(Carte carte:modele.getDefausse().getCartes()){
                            carte.setFaceCarte(Face.VERSO);
                            modele.getPioche().ajouterDessous(carte);
                        }
                        modele.getDefausse().vider();
                        modele.getPioche().melanger();
                    }
                    
                    
                    // si il peut plus jouer
                    if(modele.getJoueurCourant().getMainCourant().estBlackJack() || modele.getJoueurCourant().getMainCourant().estPerdu() 
                            || modele.getJoueurCourant().getMainCourant().getStand() || modele.getJoueurCourant().getMainCourant().est21()
                            ||  modele.getJoueurCourant().getMainCourant().getAAbandonner() || modele.getJoueurCourant().getAPerduJeu()){
                        
                        // si le joueur a une autre main
                        if(modele.getJoueurCourant().mainSuivant()){
                            Thread.sleep(2000);
                            demarrer();
                            
                        }
                        // sinon si il y a un joueur suivant on fait joueur suivant
                        else if(modele.joueurSuivant()){
                            Thread.sleep(2000);
                            demarrer();
                        }else{
                            modele.getMoteurJeu().setEtapeJeu(etapeSuivant);
                            Thread.sleep(2000);
                            modele.setMessage(modele.getCroupier().getNom()+" plays");
                            // on affiche les carte du croupier
                            for(Carte carte: modele.getCroupier().getMainCourant().getJeu().getCartes()){
                                carte.setFaceCarte(Face.RECTO);
                            }
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                            Thread.sleep(3000);
                            demarrerEtapeSuivant();

                        }

                    }
                    // sinon
                    else{
                        modele.setMessage(modele.getJoueurCourant().getNom()+" plays");
                        if(!modele.getJoueurCourant().estHumain()){
                            modele.getJoueurCourant().jouer(modele.getPioche(),modele.getDefausse());
                            Thread.sleep(3000);
                            demarrer();
                        }
                        

                    }
                } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }.start();
        
    }
    
    
}
