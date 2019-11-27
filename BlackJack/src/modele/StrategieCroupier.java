/**
 * @author 21614263 (Bastien CHAPUSOT)
 */

package modele;
/**
 * StrategieCroupier : strategie ou le joueur demande une carte jusqu'a atteindre 17, ou il s'arrete
 */
public class StrategieCroupier extends Strategie {
    protected JoueurBlackJack joueur;
    /**
     * Constructeur logique
     * @param j : le croupier
     */
    public StrategieCroupier(JoueurBlackJack j) {
        this.joueur = j;
    }
    
    /**
     * executer : execution de l'algorithme
     * @return Hit tant que la valeur de sa main est inferieure a 17, Stand sinon
     */
    public ActionsBlackJack executer() {
        if(this.joueur.getMainCourant().getValeur()<17) {
            return ActionsBlackJack.Hit;
        } else {
            return ActionsBlackJack.Stand;
        }
    }
}
