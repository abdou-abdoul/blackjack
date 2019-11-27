/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 * RegleDeJeu
 */
public class RegleDeJeu extends Observable{
    private int miseMin;
    private int miseMax;
    private int credit;
    private boolean insuranceAutorise;
    private boolean doubleAutorise;
    private boolean surrenderAutorise;
    private int nbSplitAutorise;
    private int nbPaquetPioche;
    
    /**
     * Constructeur par defaut
     */
    public RegleDeJeu(){
        this.doubleAutorise=this.insuranceAutorise=this.surrenderAutorise=true;
        this.miseMax = 1000;
        this.miseMin = 2;
        this.credit=5000;
        this.nbSplitAutorise = 1;
        this.nbPaquetPioche = 4;  
    }
    
    /**
     * Accesseur de la mise minimum
     * @return la mise minimum
     */
    public int getMiseMin(){
        return this.miseMin;
    }
    
    /**
     * Accesseur de la mise maximum
     * @return la mise maximum
     */
    public int getMiseMax(){
        return this.miseMax;
    }
    
    /**
     * Accesseur du credit
     * @return le credit
     */
    public int getCredit() {
        return this.credit;
    }
     
    /**
     * Accesseur du nombre de paquets constituant la pioche
     * @return le nombre de paquets
     */
    public int getNbPaquetPioche(){
        return this.nbPaquetPioche;
    }
    
    /**
     * Accesseur de l'insuranceAutorise
     * @return la valeur de l'insuranceAutorise
     */
    public boolean getInsuranceAutorise(){
        return this.insuranceAutorise;
    }
    
    /**
     * Accesseur du surrenderAutorise
     * @return la valeur du surrenderAutorise
     */
    public boolean getSurrenderAutorise(){
        return this.surrenderAutorise;
    }
    
    /**
     * Accesseur du doubleAutorise
     * @return la valeur du doubleAutorise
     */
    public boolean getDoubleAutorise(){
        return this.doubleAutorise;
    }
    
    /**
     * Accesseur du nombre de split autorises
     * @return le nombre de split
     */
    public int getNbSplitAutorise(){
        return this.nbSplitAutorise;
    }
    
    /**
     * Mutateur de la mise minimum
     * @param mise : la nouvelle mise
     */
    public void setMiseMin( int mise){
        this.miseMin = mise;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Mutateur de la mise maximum
     * @param mise : la nouvelle mise
     */
    public void setMiseMax(int mise){
        this.miseMax = mise;
        setChanged();
        notifyObservers();
    }

    /**
     * Mutateur du credit
     * @param val : le nouveau credit
     */
    public void setCredit(int val) {
        this.credit = val;
    }
    
    /**
     * Mutateur du nombre de paquets
     * @param nbPaquet: nombre de paquet
     */
    public void setNbPaquetPioche(int nbPaquet){
        this.nbPaquetPioche = nbPaquet;
    }
    
    /**
     * Mutateur de l'insuranceAutorise
     * @param val : la nouvelle valeur
     */
    public void setInsuranceAutorise(boolean val){
        this.insuranceAutorise = val;
    }
    
    /**
     * Mutateur du surrenderAutorise
     * @param val : la nouvelle valeur
     */
    public void setSurrenderAutorise(boolean val){
        this.surrenderAutorise = val;
    }
   
    /**
     * Mutateur du doubleAutorise
     * @param val : la nouvelle valeur
     */
    public void setDoubleAutorise(boolean val){
       this.doubleAutorise = val;
    }
    
    /**
     * Mutateur du nombre de split autorise
     * @param val : la nouvelle valeur
     */
    public void setNbSplitAutorise(int val){
        this.nbSplitAutorise = val;
    }

}
