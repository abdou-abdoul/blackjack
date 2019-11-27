/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import modele.ModeleBlackJack;
/**
 * PanneauJeu
 *
 */
public class PanneauJeu extends Panneau implements Observer{
    private static final long serialVersionUID = 888;
    private ModeleBlackJack modele;
    private Image fond2;
    private Image fond1;
    private int vueMainJoueur_Width = 175;
    private int vueMainJoueur_Height = 200;
    private int vueMiseJoueur_Width = 180;
    private int vueMiseJoueur_Height = 140;
    private   ArrayList<VueMiseJoueur> vueMiseJoueur;
    private  ArrayList<VueMainJoueur> vueMainJoueur;
    private final int NB_JOUEUR_MAX = 5;
    
    // labels
    private Vue JL_LEGENDE;
    private Vue JL_PIOCHE;
    private Vue JL_DEFAUSSE;
    private Vue JL_MISE_MIN;
    private Vue JL_MISE_MAX;
    private Vue vScoreCroupier;
    private Vue vFinJeu;
    
    // bouttons
    private ControleurBouton BT_DEAL;
    private ControleurBouton BT_HIT;
    private ControleurBouton BT_STAND;
    private ControleurBouton BT_DOUBLE;
    private ControleurBouton BT_SPLIT;
    private ControleurBouton BT_INSURANCE;
    private ControleurBouton BT_SURRENDER;
    private ControleurBouton BT_CLEAR;
    private ControleurBouton BT_RETURN;
    private ControleurBouton BT_MISE1;
    private ControleurBouton BT_MISE2;
    private ControleurBouton BT_MISE5;
    private ControleurBouton BT_MISE25;
    private ControleurBouton BT_MISE50;
    private ControleurBouton BT_MISE100;
    private ControleurBouton BT_MISE500;
    private ControleurBouton BT_MISEX;
    
    /**
     * Constructeur logique
     * @param fond1: l'image de fond lors de la phase mise
     * @param fond2: l'image de fond lors de la phase où les joueurs joue
     * @param modele: le modele
     */
    public PanneauJeu(String fond1,String fond2, ModeleBlackJack modele) {
        super(fond1);
        this.fond2 = new ImageIcon(fond2).getImage();
        this.fond1 = new ImageIcon(fond1).getImage();
        this.modele = modele;
        this.vueMainJoueur = new ArrayList<>();
        this.vueMiseJoueur = new ArrayList<>();
        this.modele.getMoteurJeu().addObserver(this);
        //this.modele.addObserver(this);
        preparePanel();
    }
    
    /**
     * instanciation globale de la vue
     */
    public void preparePanel(){
        initVue();
        initBoutton();
        afficherMise();
        //afficherJeu();
    }
    
