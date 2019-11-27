/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import cartes.Carte;

/**
 * EtapeTourSuivant
 */
public class EtapeTourSuivant extends EtapeJeu{
    /**
     * Constructeur logique
     * @param modele : acces au modele
     */
	public EtapeTourSuivant( ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.EtapeTourSuivant;
    }
    
	/**
	 * demarrer : demarrer le tour suivant
	 */
    @Override
    public synchronized void demarrer(){
        if(modele.getQuiterJeu()){return;}
        
        modele.setIndexJoueurCourant(0);
        // nombre de joueur en jeu ( croupier y compris)
        int joueurEnJeu = 0;
        // on ajoute le croupier parmi le joueurs qu'on enlevra ensuite
        modele.getJoueurs().add( modele.getCroupier());
        for(JoueurBlackJack joueur: modele.getJoueurs()){
            // regarde si le joueur a perdu
            System.out.println(joueur.getNom()+":"+joueur.getCredit()+":"+modele.getRegles().getMiseMin());
            if(joueur.getCredit()>=modele.getRegles().getMiseMin()){
                joueurEnJeu++;
            }else{
                joueur.setAPerduJeu(true);
                System.out.println(joueur.getNom()+"a perdu");
            }
            joueur.setAssurance(false);
            // on remet le main courant à 0;
            joueur.setIndexMainCourant(0);
            // on defausse les catres du joueur
            for(Carte carte: joueur.getMains().get(0).getJeu().getCartes()){
                modele.getDefausse().ajouterDessus(carte);
            }
            // on remet à 0 le gain du joueur pour le tour suivant
            joueur.setGain(0);
            // on reinintialise la main 1 du joueur 
            joueur.getMainCourant().getJeu().vider();
            joueur.getMainCourant().setStand(false);
            joueur.getMainCourant().setMise(0);
            joueur.getMainCourant().setAAbandonner(false);
  
            // on supprime les autres mains;
            for(int i= 1;i<joueur.getMains().size();i++){
                joueur.getMains().get(i).deleteObservers();
                joueur.getMains().remove(i);
            }
        }
        modele.getJoueurs().remove(modele.getJoueurs().size()-1);
        modele.setCroupierJoue(false);
        if(joueurEnJeu==1){
            setEtapeSuivant(new EtapeFinJeu(modele));
        }
        modele.setNbJoueursEnJeu(joueurEnJeu);
        modele.getMoteurJeu().setEtapeJeu(etapeSuivant);
        demarrerEtapeSuivant();
    }
}
    
