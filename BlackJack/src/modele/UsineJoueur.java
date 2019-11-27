package modele;
/**
 * UsineJoueur : Factory Methods creatrices de joueurs
 */
public class UsineJoueur {
    private static UsineJoueur instance;
    
    /**
     * Constructeur par defaut invisible
     */
    private UsineJoueur() {}
    
    /**
     * getInstance : accesseur de l'usine
     * @return l'usine
     */
    public static UsineJoueur getInstance() {
        if(instance==null) {
            instance = new UsineJoueur();
        }
        return instance;
    }
    
    /**
     * creerJoueurCroupier : creer un joueur robot avec la strategie du croupier
     * @param modele : acces au modele
     * @param nom : le nom du robot
     * @return le joueur cree
     */
    public JoueurRobot creerJoueurCroupier(ModeleBlackJack modele, String nom) {
        JoueurRobot j = new JoueurRobot(modele, nom);
        j.setStrategie(new StrategieCroupier(j));
        return j;
    }

    /**
     * creerJoueurBasique : creer un joueur robot avec la strategie optimale
     * @param modele : acces au modele
     * @param nom : le nom du robot
     * @param croupier : le croupier
     * @return le joueur cree
     */
    public JoueurRobot creerJoueurBasique(ModeleBlackJack modele, String nom,JoueurBlackJack croupier) {
        JoueurRobot j = new JoueurRobot(modele, nom);
        j.setStrategie(new StrategieBasique(j, croupier));
        return j;
    }

    /**
     * creerJoueurHasard : creer un joueur robot avec la strategie du hasard
     * @param modele : acces au modele
     * @param nom : le nom du robot
     * @return le joueur cree
     */
    public JoueurRobot creerJoueurHasard(ModeleBlackJack modele, String nom) {
        return new JoueurRobot(modele, nom, new StrategieHasard());
    }

    /**
     * creerJoueurRisque : creer un joueur robot avec la strategie risquee
     * @param modele : acces au modele
     * @param nom : le nom du robot
     * @return le joueur cree
     */
    public JoueurRobot creerJoueurRisque(ModeleBlackJack modele, String nom) {
        return new JoueurRobot(modele, nom, new StrategieRisque());
    }
}
