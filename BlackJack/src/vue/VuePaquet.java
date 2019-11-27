/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import cartes.Carte;
import cartes.Paquet;

/**
 * VuePaquet
 */
public class VuePaquet extends Vue{
    private static final long serialVersionUID = 13;
    private Paquet paquet;
    private int espacement;
    private boolean estVerticale;
    private String versoCarte;
    private int carteX;
    private int carteY;
    
    /**
     * Constructeur logique
     * @param posX : position x de la vue
     * @param posY : position y de la vue
     * @param width : largeur de la vue
     * @param height : longueur de la vue
     * @param paquet : acces au paquet
     * @param espace : espace entre les cartes
     * @param estVerticale : affichage vertical
     * @param versoCarte : ressource du verso de la carte du dessus du paquet
     * @param carteX : position x de la carte
     * @param carteY : position y de la carte
     */
    public VuePaquet(int posX, int posY,int width,int height,Paquet paquet, int espace,boolean estVerticale,String versoCarte,int carteX, int carteY){
        this.paquet = paquet;
        this.estVerticale = estVerticale;
        this.espacement = espace;
        this.versoCarte = versoCarte;
        this.carteX = carteX;
        this.carteY = carteY;
        paquet.addObserver(this);
        setBounds(posX, posY, width, height);
        paintComponent();
    }
    
    @Override
    public void paintComponent(){
        int PAQUET_X = 0;
        int PAQUET_Y = 0;
        this.removeAll();
        // centrage du paquet
        if(!estVerticale)
            //PAQUET_X = (getWidth()-(carteX+espacement*(paquet.getCartes().size()-1)))/2;
            PAQUET_X = ((getWidth()-(carteX+espacement*(paquet.getCartes().size()-1)))/2) + espacement*(paquet.getCartes().size()-1) ;
        for( Carte carte: paquet.getCartes()){
            VueCarte vCarte = new VueCarte(PAQUET_X,PAQUET_Y,carteX,carteY,carte,versoCarte);
            if(estVerticale)
                PAQUET_Y += espacement;

            else{
                PAQUET_X -= espacement;
                
            }
            this.add(vCarte);
                
        }
    }

}
