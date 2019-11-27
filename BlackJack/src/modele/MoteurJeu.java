/*
 * To change modele license header, choose License Headers in Project Properties.
 * To change modele template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.util.Observable;

/**
 * MoteurJeu
 */
public class MoteurJeu extends Observable{
    
    private ModeleBlackJack modele;
    
    /**
     * L'etape courant du etapeJeu
     * pour permettre de reprendre l'etape lorsqu'un humain ai fini de jouer
     */
    private EtapeJeu etapeJeu;
    
    /**
     * Constructeur logique
     * @param modele : acces au modele
     */
    public MoteurJeu(ModeleBlackJack modele){
        this.modele=modele;
        modele.getPioche().melanger();
        EtapeJeu tourSuivant = new EtapeTourSuivant(modele);
        EtapeJeu miseRobot = new EtapeMiseRobot(modele);
        EtapeJeu miseHumain = new EtapeMiseHumain(modele);
        EtapeJeu distribution =  new EtapeDistributionCarte(modele);
        EtapeJeu jeuJoueur = new EtapeJeuJoueur(modele);
        EtapeJeu jeuCroupier = new EtapeJeuCroupier(modele);
        EtapeJeu gain = new EtapeAttributionGain(modele);
        
        tourSuivant.setEtapeSuivant(miseRobot);
        miseRobot.setEtapeSuivant(miseHumain);
        miseHumain.setEtapeSuivant(distribution);
        distribution.setEtapeSuivant(jeuJoueur);
        jeuJoueur.setEtapeSuivant(jeuCroupier);
        jeuCroupier.setEtapeSuivant(gain);
        gain.setEtapeSuivant(tourSuivant);
        
        this.etapeJeu = tourSuivant;
        
    }
    
    /**
     * Accesseur de modele
     * @return le modele
     */
    public ModeleBlackJack getModele(){
        return modele;
    }
    
    /**
     * Accesseur de l'etape de jeu
     * @return l'etape de jeu
     */
    public EtapeJeu getEtapeJeu(){
        return etapeJeu;
    }
    
    /**
     * Mutateur de l'etape de jeu
     * @param etapeJeu : la nouvelle etape de jeu
     */
    public  void setEtapeJeu(EtapeJeu etapeJeu) {
        this.etapeJeu = etapeJeu;
        setChanged();
        notifyObservers();
    }
    
    /**
     * demarre le moteur de jeu
     */
    public void demarrer()  {
        etapeJeu.demarrer();

    }
  
 
     
}
