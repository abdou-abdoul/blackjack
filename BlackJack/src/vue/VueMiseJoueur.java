/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import modele.JoueurBlackJack;
import modele.MainBlackJack;
import modele.ModeleBlackJack;

/**
 * VueMiseJoueur
 */
public class VueMiseJoueur extends Vue{
    private static final long serialVersionUID = 10;
    private ModeleBlackJack modele;
    private JoueurBlackJack joueur;
    private MainBlackJack main;
    
    /**
     * Constructeur logique
     * @param posX : position x de la vue
     * @param posY : position y de la vue
     * @param width : largeur de la vue
     * @param height : longueur de la vue
     * @param main : acces a la main
     * @param modele : acces au modele
     * @param joueur : acces au joueur
     */
    public VueMiseJoueur(int posX, int posY,int width,int height,MainBlackJack main,ModeleBlackJack modele,JoueurBlackJack joueur){
        setBounds(posX, posY, width, height);
        this.main = main;
        this.modele = modele;
        this.joueur = joueur;
        this.modele.addObserver(this);
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
        
        
        
        VueMise vMise = new VueMise(getWidth()/2-90/2,10, 90,90,main,"");
        vMise.personnaliserText(new Font("Serif", Font.BOLD, 30), Color.WHITE);
        vMise.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(vMise);
        
        VueNom vNom = new VueNom(0,120,getWidth(),20,joueur,"PLAYER NAME : ");
        Color color1 = Color.white;
        if(joueur.estHumain()){color1 = Color.GREEN;}
        vNom.personnaliserText(new Font("DialogInput", Font.BOLD, 11), color1);
        vNom.setHorizontalAlignment(SwingConstants.CENTER);
        vNom.setVerticalAlignment(SwingConstants.CENTER);
        Color color2 = Color.GRAY;
        if(joueur.estHumain()){color2 = new Color(3,89,0);}
        vNom.setBackground(color2);
        vNom.setOpaque(true);
        this.add(vNom);
        
        VueCredit vCredit = new VueCredit(0,100,getWidth(),10,joueur,"CREDIT : ");
        vCredit.personnaliserText(new Font("Serif", Font.BOLD, 15), Color.WHITE);
        vCredit.personnaliserText(new Font("DialogInput", Font.BOLD, 11), Color.WHITE);
        vCredit.setHorizontalAlignment(SwingConstants.CENTER);
        vCredit.setVerticalAlignment(SwingConstants.CENTER);
    
        this.add(vCredit);
        
        
        this.add(vNom);
        //System.out.println(modele.getJoueurCourant().getNom()+" ===== "+joueur.getNom());
        
        
    }
}
