/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * EtapeJeu : super-classe des etapes du jeu
 */
public abstract class EtapeJeu {
    
    protected EtapeJeu etapeSuivant;
    protected ModeleBlackJack modele;
    protected EnumEtapeJeu etape;
    
    public void demarrer(){}
    
    /**
     * Mutateur de l'etape suivante
     * @param etapeSuivant : l'etape suivante
     */
    public final void setEtapeSuivant(EtapeJeu etapeSuivant){
        this.etapeSuivant = etapeSuivant;
    }
    
    public final void demarrerEtapeSuivant(){etapeSuivant.demarrer();}
    public final EnumEtapeJeu getEtape(){return etape;}
}
