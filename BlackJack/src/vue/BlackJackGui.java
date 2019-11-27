/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import javax.swing.*;

import modele.*;
import controleur.*;

/**
 * BlackJackGui : Vue globale
 */
public final class BlackJackGui extends JFrame{
    private ModeleBlackJack modele;
    private static final long serialVersionUID = 777;
    private final JFrame fenetre;
    private JPanel panelAccueil;
    private JPanel panelStrategies;
    private JPanel panelAboutUs;
    private JPanel panelRegles;
    private JPanel panelOptions;
    private JPanel panelNotes;
    private JPanel panelJeu;
    private JPanel panel;

    /**
     *
     * @param modele prend le modele.
     */
    public BlackJackGui(ModeleBlackJack modele){
        this.modele = modele;
        fenetre = new JFrame();
        fenetre.setTitle("BlackJack: accueil");//Definit un titre pour notre fenetre
        fenetre.setSize(1285, 790);//Definit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setLocationRelativeTo(null);//Nous demandons maintenant a notre objet de se positionner au centre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setResizable(false);	// La fenetre n'est pas redimensionnable
        initPaneau();
        initBouton();
        afficherAccueil(); 
    }
    
    /**
     * intialisation des paneaux.
     */
    private void initPaneau(){
        panelAccueil = new Panneau("ressources/unnamed.jpg");
        panelStrategies = new PanneauStrategies();
        panelAboutUs = new PanneauAboutUs();
        panelRegles = new PanneauRegles(); 
        panelOptions = new PanneauOptions();
        panelNotes = new PanneauNotes();
    }
    
    
    /**
     * intialisation des bouttons.
     */
    private void initBouton(){
        ControleurBouton BT_NOUVELLE_PARTIE = new ControleurBoutonOptions(555, 492, 175, 118, this);
        // affectaion des boutons dans un paneau
        panelAccueil.add(new ControleurBoutonOptions(325, 670, 190, 55, this));
        panelAccueil.add(new ControleurBoutonStrategies(215, 122, 160, 50, this));
        panelAccueil.add(new ControleurBoutonAPropos(450, 122, 160, 50, this));
        panelAccueil.add(new ControleurBoutonNotes(685, 122, 160, 50, this));
        panelAccueil.add(new ControleurBoutonRegles(915, 122, 160, 50, this));
        panelAccueil.add(BT_NOUVELLE_PARTIE);
        panelAccueil.add(new ControleurBoutonQuitter(810, 675, 170, 50));
        panelStrategies.add(new ControleurBoutonMenuPrincipal(1090, 700, 130, 30, "ressources/home.png", this,modele));
        panelAboutUs.add(new ControleurBoutonMenuPrincipal(1090, 700, 130, 30, "ressources/home.png", this,modele));
        panelRegles.add(new ControleurBoutonMenuPrincipal(1090, 700, 130, 30, "ressources/home.png", this,modele));
        panelNotes.add(new ControleurBoutonMenuPrincipal(1090, 700, 130, 30, "ressources/home.png", this,modele));
        panelOptions.add(new ControleurBoutonMenuPrincipal(1090, 700, 130, 30, "ressources/home.png", this,modele));
        panelOptions.add(new ControleurBoutonNouvellePartie(130, 700, 130, 30, modele, this));
        
        // comportement des bouttons
        BT_NOUVELLE_PARTIE.setBouttonHover("", "ressources/play.png",new JLabel(),"");
    }


    /**
     * affichage de la vue.
     */
    public void afficher(){
       fenetre.setVisible(true);
    }
    
    /**
     * affichage de l'ecran d'accueil.
     */
    public void afficherAccueil(){
        fenetre.setContentPane(panelAccueil);
    	miseAJourVue();
    }
    
    /**
     * affichage de l'ecran de jeu.
     */
    public void afficherJeu(){
        panelJeu = new PanneauJeu("ressources/plateau.jpg","ressources/plateau2.jpg",modele);
        panelJeu.add(new ControleurBoutonMenuPrincipal(100, 730, 130, 30, "ressources/home.png", this,modele));
        fenetre.setContentPane(panelJeu);
    	miseAJourVue();
    }
    
    /**
     * affichage de l'ecran de chargement avant le lancement du jeu
     */
    public void afficherChargement(){
        panel = new Panneau("ressources/plateau2.jpg");
        Vue v = new Vue();
        v.setBounds(440,230,400,50);
        v.setBackground(Color.BLACK);
        v.setOpaque(true);
        v.setText("Loading 8 seconds....");
        v.personnaliserText(new Font("Serif", Font.BOLD, 15), Color.WHITE);
        v.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(v);
        fenetre.setContentPane(panel);
    	miseAJourVue();
    }
    
    
    
    
    /**
     * affichage des options
     */
    public void afficherOptions() {
    	fenetre.setContentPane(panelOptions);
    	miseAJourVue();
    	afficher();
    }
    
    /**
     * Accesseur du panneau des options
     * @return le panneau des options
     */
    public PanneauOptions getPanelOptions() { return (PanneauOptions) panelOptions; }

    /**
     * affichage de l'ecran des regles du blackjack dans le menu principal
     */
    public void afficherRegles() {
        fenetre.setContentPane(panelRegles);
        miseAJourVue();
        afficher();
    }
    
    /**
     * Affichage de l'ecran d'a propos depuis le menu principal
     */
    public void afficherAPropos() {
    	fenetre.setContentPane(panelAboutUs);
    	miseAJourVue();
    	afficher();
    }
    
    /**
     * affichage de l'ecran de remarque sur le jeu
     */
    public void afficherNotes(){
        fenetre.setContentPane(panelNotes);
    	miseAJourVue();
    	afficher();
    }
    
    /**
     * Affichage de l'ecran des strategies depuis le menu principal
     */
    public void afficherStrategies() {
    	fenetre.setContentPane(panelStrategies);
    	miseAJourVue();
    	afficher();
    }
    
    /**
     * mise a jour vue
     */
    public void miseAJourVue(){
        fenetre.repaint();
        panelAccueil.revalidate();
        panelStrategies.revalidate();
        panelAboutUs.revalidate();
        panelRegles.revalidate();
        panelOptions.revalidate();
        panelNotes.revalidate();
        fenetre.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    
}

