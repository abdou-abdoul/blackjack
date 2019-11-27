/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edTestor.
 */
package cartes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Options
 */
public class CarteTest {
    
    public static Carte carte;
    
    public CarteTest() {    
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Teste les methodes du jeu de 52 cartes.
     */
    @Test
    public final void verifieMethodes(){
        final int valeur=12;
        final Couleur couleur=Couleur.c;
        carte = new Carte(valeur,couleur);
        final Carte carteBis = new Carte(valeur,couleur);
        assertSame(carte.getHauteur(),carteBis.getHauteur());
        assertSame(carte.getCouleur(),carteBis.getCouleur());
    }
    
}
