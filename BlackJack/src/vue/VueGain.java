/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import modele.JoueurBlackJack;

/**
 * VueGain
 */
public class VueGain extends Vue{
    private static final long serialVersionUID = 10;
    private JoueurBlackJack joueur;
    private String legende;

    /**
     * Constructeur logique
     * @param posX : position x de la vue
     * @param posY : position y de la vue
     * @param width : largeur de la vue
     * @param height : longueur de la vue
     * @param joueur : acces au joueur
     * @param legende : legende de la vue
     */
    public VueGain(int posX, int posY,int width,int height,JoueurBlackJack joueur, String legende){
        this.joueur = joueur;
        joueur.addObserver(this);
        this.legende = legende;
        setBounds(posX, posY, width, height);
        paintComponent();
    }
    
    @Override
    public void paintComponent(){
       this.setText(legende+joueur.getGain());
    }
}
