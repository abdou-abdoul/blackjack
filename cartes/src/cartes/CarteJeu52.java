/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author ABDOU,CHAPUSOT,DIALLO,GUILBERT 
 */
public class CarteJeu52 extends Carte{


    /**
     * Utilisation d'un tableau de String pour representer la couleur des cartes
     */
    private Couleur[] couleursPermis = {
        Couleur.h,
        Couleur.d,
        Couleur.c,
        Couleur.s
    };
    
    /**
     * Constructeur logique
     * @param hauteur: la hauteur de la carte
     * @param couleur: la couleur de la carte
     */
    public CarteJeu52(int hauteur, Couleur couleur){
        super(hauteur,couleur);
        // Si les valeurs donnees en parametres ne sont pas bons
        // on donne cree une carte aleatoire
        if(!hauteurPermis())
            this.hauteur=new Random().nextInt(13)+1;
        if(!couleurPermis())
            this.couleur=couleursPermis[(new Random().nextInt(4))];
            
    }
    
    /**
     * verifie si la hauteur de l'objet courant est invalide, on en attribue une aleatoirement
     */  
    private boolean hauteurPermis(){
        return this.hauteur>0 && this.hauteur <=13;
    }

    /**
     * verifie si la couleur de l'objet courant est invalide, on en attribue une aleatoirement
     */
    private boolean couleurPermis() {
        return Arrays.asList(couleursPermis).contains(couleur);
        
    }
    
}
