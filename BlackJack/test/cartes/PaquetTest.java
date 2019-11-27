/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edTestor.
 */
package cartes;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Options
 */
public class PaquetTest {

    public PaquetTest() {
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
     
    @Test
    public void testMethodes(){
         
        /**
         * Test le melange de cartes.
         */
        
        ArrayList<Carte> cartes=new ArrayList<>();
        cartes.add(new Carte(3,Couleur.c));
        cartes.add(new Carte(1,Couleur.d));
        cartes.add(new Carte(2,Couleur.h));
        cartes.add(new Carte(11,Couleur.h));
        cartes.add(new Carte(10,Couleur.h));
        cartes.add(new Carte(8,Couleur.s));
        Paquet paquetDeTest=new Paquet(cartes);
        Paquet paquetTemporaire=new Paquet(cartes);
        paquetDeTest.melanger();
        
        /**
          Probleme dans ce test, copie profonde non accessible pour faire une comparaison apres melange.
        **/ 
        int egal=0;
        Carte carteTemporaire=paquetDeTest.getCartes().get(0);
        for(int i=0;i<5;i++){
            paquetDeTest.melanger();
            egal+=carteTemporaire==paquetDeTest.getCartes().get(0)?1:0;
        }
       assertTrue("resultat "+egal,egal<2);
        
        /**
        * test ajout d'une carte sur le paquet qu'elle soit dans la position souhaite.
        */
        
        Carte carteTest=new Carte(8,Couleur.h);

        paquetDeTest.ajouterDessus(carteTest);
        assertSame(paquetDeTest.cartes.get(0),carteTest);
        paquetDeTest.retirerDessus(Face.RECTO);
        Assert.assertArrayEquals(paquetDeTest.getCartes().toArray(),paquetTemporaire.getCartes().toArray());
        
        /**
        * test ajout d'une carte sous le paquet qu'elle soit dans la position souhaite.
        */
        paquetDeTest.ajouterDessous(carteTest);
        assertSame(carteTest,paquetDeTest.cartes.get(paquetDeTest.cartes.size()-1));
        paquetDeTest.retirerDessous(Face.RECTO);
        assertSame(paquetDeTest.getCartes(),paquetTemporaire.getCartes());
  
     /**
     * test de vide d'un paquet.
     */
        paquetDeTest.vider();
        assertTrue(paquetDeTest.getCartes().isEmpty());
        
    }
    
}
