/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.Observable;
import modele.MainBlackJack;

/**
 * la vue qui affiche une mise
 * @author Abdoul
 */
public class VueMise extends Vue {
    private static final long serialVersionUID = 12;
    private MainBlackJack main;
    private String legende;
    
    /**
     * Constructeur logique
     * @param posX : position x de la vue
     * @param posY : position y de la vue
     * @param width : largeur de la vue
     * @param height : longueur de la vue
     * @param main : acces a la main
     * @param legende : legende de la vue
     */
    public VueMise(int posX, int posY,int width,int height,MainBlackJack main,String legende){
        this.main = main;
        this.legende = legende;
        main.addObserver(this);
        setBounds(posX, posY, width, height);
        paintComponent();
    }
    
    @Override
    public void paintComponent(){
       this.setText(legende+main.getMise());
    }
    
    @Override
    public void update(Observable o, Object arg) {
        paintComponent();
        mettreAJour();
    }
      
}
