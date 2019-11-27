/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Observable;
import cartes.*;
import java.util.Random;

/**
 *
 * @author ABDOU,CHAPUSOT,DIALLO,GUILBERT 
 */
public class JoueurBlackJack extends Observable{
    
    /**
     * le nom du joueur
     */
    protected String nom;
    
    /**
     * le credit total du joueur
     */
    protected int credit;
    
    /**
     * le dernier gain enregistre du joueur
     */
    protected int gain;
    
    /**
     * regles associÃ© au joueur
     */
    protected RegleDeJeu regles;
    
    /**
     * liste  de main du joueur
     * un joueur peut avoir plusieur main, le cas du split
     */
    protected ArrayList<MainBlackJack> mains;

    /**
     * si le joueur a pris l'assurance
     */
    boolean assurance = false;
    
    /**
     * index main courant
     */
    int indexMainCourant;
    
    /**
     * le joueur a perdu, il ne peut plus miser
     */
    boolean aPerduJeu;
    
 
    /**
     * constructeur d'un joueur blackjack
     * @param nom: nom du joueur
     * @param modele: le modele
     */
    public JoueurBlackJack(ModeleBlackJack modele, String nom) {
        this.mains = new ArrayList<>();
        this.mains.add(new MainBlackJack(new Paquet()));
        this.nom = nom;
        indexMainCourant = 0;
        this.regles = modele.getRegles();
        this.credit = regles.getCredit();
        this.gain = 0;
        this.aPerduJeu = false;
        
    }  
    
    /**
     *
     * @return mains
     */
    public ArrayList<MainBlackJack> getMains(){
        return this.mains;
    }
    
    /**
     *
     * @return credit
     */
    public int getCredit(){
        return this.credit;
    }
    
    /**
     * 
     * @return gain
     */
    public int getGain(){
        return this.gain;
    }
    
    /**
     * Accesseur de la main courante
     * @return la main courante
     */
    public MainBlackJack getMainCourant(){
        return mains.get(indexMainCourant);
    }
    
    /**
     *
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Accesseur de l'index de la main courante
     * @return l'index de la main courante
     */
    public int getIndexMainCourant(){
        return this.indexMainCourant;
    }
    
    /**
     * 
     * @return aPerduJeu
     */
    public boolean getAPerduJeu(){
        return aPerduJeu;
    }
   
    
    /**
     * 
     * @param val: si a perdu le jeu 
     */
    public void setAPerduJeu(boolean val){
        this.aPerduJeu = val;
        setChanged();
	notifyObservers();
    }
    
    
    /**
     * Modification des regles de jeu autorisees
     * @param regles: regles 
     */
    public void setRegles(RegleDeJeu regles){
        this.regles = regles; 
        setChanged();
	notifyObservers();
    }
    
