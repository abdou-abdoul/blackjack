/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import cartes.*;

/**
 * JoueurRobot
 */
public class JoueurRobot extends JoueurBlackJack{
    
    protected Strategie strategie;
    
    /**
     *
     * @param modele : acces au modele
     * @param nom: nom du robot
     */
    public JoueurRobot(ModeleBlackJack modele, String nom) {
        super(modele, nom);
    }
    
    /**
     *
     * @param modele : acces au modele
     * @param nom : nom du robot
     * @param s strategie initiale
     */
    public JoueurRobot(ModeleBlackJack modele, String nom, Strategie s) {
        super(modele, nom);
        strategie = s;
    }

    
    /**
     *
     * @param strategie: la strategie a appliquer
     */
    @Override
    public void setStrategie(Strategie strategie){
        this.strategie = strategie;    
    }
    
    
    /**
     * joue un coup 
     * @param pioche : la pioche
     */            
    @Override
    public synchronized void jouer(Paquet pioche,Paquet defausse) {
        switch(strategie.executer()) {
            case Hit:
                applicationHit(pioche);
                break;
            case Stand:
                applicationStand();
                break;
            case Double:
                applicationDouble(pioche);
                break;
            case DoubleHit:
                if(regles.getDoubleAutorise()) {
                        applicationDouble(pioche);
                    } else {
                            applicationHit(pioche);
                    }
                    break;
            case DoubleStand:
                    if(regles.getDoubleAutorise()) {
                            applicationDouble(pioche);
                    } else {
                            applicationStand();
                    }
                    break;
            case Split:
                    applicationSplit();
                    break;
            case Surrender:
                    applicationSurrender(defausse);
                    break;
       
            default:	
                break;
        }
    }
    
}

