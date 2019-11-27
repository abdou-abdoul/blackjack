/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import modele.RegleDeJeu;

/**
 * VueMiseMax
 */
public class VueMiseMax extends Vue{
    private static final long serialVersionUID = 10;
    private RegleDeJeu regles;
    private String legende;
    
    /**
     * Constructeur logique
     * @param posX : position x de la vue
     * @param posY : position y de la vue
     * @param width : largeur de la vue
     * @param height : longueur de la vue
     * @param regles : acces aux regles
     * @param legende : legende de la vue
     */
    public VueMiseMax(int posX, int posY,int width,int height,RegleDeJeu regles,String legende){
        this.regles = regles;
        this.legende = legende;
        regles.addObserver(this);
        setBounds(posX, posY, width, height);
        paintComponent();
    }
    
    @Override
    public void paintComponent(){
       this.setText(legende+regles.getMiseMax());
    } 
}
