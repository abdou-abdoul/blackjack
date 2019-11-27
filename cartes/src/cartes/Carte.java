/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

import java.util.Observable;

/**
 *
 * @author ABDOU,CHAPUSOT,DIALLO,GUILBERT 
 */
public class Carte extends Observable{
    
    protected int hauteur;
    protected Couleur couleur;
    protected Face faceCarte;
    
    public Carte(int hauteur,Couleur couleur){
        this.couleur = couleur;
        this.hauteur = hauteur;
        this.faceCarte = Face.VERSO;
    }
    
    public int getHauteur(){
        return this.hauteur;
    }
    
    public Couleur getCouleur(){
         return this.couleur;
    }
    
    public Face getFaceCarte(){
        return this.faceCarte;
    }
    
    public void setHauteur(int hauteur){
        this.hauteur = hauteur;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setCouleur(Couleur couleur){
        this.couleur = couleur;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setFaceCarte(Face faceCarte){
        this.faceCarte = faceCarte;
        this.setChanged();
        this.notifyObservers();
    }
            
}
