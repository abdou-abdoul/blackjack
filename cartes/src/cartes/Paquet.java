package cartes;

import java.util.*;

/**
 *
 * @author ABDOU, 
 */
public class Paquet extends Observable {
    
    protected ArrayList<Carte> cartes;
    
    
    /**
     * constructeur de paquet vide
     */
    public Paquet() {
        this.cartes = new ArrayList<>();
    }
    
    /**
     * constructeur de paquet à partir d'une liste de cartes
     * @param cartes: la liste des cartes
     */
    public Paquet(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }
    /**
     * renvoi la liste des cartes contenu dans le paquet
     * @return cartes
     */
    public ArrayList<Carte> getCartes() {
        return this.cartes;
    }

    /**
     * @return Renvoie la hauteur de la carte dont la position est donnee en parametre
     * @param position : la position de la carte
     */
    public int getValeurDe(int position) {
        if(position>this.cartes.size()-1) {
            return -1;
        }

        return this.cartes.get(position).getHauteur();
    }

    /**
     * melange des cartes du paquet
     */
    public void melanger() {
        Collections.shuffle(this.cartes);
        setChanged();
        notifyObservers();
    }

    /**
     *
     * @param indiceCoupe index de la coupe realise
     */
    public void couper(int indiceCoupe) {
        int indiceMax=this.cartes.size()-3;
        if(indiceMax<3 || indiceCoupe>indiceMax) {
                return;
        }
        
        ArrayList<Carte> paquetSplit=(ArrayList<Carte>)this.cartes.subList(0,indiceCoupe+1);
        for(int i=0;i<=indiceCoupe;i++){
            this.cartes.remove(i);
        }
        this.cartes.addAll(paquetSplit);
        setChanged();
        notifyObservers();
    }
    
    /**
     *
     * @param c la carte ajoutee sur le paquet
     */
    public void ajouterDessous(Carte c) {
        this.cartes.add(c);
        setChanged();
        notifyObservers();
        
    }

    /**
     *
     * @param c la carte ajoutee sous le paquet
     */
    public void ajouterDessus(Carte c) {
        this.cartes.add(0, c);
        setChanged();
        notifyObservers();
    }

    /**
     *
     * @return la premiere carte du paquet
     * @param face: face carte valeur
     */
    public Carte retirerDessous(Face face) {
        Carte carteTemp=this.cartes.remove(this.cartes.size()-1);
        carteTemp.setFaceCarte(face);
        setChanged();
        notifyObservers();
        return carteTemp;
    }

    /**
     *
     * @return la derniere carte du paquet
     * @param face: face carte valeur
     */
    public Carte retirerDessus(Face face) {
        Carte carteTemp=this.cartes.remove(0);
        carteTemp.setFaceCarte(face);
        setChanged();
        notifyObservers();
        return carteTemp;
    }

    /**
     *
     * @return une carte du paquet au hasard
     */
    public Carte retirerHasard() {
        Random rnd = new Random();
        Carte carteTemp=this.cartes.remove(rnd.nextInt(this.cartes.size()));
        setChanged();
        return carteTemp;
    }
    
    public void vider(){
        cartes.clear();
        setChanged();
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        String res="{";
        
        for(Carte carte:this.cartes )
            res += "("+carte.getHauteur()+","+carte.getCouleur()+")" ;
        
        res+="}";
        return res;
    }

    int getSize() {
        return this.cartes.size();
    }


}
