/**
 * @author 21614263 (Bastien CHAPUSOT)
 */

package modele;

/**
 * StrategieBasique : strategie optimale
 */
public class StrategieBasique extends Strategie {
    
    /**
     * hardTotal : jeu sans As.
     */
    public static ActionsBlackJack[][] hardTotal = {
        /* Main joueur de 17 a 20 */
        {ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand},
        /* Main joueur a 16 */
        {ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Surrender, ActionsBlackJack.Surrender, ActionsBlackJack.Surrender},
        /* Main joueur a 15 */
        {ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Surrender, ActionsBlackJack.Hit},
        /* Main joueur a 13-14 */
        {ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit}, 
        /* Main joueur a 12 */
        {ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a 11 */
        {ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.Hit},
        /* Main joueur a 10 */
        {ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a 9 */
        {ActionsBlackJack.Hit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a 5-8 */
        {ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit}
    }; 

    /**
     * softTotal : jeu avec As 
     */
    public static ActionsBlackJack[][] softTotal = {
        /* Main joueur A,8-A,9 */
        {ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand},
        /* Main joueur a A,7 */
        {ActionsBlackJack.Stand, ActionsBlackJack.DoubleStand, ActionsBlackJack.DoubleStand, ActionsBlackJack.DoubleStand, ActionsBlackJack.DoubleStand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a A,6 */
        {ActionsBlackJack.Hit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a A,4-A,5 */
        {ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a A,2-A,3 */
        {ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit}
    };

    /**
     * pairs : actions jouees en possibilites de split.
     */
    public static ActionsBlackJack[][] pairs = {
        /* Main joueur a A,A */
        {ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split},
        /* Main joueur a 10,10 */
        {ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand, ActionsBlackJack.Stand},
        /* Main joueur a 9,9 */
        {ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Stand, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Stand, ActionsBlackJack.Stand},
        /* Main joueur a 8,8 */
        {ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split},
        /* Main joueur a 7,7 */
        {ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a 6,6 */
        {ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a 5,5 */
        {ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.DoubleHit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a 4,4 */
        {ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit},
        /* Main joueur a 2,2-3,3 */
        {ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Split, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit, ActionsBlackJack.Hit}
    };
    
    private JoueurBlackJack joueur;
    private JoueurBlackJack croupier;
    
    /**
     * Constructeur logique
     * @param j joueur
     * @param c le croupier qui l'oppose.
     */
    public StrategieBasique(JoueurBlackJack j, JoueurBlackJack c) {
        this.joueur = j;
        this.croupier = c;
    }

    /**
     * getTypeStrategie
     * @return Renvoie le type de strategie : 0 = strategie Hard Totals, 1 = strategie Soft Totals, 2 = strategie Pairs
     * Renvoie 0 par defaut
     */
    protected int getTypeStrategie() {
        // Determination du type de strategie
        if(this.joueur.getMains().get(0).getJeu().getValeurDe(0)==this.joueur.getMains().get(0).getJeu().getValeurDe(1)) {
            // Strategie pairs
            return 2;
        } else if(this.joueur.getMains().get(0).getJeu().getValeurDe(0)==1 || this.joueur.getMains().get(0).getJeu().getValeurDe(1)==1) {
            // Strategie softTotal
            return 1;
        } else {
            // Strategie hardTotal
            return 0;
        }
    }

    /**
     * getJeuJoueur
     * @param typeStrategie : le type de strategie appliquee
     * @return l'indice du joueur dans le tableau des strategies
     */
    protected int getJeuJoueur(int typeStrategie) {
        int valeurCarte, jeuJoueur=0;
        // Determination du jeuJoueur
        //
        // Strategie Pairs
        if(typeStrategie==2) {
            valeurCarte=this.joueur.getMains().get(0).getJeu().getValeurDe(0);

            switch(valeurCarte) {
                case 1:
                    jeuJoueur=0;
                    break;
                case 2:
                    jeuJoueur=8;
                    break;
                case 3:
                    jeuJoueur=8;
                    break;
                case 4:
                    jeuJoueur=7;
                    break;
                case 5:
                    jeuJoueur=6;
                    break;
                case 6:
                    jeuJoueur=5;
                    break;
                case 7:
                    jeuJoueur=4;
                    break;
                case 8:
                    jeuJoueur=3;
                    break;
                case 9:
                    jeuJoueur=2;
                    break;
                case 10:
                    jeuJoueur=1;
                    break;
                default:
                    jeuJoueur=0;
                    break;
            }
        //
        // Strategie Soft Total
        } else if(typeStrategie==1) {
            // valeurCarte vaut ici la valeur de la carte qui n'est pas l'AS
            valeurCarte=(this.joueur.getMains().get(0).getJeu().getValeurDe(0)==1)?this.joueur.getMains().get(0).getJeu().getValeurDe(1):this.joueur.getMains().get(0).getJeu().getValeurDe(0);
            
            switch(valeurCarte) {
                case 2:
                    jeuJoueur=4;
                    break;
                case 3:
                    jeuJoueur=4;
                    break;
                case 4:
                    jeuJoueur=3;
                    break;
                case 5:
                    jeuJoueur=3;
                    break;
                case 6:
                    jeuJoueur=2;
                    break;
                case 7:
                    jeuJoueur=1;
                    break;
                case 8:
                    jeuJoueur=0;
                    break;
                case 9:
                    jeuJoueur=0;
                    break;
                default:
                    jeuJoueur=0;
                    break;
            }
        //
        // Strategie Hard Total
        } else {
            // valeurCarte vaut ici la somme des cartes de la main du joueur
            valeurCarte = this.joueur.getMains().get(0).getValeur();
             
            switch(valeurCarte) {
                case 5:
                    jeuJoueur=8;
                    break;
                case 6:
                    jeuJoueur=8;
                    break;
                case 7:
                    jeuJoueur=8;
                    break;
                case 8:
                    jeuJoueur=8;
                    break;
                case 9:
                    jeuJoueur=7;
                    break;
                case 10:
                    jeuJoueur=6;
                    break;
                case 11:
                    jeuJoueur=5;
                    break;
                case 12:
                    jeuJoueur=4;
                    break;
                case 13:
                    jeuJoueur=3;
                    break;
                case 14:
                    jeuJoueur=3;
                    break;
                case 15:
                    jeuJoueur=2;
                    break;
                case 16:
                    jeuJoueur=1;
                    break;
                case 17:
                    jeuJoueur=0;
                    break;
                case 18:
                    jeuJoueur=0;
                    break;
                case 19:
                    jeuJoueur=0;
                    break;
                case 20:
                    jeuJoueur=0;
                    break;
                default:
                    jeuJoueur=0;
                    break;
            }
        }
        return jeuJoueur;
    }

    /**
     * executer : execution de la strategie
     * @return l'action optimale en fonction du jeu de joueur et de celui du croupier
     */
    @Override
    public ActionsBlackJack executer() {
        /* typeStrategie determine le tableau dans lequel chercher la strategie (en fonction de la main du joueur) */
        int typeStrategie=getTypeStrategie();
        /* jeuJoueur represente les lignes */
        int jeuJoueur=getJeuJoueur(typeStrategie);
        /* jeuCroupier represente les colonnes */
        int jeuCroupier=((this.croupier.getMains().get(0).getJeu().getValeurDe(1))+8)%10;

        switch(typeStrategie) {
            case 0:
                return hardTotal[jeuJoueur][jeuCroupier];
            case 1:
                return softTotal[jeuJoueur][jeuCroupier];
            case 2:
                return pairs[jeuJoueur][jeuCroupier];
            default:
                return ActionsBlackJack.Hit;
        }
    }
}