    /**
     * instanciation de la vue
     */
    private void initVue(){
        JL_LEGENDE = new Vue();
        JL_LEGENDE.setBackground(new Color(13,13,13));
        JL_LEGENDE.setHorizontalAlignment(SwingConstants.CENTER);
        JL_LEGENDE.setForeground(Color.white);
        JL_LEGENDE.setBounds(547, 719, 180,13);
        JL_PIOCHE = new VuePaquet(975, 5, 80,100,modele.getPioche(),1,true,"dos.png",60,60);
        JL_DEFAUSSE = new VuePaquet(210, 80, 80,100,modele.getDefausse(),1,true,"dos.png",60,60);
        JL_MISE_MIN = new VueMiseMin(370, 62, 40,10,modele.getRegles(),"");
        JL_MISE_MAX = new VueMiseMax(370, 80, 40,10,modele.getRegles(),"");
        ArrayList<Integer> vueMiseJoueur_PosX = new ArrayList<>();
        ArrayList<Integer> vueMiseJoueur_PosY = new ArrayList<>();
        ArrayList<Integer> vueMainJoueur_PosX = new ArrayList<>();
        ArrayList<Integer> vueMainJoueur_PosY = new ArrayList<>();
        //ajustement de la position de joueurs en fonction du nombre de joueur
        switch(modele.getJoueurs().size()){
            case 1:
                vueMiseJoueur_PosX.add(546);
                vueMiseJoueur_PosY.add(420);
                vueMainJoueur_PosX.add(555);
                vueMainJoueur_PosY.add(360);
                break;
            case 2:
                vueMiseJoueur_PosX.add(312);vueMiseJoueur_PosX.add(782);
                vueMiseJoueur_PosY.add(370);vueMiseJoueur_PosY.add(370);
                vueMainJoueur_PosX.add(365);vueMainJoueur_PosX.add(745);
                vueMainJoueur_PosY.add(320);vueMainJoueur_PosY.add(320);
                break;
            case 3:
                vueMiseJoueur_PosX.add(312);vueMiseJoueur_PosX.add(546);vueMiseJoueur_PosX.add(782);
                vueMiseJoueur_PosY.add(370);vueMiseJoueur_PosY.add(420);vueMiseJoueur_PosY.add(370);
                vueMainJoueur_PosX.add(365);vueMainJoueur_PosX.add(555);vueMainJoueur_PosX.add(745);
                vueMainJoueur_PosY.add(320);vueMainJoueur_PosY.add(360);vueMainJoueur_PosY.add(320);
                break;
            case 4:
                vueMiseJoueur_PosX.add(172);vueMiseJoueur_PosX.add(312);vueMiseJoueur_PosX.add(546);vueMiseJoueur_PosX.add(782);
                vueMiseJoueur_PosY.add(212);vueMiseJoueur_PosY.add(370);vueMiseJoueur_PosY.add(420);vueMiseJoueur_PosY.add(370);
                vueMainJoueur_PosX.add(180);vueMainJoueur_PosX.add(365);vueMainJoueur_PosX.add(555);vueMainJoueur_PosX.add(745);
                vueMainJoueur_PosY.add(210);vueMainJoueur_PosY.add(320);vueMainJoueur_PosY.add(360);vueMainJoueur_PosY.add(320);
                break;
            case 5:
                vueMiseJoueur_PosX.add(172);vueMiseJoueur_PosX.add(312);vueMiseJoueur_PosX.add(546);vueMiseJoueur_PosX.add(782);vueMiseJoueur_PosX.add(920);
                vueMiseJoueur_PosY.add(212);vueMiseJoueur_PosY.add(370);vueMiseJoueur_PosY.add(420);vueMiseJoueur_PosY.add(370);vueMiseJoueur_PosY.add(215);
                vueMainJoueur_PosX.add(180);vueMainJoueur_PosX.add(365);vueMainJoueur_PosX.add(555);vueMainJoueur_PosX.add(745);vueMainJoueur_PosX.add(935);
                vueMainJoueur_PosY.add(210);vueMainJoueur_PosY.add(320);vueMainJoueur_PosY.add(360);vueMainJoueur_PosY.add(320);vueMainJoueur_PosY.add(190);
                break;
            default:
                break;
              
        }
            
        //vues des joueurs et des mises
        for(int i=0;i<modele.getJoueurs().size();i++){
            if(i >= NB_JOUEUR_MAX){
                return;
            }
            vueMainJoueur.add(new VueMainJoueur(vueMainJoueur_PosX.get(i),vueMainJoueur_PosY.get(i), vueMainJoueur_Width,vueMainJoueur_Height,modele.getJoueurs().get(i),modele));
            this.add(vueMainJoueur.get(i));
            vueMiseJoueur.add(new VueMiseJoueur(vueMiseJoueur_PosX.get(i),vueMiseJoueur_PosY.get(i), vueMiseJoueur_Width,vueMiseJoueur_Height,modele.getJoueurs().get(i).getMainCourant(),this.modele,modele.getJoueurs().get(i)));
            this.add(vueMiseJoueur.get(i));
        }
        //main du jeu croupier
        vScoreCroupier = new VueValeurMain(440,95,400,20,modele.getCroupier().getMainCourant(),"VALUE : ");
        vScoreCroupier.personnaliserText(new Font("Serif", Font.BOLD, 15), Color.WHITE);
        vScoreCroupier.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(vScoreCroupier);
        
        VuePaquet vPaquetCroupier = new VuePaquet(440,120,400,105,modele.getCroupier().getMainCourant().getJeu(),20,false,"dos.png",90,100);
        this.add(vPaquetCroupier);
 
        
        VueMessageJeu vMessage = new VueMessageJeu(440,230,400,50,modele,5000,new Color(0, 0, 0));
        vMessage.personnaliserText(new Font("Serif", Font.BOLD, 15), Color.WHITE);
        vMessage.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(vMessage);
        
        vFinJeu = new Vue();
        vFinJeu.setBounds(440,230,400,100);
        vFinJeu.setBackground(new Color(118,8,8));
        vFinJeu.setOpaque(true);
        vFinJeu.setText("GAME OVER, YOU MUST COME BACK TO MAIN MENU");
        vFinJeu.personnaliserText(new Font("Serif", Font.BOLD, 20), Color.WHITE);
        vFinJeu.setHorizontalAlignment(SwingConstants.CENTER);
        vFinJeu.setVerticalAlignment(SwingConstants.CENTER);
        vFinJeu.setVisible(false);
        this.add(vFinJeu);
    }
    
