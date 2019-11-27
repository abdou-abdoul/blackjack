/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Strategie : super-classe des strategies
 * @author 21614263 (Bastien CHAPUSOT)
 */
public abstract class Strategie {

    /**
     * executer : execution de la strategie
     * @return l'action qui sera executé par le joueur
     */
    public abstract ActionsBlackJack executer();
}
