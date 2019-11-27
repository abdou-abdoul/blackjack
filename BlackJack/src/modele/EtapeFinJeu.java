/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * EtapeFinJeu : l'etape de fin de jeu
 */
public class EtapeFinJeu extends EtapeJeu{
	/**
	 * Constructeur logique
	 * @param modele : acces au modele
	 */
    public EtapeFinJeu( ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.fin;
    }
    
    /**
     * demarrer : demarrer l'etape de fin de jeu
     */
    @Override
    public void demarrer(){
        System.out.println("fin du jeu");
        modele.getMoteurJeu().setEtapeJeu(this);
    
    }
}
