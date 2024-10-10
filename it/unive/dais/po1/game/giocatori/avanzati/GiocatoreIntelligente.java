package it.unive.dais.po1.game.giocatori.avanzati;

import it.unive.dais.po1.game.carte.Card;
import it.unive.dais.po1.game.giocatori.Giocatore;
import it.unive.dais.po1.game.giocatori.GiocatoreNaive;
import it.unive.dais.po1.game.gioco.Briscola;

/**
 * Una classe che rappresenta un giocatore
 * @author Pietro Ferrara
 * @version 2.0
 * @since 1.2
 */
public class GiocatoreIntelligente extends Giocatore {

    public GiocatoreIntelligente(String name) {
        super(name);
    }

    /**
     * Ritorna una carta e la elimina tra quelle che ha nel mazzo
     * @return la carta scartata
     */
    @Override public Card getCard(Card otherCard, Briscola game) {
        if(otherCard != null) {
            for (int i = 0; i < carte.length; i++) {
                Card currentCard = carte[i];
                if (currentCard != null && game.maggiore(currentCard, otherCard)) {
                    carte[i] = null;
                    return currentCard;
                }
            }
        }
        return super.getFirstCard();
    }



}
