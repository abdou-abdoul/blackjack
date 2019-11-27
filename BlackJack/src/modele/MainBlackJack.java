/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;
import cartes.*;

/**
 * MainBlackJack
 */
public class MainBlackJack extends Observable implements Observer{
    /**
     * le jeu du joueur
     */
    protected Paquet jeu;
    
    /**
     * la valeur du jeu du joueur
     */
    protected int valeur;
    
    /**
     * la mise du joueur
     */
    protected int mise;
    
    /**
     * si la main du joueur est en stand
     */
    boolean stand = false;
    
    /**
     * si le joueur a abandonner sa main (surrender)
     */
    boolean aAbandonner;
    
    /**
     * constructeur logique
     * @param jeu: le jeu du joueur
     */
    public MainBlackJack(Paquet jeu) {
        this.valeur = 0;
        this.jeu = jeu; 
        this.mise = 0;
        this.jeu.addObserver(this);
        //La main du joueur est initialisee vide
        //le calcul de sa valeur devrait se faire apres qu'il ai eu ses 2 jeu distribuees.
        calculerValeur();    
    }
    
    /**
     * renvoi la valeur de la main
     * @return valeur
     */
    public int getValeur(){  
        return valeur;       
    }
 
    /**
     * renvoi le jeu du joueur 
     * @return jeu 
     */
    public Paquet getJeu(){
        return this.jeu;
    }
    
    /**
     *
     * @return mise
     */
    public int getMise(){
        return this.mise;
    }
    
     /**
     * permet de savoir si le jeu du  joueur a été arreté ou non
     * @return stand 
     */
    public boolean getStand(){
        return this.stand;
    }
    
    /**
     * 
     * @return aPerduJeu
     */
    public boolean getAAbandonner(){
        return aAbandonner;
    }
    
    /**
     * 
     * @param val: si a perdu le jeu 
     */
    public void setAAbandonner(boolean val){
        this.aAbandonner = val;
        setChanged();
	notifyObservers();
    }
    

    /**
     *
     * @param mise: la mise du joueur
     */
    public void setMise(int mise){
        this.mise = mise;
        setChanged();
	notifyObservers();
    }
    
    /**
     *
     * @param val: la valeur du boolean
     */
    public void setStand(boolean val){
        this.stand = val;
        setChanged();
	notifyObservers();
    }
    
    
    /**
     *
     * @param mise: la mise a ajouter
     */
    public void ajouterMise(int mise) {
        setMise(this.mise + mise);
    }

    
    /**
     * modification du jeu du joueur
     * @param jeu: le nouveau jeu
     */
    public void setJeu(Paquet jeu){
        this.jeu = jeu;
        calculerValeur();
        setChanged();
        notifyObservers();
    }
    
    /**
     * calcul la valeur du main du joueur
     */
    private void calculerValeur() {
        int nbCarteAS = 0;
        this.valeur=0;   
        for(Carte carte : jeu.getCartes()){
            int hauteurCarte=carte.getHauteur();
            hauteurCarte = hauteurCarte>10 ? 10 : hauteurCarte;
            
            // on recupere le nombre d'AS du jeu du joeur
            if(hauteurCarte == 1)
                nbCarteAS++;
            
            this.valeur+=hauteurCarte;                    
        }
   
        // calcul de la valeur des jeu "AS"
        for(int i=0;i<nbCarteAS;i++){
            if( this.valeur + 10 <= 21)
                this.valeur+=10; 
            
        }       
    }
   
    
    /**
     * permet de savoir si le joueur peut faire un split
     * @return can split
     */
    public boolean canSplit(){
        if(this.jeu.getCartes().size() != 2){
            return false;
        }
        return this.jeu.getCartes().get(0) == this.jeu.getCartes().get(1);
    }

    /**
     *
     * @return si c'est un blackJack natural
     */
    public boolean estBlackJack() {
        return valeur==21 && this.jeu.getCartes().size()==2;
    }

    /**
     *
     * @return retourne si la main est un 21
     */
    public boolean est21() {
        return valeur==21;    
    }

    /**
     *
     * @return si la main dépasse 21.
     */
    public boolean estPerdu() {
        return valeur>21;    
    }

    /**
     * update : redefinition de l'observer
     */
    @Override
    public void update(Observable o, Object arg) {
        calculerValeur();
        estPerdu();
        est21();
        estBlackJack();
        setChanged();
        notifyObservers();
    }
    

        
}
