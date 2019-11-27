/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edTestor.
 */
package modele;

import cartes.Carte;
import cartes.Couleur;
import cartes.Paquet;
import java.util.ArrayList;
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
public class StrategieCroupierTest {
    
    public StrategieCroupierTest() {
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
     * methode de test.
     */
    @Test
    public void test(){
        
    ArrayList<Carte> cartes=new ArrayList<>();
    cartes.add(new Carte(10,Couleur.h));
    cartes.add(new Carte(1,Couleur.h));
    cartes.add(new Carte(8,Couleur.h));
    Paquet paquet=new Paquet(cartes);
    Paquet defausse=new Paquet();
    
    ArrayList<Carte> cartesMains=new ArrayList<>();
    cartesMains.add(new Carte(3,Couleur.c));
    cartesMains.add(new Carte(1,Couleur.d));
    Paquet paquetMain=new Paquet(cartesMains);
    
    ArrayList<MainBlackJack> mainCroupier=new  ArrayList<>();
    MainBlackJack mainPremiere=new MainBlackJack(paquetMain);
    mainCroupier.add(mainPremiere);
    
    /**
     * Teste la strategie de croupier au hit. 
     */
    JoueurRobot croupier=new JoueurRobot(null,"croupier");
    croupier.setStrategie(new StrategieCroupier(croupier));
    
    croupier.setMain(mainCroupier);
    assertTrue(croupier.indexMainCourant==0);
    croupier.jouer(paquet,defausse);
    //assertTrue(" resultatTest 1 :"+croupier.getMainCourant().getJeu().getCartes().size(),croupier.getMainCourant().getJeu().getCartes().size()==3);
    //assertTrue(" resultatTest 2 :"+croupier.getMainCourant().getValeur(),croupier.getMainCourant().getValeur()==14);
    
    /**
     * Teste la strategie au Stand ou hit.
     */
    croupier.jouer(paquet,defausse);
    //assertTrue(" resultatTest 3 :"+croupier.getMainCourant().getJeu().getCartes().size(), croupier.getMainCourant().getJeu().getCartes().size()==4);
    //assertTrue(" resultatTest 4 :"+croupier.getMainCourant().getValeur(),croupier.getMainCourant().getValeur()==15);
        
    /**
     * Teste la strategie apres second HIT.
     */
    croupier.jouer(paquet,defausse);
    //assertTrue(" resultatTest 5 :"+croupier.getMainCourant().getJeu().getCartes().size(), croupier.getMainCourant().getJeu().getCartes().size()==5);
    //assertTrue(" resultatTest 6 :"+croupier.getMainCourant().getValeur(),croupier.getMainCourant().getValeur()==23);
    }
    
}