    /**
     * instanciation des boutons
     */
    private void initBoutton(){
        ControleurBoutonRegles2 BT_RULES = new ControleurBoutonRegles2(250, 730, 130, 30);
        BT_MISE1 = new ControleurBoutonMise(453, 598, 40, 40, "ressources/mise1.png", 1, modele);
        BT_MISE2 = new ControleurBoutonMise(502, 608, 40, 40, "ressources/mise2.png", 2, modele);
        BT_MISE5 = new ControleurBoutonMise(551, 612, 40, 40, "ressources/mise5.png", 5, modele);
        BT_MISE25 = new ControleurBoutonMise(600, 615, 40, 40, "ressources/mise25.png", 25, modele);
        BT_MISE50 = new ControleurBoutonMise(649, 615, 40, 40, "ressources/mise50.png", 50, modele);
        BT_MISE100 = new ControleurBoutonMise(698, 612, 40, 40, "ressources/mise100.png", 100, modele);
        BT_MISE500 = new ControleurBoutonMise(747, 605, 40, 40, "ressources/mise500.png", 500, modele);
        BT_MISEX = new ControleurBoutonMise(797, 594, 40, 40, "ressources/misex.png", 0, modele);
        BT_DEAL = new ControleurBoutonDeal(606, 659, 63, 60, "ressources/deal0.png", modele);
        BT_CLEAR = new ControleurBoutonClear(505, 682, 20, 20, "ressources/clear0.png", modele);
        BT_RETURN = new ControleurBoutonReturn(750, 682, 20, 20, "ressources/return0.png", modele);
        BT_HIT = new ControleurBoutonHit(642, 657, 61, 60, "ressources/hit0.png", modele);
        BT_STAND = new ControleurBoutonStand(572, 658, 61, 60, "ressources/stand0.png", modele);
        BT_DOUBLE = new ControleurBoutonDouble(710, 681, 23, 22, "ressources.double0.png", modele);
        BT_SPLIT = new ControleurBoutonSplit(750, 680, 25, 22, "ressources/split0.png", modele);
        BT_INSURANCE = new ControleurBoutonInsurance(504, 680, 25, 22, "ressources/insurance0.png", modele);
        BT_SURRENDER = new ControleurBoutonSurrender(542, 682, 23, 20, "ressources/surrender0.png", modele);
        this.add(BT_RULES);
        this.add(JL_LEGENDE);
        this.add(JL_PIOCHE);
        this.add(JL_DEFAUSSE);
        this.add(JL_MISE_MIN);
        this.add(JL_MISE_MAX);
        this.add(BT_MISE1);
        this.add(BT_MISE2);
        this.add(BT_MISE5);
        this.add(BT_MISE25);
        this.add(BT_MISE50);
        this.add(BT_MISE100);
        this.add(BT_MISE500);
        this.add(BT_MISEX);
        this.add(BT_CLEAR);
        this.add(BT_RETURN);
        this.add(BT_DEAL);
        this.add(BT_HIT);
        this.add(BT_STAND);
        this.add(BT_DOUBLE);
        this.add(BT_SPLIT);
        this.add(BT_INSURANCE);
        this.add(BT_SURRENDER);  
    }
    
