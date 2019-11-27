/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
/**
 * EtapeAttributionGain : L'etape d'attribution des gains
 */
public class EtapeAttributionGain extends EtapeJeu{
    /**
     * Constructeur logique
     * @param modele : acces au modele
     */
    public EtapeAttributionGain( ModeleBlackJack modele){
        this.modele = modele;
        this.etape = EnumEtapeJeu.EtapeAttributionGain;
    }
    
    /**
     * demarrer : demarrage de l'etape
     */
    @Override
    public void demarrer(){
        new Thread(){
            @Override
            public void run() {
                try {
                    if(modele.getQuiterJeu()){return;}
                    System.out.println("------------------gaiiiiiiiiiiiiiiiiiiiiin");
                    Thread.sleep(3000);
                    JoueurBlackJack joueur = modele.getJoueurCourant();
                    int credit = joueur.getCredit();
                    MainBlackJack main = joueur.getMainCourant();

                    int mise = main.getMise();
                    // si le joueur a fait surrender : gain deja effectuer
                    if(main.getAAbandonner()){}

                    // si le joueur excede 21 point : perd sa mise
                    else if(main.estPerdu()){
                        joueur.setGain(-mise);
                    }

                    // si le croupier fait blackJack
                    else if(modele.getCroupier().getMainCourant().estBlackJack()){
                        // si le joueur a pris l'assurance
                        // il perd sa mise mais se voit payer l'assurance en double
                        if(joueur.estAssure()){
                            joueur.setCredit(credit+2*mise);
                            joueur.setGain(0);
                            System.out.println("croupier blackJack mais assuré");
                        }
                        // sinon si le joueur fait blackjack
                        // le joueur ne perd rien
                        else if(main.estBlackJack()){
                            joueur.setCredit(credit+mise);
                            joueur.setGain(0);
                            System.out.println("croupier blackjack et blackjack");
                        }
                        // sinon il perd sa mise
                        else{
                            joueur.setGain(-mise); 
                            System.out.println("croupier blackjack et perdu");
                        }
                    }
                    // si le joueur fait blackJack
                    else if(main.estBlackJack()){
                        joueur.setCredit(credit+2*mise);
                        joueur.setGain(mise);
                        System.out.println("joueur blackjack");
                    }
                    
                    // si le joueur bat le croupier
                    else if(main.getValeur() > modele.getCroupier().getMainCourant().getValeur() ||  modele.getCroupier().getMainCourant().estPerdu()){
                        // si le joueur a pris l'assurance
                        // il perd son assurance mais empoche l'ÃƒÂ©quivalent de sa mise initiale
                        if(joueur.estAssure()){
                            joueur.setCredit(credit+2*mise);
                            joueur.setGain(0);
                            System.out.println("croupier battu et assurance");
                        }
                        // sinon
                        // il empoche sa mise
                        else{
                             joueur.setCredit(credit+2*mise);
                             joueur.setGain(mise);
                             System.out.println("croupier battu");
                        }

                    }
                    // si egalité
                    // le joueur ne perd et ne gagne rien, recupere juste sa mise
                    else if(main.getValeur() == modele.getCroupier().getMainCourant().getValeur()){
                        joueur.setCredit(credit+mise);
                        joueur.setGain(0);
                        System.out.println("egalité");
                    }
                    else{
                        // dans les autres cas le joueur perd sa mise et donc on lui retire sa mise
                        joueur.setGain(-mise);
                        System.out.println("perdu");
                    }
                    main.setMise(0);
                    Thread.sleep(3000);
                    if(joueur.mainSuivant()){
                        demarrer();
                    }
                    else if(modele.joueurSuivant()){demarrer();}
                    else{
                        modele.getMoteurJeu().setEtapeJeu(etapeSuivant);
                        demarrerEtapeSuivant();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start(); 
    }
   
}
