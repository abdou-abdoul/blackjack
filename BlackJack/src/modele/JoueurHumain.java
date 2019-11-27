/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * JoueurHumain
 */
public class JoueurHumain extends JoueurBlackJack {
    
    /**
     *
     * @param modele : acces au modele
     * @param nom: nom du joueur
     */
    public JoueurHumain(ModeleBlackJack modele, String nom){
        super(modele, nom);
    }
    
    /**
     * 
     * @return estHumain
     */
    @Override 
    public boolean estHumain(){
        return true;
    }
    
    
}