    /**
     *
     * @param mains: la main du joueur
     */
    public void setMain(ArrayList<MainBlackJack> mains){
        this.mains = mains;
        setChanged();
	notifyObservers();
    }
    
    
    /**
     *
     * @param nom: le nom du joueur
     */
    public void setNom(String nom){
        this.nom = nom;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Mutateur de l'assurance
     * @param bool : la nouvelle valeur
     */
    public void setAssurance(boolean bool){
        this.assurance = bool;
        setChanged();
        notifyObservers();
    }
    
    /**
     *
     * @param credit: le credit du joueur
     */
    public void setCredit(int credit){
        this.credit = credit;
        setChanged();
	notifyObservers();
    }
    
    /**
     *
     * @param gain: le credit du joueur
     */
    public void setGain(int gain){
        this.gain = gain;
        setChanged();
	notifyObservers();
    }
    
    
    /**
     * modification de l'index du main courant
     * @param index: index du main courant
     */
    public void setIndexMainCourant(int index){
        this.indexMainCourant = index;
        setChanged();
	notifyObservers();
    }
    
    /**
     *
     * @param main: la main a ajouter
     */
    public void ajouterMain(MainBlackJack main){
        this.mains.add(main);
        setChanged();
	notifyObservers();
    }
    
    /**
     * 
     * @return si on est bien passÃ© Ã  la main suivante
     */
    public boolean mainSuivant(){
        if(!hasMainSuivant())
            return false;
        setIndexMainCourant(this.indexMainCourant+1);
        System.out.print("----main suivant");
        return true;
    }
    
    /**
     * 
     * @return si le joueur a une main suivante
     */
    public boolean hasMainSuivant(){
        return this.indexMainCourant < mains.size()-1;
    }
    

    /**
     *
     * @return assurance
     */
    public boolean estAssure() {
        return assurance;
        //On pourrait le faire comme estHumain, car l'assurance est dans les meilleures stratï¿½gies de
        //robots connues ignorï¿½.
    }
    
    /**
     * aPerdu : indique si le joueur a perdu
     * @return vrai si le joueur a perdu (ses credits sont inferieurs a la mise minimum), faux sinon
     */
    public boolean aPerdu(){
        return credit < regles.getMiseMin();
    }
    
    /**
     *
     * @return boolean
     */
    public boolean estHumain() {
        return false;
    }
      
    /**
     * doubler la mise du joueur et recevoir une carte supplementaire
     * @param paquet: le paquet
     */
    public void applicationDouble(Paquet paquet){
        int mise = this.getMainCourant().getMise();
        this.setCredit(this.credit-mise);
        this.mains.get(indexMainCourant).setMise(mise*2);
        applicationHit(paquet);
        applicationStand();
        
    }
    
    /**
     * recevoir une carte supplementaire
     * @param paquet: le paquet
     */
    public void applicationHit(Paquet paquet){
        this.getMainCourant().getJeu().ajouterDessus(paquet.retirerDessus(Face.RECTO));
    }
    
    /**
     * le joueur s'arrete
     */
    public void applicationStand(){
        this.getMainCourant().setStand(true);
    }
    
    /**
     * si le joueur peut faire un split
     * c.a.d si il a juste 2 cartes dans sa main et qui sont de la meme hauteur
     * @return si le joueur peut faire un split
     */
    public boolean canSplit(){
        Paquet jeu = this.getMainCourant().getJeu();
        if(jeu.getCartes().size() != 2){
            return false;
        }
        int mise = getMainCourant().getMise();
        if(mise>credit){return false;}
        return jeu.getCartes().get(0).getHauteur() == jeu.getCartes().get(1).getHauteur();
    }
    
    /**
     * le joueur separe son jeu en deux main.
     */
    public void applicationSplit(){
        Paquet jeuCourant = getMainCourant().getJeu(); 
        if(jeuCourant.getCartes().size() < 2){return;}
        int mise = getMainCourant().getMise();
        Paquet jeu2 = new Paquet();
        jeu2.ajouterDessus(jeuCourant.retirerDessous(Face.RECTO));
        MainBlackJack main2 =new MainBlackJack(jeu2);
        main2.setMise(mise);
 
        this.setCredit(credit-mise);
        ajouterMain(main2);
    }
    
    /**
     * le joueur prend l'assurance
     */
    public void applicationInsurance(){
        setAssurance(true);
        this.getMainCourant().setMise(this.getMainCourant().getMise()/2);
    }
    
    /**
     * le joueur se couche
     * on retire sa mise et se cartes
     * @param defausse: la defausse
     */
    public void applicationSurrender(Paquet defausse){
        this.setCredit(this.credit + this.getMainCourant().getMise()/2);
        this.setGain(-this.getMainCourant().getMise()/2);
        // defausse ses cartes
        for(Carte carte:getMainCourant().getJeu().getCartes()){defausse.ajouterDessus(carte);}
        applicationStand();
        //on retire sa mise et se cartes
        this.getMainCourant().getJeu().vider();
        this.getMainCourant().setMise(0);
        this.getMainCourant().setAAbandonner(true);
    }
    
    /**
     * 
     * @param pioche: la pioche
     * @param defausse: la defausse afin de defausser les cartes en cas d'abandon du joueur 
     */
    public void jouer(Paquet pioche,Paquet defausse){}
    
    /**
     * le joueur mise au hasard
     */
    public void miserHasard(){
        int max = regles.getMiseMax()-getMainCourant().getMise();
        if(max>credit){max = credit;}
        int min = regles.getMiseMin();
        Random generator = new Random(); 
        int mise = generator.nextInt(max+1);
        getMainCourant().setMise(getMainCourant().getMise()+mise);
        if(this.getMainCourant().getMise()<min){
            getMainCourant().setMise(min);
            this.setCredit(min);
        }
        this.setCredit(credit-mise);
    }
    
    /**
     * Mutateur de la strategie
     * @param strategie : la nouvelle strategie
     */
    public void setStrategie(Strategie strategie){}
    
}
