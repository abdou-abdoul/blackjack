/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import modele.JoueurBlackJack;
import modele.ModeleBlackJack;

/**
 * la vue qui affiche tous les mains d'un joueur
 * @author Abdoul
 */
public class VueMainJoueur extends Vue{
    private static final long serialVersionUID = 10;
    private JoueurBlackJack joueur;
    private ModeleBlackJack modele;

    /**
     * Constructeur logique
     * @param posX : position x de la vue
     * @param posY : position y de la vue
     * @param width : largeur de la vue
     * @param height : longueur de la vue
     * @param joueur : acces au joueur
     * @param modele : acces au modele
     */
    public VueMainJoueur(int posX, int posY,int width,int height,JoueurBlackJack joueur,ModeleBlackJack modele){
        setBounds(posX, posY, width, height);
        this.joueur = joueur;
        this.modele = modele;
        joueur.addObserver(this);
   
        modele.addObserver(this);
        
        paintComponent();
    }
    
    @Override
    public void paintComponent(){
        this.removeAll();
        // si le jouer a perdu on ne l'affiche pas
        if(joueur.getAPerduJeu()){
            return;
        }
        Vue curentPlayer = new Vue();
        curentPlayer.setBounds(0,0,getWidth(),getHeight());
        curentPlayer.setBackground(new Color(0, 255, 0, 20));
        curentPlayer.setOpaque(true);
        if(modele.getJoueurCourant() == joueur)
            curentPlayer.setOpaque(true);
        else
            curentPlayer.setOpaque(false);
        this.add(curentPlayer);

        VueNom vNom = new VueNom(10,160,getWidth()-20,20,joueur,"PLAYER NAME : ");
        Color color = Color.white;
        if(joueur.estHumain()){color = Color.GREEN;}
        vNom.personnaliserText(new Font("DialogInput", Font.BOLD, 10), color);
        vNom.setHorizontalAlignment(SwingConstants.CENTER);
        vNom.setVerticalAlignment(SwingConstants.CENTER);
        color = Color.GRAY;
        if(joueur.estHumain()){color = new Color(3,89,0);}
        vNom.setBackground(color);
        
        vNom.setOpaque(true);
        this.add(vNom);

        VueCredit vCredit = new VueCredit(10,25,90,10,joueur,"CREDIT : ");
        vCredit.personnaliserText(new Font("Serif", Font.BOLD, 9), Color.WHITE);
        //vCredit.personnaliserFond("ressources/bg.jpg");
        this.add(vCredit);

        VueGain vGain = new VueGain(90,25,70,10,joueur,"SCORE : ");
        vGain.personnaliserText(new Font("Serif", Font.BOLD, 9), Color.WHITE);
        vGain.setHorizontalAlignment(SwingConstants.RIGHT);
        //vGain.personnaliserFond("ressources/bg.jpg");
        this.add(vGain);
        
        Vue numMain = new Vue();
        numMain.setBounds(10,40, 60,10);
        numMain.personnaliserText(new Font("Serif", Font.BOLD, 9), Color.YELLOW);
        numMain.setText("MAIN "+(joueur.getIndexMainCourant()+1)+" /"+joueur.getMains().size());
        this.add(numMain);
        
        VueValeurMain vScore = new VueValeurMain(50,40,110,10,joueur.getMainCourant(),"VALUE : ");
        vScore.personnaliserText(new Font("Serif", Font.BOLD, 9), Color.ORANGE);
        vScore.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(vScore);
        
        // affichage du jeu
        VuePaquet vPaquet = new VuePaquet(10,55,155,85,joueur.getMainCourant().getJeu(),20,false,"dos.png",70,80);
        this.add(vPaquet);
        
        VueMise  vMise = new VueMise(0,140,175,10,joueur.getMainCourant(),"MISE : ");
        vMise.personnaliserText(new Font("Serif", Font.BOLD, 9), Color.WHITE);
        vMise.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(vMise);
        
        Vue vAssurance = new Vue();
        vAssurance.setBounds(0, 0,getWidth(), 20);
        vAssurance.personnaliserText(new Font("Serif", Font.BOLD, 9), Color.BLUE);
        vAssurance.setHorizontalAlignment(SwingConstants.CENTER);
        if(joueur.estAssure()){vAssurance.setText("INSURED");}
        this.add(vAssurance);
    }

}
