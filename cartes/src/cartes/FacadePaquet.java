/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

/**
 *
 * @author Options
 */
public class FacadePaquet {

    public FacadePaquet(){}

    public Paquet genererNPaquetCarte52(int nbPaquet) {
        Paquet paquet=new Paquet();
        for(int x=0; x<nbPaquet; x++)
            // hauteur
            for(int i=1; i<=13; i++) 
                // couleur
                for(int j=0; j<4; j++) 	
                    paquet.ajouterDessus(new Carte(i,Couleur.getCouleurFromValue(j)));
        
        return paquet;
    }
  
}
