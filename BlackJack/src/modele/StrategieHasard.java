/**
 * @author 21614263 (Bastien CHAPUSOT)
 */
package modele;

import java.util.Random;
/**
 * StrategieHasard : strategie qui renvoit Hit ou Stand aleatoirement
 */
public class StrategieHasard extends Strategie {
	/**
	 * Constructeur par defaut
	 */
    public StrategieHasard() {
        // Constructeur par defaut vide
    }

    /**
     * executer : execution de la strategie
     * @return Hit ou Stand aleatoirement
     */
    public ActionsBlackJack executer() {
        Random rnd = new Random();
        if(rnd.nextInt(2)==0) {
            return ActionsBlackJack.Hit;
        } else {
            return ActionsBlackJack.Stand;
        }
    }
}
