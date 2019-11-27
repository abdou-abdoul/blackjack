package controleur;

import java.awt.event.*;

import modele.*;
import vue.*;

public class ControleurBoutonNouvellePartie extends ControleurBouton {
    private static final long serialVersionUID = 10L;
    protected ModeleBlackJack modele;
    protected BlackJackGui vue;

    /**
     * Constructeur logique
     * @param x : position x du bouton
     * @param y : position y du bouton
     * @param width : largeur du bouton
     * @param height : longueur du bouton
     * @param modele : acces au modele
     * @param vue : acces a la vue
     */
    public ControleurBoutonNouvellePartie(int x, int y, int width, int height, ModeleBlackJack modele, BlackJackGui vue) {
        super();
    	this.modele = modele;
        this.vue = vue;
        setBounds(x, y, width, height);
        this.setButtonImage("ressources/play.png");
    }
    
    /**
     * recupereOptions : charge les options definies par l'utilisateur dans les regles de jeu
     * ajoute le nombre de joueurs defini par l'utilisateur dans le modele
     */
    public void recupererOptions() {
    	// Regles
    	RegleDeJeu regles = modele.getRegles();
    	regles.setDoubleAutorise(vue.getPanelOptions().doubleAutorise());
    	regles.setSurrenderAutorise(vue.getPanelOptions().surrenderAutorise());
    	regles.setInsuranceAutorise(vue.getPanelOptions().insuranceAutorise());
    	regles.setNbSplitAutorise(vue.getPanelOptions().nbSplitAutorise());
    	regles.setNbPaquetPioche(vue.getPanelOptions().getNbPaquets());
        regles.setMiseMin(vue.getPanelOptions().getMiseMin());
        regles.setMiseMax(vue.getPanelOptions().getMiseMax());
        regles.setCredit(vue.getPanelOptions().getCredit());
    	
    	// Joueurs
    	String[] joueurs = vue.getPanelOptions().getJoueurs();
        String[] nomJoueurs = vue.getPanelOptions().getNomJoueurs();
    	for(int i=0; i<joueurs.length; i++) {
    		if(joueurs[i].equals("JoueurHumain")) {
    			modele.ajouterJoueur(new JoueurHumain(modele,nomJoueurs[i]));
    		} else if(joueurs[i].equals("JoueurRobotBasique")) {
    			modele.ajouterJoueur(UsineJoueur.getInstance().creerJoueurBasique(modele,nomJoueurs[i], modele.getCroupier()));
    		} else if(joueurs[i].equals("JoueurRobotHasard")) {
    			modele.ajouterJoueur(UsineJoueur.getInstance().creerJoueurHasard(modele,nomJoueurs[i]));
    		} else if(joueurs[i].equals("JoueurRobotRisque")) {
    			modele.ajouterJoueur(UsineJoueur.getInstance().creerJoueurRisque(modele,nomJoueurs[i]));
    		}
    	}
    }

    /**
     * actionPerformed : demarre le jeu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // on met un thread pour attendre la fin d'autres threads en cas de retour au menu principal en cours de partie
        new Thread(){
            @Override
            public void run() {
                try {
                    modele.initModel();
                    recupererOptions();
                    modele.initPioche();
                    vue.afficherChargement();
                    Thread.sleep(8000);
                    vue.afficherJeu();
                    modele.setQuiterJeu(false);
                    modele.demarrer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
