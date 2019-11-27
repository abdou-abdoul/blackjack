/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartes;

/**
 *
 * @author Abdoul
 */
public enum Couleur {
    h(0), d(1), c(2), s(3);
	
	private int valeur;
	
	private Couleur(int v){
		valeur = v;
	}

	public int getValue() {
		return valeur;
	}
	
	public static Couleur getCouleurFromValue(int valeur){
		switch(valeur) {
		case 0:	return h;
		case 1: return d;
		case 2: return c;
		case 3: return s;
		default: return null;
		}
	}
}
