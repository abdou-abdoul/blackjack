/*
 * To change controleur license header, choose License Headers in Project Properties.
 * To change controleur template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import modele.*;
import vue.BlackJackGui;
/**
 *
 * @author 21003711
 */
public class Main {

    /**
     *
     * @param args: agruments
     */
    public static void main(String[] args) {
//        System.out.println("quelques tests!");
//        if(args.length>0){
//            System.err.println(" Usage  : BlackJack.jar ");
//        }
//        // creation d'un paquet vide
//        Paquet paquet1 = new Paquet();
//
//        // ajout de carte dans le paquet vide
//        paquet1.ajouterDessus(new CarteBlackJack(1,"c"));
//        paquet1.ajouterDessus(new CarteBlackJack(8,"c"));
//        paquet1.ajouterDessus(new CarteBlackJack(1,"c"));
//        
//
//        // creation d'un paquet de 52 cartes
//        Paquet paquet52 = new Paquet();
//        for(int i=1; i<=13; i++) {	// hauteur
//            for(int j=0; j<4; j++) {	// couleur
//                paquet52.ajouterDessus(new CarteBlackJack(i,CarteBlackJack.valeurCouleur[j]));
//            }
//        }
//
//
//        // paquet qui va contenir les cartes du defausse
//        Paquet defausse = new Paquet();
//
//        // affichage
//        System.out.println("Paquet1: ==> "+paquet1.toString());
//        System.out.println("------------------------------------------ ");
//        //System.out.println("Paquet52: ==> "+paquet52.toString());
//        
//        MainBlackJack main1 = new MainBlackJack(paquet1);
//        CarteAbstraite carte1 = new CarteBlackJack(2,"c");
//        // ajout d'une carte en main
//        main1.getJeu().ajouterDessous(carte1);
//        main1.getJeu().melanger();
//        System.out.println("listeCarte main1 = " + main1.getJeu().toString());
//        System.out.println("valeurMain main1 = " + main1.getValeur());

        ModeleBlackJack modele = new ModeleBlackJack();
        /*
        JoueurRobot robot1 = new JoueurRobot("robot 1");
        JoueurRobot robot2 = new JoueurRobot("robot 2");
        JoueurRobot robot3 = new JoueurRobot("robot 2");
        JoueurHumain humain1 = new JoueurHumain("humain 1");
        JoueurHumain humain2 = new JoueurHumain("humain 2");
        JoueurHumain humain3 = new JoueurHumain("humain 3");

        robot1.setStrategie(new StrategieRisque());
        robot2.setStrategie(new StrategieHasard());
        robot3.setStrategie(new StrategieBasique(robot3,modele.getCroupier()));
        modele.ajouterJoueur(humain1);
        modele.ajouterJoueur(robot1);
        */
//        modele.ajouterJoueur(robot2);
//        modele.ajouterJoueur(humain2);
//        modele.ajouterJoueur(humain3);

        //modele.distribuerCarte();

        BlackJackGui vue = new BlackJackGui(modele);

        vue.afficher();
    }
}
