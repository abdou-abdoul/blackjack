/**
 * @author 21614263 (Bastien CHAPUSOT)
 */
package modele;
/**
 * StrategieRisque : Strategie qui renvoit Hit quelque soit l'etat du jeu
 */
public class StrategieRisque extends Strategie {
	/**
	 * Constructeur par defaut
	 */
    public StrategieRisque() {
    }

    /**
     * executer : execution de la strategie
     * @return Hit
     */
    public ActionsBlackJack executer() {
        return ActionsBlackJack.Hit;
    }
}