    /**
     * permet d'afficher la phase où les joueurs doivent miser
     */
    public void afficherMise(){
        setBackground(this.fond1);
        for(int i=0;i<vueMainJoueur.size();i++){
            vueMiseJoueur.get(i).setVisible(true);
            vueMainJoueur.get(i).setVisible(false);
        }
        vScoreCroupier.setVisible(false);
        BT_DEAL.setVisible(true);
        BT_CLEAR.setVisible(true);
        BT_RETURN.setVisible(true);
        BT_HIT.setVisible(false);
        BT_STAND.setVisible(false);
        BT_DOUBLE.setVisible(false);
        BT_SPLIT.setVisible(false);
        BT_INSURANCE.setVisible(false);
        BT_SURRENDER.setVisible(false);
        desactiverBoutonMise();
        desactiverBoutonJeu();
        this.mettreAJour();
    }
    /**
     * permet d'afficher la phase où les joueurs doivent jouer
     */
    public void afficherJeu(){
        setBackground(this.fond2);
        for(int i=0;i<vueMainJoueur.size();i++){
            vueMiseJoueur.get(i).setVisible(false);
            vueMainJoueur.get(i).setVisible(true);
        }
        BT_DEAL.setVisible(false);
        BT_CLEAR.setVisible(false);
        BT_RETURN.setVisible(false);
        BT_HIT.setVisible(true);
        BT_STAND.setVisible(true);
        BT_DOUBLE.setVisible(true);
        BT_SPLIT.setVisible(true);
        BT_INSURANCE.setVisible(true);
        BT_SURRENDER.setVisible(true);
        desactiverBoutonMise();
        desactiverBoutonJeu();
        this.mettreAJour();
    }
    
    /**
     * on active les boutons qui permettent de miser
     */
    public void activerBoutonMise(){
        BT_MISE1.activer("ressources/mise1.png","ressources/mise1_1.png",JL_LEGENDE,"");
        BT_MISE2.activer("ressources/mise2.png","ressources/mise2_1.png",JL_LEGENDE,"");
        BT_MISE5.activer("ressources/mise5.png","ressources/mise5_1.png",JL_LEGENDE,"");
        BT_MISE25.activer("ressources/mise25.png","ressources/mise25_1.png",JL_LEGENDE,"");
        BT_MISE50.activer("ressources/mise50.png","ressources/mise50_1.png",JL_LEGENDE,"");
        BT_MISE100.activer("ressources/mise100.png","ressources/mise100_1.png",JL_LEGENDE,"");
        BT_MISE500.activer("ressources/mise500.png","ressources/mise500_1.png",JL_LEGENDE,"");
        BT_MISEX.activer("ressources/misex.png","ressources/misex_1.png",JL_LEGENDE,"");
        BT_DEAL.activer("ressources/deal.png","ressources/deal1.png",JL_LEGENDE,"DEAL");
        BT_CLEAR.activer("ressources/clear.png","ressources/clear1.png",JL_LEGENDE,"CLEAR");
        BT_RETURN.activer("ressources/return.png","ressources/return1.png",JL_LEGENDE,"RETURN");
        System.out.println("activation boutton mise");
    }
    
    /**
     * on désactive les boutons qui permetent de miser
     */
    public void desactiverBoutonMise(){
        BT_MISE1.desactiver("ressources/mise1_0.png");
        BT_MISE2.desactiver("ressources/mise2_0.png");
        BT_MISE5.desactiver("ressources/mise5_0.png");
        BT_MISE25.desactiver("ressources/mise25_0.png");
        BT_MISE50.desactiver("ressources/mise50_0.png");
        BT_MISE100.desactiver("ressources/mise100_0.png");
        BT_MISE500.desactiver("ressources/mise500_0.png");
        BT_MISEX.desactiver("ressources/misex_0.png");
        BT_CLEAR.desactiver("ressources/clear0.png");
        BT_RETURN.desactiver("ressources/return0.png");
        BT_DEAL.desactiver("ressources/deal0.png");
    }
    
