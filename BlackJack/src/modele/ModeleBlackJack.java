package modele;
import java.util.ArrayList;
import java.util.Observable;
import cartes.*;


/**
 * Classe representant le Modele du etapeJeu.
 * 
 * @author ABDOUL, GAETAN, BASTIEN, ZACCHARIAOU
 */
public class ModeleBlackJack extends Observable {
    
    /**
     * message qu'on affiche aux utilisateurx.
     */
    private String message;

    
    /**
     * Les regles
     */
    private RegleDeJeu regles;

    /**
     * La pioche.
     */
    private Paquet pioche;
    
    /**
     * La defausse.
     */
    private Paquet defausse;
    
    /**
     * Le  croupier.  
     */
    private JoueurBlackJack croupier;
    
    /**
     * si le croupier joue
     */
    private boolean croupierJoue;
    
    /**
     * La liste des joueurs.  
     */
    private ArrayList<JoueurBlackJack> joueurs;
    
    /**
     * Le  joueur qui a la main.  
     */
    private int indexJoueurCourant;
    
    /**
     * le moteur du jeu 
     */
    private MoteurJeu moteurJeu;
    
    /**
     * le nombre de joueur qui peuvent encore jouer
     */
    private int nbJoueursEnJeu;
    
    /**
     * Si le joueur
     */
    private boolean quiterJeu;
    
    /**
     * Constructeur par defaut
    */
    public ModeleBlackJack( ){
        this.regles = new RegleDeJeu(); 
        initModel();
    }
    
    /**
     * initModel : initialisation du modele
     */
    public void initModel(){
        initPioche();
        this.defausse = new Paquet();
        this.croupier = UsineJoueur.getInstance().creerJoueurCroupier(this, "Croupier");
        this.joueurs = new ArrayList<>();
        this.indexJoueurCourant = 0;
        this.moteurJeu = new MoteurJeu(this);
        this.message = "";
        this.croupierJoue = false;
        // sera remis sur false apres 6 secondes
        this.quiterJeu = true;
    }
    /**
     * initialisation de la pioche
     */
    public void initPioche(){
        pioche = new FacadePaquet().genererNPaquetCarte52(regles.getNbPaquetPioche());
        pioche.melanger();
    }
    /**
     * renvoi la pioche
     * @return pioche
     */
    public Paquet getPioche() {
        return this.pioche;
    }
    
    /**
     * Accesseur de la defausse
     * @return la defausse
     */
    public Paquet getDefausse(){
        return this.defausse;
    }
    
    /**
     * renvoi la liste des joueurs
     * @return joueurs
     */
    public ArrayList<JoueurBlackJack> getJoueurs(){
        return this.joueurs;
    }
    
    /**
     * renvoi le joueur courant
     * @return joueurCourant
     */
    public JoueurBlackJack getJoueurCourant(){
        if(croupierJoue)
            return croupier;
        return this.joueurs.get(indexJoueurCourant);
        
    }
    
    /**
     * Accesseur du message
     * @return le message
     */
    public String getMessage(){
        return this.message;
    }
    
    /**
     * Accesseur si le jeu a ete quiter
     * @return si le jeu a ete quiter
     */
    public Boolean getQuiterJeu(){
        return this.quiterJeu;
    }
    
    /**
     * 
     * @return regles de etapeJeu
     */
    public RegleDeJeu getRegles(){
        return this.regles;
    }
    
    /**
     * Accesseur du nombre de joueurs en jeu
     * @return le nombre de joueurs en jeu
     */
    public int getNbJoueursEnJeu(){
        return this.nbJoueursEnJeu;
    }
    
    /**
     * Accesseur du croupier
     * @return le croupier
     */
    public JoueurBlackJack getCroupier(){
        return this.croupier;
    }
    
    /**
     * Mutateur du nombre de joueurs en jeu
     * @param val : la nouvelle valeur
     */
    public void setNbJoueursEnJeu(int val){
        this.nbJoueursEnJeu = val;
    }
    
    /**
     * Mutateur si le jeu a ete quiter
     * @param val : la nouvelle valeur
     */
    public void setQuiterJeu(boolean val){
        this.quiterJeu = val;
    }
    
    /**
     * Mutateur du message
     * @param message : le nouveau message
     */
    public void setMessage(String message){
        this.message = message;
        setChanged();
        notifyObservers();
    }
    
    /**
     * moification de la pioche
     * @param pioche: la pioche
     */
    public  void setPioche(Paquet pioche) {
        this.pioche = pioche;
        setChanged();
        notifyObservers();
    }
    
    /**
     * modification des joueurs
     * @param joueurs: la liste des joueurs a ajouter
     */
    public void setJoueurs(ArrayList<JoueurBlackJack> joueurs){
        this.joueurs = joueurs;
        setChanged();
        notifyObservers();
    }
     
    /**
     * modification du croupier
     * @param croupier: le croupier
     */
    public void setCroupier(JoueurBlackJack croupier){
        this.croupier = croupier;
        setChanged();
        notifyObservers();
    }
    
    /**
     * modification de la defausse
     * @param defausse: la defausse
     */
    public void setDefausse(Paquet defausse){
        this.defausse = defausse;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Mutateur de croupierJoue
     * @param val : la nouvelle valeur
     */
    public void setCroupierJoue(boolean val){
        this.croupierJoue = val;
        setChanged();
        notifyObservers();
    }
    
    /**
     *
     * @param regles : modifie les regles de etapeJeu courantes.
     */
    public void setRegles(RegleDeJeu regles){
        this.regles=regles;
        setChanged();
        notifyObservers();
    }
    
    /**
     * modification de l'index du joueur courant
     * @param index: indexe du joueur courant
     */
    public void setIndexJoueurCourant(int index){
        this.indexJoueurCourant = index;
        setChanged();
        notifyObservers();
    }
  
    /**
     * ajout d'un nouveau joueur
     * @param joueur: le joueur
     */
    public void ajouterJoueur(JoueurBlackJack joueur){
        joueur.setRegles(regles);
        this.joueurs.add(joueur);
        
    }
    
    /**
     * 
     * @return di on est passÃƒÂ© au joueur suivant 
     */
    public boolean joueurSuivant(){
        setChanged();
        notifyObservers();
        if(!hasJoueurSuivant())
            return false;
        setIndexJoueurCourant(indexJoueurCourant+1);
        System.out.println("joueurs suivant");
        return true;
    }
    
    /**
     * @return si le modele contient un joueur suivant
     */
    public boolean hasJoueurSuivant(){
        return this.indexJoueurCourant < joueurs.size()-1;
    }
    
    /**
     * lancer le tour suivant
     */
    public void tourSuivant(){
        this.setIndexJoueurCourant(0);
        setCroupierJoue(false);
        
    }
    
    /**
     * demare le modele
     */
    public void demarrer(){
        moteurJeu.demarrer();  
    }
    
    /**
     * Accesseur du moteur de jeu
     * @return le moteur de jeu
     */
    public MoteurJeu getMoteurJeu(){
        return moteurJeu;
    }

   
    
}