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
public class FacadePaquetTest {
    
    public FacadePaquetTest() {
        
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
    public void facadePaquet(){
        FacadePaquet facadeTemporaire=new FacadePaquet();
        Paquet paquet=facadeTemporaire.genererNPaquetCarte52(3);
        assertTrue(paquet.cartes.size()==52*3);
    }
    
}