    /**
     * On active les boutons permettant de jouer 
     * qui sont autorisées dans les regeles du jeu
     */
    public void activerBoutonJeu(){
        BT_HIT.activer("ressources/hit.png","ressources/hit1.png",JL_LEGENDE,"HIT");
        BT_STAND.activer("ressources/stand.png","ressources/stand1.png",JL_LEGENDE,"STAND");
        // si double autorisé
        if(modele.getRegles().getDoubleAutorise()){
            BT_DOUBLE.activer("ressources/double.png","ressources/double1.png",JL_LEGENDE,"DOUBLE");
        }
        // si le joueur peut effectuer un split 
        if(modele.getJoueurCourant().canSplit() && modele.getJoueurCourant().getMains().size() <= modele.getRegles().getNbSplitAutorise()){
            BT_SPLIT.activer("ressources/split.png","ressources/split1.png",JL_LEGENDE,"SPLIT");
        }
        // si la carte du dessous (premier carte retiré et qui est affiché) est l'As
        if(modele.getCroupier().getMainCourant().getJeu().getCartes().get(1).getHauteur()==1){
            BT_INSURANCE.activer("ressources/insurance.png","ressources/insurance1.png",JL_LEGENDE,"INSURANCE");
        }
        // si abandon autorisé
        if(modele.getRegles().getSurrenderAutorise()){
            BT_SURRENDER.activer("ressources/surrender.png","ressources/surrender1.png",JL_LEGENDE,"SURRENDER");
        }
    };
    
    /**
     * on désactive les boutons qui permettent de jouer
     */
    public void desactiverBoutonJeu(){
        BT_HIT.desactiver("ressources/hit0.png");
        BT_STAND.desactiver("ressources/stand0.png");
        BT_DOUBLE.desactiver("ressources/double0.png");
        BT_SPLIT.desactiver("ressources/split0.png");
        BT_INSURANCE.desactiver("ressources/insurance0.png");
        BT_SURRENDER.desactiver("ressources/surrender0.png");
    
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update");
        System.out.println(modele.getMoteurJeu().getEtapeJeu()+"");
       
        switch(modele.getMoteurJeu().getEtapeJeu().getEtape()){
                
            case EtapeTourSuivant: 
                System.out.println("--------------------------------------tour Suivant");
                afficherMise();
                this.mettreAJour();
                break;
                
            case EtapeMiseHumain:
                
                System.out.println("--------------------------------------mise humain");
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                activerBoutonMise();
                this.mettreAJour();
                break;
                
            case EtapeMiseRobot:
                System.out.println("----------------------------------------mise Robot");
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
                //desactiverBoutonMise();
                this.mettreAJour();
                break;
                
               
            case EtapeJeuJoueur:
                if(modele.getJoueurCourant().estHumain()){
                    System.out.println("----------------------------------------Humain joue");
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    activerBoutonJeu();
                }
                else{
                    System.out.println("----------------------------------------Robot joue");
                    setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    desactiverBoutonJeu();     
                }
                this.mettreAJour();
                break;
            
            case EtapeJeuCroupier:
                System.out.println("---------jeuCroupier");
                vScoreCroupier.setVisible(true);
                desactiverBoutonJeu();
                
                break;

            case EtapeAttributionGain:
                System.out.println("-----------gain");
                this.mettreAJour();
                break;
                
            case EtapeDistributionCarte:
                System.out.println("-----------distribution");
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
                afficherJeu();
                break;
            
            case fin:
                System.out.println("-----------game over");
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                vFinJeu.setVisible(true);
                desactiverBoutonJeu();
                desactiverBoutonMise();
                break;
                  
            default:
                break;
        }
    }   
}
